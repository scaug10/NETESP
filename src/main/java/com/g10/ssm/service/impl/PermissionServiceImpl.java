package com.g10.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.PermissionMapper;
import com.g10.ssm.mapper.UserPerssionMapper;
import com.g10.ssm.po.Permission;
import com.g10.ssm.po.PermissionCustom;
import com.g10.ssm.po.UserPermissionCustom;
import com.g10.ssm.po.UserPerssionKey;
import com.g10.ssm.po.UserPerssionVo;
import com.g10.ssm.service.LoginService;
import com.g10.ssm.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	private UserPerssionMapper userPerssionMapper;
	@Autowired
	private PermissionMapper permissionMapper;
	@Autowired
	private LoginService loginService;
	/**
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

	/**
	 *通过账号查询用户所有权限列表
	 */
	@Override
	public List<Permission> searchUserPermissionList(String userName) throws Exception {
		List<Permission> list=null;
		if(userName==null)
			return list;
		list=(List<Permission>) permissionMapper.selectUserAllPermissionList(userName);
		return list;
	}

	/**
	 * 新增权限(admin),先去数据库找看是否有同名的权限，如果有则不能新增。
	 */
	@Override
	public int insertPermission(String name) throws Exception {
		if(name==null)
			return -1;
		ArrayList<Permission> list=null;
		list=(ArrayList<Permission>) permissionMapper.isPermissionExist(name);
		if(list.size()>0)
			return -2;//数据库有同名的权限
		Permission permission=new Permission();
		permission.setName(name);
		return permissionMapper.insert(permission);
	}

	/**
	 * 批量删除用户权限（admin）
	 */
	@Override
	public int deletePermission(UserPermissionCustom userPermissionCustom) throws Exception {
		int result=1;
		for(int i=0;i<userPermissionCustom.getUserPermissionList().size();i++){
			if((userPermissionCustom.getUserPermissionList().get(i).getPermissionId()==null)&&(userPermissionCustom.getUserPermissionList().get(i).getUserName()==null)){
				result=-1;
				break;
			}
		}
		if(result==-1)
			return result;
		result=userPerssionMapper.deleteUserPermissionList(userPermissionCustom);
		if(result!=userPermissionCustom.getUserPermissionList().size())
			return -1;
		else {
			return 1;
		}
	}

	/**
	 * 修改权限（admin）
	 */
	@Override
	public int updatePermission(Permission permission) throws Exception {
		if(permission==null)
			return -1;
		return permissionMapper.updateByPrimaryKey(permission);
	}

	/**
	 * 给多个用户分配同一个权限(admin)
	 */
	@Override
	public int givePermissionToManyUsers(UserPerssionVo userPerssionVo) throws Exception {
		if(userPerssionVo==null||userPerssionVo.getList()==null)
			return -1;
		int result=-1;
		for(int i=0;i<userPerssionVo.getList().size();i++){
			if(!loginService.isUserIdExist(userPerssionVo.getList().get(i).getUserName())){
				result=-2;//你想要分配的用户不存在
				return result;
			}
		}
		result=userPerssionMapper.givePermissionToManyUsers(userPerssionVo);
		if(result==userPerssionVo.getList().size())
			return 1;
		else {
			return -1;
		}
	}

	/**
     * 查询所有用户权限列表
     */
	@Override
	public List<PermissionCustom> searchAllUserPermissionList() throws Exception {
		List<PermissionCustom> list=null;
		list=permissionMapper.searchAllUserPermissionList();
		return list;
	}

	/**
	 *根据权限名称模糊查询权限
	 */
	@Override
	public List<Permission> searchPermissionByName(String name) throws Exception {
		if(name==null||name.trim()=="")
			return null;
		List<Permission> permission=permissionMapper.searchPermissionByName(name);
		return permission;
	}

	/**
	 * 删除单个权限（首先要删除用户权限关系表（从表）然后再删除权限表（主表），只要在数据库设置级联操作
	 * （从表外键字段设置delete的cascade）即可，所以这里只用删除权限表（主表）即可）
	 */
	@Override
	public Integer deleteOnePermission(Integer permissionId) throws Exception {
		if(permissionId==null)
			return null;
		Integer res=permissionMapper.deleteByPrimaryKey(permissionId);
		if(res!=1)
			return null;
		return res;
	}

	/**
	 * 查询权限列表
	 * 
	 */
	@Override
	public List<Permission> searchPermissionList() throws Exception {
		List<Permission> list=null;
		list=permissionMapper.searchPermissionList();
		return list;
	}

	/**
	 * 删除多个权限（首先要删除用户权限关系表（从表）然后再删除权限表（主表），只要在数据库设置级联操作
	 * （从表外键字段设置delete的cascade）即可，所以这里只用删除权限表（主表）即可）
	 */
	@Override
	public Integer deleteManyPermission(List<Integer> list) throws Exception {
		if(list==null)
			return null;
		Integer res=permissionMapper.deletePermissionListFromPermission(list);
		if(res!=list.size())
			return null;
		return res;
	}

}
