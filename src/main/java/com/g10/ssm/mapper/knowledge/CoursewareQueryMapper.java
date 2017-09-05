package com.g10.ssm.mapper.knowledge;

import java.util.ArrayList;
import java.util.List;

import com.g10.ssm.po.knowledge.Courseware;

public interface CoursewareQueryMapper {
	List<Courseware> selectAllCourseware();

	List<Courseware> selectByCategoryId(int cwcfId);

	List<Courseware> selectByName(String coursewareName);

	int deleteCourseware(ArrayList<Integer> coursewareArray);
}
