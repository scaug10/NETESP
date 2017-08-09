package com.g10.ssm.mapper.knowledge;

import java.util.List;

import com.g10.ssm.po.knowledge.Courseware;

public interface CoursewareQueryMapper {
	List<Courseware> selectAllCourseware();
}
