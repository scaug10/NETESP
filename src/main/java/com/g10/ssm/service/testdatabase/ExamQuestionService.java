package com.g10.ssm.service.testdatabase;

import java.util.List;

import com.g10.ssm.po.testdatabase.ExamQuestionKey;

public interface ExamQuestionService {
	public List<ExamQuestionKey> queryExamQuestion() throws Exception;

	/*
	 * public int updateExamQuestion(ExamQuestionKey examQuestion) throws
	 * Exception;
	 */

	public int saveExamQuestion(ExamQuestionKey examQuestion) throws Exception;

	public int deleteExamQuestionByPrimaryKey(ExamQuestionKey examQuestion) throws Exception;

}
