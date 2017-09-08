package com.g10.ssm.controller.testdatabase;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.testdatabase.ChoiceQuestion;
import com.g10.ssm.po.testdatabase.Subject;
import com.g10.ssm.service.testdatabase.ChoiceQuestionService;
import com.g10.ssm.service.testdatabase.SubjectService;

@Controller
@RequestMapping("/subject")
public class SubjectController {
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private ChoiceQuestionService choiceService;

	@RequestMapping("/querySubject")
	public ModelAndView querySubject(@Param("subjectId") int subjectId, ModelAndView modelAndView) throws Exception {
		Subject record = subjectService.querySubjectById(subjectId);
		modelAndView.addObject("subject", record);
		return modelAndView;
	}

	@RequestMapping("/save")
	@ResponseBody
	public int saveSubject(Subject subject, ChoiceQuestion choice) throws Exception {
		subject.setSubjectPattern("文字");
		subject.setTestDatabaseId(new Long(2));
		int result = subjectService.saveSubject(subject);
		if(result == 1){
			Integer id = subjectService.selectLastSubjectId(subject.getContent());
			if(id != null && id != 0){
				choice.setId(id);
				result = choiceService.saveChoiceQuestionBySubjectId(choice);
			}
		}
		return result;
	}

//	@RequestMapping("/editSubject")
//	@ResponseBody
//	public int updateSubject(Subject subject) throws Exception {
//		int result = subjectService.updateSubject(subject);
//		return result;
//	}

	@RequestMapping("/delete")
	@ResponseBody
	public int deleteSubject(Integer[] idList) throws Exception {
		if(idList == null) return 0;
		Integer result = subjectService.deleteSubjectByIds(idList);
//		int result = subjectService.deleteSubjectByPrimaryKey(subjectId);
		return result;
	}

	@RequestMapping("/all")
	@ResponseBody
	public List<Subject> getAllSubject(Integer id) throws Exception {
		if(id == null) return null;
		String testDatabaseMatter;
		if(id == 0) testDatabaseMatter="正规题库";
		else if(id == 1) testDatabaseMatter="练习题库";
		else if(id == 2) testDatabaseMatter="模拟题库";
		else testDatabaseMatter="竞赛题库";
		List<Subject> list = subjectService.querySubject(testDatabaseMatter);
		return list;
	}
	
	@RequestMapping("/add")
	public String addSubjectPage(){
		return "questionBank/QuestionAdd";
	}
	
	@RequestMapping("/search")
	@ResponseBody
	public List<Subject> searchSubject(Subject subject) throws Exception{
		if(subject.getName() != null && subject.getName() == 0) subject.setName(null);
		if(subject.getSubjectType() == "") subject.setSubjectType(null);
		List<Subject> list = subjectService.selectSubjectBySelective(subject);
		return list;
	}
	
	@RequestMapping("/edit")
	public String editSubject(Integer subjectId, Model model) throws Exception{
		if(subjectId != null && subjectId != 0){
			Subject subject = subjectService.querySubjectById(subjectId);
			model.addAttribute("Question", subject);
			return "questionBank/QuestionModify";
		}
		return null;
	}
	
	@RequestMapping("/check")
	public String checkSubject(Integer subjectId, Model model) throws Exception{
		if(subjectId != null && subjectId != 0){
			Subject subject = subjectService.querySubjectById(subjectId);
			model.addAttribute("Question", subject);
			return "questionBank/QuestionCheckMore";
		}
		return null;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Integer updateSubject(Subject subject) throws Exception{
		if(subject != null){
			Integer result = subjectService.updateSubject(subject);
			return result;
		}
		return 0;
	}

}
