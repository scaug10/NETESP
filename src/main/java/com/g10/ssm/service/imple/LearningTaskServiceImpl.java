package com.g10.ssm.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.LearningTaskMapper;
import com.g10.ssm.mapper.LearningTaskQueryMapper;
import com.g10.ssm.po.LearningTask;
import com.g10.ssm.po.LearningTaskExt;
import com.g10.ssm.service.LearningTaskService;

@Service("learningTaskService")
public class LearningTaskServiceImpl implements LearningTaskService {

	@Autowired
	private LearningTaskMapper learningTaskDao;
	@Autowired
	private LearningTaskQueryMapper learningTaskQueryDao;

	@Override
	public List<LearningTaskExt> queryLearningTask() throws Exception {
		List<LearningTaskExt> list = learningTaskQueryDao.selectAllLearnTask();
		return list;
	}

	@Override
	public int updateLearningTask(LearningTask learningTask) throws Exception {
		int result = learningTaskDao.updateByPrimaryKeySelective(learningTask);
		return result;
	}

	@Override
	public int saveLearningTask(LearningTask learningTask) throws Exception {
		int result = learningTaskDao.insertSelective(learningTask);
		return result;
	}

	@Override
	public int deleteLearningTaskByPrimaryKey(int learningTaskId) throws Exception {
		int result = learningTaskDao.deleteByPrimaryKey(learningTaskId);
		return result;
	}

	@Override
	public LearningTask queryLearningTaskById(Integer learningTaskId) throws Exception {
		LearningTask record = learningTaskDao.selectByPrimaryKey(learningTaskId);
		return record;
	}

	@Override
	public int checkLearningTask(String taskName) throws Exception {
		LearningTask record = learningTaskQueryDao.checkLearningTask(taskName);
		if (record != null) {
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteLearningTask(Integer[] learningTaskId) throws Exception {
		int result = learningTaskQueryDao.deleteLearningTask(learningTaskId);
		return result;
	}

	@Override
	public List<LearningTaskExt> searchLearningTask(String taskName) throws Exception {
		List<LearningTaskExt> list = learningTaskQueryDao.selectLearningTaskByName(taskName);
		return list;
	}

	@Override
	public int selectId() throws Exception {
		int learningTaskId = learningTaskQueryDao.selectId();
		return learningTaskId;
	}

	@Override
	public LearningTaskExt queryLearningTaskByLearningTaskId(Integer learningTaskId) throws Exception {
		LearningTaskExt record = learningTaskQueryDao.selectLearningTask(learningTaskId);
		return record;
	}

	@Override
	public List<LearningTaskExt> queryLearningTaskByDepartmentId(Integer departmentId) throws Exception {
		List<LearningTaskExt> list = learningTaskQueryDao.selectLearningTaskByDepartmentId(departmentId);
		return list;
	}

	@Override
	public List<LearningTaskExt> getAllLearningTaskByUserName(String userName) throws Exception {
		List<LearningTaskExt> list = learningTaskQueryDao.selectAllLearningTaskByUserName(userName);
		return list;
	}
}
