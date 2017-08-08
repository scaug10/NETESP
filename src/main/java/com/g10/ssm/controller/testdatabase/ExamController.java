package com.g10.ssm.controller.testdatabase;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.testdatabase.Exam;
import com.g10.ssm.service.testdatabase.ExamService;

@Controller
public class ExamController {
	@Autowired
	private ExamService examService;

	@RequestMapping("/queryExam")
	public ModelAndView queryExam(@Param("examId") int examId, ModelAndView modelAndView) throws Exception {
		Exam record = examService.queryExamById(examId);
		modelAndView.addObject("exam", record);
		return modelAndView;
	}

	@RequestMapping("/saveExam")
	public int saveExam(Exam exam) throws Exception {
		int result = examService.saveExam(exam);
		return result;
	}

	@RequestMapping("/editExam")
	public int editExam(Exam exam) throws Exception {
		int result = examService.updateExam(exam);
		return result;
	}

	@RequestMapping("/deleteExam")
	public int deleteExam(@Param("examId") int examId) throws Exception {
		int result = examService.deleteExamByPrimaryKey(examId);
		return result;
	}

	@RequestMapping("/getAllExam")
	public ModelAndView getAllExam(ModelAndView modelAndView) throws Exception {
		List<Exam> list = examService.queryExam();
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
