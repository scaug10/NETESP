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

	@Override
	public String[] getAllLearningTaskDepartment(int learningTaskId) throws Exception {
		String[] departmentName = userLearningTaskQueryDao.selectAllDepartmentName(learningTaskId);
		return departmentName;
	}

	@Override
	public String[] getAllUserName(int departmentId) throws Exception {
		String[] userName = userLearningTaskQueryDao.selectAllUserName(departmentId);
		return userName;
	}

	@Override
	public Integer[] getAllDepartmentId(int learningTaskId) throws Exception {
		Integer[] departmentId = userLearningTaskQueryDao.selectAllDepartmentId(learningTaskId);
		return departmentId;
	}

	@Override
	public int deleteUserLearningTask(Integer learningTaskId) throws Exception {
		int result = userLearningTaskQueryDao.deleteUserLearningTask(learningTaskId);
		return result;
	}

	@Override
	public Integer[] getAllLearningTaskByDepartmentId(int departmentId) throws Exception {
		Integer[] learningTaskId = userLearningTaskQueryDao.selectLearningTaskByName(departmentId);
		return learningTaskId;
	}

	@Override
	public String[] getLearningTaskById(int learningTaskId) throws Exception {
		String[] userName = userLearningTaskQueryDao.selectLearningTaskById(learningTaskId);
		return userName;
	}

}
