package com.g10.ssm.controller.testdatabase;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.g10.ssm.po.testdatabase.Exam;
import com.g10.ssm.service.testdatabase.ExamService;

@Controller
public class ExamController {
	@Autowired
	private ExamService examService;

	@RequestMapping("/queryExam")
	public String queryExam(@Param("name") String name, Model model) throws Exception {
		List<Exam> list = examService.queryExamByName(name);
		model.addAttribute("list", list);
		return "Examination/examination";
	}

	@RequestMapping("/saveExam")
	@ResponseBody
	public int saveExam(Exam exam) throws Exception {
		int result = examService.checkExam(exam.getName());
		if (result == 1) {
			return 2;
		} else {
			result = examService.saveExam(exam);
			return result;
		}
	}

	@RequestMapping("/editExam")
	@ResponseBody
	public int editExam(Exam exam) throws Exception {
		int result = examService.updateExam(exam);
		return result;
	}

	@RequestMapping("/deleteExam")
	@ResponseBody
	public int deleteExam(Integer[] examId) throws Exception {
		int result = examService.deleteExamByPrimaryKey(examId);
		return result;
	}

	@RequestMapping("/getAllExam")
	public String getAllExam(Model model) throws Exception {
		List<Exam> list = examService.queryExam();
		model.addAttribute("list", list);
		return "Examination/examination";
	}
}
