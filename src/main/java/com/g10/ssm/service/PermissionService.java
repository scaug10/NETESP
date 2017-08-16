package com.g10.ssm.service;

import java.util.ArrayList;
import java.util.List;

import com.g10.ssm.po.Permission;
import com.g10.ssm.po.PermissionCustom;
import com.g10.ssm.po.UserPermissionCustom;
import com.g10.ssm.po.UserPerssionVo;

public interface PermissionService {
	/**
	 * 给成功注册的用户赋予一个默认权限（default）
	 */
	public int giveDefaultPermission(String userName)throws Exception;
	/**
	 * 通过账号查询用户所有权限列表
	 */
	public ArrayList<Permission> searchUserPermissionList(String userName)throws Exception;
	/**
	 * 新增权限（admin）
	 */
	public int insertPermission(String name)throws Exception;
	/**
	 * 删除权限（admin）
	 */
	public int deletePermission(UserPermissionCustom userPermissionCustom)throws Exception;
	/**
	 * 修改权限（admin）
	 */
	public int updatePermission(Permission permission)throws Exception;
	/**
	 * 给多个用户分配同一个权限
	 */
	public int givePermissionToManyUsers(UserPerssionVo userPerssionVo)throws Exception;
	/**
	 * 查询权限列表
	 */
	public List<PermissionCustom> searchPermissionList()throws Exception;
}
