package com.g10.ssm.service;

public interface PermissionService {
	/*
	 * 给成功注册的用户赋予一个默认权限（default）
	 */
	public int giveDefaultPermission(String userName)throws Exception;
}
