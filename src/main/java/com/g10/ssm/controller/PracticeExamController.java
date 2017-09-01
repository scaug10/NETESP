package com.g10.ssm.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.PracticeExamKey;
import com.g10.ssm.service.PracticeExamService;

@Controller
public class PracticeExamController {
	@Autowired
	private PracticeExamService practiceExamService;

	@RequestMapping("/queryPracticeExam")
	public ModelAndView queryPracticeExam(@Param("examId") int examId, ModelAndView modelAndView) throws Exception {
		List<PracticeExamKey> list = practiceExamService.queryPracticeExamById(examId);
		modelAndView.addObject("PE", list);
		return modelAndView;
	}

	@RequestMapping("/savePracticeExam")
	@ResponseBody
	public int savePracticeExam(PracticeExamKey practiceExam) throws Exception {
		int result = practiceExamService.savePracticeExam(practiceExam);
		return result;
	}

	@RequestMapping("/deletePracticeExam")
	@ResponseBody
	public int deletePracticeExam(PracticeExamKey practiceExam) throws Exception {
		int result = practiceExamService.deletePracticeExamByPrimaryKey(practiceExam);
		return result;
	}

	@RequestMapping("/getAllPracticeExam")
	public ModelAndView getAllPracticeExam(ModelAndView modelAndView) throws Exception {
		List<PracticeExamKey> list = practiceExamService.queryPracticeExam();
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
