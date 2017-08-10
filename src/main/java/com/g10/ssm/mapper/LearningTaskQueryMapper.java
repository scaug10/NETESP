package com.g10.ssm.mapper;

import java.util.List;

import com.g10.ssm.po.LearningTask;

public interface LearningTaskQueryMapper {
	List<LearningTask> selectAllLearnTask();
}
