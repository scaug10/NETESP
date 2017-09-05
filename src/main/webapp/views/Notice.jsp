<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>查看公告</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/popup.css"/>
		<style>
			table {
				border-collapse: collapse;
				border: 1px;
				border-style: solid;
				border-color: #003300;
				table-layout: fixed;
			}
			
			td {
				border: 0px solid #dcdbdb;
				border-collapse: separate;
				word-break: keep-all;
				white-space: nowrap;
				overflow: hidden;
				text-overflow: ellipsis;
			}
			
			th {
				border: 1px;
				border-bottom-style: solid;
				border-bottom-color: #003300;
				background-color: #BCFB84;
				border-collapse: separate;
			}
			
			.box1 {
				float: left;
				margin: 20px;
				width: 70%;
			}
			
			.box11 {
				width: 750px;
			}
			
			.box2 {
				float: right;
				margin-top: 20px;
				width: 20%;
			}
			
			.box22 {
				position: absolute;
				left: 750px;
			}
			
			.box111 {
				width: 1000px;
			}
			
			.clear {
				clear: both;
			}
			
			.style1{
				overflow: hidden;
				white-space: nowrap;
				text-overflow: ellipsis;
			}
			<br />
		</style>
		<script>
			function createXmlHttpRequest() {
				if(window.ActiveXObject) {
					return new ActiveXObject("Microsoft.XMLHTTP");
				} else if(window.XMLHttpRequest) { //非IE浏览器
					return new XMLHttpRequest();
				}
			}
			function writeNotice(){
				var o = document.getElementById("noticeBody")
				var getNotice = [
				["新闻通告","2017-02-03"],
				["新闻通告","2017-02-04"],
				["新闻通告","2017-02-05"]
				];
				var notice = ""
				for(i=0;i<3;i++){
					notice += "<li><a href=''>" + getNotice[i][0] + "</a><span class='data'>[" + getNotice[i][1] + "]</span></li>\n";
				}
				o.innerHTML = notice;
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
												"<a href=\"personal.html\">个人中心</a>\n"+
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
<!-- 						<ul class="sub"> -->
<!-- 							<li><a href="course.html">课改介绍</a></li> -->
<!-- 							<li><a href="course1.html">改革课程</a></li> -->
<!-- 						</ul> -->
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
						<h3><a href="${pageContext.request.contextPath}/getAllKnowledge">知识库</a></h3>
						<ul class="sub">
							<li><a href="teachers.html">名师资源</a></li>
							<li><a href="teachers.html">名师推荐</a></li>
							<li><a href="teachers1.html">名师介绍</a></li>
						</ul>
					</li>
					<li class="nLi">
						<h3><a href="schoolmate.html">在线练习</a></h3>
					</li>
					<li class="nLi">
						<h3><a href="exam.html">应急学习</a></h3>
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
							<li><a href="notice2.html">个人通告</a></li>
						</ul>
					</div>
					<div class="ic_wrap fr">
						<ul id="noticeBody" class="news_list">
						</ul>
						<!--分页-->
						<div class="record">
	                        <span class="prev"><a href="">上一页</a></span>
	                        <span class="word"><a href="">1</a></span>
	                        <span class="word"><a href="">2</a></span>
	                        <span class="word"><a href="">3</a></span>
	                        <span class="word"><a href="">4</a></span>
	                        <span class="word"><a href="">5</a></span>
	                        <span class="word"><a href="">6</a></span>
	                        <span class="next"><a href="">下一页</a></span>
	                        <span class="sum">共6页</span>
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
				<p>地址：陕西省西安市XXXXXXXXX  更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
				<img src="images/er.png" class="er" />
			</div>
		</div>
		<script src="../js/jquery-1.11.0.min.js" type="text/javascript"></script>
		<script src="../js/jquery.SuperSlide.2.1.js" type="text/javascript"></script>
		<script src="../js/common.js"></script>

</body>


</html>