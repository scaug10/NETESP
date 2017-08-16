package com.g10.ssm.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.mapper.UserPerssionMapper;
import com.g10.ssm.po.Permission;
import com.g10.ssm.po.PermissionCustom;
import com.g10.ssm.po.UserPermissionCustom;
import com.g10.ssm.po.UserPerssionKey;
import com.g10.ssm.po.UserPerssionVo;
import com.g10.ssm.service.PermissionService;

@Controller
public class PermissionController {
	@Autowired
	private PermissionService permissionService;
	
	/**
	 * 新增权限,此操作只有超级管理员(admin)可以进行操作
	 */
	@RequestMapping(value="/insertPermission",method=RequestMethod.POST)
	public ModelAndView insertPermission(@RequestParam(value="name",required=true)String name,
			HttpServletRequest request) throws Exception{
		ModelAndView modelAndView =new ModelAndView();
		if(name==null||name.trim().equals("")){
			modelAndView.addObject("result", 4);//name不能为空
			modelAndView.setViewName("insertPermission");
			return modelAndView;
		}
		String userName=(String) request.getSession().getAttribute("userName");
		if(userName==null||userName.trim().equals("")){
			modelAndView.addObject("result", 3);//用户名不存在
			modelAndView.setViewName("login");
			return modelAndView;
		}
		if(!userName.equals("admin")){
			modelAndView.addObject("result", 5);//用户没有操作此功能的权限
			modelAndView.setViewName("insertPermission");
			return modelAndView;
		}
		int result=permissionService.insertPermission(name);
		if(result==-2){
			modelAndView.addObject("result", 6);//该权限名已存在，新增权限失败
			modelAndView.setViewName("insertPermission");
		}else if(result==1){
			modelAndView.addObject("result", 1);//新增权限成功！
			modelAndView.setViewName("searchPermissionList");
		}else {
			modelAndView.addObject("result", 2);//新增权限失败！
			modelAndView.setViewName("insertPermission");
		}
		return modelAndView;
	}
	
	/**
	 * 删除多个用户权限，此操作只有超级管理员(admin)可以进行操作
	 */
	@RequestMapping(value="/deletePermission",method=RequestMethod.POST)
	public ModelAndView deletePermission(UserPermissionCustom userPermissionCustom,
			//@RequestParam(value="userId",required=true)String userId,
			HttpServletRequest request) throws Exception{
		ModelAndView modelAndView=new ModelAndView();
/*		UserPermissionCustom userPermissionCustom=new UserPermissionCustom();
		ArrayList<UserPerssionKey> userPermissionList=new ArrayList<UserPerssionKey>();
		UserPerssionKey userPerssionKey=new UserPerssionKey();
		userPerssionKey.setPermissionId(3);
		userPerssionKey.setUserName("1234567");
		userPermissionList.add(userPerssionKey);
		UserPerssionKey userPerssionKey1=new UserPerssionKey();
		userPerssionKey1.setPermissionId(2);
		userPerssionKey1.setUserName("98765");
		userPermissionList.add(userPerssionKey1);
		userPermissionCustom.setUserPermissionList(userPermissionList);*/
		if(userPermissionCustom.getUserPermissionList()==null){
			modelAndView.addObject("result", 3);//没有要删除的数据
			modelAndView.setViewName("deletePermission");
			return modelAndView;
		}
		String userId=(String) request.getSession().getAttribute("userName");
		if(userId==null||userId.trim().equals("")){
			modelAndView.addObject("result", 4);//用户名不存在
			modelAndView.setViewName("login");
			return modelAndView;
		}
		if(!userId.equals("admin")){
			modelAndView.addObject("result", 5);//用户没有操作此功能的权限
			modelAndView.setViewName("deletePermission");
			return modelAndView;
		}
		int result=permissionService.deletePermission(userPermissionCustom);
		if(result==1){
			modelAndView.addObject("result", 1);//删除用户权限成功
			modelAndView.setViewName("searchPermissionList");
		}else{
			modelAndView.addObject("result", 2);//删除用户权限失败
			modelAndView.setViewName("deletePermission");
		}
		return modelAndView;
	}
	
