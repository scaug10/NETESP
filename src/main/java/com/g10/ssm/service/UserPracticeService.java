package com.g10.ssm.service;

import java.util.List;

import com.g10.ssm.po.UserPracticeKey;

public interface UserPracticeService {
	public List<UserPracticeKey> queryUserPractice() throws Exception;

	/*
	 * public int updateUserPractice(UserPracticeKey userPractice) throws
	 * Exception;
	 */

	public int saveUserPractice(UserPracticeKey userPractice) throws Exception;

	public int deleteUserPracticeByPrimaryKey(UserPracticeKey userPractice) throws Exception;

	public List<UserPracticeKey> queryUserPracticeById(String userName) throws Exception;
}
