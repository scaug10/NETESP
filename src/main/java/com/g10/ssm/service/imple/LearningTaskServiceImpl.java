package com.g10.ssm.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.LearningTaskMapper;
import com.g10.ssm.mapper.LearningTaskQueryMapper;
import com.g10.ssm.po.LearningTask;
import com.g10.ssm.service.LearningTaskService;

@Service("learningTaskService")
public class LearningTaskServiceImpl implements LearningTaskService {

	@Autowired
	private LearningTaskMapper learningTaskDao;
	@Autowired
	private LearningTaskQueryMapper learningTaskQueryDao;

	@Override
	public List<LearningTask> queryLearningTask() throws Exception {
		List<LearningTask> list = learningTaskQueryDao.selectAllLearnTask();
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

}
