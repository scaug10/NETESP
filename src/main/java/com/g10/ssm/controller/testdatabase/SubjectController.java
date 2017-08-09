package com.g10.ssm.controller.testdatabase;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.testdatabase.Subject;
import com.g10.ssm.service.testdatabase.SubjectService;

@Controller
public class SubjectController {
	@Autowired
	private SubjectService subjectService;

	@RequestMapping("/querySubject")
	public ModelAndView querySubject(@Param("subjectId") int subjectId, ModelAndView modelAndView) throws Exception {
		Subject record = subjectService.querySubjectById(subjectId);
		modelAndView.addObject("subject", record);
		return modelAndView;
	}

	@RequestMapping("/saveSubject")
	@ResponseBody
	public int saveSubject(Subject subject) throws Exception {
		int result = subjectService.saveSubject(subject);
		return result;
	}

	@RequestMapping("/updateSubject")
	@ResponseBody
	public int updateSubject(Subject subject) throws Exception {
		int result = subjectService.updateSubject(subject);
		return result;
	}

	@RequestMapping("/deleteSubject")
	@ResponseBody
	public int deleteSubject(@Param("subjectId") int subjectId) throws Exception {
		int result = subjectService.deleteSubjectByPrimaryKey(subjectId);
		return result;
	}

	@RequestMapping("/getAllSubject")
	public ModelAndView getAllSubject(ModelAndView modelAndView) throws Exception {
		List<Subject> list = subjectService.querySubject();
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
