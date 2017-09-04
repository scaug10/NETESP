package com.g10.ssm.service.imple.testdatabase;

import java.awt.Choice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g10.ssm.mapper.testdatabase.ChoiceQuestionMapper;
import com.g10.ssm.po.testdatabase.ChoiceQuestion;
import com.g10.ssm.service.testdatabase.ChoiceQuestionService;

@Service
public class ChoiceQuestionServiceImple implements ChoiceQuestionService{

	@Autowired
	ChoiceQuestionMapper choiceMapper;
	
	@Override
	public int saveChoiceQuestionBySubjectId(ChoiceQuestion choice)
			throws Exception {
		if(choice.getId() != null){
			int result = choiceMapper.insertSelective(choice);
			return result;
		}
		return 0;
	}

	@Override
	public ChoiceQuestion selectChoiceById(Integer choiceId) throws Exception {
		if(choiceId != null && choiceId != 0){
			ChoiceQuestion choice = choiceMapper.selectByPrimaryKey(choiceId);
			return choice;
		}
		return null;
	}

}
