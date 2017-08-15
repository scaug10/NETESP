package com.g10.ssm.mapper;

import com.g10.ssm.po.UserPerssionExample;
import com.g10.ssm.po.UserPerssionKey;
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
}