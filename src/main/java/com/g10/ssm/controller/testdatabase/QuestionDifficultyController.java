package com.g10.ssm.controller.testdatabase;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.testdatabase.QuestionDifficulty;
import com.g10.ssm.service.testdatabase.QuestionDifficultyService;

@Controller
public class QuestionDifficultyController {

	@Autowired
	private QuestionDifficultyService questionDifficultyService;

	@RequestMapping("/queryQuestionDifficulty")
	public ModelAndView queryQuestionDifficulty(@Param("difficultyId") Integer difficultyId, ModelAndView modelAndView)
			throws Exception {
		QuestionDifficulty record = questionDifficultyService.queryQuestionDifficultyById(difficultyId);
		modelAndView.addObject("QD", record);
		return modelAndView;
	}

	@RequestMapping("/saveQuestionDifficulty")
	public int saveQuestionDifficulty(QuestionDifficulty questionDifficulty) throws Exception {
		int result = questionDifficultyService.saveQuestionDifficulty(questionDifficulty);
		return result;
	}

	@RequestMapping("/editQuestionDifficulty")
	public int editQuestionDifficulty(QuestionDifficulty questionDifficulty) throws Exception {
		int result = questionDifficultyService.updateQuestionDifficulty(questionDifficulty);
		return result;
	}

	@RequestMapping("/deleteQuestionDifficulty")
	public int deleteQuestionDifficulty(int difficultyId) throws Exception {
		int result = questionDifficultyService.deleteQuestionDifficultyByPrimaryKey(difficultyId);
		return result;
	}

	@RequestMapping("/getAllQuestionDifficulty")
	public ModelAndView getAllQuestionDifficulty(ModelAndView modelAndView) throws Exception {
		List<QuestionDifficulty> list = questionDifficultyService.queryQuestionDifficulty();
		modelAndView.addObject("QDlist", list);
		return modelAndView;
	}
}