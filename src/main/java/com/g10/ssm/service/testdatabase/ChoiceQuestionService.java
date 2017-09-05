package com.g10.ssm.service.testdatabase;


import com.g10.ssm.po.testdatabase.ChoiceQuestion;

public interface ChoiceQuestionService {

	/**
	 * @Title: saveChoiceQuestionBySubjectId 
	 * @Description: 单选题，多选题，判断题，保存A，B，C，D或E选项
	 * @param choice
	 * @throws Exception
	 * @return int
	 */
	public int saveChoiceQuestionBySubjectId(ChoiceQuestion choice)
			throws Exception;
	
	public ChoiceQuestion selectChoiceById(Integer choiceId) throws Exception;
	
}
