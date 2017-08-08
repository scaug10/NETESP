package com.g10.ssm.controller.testdatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.testdatabase.ExamTypeWeightKey;
import com.g10.ssm.service.testdatabase.ExamTypeWeightService;

@Controller
public class ExamTypeWeightController {
	@Autowired
	private ExamTypeWeightService examTypeWeightService;

	@RequestMapping("/getAllExamTypeWeight")
	public ModelAndView getAllExamTypeWeight(ModelAndView modelAndView) throws Exception {
		List<ExamTypeWeightKey> list = examTypeWeightService.queryExamTypeWeight();
		modelAndView.addObject("list", list);
		return modelAndView;
	}

	@RequestMapping("/saveExamTypeWeight")
	public int saveExamTypeWeight(ExamTypeWeightKey examTypeWeight) throws Exception {
		int result = examTypeWeightService.saveExamTypeWeight(examTypeWeight);
		return result;
	}

	@RequestMapping("/deleteExamTypeWeight")
	public int deleteExamTypeWeight(ExamTypeWeightKey examTypeWeight) throws Exception {
		int result = examTypeWeightService.deleteExamTypeWeightByPrimaryKey(examTypeWeight);
		return result;
	}
}
