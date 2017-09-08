<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>查看公告</title>
		<link rel="stylesheet" type="text/css" href="../css/css.css" />
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
		<link rel="stylesheet" type="text/css" href="../css/popup.css"/>
		<script>
			function createXmlHttpRequest() {
				if(window.ActiveXObject) { //如果是IE浏览器
					return new ActiveXObject("Microsoft.XMLHTTP");
				} else if(window.XMLHttpRequest) { //非IE浏览器
					return new XMLHttpRequest();
				}
			}
			
			function getNoticeList() {
				var url = "${pageContext.request.contextPath}/notice/getPersonalNotice";
				var xmlhttp = createXmlHttpRequest();
				xmlhttp.open("post", url, true);
				xmlhttp.send();
				xmlhttp.onreadystatechange = function() {
					if (this.status == 200 && this.readyState == 4) {
						var jsonObject = this.responseText;
						var result = eval("(" + jsonObject + ")"); //json转为js数组
						var str = ""
						for (var i = 0; i < result.length; ++i) {
							var noticeId=result[i].noticeId;
							var title = result[i].title;
							var noticeType=result[i].noticeType;
							var isPublic=result[i].isPublic;
							var s1="非公开";
							var createTime=result[i].createTime;
							str += "<li><a href='${pageContext.request.contextPath}/notice/jumpSearchNoticePage?noticeId="+noticeId+
									"'>" + title+ "</a><span class='data'>[" + (new Date(createTime)).toLocaleDateString() + "]</span>\n";
						}
						document.getElementById("noticeBody").innerHTML = str;
					}
				}
			}
			
			function getPublicNotice(){
				var url = "${pageContext.request.contextPath}/notice/getPublicNotice";
				var xmlhttp = createXmlHttpRequest();
				xmlhttp.open("post", url, true);
				xmlhttp.send();
				xmlhttp.onreadystatechange = function() {
					if (this.status == 200 && this.readyState == 4) {
						var result = JSON.parse(this.responseText);
						var str = ""
						for (var i = 0; i < result.length; ++i) {
							var noticeId=result[i].noticeId;
							var title = result[i].title;
							var noticeType=result[i].noticeType;
							var isPublic=result[i].isPublic;
							var s1="公开";
							var createTime=result[i].createTime;
							str += "<li><a href='${pageContext.request.contextPath}/notice/jumpSearchNoticePage?noticeId="+noticeId+
									"'>" + title+ "</a><span class='data'>[" + (new Date(createTime)).toLocaleDateString() + "]</span>\n";
						}
						document.getElementById("noticeBody").innerHTML = str;
					}
				}
			}
		</script>

	</head>

	<body>
		<!--header start-->
		<div class="header_wrap">
			<div class="header">
				<span class="wel_word fl">欢迎访问应急化教育与培训平台！</span>
				<span class="corner fr">
					<ul>
						<li><a href="upload.html"></a></li>
						<%
							String username = (String)request.getSession().getAttribute("userName");
							if(username == null){
								out.println("<li><a href=\""+ request.getContextPath() + "/login/jumpRegisterPage\">注册</a>|</li>");
								out.println("<li class=\"login_li\"><a href=\""+request.getContextPath()+"/login/jumpLoginPage\" class=\"tc\">登录</a></li>");
							}
						%>
						<li class="user_li nLi">
							<a href="javascript:void(0);">
							<%
								if(username != null){
									out.print("欢迎： " + username);
									out.println("<div class=\"user_handle\">\n" + 
												"<a href=\""+request.getContextPath()+"/password/reset\">修改密码</a>\n"+
												"<a href=\"ownTopic.html\">我的学习任务</a>\n"+
												"<a href=\""+ request.getContextPath() +"/login/exitSys\">退出</a>\n"+
												"</div>"
											);
								}
							%>
						</li>
					</ul>
					<div class="clear"></div>
				</span>
				<div class="clear"></div>
			</div>
		</div>
		
		<!--nav start-->
		<div class="nav_menu">
			<a href="${pageContext.request.contextPath }/index" class="logo fl">
				<img src="${pageContext.request.contextPath }/img/index/logo.jpg" /></a>
			<div class="nav_list fr">
				<ul id="nav" class="nav clearfix">
					<li class="nLi"></li>
					<li class="nLi">
						<h3><a href="${pageContext.request.contextPath }/summary">中心概况</a></h3>
					</li>
					<li class="nLi">
						<h3><a href="${pageContext.request.contextPath }/forum/index">论坛交流</a></h3>
					</li>
					<li class="nLi">
						<h3><a href="${pageContext.request.contextPath}/notice/jumpNoticeList">公告通知</a></h3>
						<ul class="sub">
							<li><a href="${pageContext.request.contextPath}/notice/jumpNoticeList">公告通知</a></li>
							<%
								if(username != null){
									out.println("<li><a href=\"" + request.getContextPath() + "/notice/jumpPersonalNoticePage\">个人通知</a></li>");
								}
							%>
						</ul>
					</li>
					<li class="nLi">
						<h3><a href="${pageContext.request.contextPath}/getAllRepositoryCategory"">知识库</a></h3>
						<ul class="sub">
							<li><a href="${pageContext.request.contextPath}/getAllKnowledge">知识管理</a></li>
							<li><a href="${pageContext.request.contextPath}/getAllRepositoryCategory">知识库分类</a></li>
							<li><a href="${pageContext.request.contextPath}/questionbank">知识库</a></li>
							<li><a href="${pageContext.request.contextPath}/exam/all">试卷管理</a></li>
						</ul>
					</li>
					<li class="nLi">
						<h3><a href="schoolmate.html">在线练习</a></h3>
						<ul class="sub">
							<li><a href="${pageContext.request.contextPath}/getAllStrategy">策略管理</a></li>
							<li><a href="${pageContext.request.contextPath}/getAllExam">练习</a>
						</ul>
					</li>
					<li class="nLi">
						<h3><a href="exam.html">应急学习</a></h3>
						<ul class="sub">
							<li><a href="exam.html">考试安排</a></li>
							<li><a href="${pageContext.request.contextPath}/jumpToCourseware">课件</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
		<!--inside content start-->
		<div class="inside_wrap">
			<div class="inside_con">
				<div class="adr">
					<a href="${pageContext.request.contextPath }/index">首页</a>&nbsp;>&nbsp;公告目录&nbsp;>&nbsp;学习计划
				</div>
				<div class="inside_box">
					<div class="sidemenu fl">
						<div class="s_title">公告目录</div>
						<ul>
							<li><a onclick="getPublicNotice()">公告通知</a></li>
							<li class="on"><a onclick="getNoticeList()">个人公告</a></li>
						</ul>
					</div>
					<div class="ic_wrap fr">
						<ul id="noticeBody" class="news_list">
							
						</ul>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
		<!--footer start-->
		<div class="footer_wrap">
			<div class="line"></div>
			<div class="footer">
				<p>版权所有：应急化教育与培训平台</p>
				<p>电话：0123456789 &nbsp;&nbsp;&nbsp;邮箱：0123456789@163.com</p>
				<p>地址：广东省广州市华南农业大学 </p>
			</div>
		</div>
		<script src="${pageContext.request.contextPath }/js/jquery-1.11.0.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath }/js/jquery.SuperSlide.2.1.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath }/js/common.js"></script>
		<script type="text/javascript">
// 			jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true, autoPage:true, trigger:"click" });
// 			jQuery(".notice").slide({mainCell:".bd ul",autoPage:true,effect:"top",autoPlay:true,vis:1});
			jQuery(".schoolmate .b_wrap").slide({titCell:".hd ul",mainCell:".bd ul",autoPage:true,effect:"left",autoPlay:true,vis:5,trigger:"click"});
		</script>
</body>


</html>