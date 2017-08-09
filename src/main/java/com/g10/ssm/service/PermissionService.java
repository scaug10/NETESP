package com.g10.ssm.service;

import java.util.ArrayList;

import com.g10.ssm.po.Permission;

public interface PermissionService {
	/*
	 * 给成功注册的用户赋予一个默认权限（default）
	 */
	public int giveDefaultPermission(String userName)throws Exception;
	/*
	 * 通过账号查询用户所有权限列表
	 */
	public ArrayList<Permission> searchUserPermissionList(String userName)throws Exception;
}
