package com.g10.ssm.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.NoticeMapper;
import com.g10.ssm.mapper.NoticeQueryMapper;
import com.g10.ssm.po.Notice;
import com.g10.ssm.service.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeDao;
	@Autowired
	private NoticeQueryMapper noticeQueryDao;

	@Override
	public List<Notice> queryNotice() throws Exception {
		List<Notice> list = noticeQueryDao.selectAllNotice();
		return list;
	}

	@Override
	public int updateNotice(Notice notice) throws Exception {
		int result = noticeDao.updateByPrimaryKeySelective(notice);
		return result;
	}

	@Override
	public int saveNotice(Notice notice) throws Exception {
		int result = noticeDao.insertSelective(notice);
		return result;
	}

	@Override
	public int deleteNoticeByPrimaryKey(int noticeId) throws Exception {
		int result = noticeDao.deleteByPrimaryKey(noticeId);
		return result;
	}

	@Override
	public Notice queryNoticeById(Integer noticeId) throws Exception {
		Notice record = noticeDao.selectByPrimaryKey(noticeId);
		return record;
	}

}
