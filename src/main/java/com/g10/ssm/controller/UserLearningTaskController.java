package com.g10.ssm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.ws.RespectBinding;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.UserLearningTaskKey;
import com.g10.ssm.service.UserLearningTaskService;

@Controller
public class UserLearningTaskController {
	@Autowired
	private UserLearningTaskService userLearningTaskService;

	@RequestMapping("/queryUserLearningTask")
	public ModelAndView queryUserLearningTask(@Param("userName") String userName, ModelAndView modelAndView)
			throws Exception {
		List<UserLearningTaskKey> list = userLearningTaskService.queryUserLearningTaskById(userName);
		modelAndView.addObject("ULTlist", list);
		return modelAndView;
	}

	@RequestMapping("/saveUserLearningTask")
	@ResponseBody
	public int saveUserLearningTask(UserLearningTaskKey userLearningTask) throws Exception {
		int result = userLearningTaskService.saveUserLearningTask(userLearningTask);
		return result;
	}

	@RequestMapping("/deleteUserLearningTask")
	@ResponseBody
	public int deleteUserLearningTask(UserLearningTaskKey userLearningTask) throws Exception {
		int result = userLearningTaskService.deleteUserLearningTaskPrimaryKey(userLearningTask);
		return result;
	}

	@RequestMapping("/getAllUserLearningTask")
	public ModelAndView getAllUserLearningTask(ModelAndView modelAndView) throws Exception {
		List<UserLearningTaskKey> list = userLearningTaskService.queryUserLearningTask();
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
