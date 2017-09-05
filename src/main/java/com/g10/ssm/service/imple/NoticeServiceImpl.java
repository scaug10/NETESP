package com.g10.ssm.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.NoticeMapper;
import com.g10.ssm.mapper.NoticeQueryMapper;
import com.g10.ssm.mapper.UserNoticeQueryMapper;
import com.g10.ssm.po.Notice;
import com.g10.ssm.po.UserNoticeVo;
import com.g10.ssm.service.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeDao;
	@Autowired
	private NoticeQueryMapper noticeQueryDao;
	@Autowired
	private UserNoticeQueryMapper userNoticeQueryMapper;

	@Override
	public List<Notice> queryNotice() throws Exception {
		List<Notice> list=null;
		list = noticeQueryDao.selectAllNotice();
		return list;
	}

	@Override
	public int updateNotice(Notice notice) throws Exception {
		if(notice==null)
			return -1;
		int result = noticeDao.updateByPrimaryKey(notice);
		if(result!=1)
			return -1;
		return result;
	}

	@Override
	public int saveNotice(Notice notice) throws Exception {
		if(notice==null)
			return -1;
		int result = noticeDao.insert(notice);
		if(result!=1)
			return -1;
		return result;
	}

	@Override
	public int deleteNoticeByPrimaryKey(Integer noticeId) throws Exception {
		if(noticeId==null)
			return -1;
		int result = noticeDao.deleteByPrimaryKey(noticeId);
		if(result!=1)
			return -1;
		return result;
	}

	@Override
	public Notice queryNoticeById(Integer noticeId) throws Exception {
		if(noticeId==null)
			return null;
		Notice record = noticeDao.selectByPrimaryKey(noticeId);
		return record;
	}

	/**
	 * 获取公开性公告通知列表
	 */
	@Override
	public List<Notice> queryPublicNotice() {
		List<Notice> list=null;
		list = noticeQueryDao.selectPublicNotice();
		return list;
	}

	/**
	 * 给指定用户发布公告
	 */
	@Override
	public int sendNoticeToManyUser(UserNoticeVo userNoticeVo) throws Exception {
		if(userNoticeVo==null||userNoticeVo.getList()==null||userNoticeVo.getList().size()<1)
			return -1;
		int result=userNoticeQueryMapper.sendNoticeToManyUser(userNoticeVo);
		if(result!=userNoticeVo.getList().size())
			return -1;
		return 1;
	}

	/**
	 * 用户获取个人公告列表（非公开性的）
	 */
	@Override
	public List<Notice> getNoticeByUserName(String userName) {
		if(userName==null||userName.trim().equals(""))
			return null;
		List<Notice> list=null;
		list=noticeQueryDao.getNoticeByUserName(userName);
		return list;
	}

	/**
	 * 删除多个公告（首先要删除用户公告关系表（从表）然后再删除公告表（主表），只要在数据库设置级联操作
	 * （从表外键字段设置delete的cascade）即可，所以这里只用删除公告表（主表）即可）
	 */
	@Override
	public Integer deleteManyNotice(List<Integer> list) {
		if(list==null)
			return null;
		Integer res=noticeQueryDao.deleteManyNoticeFromNotice(list);
		if(res!=list.size())
			return null;
		return res;
	}

	/**
	 * 插入一条公告的同时自动返回自增主键到noticeId属性中
	 * @param notice
	 * @return
	 */
	@Override
	public int insertNoticeAndGetId(Notice notice) {
		if(notice==null)
			return -1;
		int result=noticeQueryDao.insertNoticeAndGetId(notice);
		if(result!=1)
			return -1;
		return result;
	}

	/**
	 * 获取前4条公开性公告通知列表
	 */
	@Override
	public List<Notice> queryFourPublicNotice() {
		List<Notice> list=null;
		list = noticeQueryDao.selectFourPublicNotice();
		return list;
	}

}
