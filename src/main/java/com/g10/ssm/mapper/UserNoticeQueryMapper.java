package com.g10.ssm.mapper;

import com.g10.ssm.po.UserNoticeVo;

public interface UserNoticeQueryMapper {

	/**
	 * 给指定用户发布公告
	 */
	int sendNoticeToManyUser(UserNoticeVo userNoticeVo);
	
}
