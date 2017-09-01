package com.g10.ssm.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.LearningTask;
import com.g10.ssm.service.LearningTaskService;

@Controller
public class LearningTaskController {
	@Autowired
	private LearningTaskService learningTaskService;

	@RequestMapping("/queryLearningTask")
	public ModelAndView queryLearningTask(@Param("learningTaskId") int learningTaskId, ModelAndView modelAndView)
			throws Exception {
		LearningTask record = learningTaskService.queryLearningTaskById(learningTaskId);
		modelAndView.addObject("LearningTask", record);
		return modelAndView;
	}

	@RequestMapping("/editLearningTask")
	@ResponseBody
	public int editLearningTask(LearningTask learningTask) throws Exception {
		int result = learningTaskService.updateLearningTask(learningTask);
		return result;
	}

	@RequestMapping("/saveLearningTask")
	@ResponseBody
	public int saveLearningTask(LearningTask learningTask) throws Exception {
		int result = learningTaskService.saveLearningTask(learningTask);
		return result;
	}

	@RequestMapping("/deleteLearningTask")
	@ResponseBody
	public int deleteLearningTask(@Param("learningTaskId") int learningTaskId) throws Exception {
		int result = learningTaskService.deleteLearningTaskByPrimaryKey(learningTaskId);
		return result;
	}

	@RequestMapping("/getAllLearningTask")
	public ModelAndView getAllLearningTask(ModelAndView modelAndView) throws Exception {
		List<LearningTask> list = learningTaskService.queryLearningTask();
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
