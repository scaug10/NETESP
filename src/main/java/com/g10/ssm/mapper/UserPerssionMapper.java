package com.g10.ssm.mapper;

import com.g10.ssm.po.UserPermissionCustom;
import com.g10.ssm.po.UserPerssionExample;
import com.g10.ssm.po.UserPerssionKey;
import com.g10.ssm.po.UserPerssionVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPerssionMapper {
    int countByExample(UserPerssionExample example);

    int deleteByExample(UserPerssionExample example);

    int deleteByPrimaryKey(UserPerssionKey key);

    int insert(UserPerssionKey record);

    int insertSelective(UserPerssionKey record);

    List<UserPerssionKey> selectByExample(UserPerssionExample example);

    int updateByExampleSelective(@Param("record") UserPerssionKey record, @Param("example") UserPerssionExample example);

    int updateByExample(@Param("record") UserPerssionKey record, @Param("example") UserPerssionExample example);
    
    /** 
     * 批量删除用户权限列表
     */
    int deleteUserPermissionList(UserPermissionCustom userPermissionCustom);
    /**
     * 给多个用户分配同一个权限
     */
    int givePermissionToManyUsers(UserPerssionVo userPerssionVo);
}