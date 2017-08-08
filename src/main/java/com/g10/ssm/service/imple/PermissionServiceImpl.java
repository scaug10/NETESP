package com.g10.ssm.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.UserPerssionMapper;
import com.g10.ssm.po.UserPerssionKey;
import com.g10.ssm.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	private UserPerssionMapper userPerssionMapper;
	
	/*
	 * 给成功注册的用户赋予一个默认权限（default）
	 */
	@Override
	public int giveDefaultPermission(String userName) throws Exception {
		int res=-1;
		UserPerssionKey userPerssionKey=new UserPerssionKey();
		userPerssionKey.setPermissionId(1);
		userPerssionKey.setUserName(userName);
		res=userPerssionMapper.insert(userPerssionKey);
		return res;
	}

}
