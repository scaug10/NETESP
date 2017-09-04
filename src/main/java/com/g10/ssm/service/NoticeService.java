package com.g10.ssm.service;

import java.util.List;

import com.g10.ssm.po.Notice;
import com.g10.ssm.po.UserNoticeVo;

public interface NoticeService {
	public List<Notice> queryNotice() throws Exception;

	public int updateNotice(Notice notice) throws Exception;

	public int saveNotice(Notice notice) throws Exception;

	public int deleteNoticeByPrimaryKey(Integer noticeId) throws Exception;

	public Notice queryNoticeById(Integer noticeId) throws Exception;
	
	/**
	 * 给指定用户发布公告
	 */
	public int sendNoticeToManyUser(UserNoticeVo userNoticeVo)throws Exception;

	/**
	 * 获取公开性公告通知列表
	 */
	public List<Notice> queryPublicNotice();

	/**
	 * 用户获取个人公告列表（非公开性的）
	 * @param userName
	 * @return
	 */
	public List<Notice> getNoticeByUserName(String userName);

	/**
	 * 删除多个公告（首先要删除用户公告关系表（从表）然后再删除公告表（主表），只要在数据库设置级联操作
	 * （从表外键字段设置delete的cascade）即可，所以这里只用删除公告表（主表）即可）
	 */
	public Integer deleteManyNotice(List<Integer> list);

	/**
	 * 插入一条公告的同时自动返回自增主键到noticeId属性中
	 * @param notice
	 * @return
	 */
	public int insertNoticeAndGetId(Notice notice);

	/**
	 * 获取前4条公开性公告通知列表
	 */
	public List<Notice> queryFourPublicNotice();
}
