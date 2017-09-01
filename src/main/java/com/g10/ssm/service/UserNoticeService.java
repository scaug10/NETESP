package com.g10.ssm.service;

import java.util.List;

import com.g10.ssm.po.UserNoticeKey;

public interface UserNoticeService {
	public List<UserNoticeKey> queryUserNotice() throws Exception;

	/*
	 * public int updateUserNotice(UserNoticeKey userNotice) throws Exception;
	 */

	public int saveUserNotice(UserNoticeKey userNotice) throws Exception;

	public int deleteUserNoticeByPrimaryKey(UserNoticeKey userNotice) throws Exception;

	public List<UserNoticeKey> queryUserNoticeById(String userName) throws Exception;
}
