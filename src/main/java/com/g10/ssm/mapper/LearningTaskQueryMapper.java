package com.g10.ssm.mapper;

import java.util.List;

import com.g10.ssm.po.LearningTask;
import com.g10.ssm.po.LearningTaskExt;

public interface LearningTaskQueryMapper {
	List<LearningTaskExt> selectAllLearnTask();

	List<LearningTaskExt> selectLearningTaskByName(String taskName);

	List<LearningTaskExt> selectLearningTaskByDepartmentId(Integer departmentId);

	List<LearningTaskExt> selectAllLearningTaskByUserName(String userName);

	LearningTask checkLearningTask(String taskName);

	int deleteLearningTask(Integer[] learningTaskId);

	int selectId();

	LearningTaskExt selectLearningTask(Integer learningTaskId);
}
