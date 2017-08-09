package com.g10.ssm.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.PermissionMapper;
import com.g10.ssm.mapper.UserMapper;
import com.g10.ssm.mapper.UserPerssionMapper;
import com.g10.ssm.po.Permission;
import com.g10.ssm.po.UserPerssionKey;
import com.g10.ssm.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	private UserPerssionMapper userPerssionMapper;
	@Autowired
	private PermissionMapper permissonMapper;
	/*
	 * 给成功注册的用户赋予一个默认权限（default）
	 */
	@Override
	public int giveDefaultPermission(String userName) throws Exception {
		int res=-1;
		if(userName==null)
			return res;
		UserPerssionKey userPerssionKey=new UserPerssionKey();
		userPerssionKey.setPermissionId(1);
		userPerssionKey.setUserName(userName);
		res=userPerssionMapper.insert(userPerssionKey);
		return res;
	}

	/*
	 *通过账号查询用户所有权限列表
	 */
	@Override
	public ArrayList<Permission> searchUserPermissionList(String userName) throws Exception {
		ArrayList<Permission> list=null;
		if(userName==null)
			return list;
		list=(ArrayList<Permission>) permissonMapper.selectUserAllPermissionList(userName);
		return list;
	}

}
