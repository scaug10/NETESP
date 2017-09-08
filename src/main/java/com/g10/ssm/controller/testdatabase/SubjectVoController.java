package com.g10.ssm.controller.testdatabase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.g10.ssm.po.testdatabase.ChoiceQuestion;
import com.g10.ssm.po.testdatabase.Exam;
import com.g10.ssm.po.testdatabase.ExamQuestionKey;
import com.g10.ssm.po.testdatabase.Strategy;
import com.g10.ssm.po.testdatabase.Subject;
import com.g10.ssm.po.testdatabase.SubjectCustom;
import com.g10.ssm.po.testdatabase.SubjectQueryVo;
import com.g10.ssm.po.testdatabase.TestItemsDesign;
import com.g10.ssm.service.testdatabase.ChoiceQuestionService;
import com.g10.ssm.service.testdatabase.ExamQuestionService;
import com.g10.ssm.service.testdatabase.ExamService;
import com.g10.ssm.service.testdatabase.StrategyQuestionTypesService;
import com.g10.ssm.service.testdatabase.StrategyService;
import com.g10.ssm.service.testdatabase.SubjectService;
import com.g10.ssm.service.testdatabase.TestItemsDesignService;

@Controller
@RequestMapping("/test")
public class SubjectVoController {
	@Autowired
	private StrategyQuestionTypesService sqts;
	
	@Autowired
	private TestItemsDesignService tds;
	
	@Autowired 
	private SubjectService subjectService;
	
	@Autowired
	private ExamQuestionService eqService;
	
	@Autowired
	private ChoiceQuestionService choiceService;
	
	@Autowired
	private StrategyService strategyService;
	
	@Autowired
	private ExamService examService;
	
	private List<Integer> getAllDids(Integer strategyId) throws Exception{
		if(strategyId != null && strategyId != 0){
			List<Integer> ids = null;
			ids = sqts.selectTidByStrategyId(strategyId);
			return ids;
		}
		return null;
	}
	
	private TestItemsDesign getTestItemsDesign(Integer id) throws Exception{
		if(id != null && id != 0){
			TestItemsDesign testDesign = null;
			testDesign = tds.queryTestItemsDesignById(id);
			return testDesign;
		}
		return null;
	}
	
	private List<Subject> getSubjectsById(Integer id) throws Exception{
		if(id != null && id != 0){
			List<Integer> list = null;
			list = eqService.selectSubjectIdByExamId(id);
			if(list != null){
				List<Subject> subjects = new ArrayList<Subject>();
				for(Integer subjectId: list){
					Subject subject = subjectService.querySubjectById(subjectId);
					if(subject != null)
						subjects.add(subject);
				}
				return subjects;
			}
		}
		return null;
	}
	
	@RequestMapping("/singleChoice")
	@ResponseBody
	public SubjectQueryVo getSingleChoice(Exam exam, String subjectType) throws Exception{
		if(exam != null && exam.getExamId() != null && exam.getStrategyId() != null){
			List<Integer> tids = getAllDids(exam.getStrategyId());
			if(tids != null){
				//获取某种题型下的所有题
				List<SubjectCustom> list = new ArrayList<SubjectCustom>();
				SubjectQueryVo subjectQueryVo = new SubjectQueryVo();
				for(Integer id: tids){
					//获取单道题
					TestItemsDesign testDesign = getTestItemsDesign(id);
					if(testDesign != null && testDesign.getExamType().equals(subjectType)){
						subjectQueryVo.setSingleScore(testDesign.getScore());
						//获取试卷中所有试题
						List<Subject> subjects = getSubjectsById(exam.getExamId());
						for(Subject subject: subjects){
							if(subject.getSubjectType().equals(subjectType)){
								SubjectCustom subjectCustom = new SubjectCustom(subject);
								ChoiceQuestion choice = choiceService.selectChoiceById(subject.getSubjectId());
								subjectCustom.setChoice(choice);
								list.add(subjectCustom);
							}
						}
					}
				}
				subjectQueryVo.setList(list);
				return subjectQueryVo;
			}
		}
		return null;
	}
	
	private boolean createExam(Integer strategyId, Integer examId) throws Exception{
		if(strategyId != null && strategyId != 0){
			if(examId != null && examId != 0){
				List<Integer> ids = null;
				ids = sqts.selectTidByStrategyId(strategyId);
				if(ids != null){
					for(Integer id: ids){
						TestItemsDesign testDesign = getTestItemsDesign(id);
						SubjectCustom subject = new SubjectCustom();
						subject.setLowerlimitDifficultyId(testDesign.getLowerlimitDifficultyId());
						subject.setToplimitDifficultyId(testDesign.getToplimitDifficultyId());
						subject.setSubjectNum(testDesign.getNumber());
						subject.setSubjectType(testDesign.getExamType());
						List<Integer> sids = subjectService.selectIdsByExample(subject);
						if(sids.size() < subject.getSubjectNum())
							return false;
						for(Integer sid: sids){
							ExamQuestionKey examQuestion = new ExamQuestionKey();
							examQuestion.setExamId(examId);
							examQuestion.setSubjectId(sid);
							int result = eqService.saveExamQuestion(examQuestion);
							if(result == 0) return false;
						}
					}
				}
			}
			return true;
		}
		return false;
	}
	
	@RequestMapping("/submit/exam")
	@ResponseBody
	public Integer generateExam(Integer strategyId, String examName) throws Exception{
		if(examName != null && strategyId != null && strategyId != 0){
			Exam exam = new Exam();
			exam.setName(examName);
			exam.setStrategyId(strategyId);
			int result = examService.saveExam(exam);
			Exam exam0 = examService.queryExamByExam(exam);
			boolean ok = createExam(exam0.getStrategyId(), exam0.getExamId());
			return ok ? result : 0;
		}
		return 0;
	}
	
	@RequestMapping("/testpaper")
	public String getTest(Model model, Integer examId, Integer strategyId) throws Exception{
		model.addAttribute("examId", examId);
		model.addAttribute("strategyId", strategyId);
		return "questionBank/test";
	}
	
	@RequestMapping("/strategy/all")
	@ResponseBody
	public List<Strategy> getAllStrategy() throws Exception{
		List<Strategy> list = null;
		list = strategyService.queryStrategy();
		return list;
	}
	
	@RequestMapping("/add/exam")
	public String intoExamAdd(){
		return "Strategy/ExaminationAdd";
	}

	
}
