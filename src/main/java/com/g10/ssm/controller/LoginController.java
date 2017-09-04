package com.g10.ssm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.po.Department;
import com.g10.ssm.po.Permission;
import com.g10.ssm.po.User;
import com.g10.ssm.service.DepartmentService;
import com.g10.ssm.service.LoginService;
import com.g10.ssm.service.PermissionService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private PermissionService permissionService;
	@Autowired DepartmentService departmentService;
	
	/**
	 * 用户注册,并赋予一个默认权限
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public Integer register(User user) throws Exception{
		if(user==null){
			return null;//用户不能为空
		}
		String userName=user.getUserName();
		boolean result=loginService.isUserIdExist(userName);
		if(result==true){
			return null;//用户名已存在
		}
		user.setLoginStatus(false);
		user.setRegisterTime(new Date());
		int res=loginService.saveUser(user);
		if(res == 1) {
			return 1;//用户注册成功
		}
		else{
			return null;//用户注册失败
		}
	}
	
	/**
	 * 查询用户列表
	 */
	@RequestMapping(value="/searchUserList",method=RequestMethod.POST)
	@ResponseBody
	public List<User> searchUserList(HttpServletRequest request) throws Exception{
		String userId=(String) request.getSession().getAttribute("userName");
		if(userId==null||userId.trim().equals("")){
			return null;//用户名不存在
		}
		if(!userId.equals("admin")){
			return null;//用户没有操作此功能的权限
		}
		List<User> list=loginService.searchUserList();
		if(list==null||list.size()<1){
			return null;//查询用户列表失败
		}else{
			return list;//用户注册失败
		}
	}
	
	/**
	 * 用户登录,只要有多个权限就是管理员，否则就是用户
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<Permission> login(String userName,String password,
			HttpServletRequest request,Model model)throws Exception{
		if(userName==null||password==null||userName.equals("")||password.equals("")){
			return null;//用户名或密码不能为空
		}
		int res=loginService.checkUserPassword(userName, password);
		if(res==1){
			ArrayList<Permission> list=(ArrayList<Permission>) permissionService.searchUserPermissionList(userName);
			if(list.size()>0){
				request.getSession().setAttribute("userName", userName);
				return list;//用户登录成功
			}else {
				return null;//用户登录失败
			}
		}else {
			return null;//用户名与密码不匹配
		}
	}
	
	/**
	 * 找回密码之发送验证码(发送邮件出错，暂时忽略)
	 */
	@RequestMapping(value="/sendVerificationCode",method=RequestMethod.POST)
	@ResponseBody
	public Integer sendVerificationCode(@RequestParam(value="userName",required=true)String userName,
			@RequestParam(value="email",required=true)String email,
			HttpServletRequest request)throws Exception{
		if(userName==null||email==null||userName.trim().equals("")||email.trim().equals("")){
			return null;//用户名或邮箱不能为空
		}
		Integer res=loginService.sendVerificationCode(userName,email);
		if(res==1){
			return res;//发送验证码成功
		}else{
			return null;//发送验证码失败(用户名不存在或用户输入邮箱与用户名不一致)
		}
	}
	
	/**
	 * 找回密码之发送用户原密码(发送邮件出错，暂时忽略)
	 * @throws Exception 
	 */
	@RequestMapping(value="/sendOriginPassword",method=RequestMethod.POST)
	@ResponseBody
	public Integer sendOriginPassword(@RequestParam(value="userName",required=true)String userName,
			@RequestParam(value="verificationCode",required=true)String verificationCode) throws Exception{
		if(userName==null||userName.trim().equals("")||verificationCode==null||verificationCode.trim().equals("")){
			return null;//用户名或验证码不能为空
		}
		Integer res=loginService.sendOriginPassword(userName,verificationCode);
		if(res==1){
			return res;//发送用户原密码成功
		}else{
			return null;//发送用户原密码失败(用户名不存在或用户输入的验证码与数据库的验证码不一致)
		}
	}
	
	/**
	 * 修改密码
	 * @throws Exception 
	 */
	@RequestMapping(value="/changePassword",method=RequestMethod.POST)
	public ModelAndView changePassword(@RequestParam(value="userName",required=true)String userName,
			@RequestParam(value="password",required=true)String password,
			HttpServletRequest request) throws Exception{
		ModelAndView modelAndView=new ModelAndView();
		if(userName==null||password==null||userName.trim().equals("")||password.trim().equals("")){
			modelAndView.addObject("result", -1);//用户名或密码不能为空
			modelAndView.setViewName("changePassword");
			return modelAndView;
		}
		int res=loginService.changePassword(userName,password);
		if(res==1){
			modelAndView.addObject("result", 1);//用户修改密码密码成功
			modelAndView.setViewName("login");
		}else{
			modelAndView.addObject("result", -1);//用户修改密码失败
			modelAndView.setViewName("changePassword");
		}
		return modelAndView;
	}
	
	/**
	 * 注册页面动态获取数据库的单位列表
	 * @throws Exception 
	 */
	@ModelAttribute("departments")
	public Map<Integer, String> getDepartmentList() throws Exception{
		ArrayList<Department> departmentList=null;
		departmentList=(ArrayList<Department>) departmentService.queryDepartment();
		if(departmentList!=null){
			Map<Integer, String> departments=new HashMap<Integer, String>();
			for(int i=0;i<departmentList.size();i++){
				departments.put(departmentList.get(i).getDepartmentId(), departmentList.get(i).getName());
			}
			return departments;
		}
		return null;
	}
	
	/**
	 * 跳到注册页面
	 */
	@RequestMapping("/jumpRegisterPage")
	public String jumpRegisterPage(){
		return "login/register";
	}
	
	/**
	 * 跳到登录页面
	 */
	@RequestMapping("/jumpLoginPage")
	public String jumpLoginPage(){
		return "login/login";
	}
	
	/**
	 * 跳到忘记密码第一个页面
	 */
	@RequestMapping("/jumpForgetPassword1")
	public String jumpForgetPassword1(){
		return "login/forgetPassword1";
	}
	
	/**
	 * 跳到忘记密码第二个页面
	 */
	@RequestMapping("/jumpForgetPassword2")
	public String jumpForgetPassword2(){
		return "login/forgetPassword2";
	}
	
	/**
	 * 跳到忘记密码第三个页面
	 */
	@RequestMapping("/jumpForgetPassword3")
	public String jumpForgetPassword3(){
		return "login/forgetPassword3";
	}
}
