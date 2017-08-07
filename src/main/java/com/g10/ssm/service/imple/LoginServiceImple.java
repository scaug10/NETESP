package com.g10.ssm.service.imple;

import org.springframework.beans.factory.annotation.Autowired;

import com.g10.ssm.mapper.UserMapper;
import com.g10.ssm.po.User;
import com.g10.ssm.service.LoginService;

public class LoginServiceImple implements LoginService{
	@Autowired
	private UserMapper userMapper;

	/*
	 *新增注册用户
	 */
	@Override
	public int saveUser(User user) throws Exception {
		int res=-1;
		res=userMapper.insert(user);
		return res;
	}
    
	/*
	 * 验证用户登录密码是否与数据库一致
	 */
	@Override
	public int checkUserPassword(int userId,String password) throws Exception {
		int res=-1;
		User user=userMapper.selectByPrimaryKey(userId);
		String pwd=user.getPassword();
		if(pwd.equals(password.trim())){
			user.setLoginStatus(true);
			userMapper.updateByPrimaryKey(user);
			res=1;
			return res;
		}
		else {
			return res;
		}
	}
	
	
}
