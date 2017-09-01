package com.g10.ssm.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.LearningTaskCoursewareKey;
import com.g10.ssm.service.LearningTaskCoursewareService;

@Controller
public class LearningTaskCoursewareController {
	@Autowired
	private LearningTaskCoursewareService learningTaskCoursewareService;

	@RequestMapping("/queryLearningTaskCourseware")
	public ModelAndView queryLearningTaskCourseware(@Param("learningTaskId") int learningTaskId,
			ModelAndView modelAndView) throws Exception {
		List<LearningTaskCoursewareKey> list = learningTaskCoursewareService
				.queryLearningTaskCoursewareById(learningTaskId);
		modelAndView.addObject("Coslist", list);
		return modelAndView;
	}

	@RequestMapping("/saveLearningTaskCourseware")
	@ResponseBody
	public int saveLearningTaskCourseware(LearningTaskCoursewareKey learningTaskCourseware) throws Exception {
		int result = learningTaskCoursewareService.saveLearningTaskCourseware(learningTaskCourseware);
		return result;
	}

	@RequestMapping("/deleteLearningTaskCourseware")
	@ResponseBody
	public int deleteLearningTaskCourseware(LearningTaskCoursewareKey learningTaskCourseware) throws Exception {
		int result = learningTaskCoursewareService.deleteLearningTaskCoursewareByPrimaryKey(learningTaskCourseware);
		return result;
	}

	@RequestMapping("/getAllLearningTaskCourseware")
	public ModelAndView getAllLearningTaskCourseware(ModelAndView modelAndView) throws Exception {
		List<LearningTaskCoursewareKey> list = learningTaskCoursewareService.queryLearningTaskCourseware();
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
