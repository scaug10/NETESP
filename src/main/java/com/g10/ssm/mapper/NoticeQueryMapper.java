package com.g10.ssm.mapper;

import java.util.List;

import com.g10.ssm.po.Notice;

public interface NoticeQueryMapper {
	/**
	 * 管理员查询公告通知列表
	 * @return
	 */
	List<Notice> selectAllNotice();

	/**
	 * 获取公开性公告通知列表
	 */
	List<Notice> selectPublicNotice();

	/**
	 * 用户获取个人公告列表（非公开性的）
	 */
	List<Notice> getNoticeByUserName(String userName);

	/**
	 * 删除多个公告（首先要删除用户公告关系表（从表）然后再删除公告表（主表），只要在数据库设置级联操作
	 * （从表外键字段设置delete的cascade）即可，所以这里只用删除公告表（主表）即可）
	 */
	Integer deleteManyNoticeFromNotice(List<Integer> list);

	/**
	 * 插入一条公告的同时自动返回自增主键到noticeId属性中
	 * @param notice
	 * @return
	 */
	int insertNoticeAndGetId(Notice notice);

	/**
	 * 获取前4条公开性公告通知列表
	 */
	List<Notice> selectFourPublicNotice();
}
