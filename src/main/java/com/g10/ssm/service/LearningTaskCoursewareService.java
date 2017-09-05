package com.g10.ssm.service;

import java.util.List;

import com.g10.ssm.po.LearningTaskCoursewareKey;

public interface LearningTaskCoursewareService {
	public List<LearningTaskCoursewareKey> queryLearningTaskCourseware() throws Exception;

	public String[] queryAllCoursewareUrl(Integer learningTaskId) throws Exception;

	public Integer[] getAllCoursewareId(Integer learningTaskId) throws Exception;

	/*
	 * public int updateLearningTaskCourseware(LearningTaskCoursewareKey
	 * testTable) throws Exception;
	 */

	public int saveLearningTaskCourseware(LearningTaskCoursewareKey learningTaskCourseware) throws Exception;

	public int deleteLearningTaskCoursewareByPrimaryKey(LearningTaskCoursewareKey learningTaskCourseware)
			throws Exception;

	public int deleteLearningTaskCourseware(Integer learningTaskId) throws Exception;
}
