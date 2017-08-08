package com.g10.ssm.controller.testdatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.testdatabase.ExamQuestionKey;
import com.g10.ssm.service.testdatabase.ExamQuestionService;

@Controller
public class ExamQuestionController {
	@Autowired
	private ExamQuestionService examQuestionService;

	@RequestMapping("/getAllExamQuestion")
	public ModelAndView queryExamQuestion(ModelAndView modelAndView) throws Exception {
		List<ExamQuestionKey> list = examQuestionService.queryExamQuestion();
		modelAndView.addObject("list", list);
		return modelAndView;
	}

	@RequestMapping("/saveExamQuestion")
	public int saveExamQuestion(ExamQuestionKey examQuestion) throws Exception {
		int result = examQuestionService.saveExamQuestion(examQuestion);
		return result;
	}

	@RequestMapping("/deleteExamQuestion")
	public int deleteExamQuestion(ExamQuestionKey examQuestion) throws Exception {
		int result = examQuestionService.deleteExamQuestionByPrimaryKey(examQuestion);
		return result;
	}
}