	/**
	 * 修改权限，此操作只有超级管理员(admin)可以进行操作
	 */
	@RequestMapping(value="/updatePermission",method=RequestMethod.POST)
	public ModelAndView updatePermission(Permission permission,
			//@RequestParam(value="userId",required=true)String userId,
			HttpServletRequest request) throws Exception{
		ModelAndView modelAndView=new ModelAndView();
		if(permission==null){
			modelAndView.addObject("result",3);//没有要修改的权限
			modelAndView.setViewName("updatePermission");
			return modelAndView;
		}
		String userId=(String) request.getSession().getAttribute("userName");
		if(userId==null||userId.trim().equals("")){
			modelAndView.addObject("result", 4);//用户名不存在
			modelAndView.setViewName("login");
			return modelAndView;
		}
		if(!userId.equals("admin")){
			modelAndView.addObject("result", 5);//用户没有操作此功能的权限
			modelAndView.setViewName("updatePermission");
			return modelAndView;
		}
		int result=permissionService.updatePermission(permission);
		if(result==1){
			modelAndView.addObject("result", 1);//修改权限成功
			modelAndView.setViewName("searchPermissionList");
		}else{
			modelAndView.addObject("result", 2);//修改权限失败
			modelAndView.setViewName("updatePermission");
		}
		return modelAndView;
	}
	
	/**
	 * 给多个用户分配同一个权限,此操作只有超级管理员(admin)可以进行操作
	 */
	@RequestMapping(value="/givePermission",method=RequestMethod.POST)
	public ModelAndView givePermission(UserPerssionVo userPerssionVo,
			//@RequestParam(value="userId",required=true)String userId,
			HttpServletRequest request) throws Exception{
		ModelAndView modelAndView=new ModelAndView();
		if(userPerssionVo==null){
			modelAndView.addObject("result", 3);//没有要分配权限给用户
			modelAndView.setViewName("givePermission");
			return modelAndView;
		}
		String userId=(String) request.getSession().getAttribute("userName");
		if(userId==null||userId.trim().equals("")){
			modelAndView.addObject("result", 4);//用户名不存在
			modelAndView.setViewName("login");
			return modelAndView;
		}
		if(!userId.equals("admin")){
			modelAndView.addObject("result", 5);//用户没有操作此功能的权限
			modelAndView.setViewName("givePermission");
			return modelAndView;
		}
/*		ArrayList<String> userNameList=new ArrayList<String>();
		userNameList.add("1234567");
		userNameList.add("8765");
		userPerssionVo.setUserNameList(userNameList);*/
		int result=permissionService.givePermissionToManyUsers(userPerssionVo);
		if(result==1){
			modelAndView.addObject("result", 1);//给多个用户分配权限成功
			modelAndView.setViewName("searchPermissionList");
		}
		else if(result==-2){
			modelAndView.addObject("result", 6);//有些用户不存在
			modelAndView.setViewName("givePermission");
		}
		else {
			modelAndView.addObject("result", 2);//y给多个用户分配权限失败
			modelAndView.setViewName("givePermission");
		}
		return modelAndView;
	}
	
	/**
	 * 查询权限列表
	 */
	@RequestMapping(value="/searchPermissionList",method=RequestMethod.POST)
	public ModelAndView searchPermissionList(//@RequestParam(value="userId",required=true)String userId,
			HttpServletRequest request) throws Exception{
		ModelAndView modelAndView=new ModelAndView();
		String userId=(String) request.getSession().getAttribute("userName");
		if(userId==null||userId.trim().equals("")){
			modelAndView.addObject("result", 4);//用户名不存在
			modelAndView.setViewName("login");
			return modelAndView;
		}
		if(!userId.equals("admin")){
			modelAndView.addObject("result", 5);//用户没有操作此功能的权限
			modelAndView.setViewName("givePermission");
			return modelAndView;
		}
		ArrayList<PermissionCustom> permissionList=(ArrayList<PermissionCustom>) permissionService.searchPermissionList();
		if(permissionList==null){
			modelAndView.addObject("result", 2);//查询权限列表失败
		}else {
			modelAndView.addObject("result", 1);//查询权限列表成功
			modelAndView.addObject("permissionList", permissionList);
		}
		modelAndView.setViewName("searchPermissionList");
		return modelAndView;
	}
}
