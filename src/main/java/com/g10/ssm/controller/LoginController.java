package com.g10.ssm.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.Permission;
import com.g10.ssm.po.User;
import com.g10.ssm.service.LoginService;
import com.g10.ssm.service.PermissionService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private PermissionService permissionService;
	
	/**
	 * 用户注册,并赋予一个默认权限
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView register(@RequestParam(value="user",required=true)User user) throws Exception{
		ModelAndView modelAndView=new ModelAndView();
		if(user==null){
			modelAndView.addObject("result", -1);//用户不能为空
			modelAndView.setViewName("register");
		}
		String userName=user.getUserName();
		boolean result=loginService.isUserIdExist(userName);
		if(result==true){
			modelAndView.addObject("result", 7);//用户名已存在
			modelAndView.setViewName("register");
			return modelAndView;
		}
		user.setLoginStatus(false);
		user.setRegisterTime(new Date());
		int res=loginService.saveUser(user);
		if(res == 1) {
			modelAndView.addObject("result",1);//用户注册成功
			modelAndView.setViewName("login");
		}
		else{
			modelAndView.addObject("result", -1);//用户注册失败
			modelAndView.setViewName("register");
		}
		return modelAndView;
		
	}
	
	/**
	 * 用户登录,只要有多个权限就是管理员，否则就是用户
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(@RequestParam(value="userName",required=true)String userName,
			@RequestParam(value="password",required=true)String password,
			HttpServletRequest request)throws Exception{
		ModelAndView modelAndView=new ModelAndView();
		if(userName==null||password==null){
			modelAndView.addObject("result", -1);//用户名或密码不能为空
			modelAndView.setViewName("login");
			return modelAndView;
		}
		int res=loginService.checkUserPassword(userName, password);
		if(res==1){
			ArrayList<Permission> list=permissionService.searchUserPermissionList(userName);
			if(list.size()>0){
				modelAndView.addObject("result", 1);//用户登录成功
				request.getSession().setAttribute("userName", userName);
				modelAndView.addObject("permissionList", list);
				modelAndView.setViewName("main");
			}else {
				modelAndView.addObject("result", -2);//用户登录失败
				modelAndView.addObject("permissionList", list);
				modelAndView.setViewName("login");
			}
		}else {
			modelAndView.addObject("result", -1);//用户登录失败
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}
	
	/**
	 * 找回密码
	 */
	@RequestMapping(value="/findPassword",method=RequestMethod.POST)
	public ModelAndView findPassword(@RequestParam(value="userName",required=true)String userName)throws Exception{
		ModelAndView modelAndView=new ModelAndView();
		if(userName==null){
			modelAndView.addObject("result", -1);//用户名不能为空
			modelAndView.setViewName("findPassword");
			return modelAndView;
		}
		int res=loginService.findPassword(userName);
		if(res==1){
			modelAndView.addObject("result", 1);//用户找回密码成功
			modelAndView.setViewName("login");
		}else {
			modelAndView.addObject("result", -1);//用户找回密码失败
			modelAndView.setViewName("findPassword");
		}
		return modelAndView;
	}
}
