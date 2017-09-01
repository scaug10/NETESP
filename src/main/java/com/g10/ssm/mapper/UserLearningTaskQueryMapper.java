package com.g10.ssm.mapper;

import java.util.List;

import com.g10.ssm.po.UserLearningTaskKey;

public interface UserLearningTaskQueryMapper {
	List<UserLearningTaskKey> selectAllUserLearningTask();

	List<UserLearningTaskKey> selectAllLearningTask(String userName);
}
