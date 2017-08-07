package com.g10.ssm.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.User;
import com.g10.ssm.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView register(User user){
		user.setLoginStatus(false);
		user.setRegisterTime(new Date());
		return null;
		
	}
}
