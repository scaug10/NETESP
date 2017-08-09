package com.g10.ssm.service.knowledge;

import java.util.List;

import com.g10.ssm.po.knowledge.Courseware;

public interface CoursewareService {
	public List<Courseware> queryCourseware() throws Exception;

	public int updateCourseware(Courseware courseware) throws Exception;

	public int saveCourseware(Courseware courseware) throws Exception;

	public int deleteCoursewareByPrimaryKey(int coursewareId) throws Exception;

	public Courseware queryCoursewareById(Integer coursewareId) throws Exception;
}
