package com.g10.ssm.service;

import java.util.List;

import com.g10.ssm.po.LearningTask;

public interface LearningTaskService {
	public List<LearningTask> queryLearningTask() throws Exception;

	public int updateLearningTask(LearningTask learningTask) throws Exception;

	public int saveLearningTask(LearningTask learningTask) throws Exception;

	public int deleteLearningTaskByPrimaryKey(int learningTaskId) throws Exception;

	public LearningTask queryLearningTaskById(Integer learningTaskId) throws Exception;
}
