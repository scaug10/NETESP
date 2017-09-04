package com.g10.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartLoadingController {
	
	@RequestMapping("/index")
	public String intoNetesp(){
		return "index3";
	}
	
	@RequestMapping("/summary")
	public String Summary(){
		return "summary0";
	}
	
	@RequestMapping("/password/reset")
	public String resetPassword(){
		return "login/resetPassword";
	}
	
	@RequestMapping("/questionbank")
	public String questionBank(){
		return "questionBank/QuestionBankManagement";
	}
	
}
