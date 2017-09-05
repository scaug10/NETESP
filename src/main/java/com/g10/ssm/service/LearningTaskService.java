package com.g10.ssm.service;

import java.util.List;

import com.g10.ssm.po.LearningTask;
import com.g10.ssm.po.LearningTaskExt;

public interface LearningTaskService {
	public List<LearningTaskExt> queryLearningTask() throws Exception;

	public List<LearningTaskExt> searchLearningTask(String taskName) throws Exception;

	public List<LearningTaskExt> queryLearningTaskByDepartmentId(Integer departmentId) throws Exception;

	public LearningTaskExt queryLearningTaskByLearningTaskId(Integer learningTaskId) throws Exception;

	public int selectId() throws Exception;

	public int updateLearningTask(LearningTask learningTask) throws Exception;

	public int saveLearningTask(LearningTask learningTask) throws Exception;

	public int checkLearningTask(String taskName) throws Exception;

	public int deleteLearningTaskByPrimaryKey(int learningTaskId) throws Exception;

	public int deleteLearningTask(Integer[] learningTaskId) throws Exception;

	public LearningTask queryLearningTaskById(Integer learningTaskId) throws Exception;

	public List<LearningTaskExt> getAllLearningTaskByUserName(String userName) throws Exception;
}
