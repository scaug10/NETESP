package com.g10.ssm.service.imple.testdatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.testdatabase.QuestionDifficultyMapper;
import com.g10.ssm.mapper.testdatabase.QuestionDifficultyQueryMapper;
import com.g10.ssm.po.testdatabase.QuestionDifficulty;
import com.g10.ssm.service.testdatabase.QuestionDifficultyService;

@Service("/questionDifficulty")
public class QuestionDifficultyServiceImpl implements QuestionDifficultyService {

	@Autowired
	private QuestionDifficultyMapper questionDifficultyDao;
	@Autowired
	private QuestionDifficultyQueryMapper questionDifficultyQueryDao;

	@Override
	public List<QuestionDifficulty> queryQuestionDifficulty() throws Exception {
		List<QuestionDifficulty> list = questionDifficultyQueryDao.selectAllQuestionDifficulty();
		return list;
	}

	@Override
	public int updateQuestionDifficulty(QuestionDifficulty questionDifficulty) throws Exception {
		int result = questionDifficultyDao.updateByPrimaryKeySelective(questionDifficulty);
		return result;
	}

	@Override
	public int saveQuestionDifficulty(QuestionDifficulty questionDifficulty) throws Exception {
		int result = questionDifficultyDao.insertSelective(questionDifficulty);
		return result;
	}

	@Override
	public int deleteQuestionDifficultyByPrimaryKey(int difficultyId) throws Exception {
		int result = questionDifficultyDao.deleteByPrimaryKey(difficultyId);
		return result;
	}

	@Override
	public QuestionDifficulty queryQuestionDifficultyById(Integer difficultyId) throws Exception {
		QuestionDifficulty record = questionDifficultyDao.selectByPrimaryKey(difficultyId);
		return record;
	}

}
