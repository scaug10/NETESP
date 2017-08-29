package com.g10.ssm.mapper;

import com.g10.ssm.po.Permission;
import com.g10.ssm.po.PermissionCustom;
import com.g10.ssm.po.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper {
    int countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(Integer permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Integer permissionId);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    /**
     * 通过账号查询用户所有权限列表
     */
    List<Permission> selectUserAllPermissionList(String userName);
    
    /**
     * 通过权限名查找权限列表判断该权限是否存在
     */
    List<Permission> isPermissionExist(String name);
    
    /**
     * 查询所有用户权限列表
     */
    List<PermissionCustom> searchAllUserPermissionList();

    /**
     * 查询权限列表
     */
	List<Permission> searchPermissionList();

	/**
	 * 删除权限表中指定的多个权限
	 * @param list
	 * @return
	 */
	int deletePermissionListFromPermission(List<Integer> list);

	/**
	 *根据权限名称模糊查询权限
	 */
	List<Permission> searchPermissionByName(String name);
}