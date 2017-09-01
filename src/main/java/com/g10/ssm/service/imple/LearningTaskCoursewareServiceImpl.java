package com.g10.ssm.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.LearningTaskCoursewareMapper;
import com.g10.ssm.mapper.LearningTaskCoursewareQueryMapper;
import com.g10.ssm.po.LearningTaskCoursewareKey;
import com.g10.ssm.service.LearningTaskCoursewareService;

@Service("learningTaskCoursewareService")
public class LearningTaskCoursewareServiceImpl implements LearningTaskCoursewareService {

	@Autowired
	private LearningTaskCoursewareMapper learningTaskCoursewareDao;
	@Autowired
	private LearningTaskCoursewareQueryMapper learningTaskCoursewareQueryDao;

	@Override
	public List<LearningTaskCoursewareKey> queryLearningTaskCourseware() throws Exception {
		List<LearningTaskCoursewareKey> list = learningTaskCoursewareQueryDao.selectAllLearningTaskCourseware();
		return list;
	}

	@Override
	public int saveLearningTaskCourseware(LearningTaskCoursewareKey learningTaskCourseware) throws Exception {
		int result = learningTaskCoursewareDao.insertSelective(learningTaskCourseware);
		return result;
	}

	@Override
	public int deleteLearningTaskCoursewareByPrimaryKey(LearningTaskCoursewareKey learningTaskCourseware)
			throws Exception {
		int result = learningTaskCoursewareDao.deleteByPrimaryKey(learningTaskCourseware);
		return result;
	}

	@Override
	public List<LearningTaskCoursewareKey> queryLearningTaskCoursewareById(int learningTaskId) throws Exception {
		List<LearningTaskCoursewareKey> list = learningTaskCoursewareQueryDao
				.selectCoursewareByLearningTaskId(learningTaskId);
		return list;
	}

}
