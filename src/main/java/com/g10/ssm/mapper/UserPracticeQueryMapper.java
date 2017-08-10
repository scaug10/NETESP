package com.g10.ssm.mapper;

import java.util.List;

import com.g10.ssm.po.UserPracticeKey;

public interface UserPracticeQueryMapper {
	List<UserPracticeKey> selectAllUserPractice();

	List<UserPracticeKey> selectAllPractice(String userName);
}
