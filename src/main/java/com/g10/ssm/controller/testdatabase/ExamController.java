package com.g10.ssm.controller.testdatabase;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.g10.ssm.po.testdatabase.Exam;
import com.g10.ssm.po.testdatabase.ExamCustom;
import com.g10.ssm.service.testdatabase.ExamService;
import com.g10.ssm.service.testdatabase.StrategyService;

@Controller
public class ExamController {
	@Autowired
	private ExamService examService;
	
	@Autowired
	private StrategyService strategyService;

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

	@RequestMapping("/exam/delete")
	@ResponseBody
	public int deleteExam(Integer[] examId) throws Exception {
		int result = examService.deleteExamByPrimaryKey(examId);
		return result;
	}

	@RequestMapping("/exam/query")
	@ResponseBody
	public List<ExamCustom> getAllExam() throws Exception {
		List<Exam> list = examService.queryExam();
		List<ExamCustom> exams = new ArrayList<ExamCustom>();
		for(Exam exam: list){
			ExamCustom examCustom = new ExamCustom();
			examCustom.setExamId(exam.getExamId());
			examCustom.setName(exam.getName());
			examCustom.setStrategyId(exam.getStrategyId());
			String name = strategyService.selectStrategyNameById(exam.getStrategyId());
			examCustom.setStrategyName(name);
			exams.add(examCustom);
		}
		return exams;
	}
	
	@RequestMapping("/exam/all")
	public String intoExamManage(){
		return "Strategy/ExaminationManagement";
	}
}
