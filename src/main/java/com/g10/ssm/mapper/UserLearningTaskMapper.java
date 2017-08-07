package com.g10.ssm.mapper;

import com.g10.ssm.po.UserLearningTaskExample;
import com.g10.ssm.po.UserLearningTaskKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLearningTaskMapper {
    int countByExample(UserLearningTaskExample example);

    int deleteByExample(UserLearningTaskExample example);

    int deleteByPrimaryKey(UserLearningTaskKey key);

    int insert(UserLearningTaskKey record);

    int insertSelective(UserLearningTaskKey record);

    List<UserLearningTaskKey> selectByExample(UserLearningTaskExample example);

    int updateByExampleSelective(@Param("record") UserLearningTaskKey record, @Param("example") UserLearningTaskExample example);

    int updateByExample(@Param("record") UserLearningTaskKey record, @Param("example") UserLearningTaskExample example);
}