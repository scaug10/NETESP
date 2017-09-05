package com.g10.ssm.service;

import java.util.List;

import com.g10.ssm.po.PracticeExamKey;

public interface PracticeExamService {
	public List<PracticeExamKey> queryPracticeExam() throws Exception;

	/*
	 * public int updatePracticeExam(PracticeExamKey practiceExam) throws
	 * Exception;
	 */

	public int savePracticeExam(PracticeExamKey practiceExam) throws Exception;

	public int deletePracticeExamByPrimaryKey(PracticeExamKey practiceExam) throws Exception;

	public List<PracticeExamKey> queryPracticeExamById(Integer examId) throws Exception;
}
