package com.g10.ssm.service.testdatabase;

import java.util.List;

import com.g10.ssm.po.testdatabase.QuestionDifficulty;

public interface QuestionDifficultyService {
	public List<QuestionDifficulty> queryQuestionDifficulty() throws Exception;

	public int updateQuestionDifficulty(QuestionDifficulty questionDifficulty) throws Exception;

	public int saveQuestionDifficulty(QuestionDifficulty questionDifficulty) throws Exception;

	public int deleteQuestionDifficultyByPrimaryKey(int difficultyId) throws Exception;

	public QuestionDifficulty queryQuestionDifficultyById(Integer difficultyId) throws Exception;
}
