package com.g10.ssm.mapper;

import com.g10.ssm.po.UserPracticeExample;
import com.g10.ssm.po.UserPracticeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPracticeMapper {
    int countByExample(UserPracticeExample example);

    int deleteByExample(UserPracticeExample example);

    int deleteByPrimaryKey(UserPracticeKey key);

    int insert(UserPracticeKey record);

    int insertSelective(UserPracticeKey record);

    List<UserPracticeKey> selectByExample(UserPracticeExample example);

    int updateByExampleSelective(@Param("record") UserPracticeKey record, @Param("example") UserPracticeExample example);

    int updateByExample(@Param("record") UserPracticeKey record, @Param("example") UserPracticeExample example);
}