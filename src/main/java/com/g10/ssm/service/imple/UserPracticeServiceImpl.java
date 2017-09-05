package com.g10.ssm.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.UserPracticeMapper;
import com.g10.ssm.mapper.UserPracticeQueryMapper;
import com.g10.ssm.po.UserPracticeKey;
import com.g10.ssm.service.UserPracticeService;

@Service("userPracticeService")
public class UserPracticeServiceImpl implements UserPracticeService {

	@Autowired
	private UserPracticeMapper userPracticeDao;
	@Autowired
	private UserPracticeQueryMapper userPracticeQueryDao;

	@Override
	public List<UserPracticeKey> queryUserPractice() throws Exception {
		List<UserPracticeKey> list = userPracticeQueryDao.selectAllUserPractice();
		return list;
	}

	/*
	 * @Override public int updateUserPractice(UserPracticeKey userPractice)
	 * throws Exception { return 0; }
	 */

	@Override
	public int saveUserPractice(UserPracticeKey userPractice) throws Exception {
		int result = userPracticeDao.insertSelective(userPractice);
		return result;
	}

	@Override
	public int deleteUserPracticeByPrimaryKey(UserPracticeKey userPractice) throws Exception {
		int result = userPracticeDao.deleteByPrimaryKey(userPractice);
		return result;
	}

	@Override
	public List<UserPracticeKey> queryUserPracticeById(String userName) throws Exception {
		List<UserPracticeKey> list = userPracticeQueryDao.selectAllPractice(userName);
		return list;
	}

}
