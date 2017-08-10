package com.g10.ssm.service;

import java.util.List;

import com.g10.ssm.po.Notice;

public interface NoticeService {
	public List<Notice> queryNotice() throws Exception;

	public int updateNotice(Notice notice) throws Exception;

	public int saveNotice(Notice notice) throws Exception;

	public int deleteNoticeByPrimaryKey(int noticeId) throws Exception;

	public Notice queryNoticeById(Integer noticeId) throws Exception;
}
