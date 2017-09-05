package com.g10.ssm.service;

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
	public List<Permission> searchUserPermissionList(String userName)throws Exception;
	/**
	 * 新增权限（admin）
	 */
	public int insertPermission(String name)throws Exception;
	/**
	 * 删除多个用户权限（admin）
	 */
	public int deletePermission(UserPermissionCustom userPermissionCustom)throws Exception;
	/**
	 * 修改权限（admin）
	 */
	public int updatePermission(Permission permission)throws Exception;
	/**
	 * 给多个用户分配同一个权限（admin）
	 */
	public int givePermissionToManyUsers(UserPerssionVo userPerssionVo)throws Exception;
	/**
	 * 查询所有用户权限列表
	 */
	public List<PermissionCustom> searchAllUserPermissionList()throws Exception;
	/**
	 * 根据权限名称模糊查询权限
	 */
	public List<Permission> searchPermissionByName(String name)throws Exception;
	/**
	 * 删除单个权限（首先要删除用户权限关系表（从表）然后再删除权限表（主表），只要在数据库设置级联操作
	 * （从表外键字段设置delete的cascade）即可，所以这里只用删除权限表（主表）即可）
	 */
	public Integer deleteOnePermission(Integer permissionId)throws Exception;
	/**
	 * 查询权限列表
	 */
	public List<Permission> searchPermissionList()throws Exception;
	/**
	 * 删除多个权限（首先要删除用户权限关系表（从表）然后再删除权限表（主表），只要在数据库设置级联操作
	 * （从表外键字段设置delete的cascade）即可，所以这里只用删除权限表（主表）即可）
	 */
	public Integer deleteManyPermission(List<Integer> list)throws Exception;
}
