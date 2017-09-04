package com.g10.ssm.mapper.knowledge;

import com.g10.ssm.po.knowledge.Courseware;
import com.g10.ssm.po.knowledge.CoursewareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CoursewareMapper {
    int countByExample(CoursewareExample example);

    int deleteByExample(CoursewareExample example);

    int deleteByPrimaryKey(Integer coursewareId);

    int insert(Courseware record);

    int insertSelective(Courseware record);

    List<Courseware> selectByExample(CoursewareExample example);

    Courseware selectByPrimaryKey(Integer coursewareId);

    int updateByExampleSelective(@Param("record") Courseware record, @Param("example") CoursewareExample example);

    int updateByExample(@Param("record") Courseware record, @Param("example") CoursewareExample example);

    int updateByPrimaryKeySelective(Courseware record);

    int updateByPrimaryKey(Courseware record);
}