package com.g10.ssm.mapper;

import java.util.List;

import com.g10.ssm.po.UserNoticeKey;
import com.g10.ssm.po.UserNoticeVo;

public interface UserNoticeQueryMapper {

	/**
	 * 给指定用户发布公告
	 */
	int sendNoticeToManyUser(UserNoticeVo userNoticeVo);
	
	List<UserNoticeKey> selectAllUserNotice();

	List<UserNoticeKey> selectAllNotice(String userName);
	
}
