package com.g10.ssm.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.User;
import com.g10.ssm.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	/*
	 * 用户注册,并赋予一个默认权限
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView register(User user) throws Exception{
		String userName=user.getUserName();
		boolean result=loginService.isUserIdExist(userName);
		ModelAndView modelAndView=new ModelAndView();
		if(result==true){
			modelAndView.addObject("result", 7);
			modelAndView.setViewName("register");
			return modelAndView;
		}
		user.setLoginStatus(false);
		user.setRegisterTime(new Date());
		int res=loginService.saveUser(user);
		if(res == 1) {
			modelAndView.addObject("result",1);
			modelAndView.setViewName("login");
		}
		else{
			modelAndView.addObject("result", -1);
			modelAndView.setViewName("register");
		}
		return modelAndView;
		
	}
	
	/*
	 * 用户登录
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(@RequestParam(value="userName",required=true)String userName,
			@RequestParam(value="password",required=true)String password)throws Exception{
		int res=loginService.checkUserPassword(userName, password);
		ModelAndView modelAndView=new ModelAndView();
		if(res==1){
			modelAndView.addObject("result", 1);
			modelAndView.setViewName("main");
		}else {
			modelAndView.addObject("result", -1);
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}
	
	/*
	 * 找回密码
	 */
	@RequestMapping(value="/findPassword",method=RequestMethod.POST)
	public String findPassword(@RequestParam(value="userName",required=true)int userName)throws Exception{
		
		return null;
	}
}
