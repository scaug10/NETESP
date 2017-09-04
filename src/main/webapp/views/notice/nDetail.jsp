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
	href="${pageContext.request.contextPath}/css/login/style.css" />
<script>
	function createXmlHttpRequest() {
		if (window.ActiveXObject) { //如果是IE浏览器
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) { //非IE浏览器
			return new XMLHttpRequest();
		}
	}
	function writeNotice() {
		var url = "${pageContext.request.contextPath}/notice/queryNotice";
		var xmlhttp = createXmlHttpRequest();
		xmlhttp.open("post", url, true);
		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlhttp.send("noticeId=8");
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
	<div class="header_wrap">
		<div class="header">
			<span class="wel_word fl">欢迎访问应急化教育与培训平台！</span> <span
				class="corner fr">
				<ul>
					<li><a href="upload.html">//</a>|</li>
					<li><a href="register.html">注册</a>|</li>
					<li class="login_li"><a href="star/login.html" class="tc">登录</a></li>
					<li class="user_li nLi"><a href="javascript:void(0);">登录名</a>
						<div class="user_handle">
							<a href="personal.html">个人中心</a> <a href="ownTopic.html">我的学习任务</a>
							<a href="javascript:void(0);">退出</a>
						</div></li>
				</ul>
				<div class="clear"></div>
			</span>
			<div class="clear"></div>
		</div>
	</div>
	<!--nav start-->
	<div class="nav_menu">
		<a href="index.html" class="logo fl"><img src="${pageContext.request.contextPath}/img/logo.png" /></a>
		<div class="nav_list fr">
			<ul id="nav" class="nav clearfix">
				<li class="nLi"></li>
				<li class="nLi">
					<h3>
						<a href="about.html">中心概况</a>
					</h3>
				</li>
				<li class="nLi">
					<h3>
						<a href="course.html">论坛交流</a>
					</h3>
					<ul class="sub">
						<li><a href="course.html">课改介绍</a></li>
						<li><a href="course1.html">改革课程</a></li>
					</ul>
				</li>
				<li class="nLi">
					<h3>
						<a href="resource.html">公告通知</a>
					</h3>
					<ul class="sub">
						<li><a href="resource.html">文献资料</a></li>
						<li><a href="resource.html">学习资料</a></li>
						<li><a href="resource1.html">教学视频</a></li>
					</ul>
				</li>
				<li class="nLi">
					<h3>
						<a href="teachers.html">在线知识</a>
					</h3>
					<ul class="sub">
						<li><a href="teachers.html">名师资源</a></li>
						<li><a href="teachers.html">名师推荐</a></li>
						<li><a href="teachers1.html">名师介绍</a></li>
					</ul>
				</li>
				<li class="nLi">
					<h3>
						<a href="schoolmate.html">在线练习</a>
					</h3>
				</li>
				<li class="nLi">
					<h3>
						<a href="exam.html">应急学习</a>
					</h3>
					<ul class="sub">
						<li><a href="exam.html">考试安排</a></li>
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
				<a href="index.html">首页</a>&nbsp;>&nbsp;公告目录&nbsp;>&nbsp;公告通知
			</div>
			<div class="inside_box">
				<div class="sidemenu fl">
					<div class="s_title">公告目录</div>
					<ul>
						<li class="on"><a href="notice.html">公告通知</a></li>
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
			<p>版权所有：陕西师范大学基础教育语文研究中心</p>
			<p>电话：029-8888888&nbsp;&nbsp;&nbsp;邮箱：XXXXXXXX@163.com</p>
			<p>
				地址：陕西省西安市XXXXXXXXX 更多模板：<a href="http://www.mycodes.net/"
					target="_blank">源码之家</a>
			</p>
			<img src="${pageContext.request.contextPath}/img/er.png" class="er" />
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/js/login/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/login/jquery.SuperSlide.2.1.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/login/common.js"></script>
</body>
</html>