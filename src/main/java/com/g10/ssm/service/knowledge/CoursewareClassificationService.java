package com.g10.ssm.service.knowledge;

import java.util.List;

import com.g10.ssm.po.knowledge.CoursewareClassification;

public interface CoursewareClassificationService {
	public List<CoursewareClassification> queryCoursewareClassification() throws Exception;

	public int updateCoursewareClassification(CoursewareClassification coursewareClassification) throws Exception;

	public int saveCoursewareClassification(CoursewareClassification coursewareClassification) throws Exception;

	public int deleteCoursewareClassificationByPrimaryKey(int cwcfId) throws Exception;

	public CoursewareClassification queryCoursewareClassificationById(Integer cwcfId) throws Exception;
}
