package com.g10.ssm.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.Practice;
import com.g10.ssm.service.PracticeService;

@Controller
public class PracticeController {
	@Autowired
	private PracticeService practiceService;

	@RequestMapping("/queryPractice")
	public ModelAndView queryPractice(@Param("practiceId") int practiceId, ModelAndView modelAndView) throws Exception {
		Practice record = practiceService.queryPracticeById(practiceId);
		modelAndView.addObject("Practice", record);
		return modelAndView;
	}

	@RequestMapping("/editPractice")
	@ResponseBody
	public int editPractice(Practice practice) throws Exception {
		int result = practiceService.updatePractice(practice);
		return result;
	}

	@RequestMapping("/savePractice")
	@ResponseBody
	public int savePractice(Practice practice) throws Exception {
		int result = practiceService.savePractice(practice);
		return result;
	}

	@RequestMapping("/deletePractice")
	@ResponseBody
	public int deletePractice(@Param("practiceId") int practiceId) throws Exception {
		int result = practiceService.deletePracticeByPrimaryKey(practiceId);
		return result;
	}

	@RequestMapping("/getAllPractice")
	public ModelAndView getAllPractice(ModelAndView modelAndView) throws Exception {
		List<Practice> list = practiceService.queryPractice();
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
