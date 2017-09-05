package com.g10.ssm.controller.testdatabase;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.testdatabase.UserQuestionAnswer;
import com.g10.ssm.service.testdatabase.UserQuestionAnswerService;

@Controller
public class UserQuestionAnswerController {
	@Autowired
	private UserQuestionAnswerService userQuestionAnswerService;

	@RequestMapping("/queryUserQuestionAnswer")
	public ModelAndView queryUserQuestionAnswer(@Param("userAnswerId") int userAnswerId, ModelAndView modelAndView)
			throws Exception {
		UserQuestionAnswer record = userQuestionAnswerService.queryUserQuestionAnswerById(userAnswerId);
		modelAndView.addObject("UQA", record);
		return modelAndView;
	}

	@RequestMapping("/editUserQuestionAnswer")
	@ResponseBody
	public int editUserQuestionAnswer(UserQuestionAnswer userQuestionAnswer) throws Exception {
		int result = userQuestionAnswerService.updateUserQuestionAnswer(userQuestionAnswer);
		return result;
	}

	@RequestMapping("/saveUserQuestionAnswer")
	@ResponseBody
	public int saveUserQuestionAnswer(UserQuestionAnswer userQuestionAnswer) throws Exception {
		int result = userQuestionAnswerService.saveUserQuestionAnswer(userQuestionAnswer);
		return result;
	}

	@RequestMapping("/deleteUserQuestionAnswer")
	@ResponseBody
	public int deleteUserQuestionAnswer(@Param("userAnswerId") int userAnswerId) throws Exception {
		int result = userQuestionAnswerService.deleteUserQuestionAnswerByPrimaryKey(userAnswerId);
		return result;
	}

	@RequestMapping("/getAllUserQuestionAnswer")
	public ModelAndView getAllUserQuestionAnswer(@Param("userName") String userName, ModelAndView modelAndView)
			throws Exception {
		List<UserQuestionAnswer> list = userQuestionAnswerService.queryUserQuestionAnswer(userName);
		modelAndView.addObject("list", list);
		return modelAndView;
	}
}
