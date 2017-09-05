package com.g10.ssm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.g10.ssm.po.Notice;
import com.g10.ssm.po.Permission;
import com.g10.ssm.po.UserNoticeKey;
import com.g10.ssm.po.UserNoticeVo;
import com.g10.ssm.service.NoticeService;
import com.g10.ssm.service.PermissionService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private PermissionService permissionService;

	/**
	 * 查询单个公告通知
	 * @param noticeId
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryNotice")
	@ResponseBody
	public Notice queryNotice(@Param("noticeId") Integer noticeId) throws Exception {
		if(noticeId==null)
			return null;//公告通知Id为空
		Notice notice = noticeService.queryNoticeById(noticeId);
		return notice;
	}

	/**
	 * 管理员修改公告通知
	 * @param notice
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editNotice")
	@ResponseBody
	public Integer editNotice(Notice notice,HttpServletRequest request) throws Exception {
		if(notice==null)
			return null;//公告通知不能为空
		String userName=(String) request.getSession().getAttribute("userName");
		if(userName==null||userName.trim().equals(""))
			return null;//用户名为空
		List<Permission> list=permissionService.searchUserPermissionList(userName);
		if(list==null||list.size()<2)
			return null;//该用户没有修改公告通知的权限（不是管理员）
		notice.setCreateTime(new Date());
		int result = noticeService.updateNotice(notice);
		if(result!=1)
			return null;//用户修改公告通知失败
		return result;//用户修改公告通知成功
	}

	/**
	 * 管理员发布公告通知
	 * @param notice
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/saveNotice")
	@ResponseBody
	public Integer saveNotice(Notice notice,String[] userList,HttpServletRequest request) throws Exception {
		if(notice==null)
			return null;//公告通知不能为空
		String userName=(String) request.getSession().getAttribute("userName");
		if(userName==null||userName.trim().equals(""))
			return null;//用户名为空
		List<Permission> list2=permissionService.searchUserPermissionList(userName);
		if(list2==null||list2.size()<2)
			return null;//该用户没有发布公告通知的权限（不是管理员）
		notice.setCreateTime(new Date());
		if(notice.getIsPublic()){
			int result = noticeService.saveNotice(notice);
			if(result==-1)
			return null;//新增公告通知失败
			return 1;//新增公告通知成功
		}
		if(userList==null||userList.length<1){
			return null;//没有指定要发送公告的用户
		}
		int res = noticeService.insertNoticeAndGetId(notice);
		if(res==-1)
			return null;
		List<UserNoticeKey> list=new ArrayList<UserNoticeKey>();
		for(int i=0;i<userList.length;i++){
			UserNoticeKey userNoticeKey=new UserNoticeKey();
			userNoticeKey.setNoticeId(notice.getNoticeId());
			userNoticeKey.setUserName(userList[i]);
			list.add(userNoticeKey);
		}
		UserNoticeVo userNoticeVo=new UserNoticeVo();
		userNoticeVo.setList(list);
		int result=noticeService.sendNoticeToManyUser(userNoticeVo);
		if(result==-1)
			return null;//新增公告通知失败
		return result;//新增公告通知成功
	}

	/**
	 * 管理员删除公告通知
	 * @param noticeId
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteNotice")
	@ResponseBody
	public Integer deleteNotice(@Param("noticeId") Integer noticeId,HttpServletRequest request) throws Exception {
		if(noticeId==null)
			return null;//公告通知Id为空
		String userName=(String) request.getSession().getAttribute("userName");
		if(userName==null||userName.trim().equals(""))
			return null;//用户名为空
		List<Permission> list=permissionService.searchUserPermissionList(userName);
		if(list==null||list.size()<2)
			return null;//该用户没有删除公告通知的权限（不是管理员）
		int result = noticeService.deleteNoticeByPrimaryKey(noticeId);
		if(result!=1)
			return null;//用户删除公告失败
		return result;//用户删除公告成功
	}

	/**
	 * 管理员获取公告通知列表(包括公开性的和非公开性的)
	 * @param modelAndView
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAllNotice")
	@ResponseBody
	public List<Notice> getAllNotice(HttpServletRequest request) throws Exception {
		String userName=(String) request.getSession().getAttribute("userName");
		if(userName==null||userName.trim().equals(""))
			return null;//用户名为空
		List<Permission> list2=permissionService.searchUserPermissionList(userName);
		if(list2==null||list2.size()<2)
			return null;//该用户没有获取公告通知列表的权限（不是管理员）
		List<Notice> list = noticeService.queryNotice();
		return list;
	}
	
	/**
	 * 获取公开性公告通知列表
	 */
	@RequestMapping("/getPublicNotice")
	@ResponseBody
	public List<Notice> getPublicNotice() throws Exception {
		List<Notice> list = noticeService.queryPublicNotice();
		return list;
	}
	
	/**
	 * 获取前4条公开性公告通知列表
	 */
	@RequestMapping("/getFourPublicNotice")
	@ResponseBody
	public List<Notice> getFourPublicNotice() throws Exception {
		List<Notice> list = noticeService.queryFourPublicNotice();
		return list;
	}
	
	/**
	 * 用户获取个人公告列表（非公开性的）
	 */
	@RequestMapping("/getPersonalNotice")
	@ResponseBody
	public List<Notice> getPersonalNotice(HttpServletRequest request) throws Exception {
		String userName=(String) request.getSession().getAttribute("userName");
		if(userName==null||userName.trim().equals(""))
			return null;//用户名为空
		List<Notice> list=null;
		list=noticeService.getNoticeByUserName(userName);
		return list;
	}
	
	/**
	 * 删除多个公告（首先要删除用户公告关系表（从表）然后再删除公告表（主表），只要在数据库设置级联操作
	 * （从表外键字段设置delete的cascade）即可，所以这里只用删除公告表（主表）即可）
	 */
	@RequestMapping(value="/deleteManyNotice",method=RequestMethod.POST)
	@ResponseBody
	public Integer deleteManyNotice(Integer[] list,
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
		List<Permission> list1=permissionService.searchUserPermissionList(userId);
		if(list1==null||list1.size()<2)
			return null;//该用户没有删除公告通知的权限（不是管理员）
		Integer res=noticeService.deleteManyNotice(list2);
		return res;
	}
	
	/**
	 * 跳到前台公告通知页面
	 */
	@RequestMapping("/jumpPublicNoticePage")
	public String jumpPublicNoticePage(){
		return "";
	}
	
	/**
	 * 跳到前台个人公告通知页面
	 */
	@RequestMapping("/jumpPersonalNoticePage")
	public String jumpPersonalNoticePage(){
		return "";
	}
	
	/**
	 * 跳到后台公告列表页面
	 */
	@RequestMapping("/jumpNoticeList")
	public String jumpNoticeList(){
		return "notice/NoticeManagement";
	}
	
	/**
	 * 跳到后台新增公告页面
	 */
	@RequestMapping("/jumpAddNoticePage")
	public String jumpAddNoticePage(){
		return "notice/NoticeSet";
	}
	
	/**
	 * 跳到前台查询公告页面
	 */
	@RequestMapping("/jumpSearchNoticePage")
	public String jumpSearchNoticePage(){
		return "notice/nDetail";
	}
	
}
