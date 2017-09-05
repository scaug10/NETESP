package com.g10.ssm.service;

import java.util.List;

import com.g10.ssm.po.UserLearningTaskKey;

public interface UserLearningTaskService {
	public List<UserLearningTaskKey> queryUserLearningTask() throws Exception;

	public String[] getAllLearningTaskDepartment(int learningTaskId) throws Exception;

	public String[] getAllUserName(int departmentId) throws Exception;

	public String[] getLearningTaskById(int learningTaskId) throws Exception;

	public Integer[] getAllDepartmentId(int learningTaskId) throws Exception;

	public Integer[] getAllLearningTaskByDepartmentId(int departmentId) throws Exception;

	/*
	 * public int updateUserLearningTask(UserLearningTaskKey userLearningTask)
	 * throws Exception;
	 */

	public int saveUserLearningTask(UserLearningTaskKey userLearningTask) throws Exception;

	public int deleteUserLearningTaskPrimaryKey(UserLearningTaskKey userLearningTask) throws Exception;

	public int deleteUserLearningTask(Integer learningTaskId) throws Exception;

	public List<UserLearningTaskKey> queryUserLearningTaskById(String userName) throws Exception;
}
