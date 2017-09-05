package com.g10.ssm.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.UserLearningTaskMapper;
import com.g10.ssm.mapper.UserLearningTaskQueryMapper;
import com.g10.ssm.po.UserLearningTaskKey;
import com.g10.ssm.service.UserLearningTaskService;

@Service("userLearningTaskService")
public class UserLearningTaskServiceImpl implements UserLearningTaskService {

	@Autowired
	private UserLearningTaskMapper userLearningTaskDao;
	@Autowired
	private UserLearningTaskQueryMapper userLearningTaskQueryDao;

	@Override
	public List<UserLearningTaskKey> queryUserLearningTask() throws Exception {
		List<UserLearningTaskKey> list = userLearningTaskQueryDao.selectAllUserLearningTask();
		return list;
	}

	/*
	 * @Override public int updateUserLearningTask(UserLearningTaskKey
	 * userLearningTask) throws Exception {
	 * 
	 * return 0; }
	 */

	@Override
	public int saveUserLearningTask(UserLearningTaskKey userLearningTask) throws Exception {
		int result = userLearningTaskDao.insertSelective(userLearningTask);
		return result;
	}

	@Override
	public int deleteUserLearningTaskPrimaryKey(UserLearningTaskKey userLearningTask) throws Exception {
		int result = userLearningTaskDao.deleteByPrimaryKey(userLearningTask);
		return result;
	}

	@Override
	public List<UserLearningTaskKey> queryUserLearningTaskById(String userName) throws Exception {
		List<UserLearningTaskKey> list = userLearningTaskQueryDao.selectAllLearningTask(userName);
		return list;
	}

}
