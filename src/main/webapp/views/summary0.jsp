<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<title>应急化教育与培训平台</title>
		<link rel="stylesheet" href="css/style.css" />
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
						<h3><a href="${pageContext.request.contextPath}/notice/jumpPublicNoticePage">公告通知</a></h3>
						<ul class="sub">
							<li><a href="${pageContext.request.contextPath}/notice/jumpPersonalNoticePage">公告通知</a></li>
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
					<a href="${pageContext.request.contextPath }/index">首页</a>&nbsp;>&nbsp;中心概况
				</div>
				<div class="inside_box">
					<div class="sidemenu fl">
						<div class="s_title">中心概况</div>
						
					</div>
					<div class="ic_wrap fr">
						<p>近年来，我国地质灾害频发，地震或者灾害使电力通信电路出现了大面积瘫痪，同时经常发生大幅度的洪涝、雨雪冰冻等天气也将导致各种线路倒塔以及其它灾害，为及时有效应对突发事件,保障电网安全稳定运行，提升应急指挥水平和员工应急抢险技能，四川省电力公司应急中心加快了应急救援培训体系建设步伐。为保证电力设施安全、稳定、高效运行，提高大电网安全生产运行的能力，预防大面积停电事故的发生，为此有必要对电力员工进行培训教育，了解各方面安全知识、应急知识、快速提高应急救援队伍体系，形成指挥有力、运转高效的电力应急体系。</p>
						<p>通过建立“统筹管理、科学分布、合理储备、统一调配、实时信息”的应急指挥体系。四川省电力公司定期对员工进行应急管理日常培训、练习、各种技术资料仓库建立，达到了应急处理的一般要求，但传统纸字方式，已不能满足信息化建设的基本需求，所以提出网络化应急培训教育平台。</p>
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
				<p>地址：陕西省西安市XXXXXXXXX  更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
				<img src="images/er.png" class="er" />
			</div>
		</div>
		<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
		<script src="js/jquery.SuperSlide.2.1.js" type="text/javascript"></script>
		<script src="js/common.js"></script>
	</body>
</html>
