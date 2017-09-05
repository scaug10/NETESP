package com.g10.ssm.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.UserNoticeKey;
import com.g10.ssm.service.UserNoticeService;

@Controller
public class UserNoticeController {
	@Autowired
	private UserNoticeService userNoticeService;

	@RequestMapping("/queryUserNotice")
	public ModelAndView queryUserNotice(@Param("userName") String userName, ModelAndView modelAndView)
			throws Exception {
		List<UserNoticeKey> list = userNoticeService.queryUserNoticeById(userName);
		modelAndView.addObject("UNlist", list);
		return modelAndView;
	}

	@RequestMapping("/saveUserNotice")
	@ResponseBody
	public int saveUserNotice(UserNoticeKey userNotice) throws Exception {
		int result = userNoticeService.saveUserNotice(userNotice);
		return result;
	}

	@RequestMapping("/deleteUserNotice")
	@ResponseBody
	public int deleteUserNotice(UserNoticeKey userNotice) throws Exception {
		int result = userNoticeService.deleteUserNoticeByPrimaryKey(userNotice);
		return result;
	}

	@RequestMapping("/getAllUserNotice")
	public ModelAndView getAllUserNotice(ModelAndView modelAndView) throws Exception {
		List<UserNoticeKey> list = userNoticeService.queryUserNotice();
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
