<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>公告</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" type="text/css" 
	href="${pageContext.request.contextPath }/css/popup.css"/>
	
<script>
	function createXmlHttpRequest() {
		if (window.ActiveXObject) { //如果是IE浏览器
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) { //非IE浏览器
			return new XMLHttpRequest();
		}
	}
	function getQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null) return unescape(r[2]);
		return null;
	}
	function writeNotice() {
		var url = "${pageContext.request.contextPath}/notice/queryNotice";
		var xmlhttp = createXmlHttpRequest();
		xmlhttp.open("post", url, true);
		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlhttp.send("noticeId=" + getQueryString("noticeId"));
		xmlhttp.onreadystatechange = function() {
			if (this.status == 200 && this.readyState == 4) {
				var jsonObject = this.responseText;
				var result =JSON.parse(jsonObject); //json转为js数组
				var o = document.getElementById("Title")
				var p = document.getElementById("content")
				var getNDetail = ""
				var nTitle = ""
				var nDetail = ""
				nTitle += result.title + "<span class='n_date'>" + new Date(result.createTime).toLocaleString() + "</span>"
				nDetail += result.content;
				o.innerHTML = nTitle;
				p.innerHTML = nDetail;
			}
		}
	}
</script>
</head>
<body onload="writeNotice()">
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
		<a href="index.html" class="logo fl">
			<img src="${pageContext.request.contextPath }/images/logo.png" /></a>
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
					<h3><a href="${pageContext.request.contextPath}/notice/jumpSearchNoticePage">公告通知</a></h3>
					<ul class="sub">
						<li><a href="${pageContext.request.contextPath}/notice/jumpSearchNoticePage">公告通知</a></li>
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
				<a href="${pageContext.request.contextPath }/index">首页</a>&nbsp;>&nbsp;公告目录&nbsp;>&nbsp;公告通知
			</div>
			<div class="inside_box">
				<div class="sidemenu fl">
					<div class="s_title">公告目录</div>
					<ul>
						<li class="on"><a href="">公告通知</a></li>
						<% String userName=(String)request.getSession().getAttribute("userName");
						if(userName!=null&&!userName.trim().equals(""))
							out.println("<li><a href=\"notice2.html\">个人通告</a></li>");
						%>
						
					</ul>
				</div>
				<div class="ic_wrap fr">
					<h3 class="n_title" id="Title">
						标题<span class="n_date">发布日期</span>
					</h3>
					<p id="content"></p>
					<div class="n_link">
						<!--<ul>
	                            <li>上一条<a href="">通知名称</a><span class="date">2016-05-21</span></li>
	                            <li>下一条<a href="">通知名称</a><span class="date">2016-05-21</span></li>
	                        </ul>-->
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<!--footer start-->
	<div class="footer_wrap">
		<div class="line"></div>
		<div class="footer">
<!-- 			<p>版权所有：陕西师范大学基础教育语文研究中心</p> -->
<!-- 			<p>电话：029-8888888&nbsp;&nbsp;&nbsp;邮箱：XXXXXXXX@163.com</p> -->
<!-- 			<p>地址：陕西省西安市XXXXXXXXX  更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p> -->
<!-- 			<img src="images/er.png" class="er" /> -->
		</div>
	</div>
	<script src="${pageContext.request.contextPath }/js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/js/jquery.SuperSlide.2.1.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/js/common.js"></script>
</body>
</html>