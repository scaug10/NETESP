package com.g10.ssm.service;

import java.util.List;

import com.g10.ssm.po.UserLearningTaskKey;

public interface UserLearningTaskService {
	public List<UserLearningTaskKey> queryUserLearningTask() throws Exception;

	/*
	 * public int updateUserLearningTask(UserLearningTaskKey userLearningTask)
	 * throws Exception;
	 */

	public int saveUserLearningTask(UserLearningTaskKey userLearningTask) throws Exception;

	public int deleteUserLearningTaskPrimaryKey(UserLearningTaskKey userLearningTask) throws Exception;

	public List<UserLearningTaskKey> queryUserLearningTaskById(String userName) throws Exception;
}
