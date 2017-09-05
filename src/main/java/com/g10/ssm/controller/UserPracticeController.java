package com.g10.ssm.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.UserPracticeKey;
import com.g10.ssm.service.UserPracticeService;

@Controller
public class UserPracticeController {
	@Autowired
	private UserPracticeService userPracticeService;

	@RequestMapping("/queryUserPractice")
	public ModelAndView queryUserPractice(@Param("userName") String userName, ModelAndView modelAndView)
			throws Exception {
		List<UserPracticeKey> list = userPracticeService.queryUserPracticeById(userName);
		modelAndView.addObject("UPlist", list);
		return modelAndView;
	}

	@RequestMapping("/saveUserPractice")
	@ResponseBody
	public int saveUserPractice(UserPracticeKey userPractice) throws Exception {
		int result = userPracticeService.saveUserPractice(userPractice);
		return result;
	}

	@RequestMapping("/deleteUserPractice")
	@ResponseBody
	public int deleteUserPractice(UserPracticeKey userPractice) throws Exception {
		int result = userPracticeService.deleteUserPracticeByPrimaryKey(userPractice);
		return result;
	}

	@RequestMapping("/getAllUserPractice")
	public ModelAndView getAllUserPractice(ModelAndView modelAndView) throws Exception {
		List<UserPracticeKey> list = userPracticeService.queryUserPractice();
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
