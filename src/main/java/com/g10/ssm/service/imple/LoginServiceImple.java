package com.g10.ssm.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.UserMapper;
import com.g10.ssm.po.User;
import com.g10.ssm.service.LoginService;
import com.g10.ssm.service.PermissionService;

@Service
public class LoginServiceImple implements LoginService{
	@Autowired
	private UserMapper userMapper;

	
	@Autowired
	private PermissionService permissionService;
	/*
	 *新增注册用户,并为用户赋予一个权限
	 */
	@Override
	public int saveUser(User user) throws Exception {
		int res=-1;
		res=userMapper.insert(user);
		if(res==1){
			String userName=user.getUserName();
			int result=permissionService.giveDefaultPermission(userName);
			return result;
		}else {
			return res;
		}
	}
    
	/*
	 * 验证用户登录密码是否与数据库一致
	 */
	@Override
	public int checkUserPassword(String userName,String password) throws Exception {
		int res=-1;
		User user=userMapper.selectByPrimaryKey(userName);
		if(user==null)
			return res;
		String pwd=user.getPassword();
		if(pwd.equals(password.trim())){
			user.setLoginStatus(true);
			res=userMapper.updateByPrimaryKey(user);
			return res;
		}
		else {
			return res;
		}
	}

	/*
	 * 找回密码
	 */
	@Override
	public int findPassword(String userName) throws Exception {
		int res=-1;
		User user=userMapper.selectByPrimaryKey(userName);
		String email=user.getEmail();
		
		return 0;
	}

	/*
	 * 查询登录名是否已经存在
	 */
	@Override
	public boolean isUserIdExist(String userName) throws Exception {
		User user=userMapper.selectByPrimaryKey(userName);
		if(user==null)
			return false;
		else {
			return true;
		}
	}


	
	
}
