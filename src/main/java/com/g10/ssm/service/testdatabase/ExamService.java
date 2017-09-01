package com.g10.ssm.service.testdatabase;

import java.util.List;

import com.g10.ssm.po.testdatabase.Exam;

public interface ExamService {
	public List<Exam> queryExam() throws Exception;

	public List<Exam> queryExamByName(String name) throws Exception;

	public int updateExam(Exam exam) throws Exception;

	public int saveExam(Exam exam) throws Exception;

	public int deleteExamByPrimaryKey(Integer[] examId) throws Exception;

	public Exam queryExamById(Integer examId) throws Exception;

	public int checkExam(String name) throws Exception;
}
