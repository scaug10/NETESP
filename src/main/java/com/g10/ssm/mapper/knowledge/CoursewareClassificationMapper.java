package com.g10.ssm.mapper.knowledge;

import com.g10.ssm.po.knowledge.CoursewareClassification;
import com.g10.ssm.po.knowledge.CoursewareClassificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoursewareClassificationMapper {
    int countByExample(CoursewareClassificationExample example);

    int deleteByExample(CoursewareClassificationExample example);

    int deleteByPrimaryKey(Integer cwcfId);

    int insert(CoursewareClassification record);

    int insertSelective(CoursewareClassification record);

    List<CoursewareClassification> selectByExample(CoursewareClassificationExample example);

    CoursewareClassification selectByPrimaryKey(Integer cwcfId);

    int updateByExampleSelective(@Param("record") CoursewareClassification record, @Param("example") CoursewareClassificationExample example);

    int updateByExample(@Param("record") CoursewareClassification record, @Param("example") CoursewareClassificationExample example);

    int updateByPrimaryKeySelective(CoursewareClassification record);

    int updateByPrimaryKey(CoursewareClassification record);
}