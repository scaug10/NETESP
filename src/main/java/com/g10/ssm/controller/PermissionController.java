package com.g10.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.g10.ssm.mapper.UserPerssionMapper;
import com.g10.ssm.po.Permission;
import com.g10.ssm.po.PermissionCustom;
import com.g10.ssm.po.UserPermissionCustom;
import com.g10.ssm.po.UserPerssionKey;
import com.g10.ssm.po.UserPerssionVo;
import com.g10.ssm.service.PermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {
	@Autowired
	private PermissionService permissionService;
	
	/**
	 * 新增权限,此操作只有超级管理员(admin)可以进行操作
	 */
	@RequestMapping(value="/insertPermission",method=RequestMethod.POST)
	@ResponseBody
	public Integer insertPermission(@RequestParam(value="name",required=true)String name,
			HttpServletRequest request) throws Exception{
		if(name==null||name.trim().equals("")){
			return null;//name不能为空
		}
		String userName=(String) request.getSession().getAttribute("userName");
		if(userName==null||userName.trim().equals("")){
			return null;//用户名不存在
		}
		if(!userName.equals("admin")){
			return null;//用户没有操作此功能的权限
		}
		Integer result=permissionService.insertPermission(name);
		if(result==-2){
			return null;//该权限名已存在，新增权限失败
		}else if(result==1){
			return result;//新增权限成功！
		}else {
			return null;//新增权限失败！
		}
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
	@ResponseBody
	public Integer updatePermission(Permission permission,
			HttpServletRequest request) throws Exception{
		if(permission==null){
			return null;//没有要修改的权限
		}
		String userId=(String) request.getSession().getAttribute("userName");
		if(userId==null||userId.trim().equals("")){
			return null;//用户名不存在
		}
		if(!userId.equals("admin")){
			return null;//用户没有操作此功能的权限
		}
		int result=permissionService.updatePermission(permission);
		if(result==1){
			return result;//修改权限成功
		}else{
			return null;//修改权限失败
		}
	}
	
	/**
	 * 给多个用户分配同一个权限,此操作只有超级管理员(admin)可以进行操作
	 */
	@RequestMapping(value="/givePermission",method=RequestMethod.POST)
	@ResponseBody
	public Integer givePermission(String[] list,Integer permissionId,
			HttpServletRequest request) throws Exception{
		if(list==null||list.length<=0||permissionId==null)
			return null;
		List<UserPerssionKey> list2=new ArrayList<UserPerssionKey>();
		for(int i=0;i<list.length;i++){
			UserPerssionKey userPerssionKey=new UserPerssionKey();
			userPerssionKey.setPermissionId(permissionId);
			userPerssionKey.setUserName(list[i]);
			list2.add(userPerssionKey);
		}
		String userId=(String) request.getSession().getAttribute("userName");
		if(userId==null||userId.trim().equals("")){
			return null;//用户名不存在
		}
		if(!userId.equals("admin")){
			return null;//用户没有操作此功能的权限
		}
		UserPerssionVo userPerssionVo=new UserPerssionVo();
		userPerssionVo.setList(list2);
		int result=permissionService.givePermissionToManyUsers(userPerssionVo);
		if(result==1){
			return result;//给多个用户分配权限成功
		}
		else if(result==-2){
			return null;//有些用户不存在
		}
		else {
			return null;//y给多个用户分配权限失败
		}
	}
	
	/**
	 * 通过账号查询用户权限列表(所有人)
	 */
	@RequestMapping(value="/searchUserPermissionListByUserName",method=RequestMethod.POST)
	@ResponseBody
	public List<PermissionCustom> searchUserPermissionListByUserName(//@RequestParam(value="userId",required=true)String userId,
			HttpServletRequest request) throws Exception{
		String userId=(String) request.getSession().getAttribute("userName");
		if(userId==null||userId.trim().equals("")){
			return null;//用户名不存在
		}
		List<PermissionCustom> permissionList= permissionService.searchAllUserPermissionList();
		if(permissionList==null){
			return null;
		}else {
			return permissionList;//查询权限列表成功
		}
	}
	
	/**
	 * 查询所有用户权限列表
	 */
	@RequestMapping(value="/searchAllUserPermissionList",method=RequestMethod.POST)
	public ModelAndView searchAllUserPermissionList(//@RequestParam(value="userId",required=true)String userId,
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
		ArrayList<PermissionCustom> permissionList=(ArrayList<PermissionCustom>) permissionService.searchAllUserPermissionList();
		if(permissionList==null){
			modelAndView.addObject("result", 2);//查询所有用户权限列表失败
		}else {
			modelAndView.addObject("result", 1);//查询所有用户权限列表成功
			modelAndView.addObject("permissionList", permissionList);
		}
		modelAndView.setViewName("searchPermissionList");
		return modelAndView;
	}
	
	/**
	 * 根据权限名称模糊查询权限
	 * @throws Exception 
	 * 
	 */
	@RequestMapping(value="/searchPermissionByName",method=RequestMethod.POST)
	@ResponseBody
	public List<Permission> searchPermissionByName(@RequestParam(value="name",required=true)String name,
			HttpServletRequest request) throws Exception{
		if(name==null||name.trim()=="")
			return null;
		String userId=(String) request.getSession().getAttribute("userName");
		if(userId==null||userId.trim().equals("")){
			return null;//用户名不存在
		}
		if(!userId.equals("admin")){
			return null;//用户没有操作此功能的权限
		}
		List<Permission> permission=permissionService.searchPermissionByName(name);
		return permission;
	}
	
	/**
	 * 删除单个权限（首先要删除用户权限关系表（从表）然后再删除权限表（主表），只要在数据库设置级联操作
	 * （从表外键字段设置delete的cascade）即可，所以这里只用删除权限表（主表）即可）
	 */
	@RequestMapping(value="/deleteOnePermission",method=RequestMethod.POST)
	@ResponseBody
	public Integer deleteOnePermission(@RequestParam(value="permissionId",required=true)Integer permissionId,
			//@RequestParam(value="userId",required=true)String userId,
			HttpServletRequest request) throws Exception{
		if(permissionId==null)
			return null;
		String userId=(String) request.getSession().getAttribute("userName");
		if(userId==null||userId.trim().equals("")){
			return null;//用户名不存在
		}
		if(!userId.equals("admin")){
			return null;//用户没有操作此功能的权限
		}
		Integer res=permissionService.deleteOnePermission(permissionId);
		return res;
	}
	
	/**
	 * 查询权限列表
	 * @throws Exception 
	 * 
	 */
	@RequestMapping(value="/searchPermissionList",method=RequestMethod.POST)
	@ResponseBody
	public List<Permission> searchPermissionList(HttpServletRequest request) throws Exception{
		String userId=(String) request.getSession().getAttribute("userName");
		if(userId==null||userId.trim().equals("")){
			return null;//用户名不存在
		}
		if(!userId.equals("admin")){
			return null;//用户没有操作此功能的权限
		}
		List<Permission> list=permissionService.searchPermissionList();
		return list;
	}
	
	/**
	 * 删除多个权限（首先要删除用户权限关系表（从表）然后再删除权限表（主表），只要在数据库设置级联操作
	 * （从表外键字段设置delete的cascade）即可，所以这里只用删除权限表（主表）即可）* 删除单个权限（首先要删除用户权限关系表然后再删除权限表）
	 */
	@RequestMapping(value="/deleteManyPermission",method=RequestMethod.POST)
	@ResponseBody
	public Integer deleteManyPermission(Integer[] list,
			HttpServletRequest request) throws Exception{
		if(list==null||list.length<=0)
			return null;
		List<Integer> list2=new ArrayList<Integer>();
		int flag=0;
		for(int i=0;i<list.length;i++){
			if(list[i]!=-1){
				list2.add(list[i]);
				flag=1;
			}		
		}
		if(flag==0)
			return null;
		String userId=(String) request.getSession().getAttribute("userName");
		if(userId==null||userId.trim().equals("")){
			return null;//用户名不存在
		}
		if(!userId.equals("admin")){
			return null;//用户没有操作此功能的权限
		}
		Integer res=permissionService.deleteManyPermission(list2);
		return res;
	}
	
	/**
	 * 跳到权限管理页面
	 */
	@RequestMapping("/jumpPermissionPage")
	public String jumpPermissionPage(){
		return "permission/AuthorityManagement";
	}
	
	/**
	 * 跳到新增权限页面
	 */
	@RequestMapping("/jumpInsertPermissionPage")
	public String jumpInsertPermissionPage(){
		return "permission/AuthorityAdd";
	}
	
	/**
	 * 跳到查询权限页面
	 */
	@RequestMapping("/jumpSearchPermissionPage")
	public String jumpSearchPermissionPage(){
		return "permission/AuthorityQuery";
	}
	
	/**
	 * 跳到修改权限页面
	 */
	@RequestMapping("/jumpModifyPermissionPage")
	public String jumpModifyPermissionPage(){
		return "permission/AuthorityRevise";
	}
	
	/**
	 * 跳到给多个用户分配同一个权限的页面
	 */
	@RequestMapping("/jumpPermissionDistributePage")
	public String jumpPermissionDistributePage(){
		return "permission/AuthoritySetUp";
	}
}
