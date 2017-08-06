package com.g10.ssm.mapper;

import com.g10.ssm.po.LearningTaskCoursewareExample;
import com.g10.ssm.po.LearningTaskCoursewareKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LearningTaskCoursewareMapper {
    int countByExample(LearningTaskCoursewareExample example);

    int deleteByExample(LearningTaskCoursewareExample example);

    int deleteByPrimaryKey(LearningTaskCoursewareKey key);

    int insert(LearningTaskCoursewareKey record);

    int insertSelective(LearningTaskCoursewareKey record);

    List<LearningTaskCoursewareKey> selectByExample(LearningTaskCoursewareExample example);

    int updateByExampleSelective(@Param("record") LearningTaskCoursewareKey record, @Param("example") LearningTaskCoursewareExample example);

    int updateByExample(@Param("record") LearningTaskCoursewareKey record, @Param("example") LearningTaskCoursewareExample example);
}