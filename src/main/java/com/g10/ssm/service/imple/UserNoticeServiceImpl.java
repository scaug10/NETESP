package com.g10.ssm.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.UserNoticeMapper;
import com.g10.ssm.mapper.UserNoticeQueryMapper;
import com.g10.ssm.po.UserNoticeKey;
import com.g10.ssm.service.UserNoticeService;

@Service("userNoticeService")
public class UserNoticeServiceImpl implements UserNoticeService {

	@Autowired
	private UserNoticeMapper userNoticeDao;
	@Autowired
	private UserNoticeQueryMapper userNoticeQueryDao;

	@Override
	public List<UserNoticeKey> queryUserNotice() throws Exception {
		List<UserNoticeKey> list = userNoticeQueryDao.selectAllUserNotice();
		return list;
	}

	/*
	 * @Override public int updateUserNotice(UserNoticeKey userNotice) throws
	 * Exception { return 0; }
	 */

	@Override
	public int saveUserNotice(UserNoticeKey userNotice) throws Exception {
		int result = userNoticeDao.insertSelective(userNotice);
		return result;
	}

	@Override
	public int deleteUserNoticeByPrimaryKey(UserNoticeKey userNotice) throws Exception {
		int result = userNoticeDao.deleteByPrimaryKey(userNotice);
		return result;
	}

	@Override
	public List<UserNoticeKey> queryUserNoticeById(String userName) throws Exception {
		List<UserNoticeKey> list = userNoticeQueryDao.selectAllNotice(userName);
		return list;
	}

}
