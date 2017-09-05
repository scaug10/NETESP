package com.g10.ssm.service.testdatabase;

import java.util.List;

import com.g10.ssm.po.testdatabase.ExamTypeWeightKey;

public interface ExamTypeWeightService {
	public List<ExamTypeWeightKey> queryExamTypeWeight() throws Exception;

	/*
	 * public int updateTestTable(ExamTypeWeightKey testTable) throws Exception;
	 */

	public int saveExamTypeWeight(ExamTypeWeightKey examTypeWeight) throws Exception;

	public int deleteExamTypeWeightByPrimaryKey(ExamTypeWeightKey examTypeWeight) throws Exception;

}
