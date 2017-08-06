package com.g10.ssm.mapper;

import com.g10.ssm.po.LearningTask;
import com.g10.ssm.po.LearningTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LearningTaskMapper {
    int countByExample(LearningTaskExample example);

    int deleteByExample(LearningTaskExample example);

    int deleteByPrimaryKey(Integer learningTaskId);

    int insert(LearningTask record);

    int insertSelective(LearningTask record);

    List<LearningTask> selectByExample(LearningTaskExample example);

    LearningTask selectByPrimaryKey(Integer learningTaskId);

    int updateByExampleSelective(@Param("record") LearningTask record, @Param("example") LearningTaskExample example);

    int updateByExample(@Param("record") LearningTask record, @Param("example") LearningTaskExample example);

    int updateByPrimaryKeySelective(LearningTask record);

    int updateByPrimaryKey(LearningTask record);
}