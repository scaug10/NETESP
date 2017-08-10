package com.g10.ssm.mapper;

import java.util.List;

import com.g10.ssm.po.UserNoticeKey;

public interface UserNoticeQueryMapper {
	List<UserNoticeKey> selectAllUserNotice();

	List<UserNoticeKey> selectAllNotice(String userName);
}
