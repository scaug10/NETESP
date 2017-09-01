package com.g10.ssm.mapper;

import java.util.List;

import com.g10.ssm.po.LearningTaskCoursewareKey;

public interface LearningTaskCoursewareQueryMapper {
	List<LearningTaskCoursewareKey> selectAllLearningTaskCourseware();

	List<LearningTaskCoursewareKey> selectCoursewareByLearningTaskId(int learningTaskId);
}
