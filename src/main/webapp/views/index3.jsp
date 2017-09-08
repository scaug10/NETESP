<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>应急化教育与培训平台</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/popup.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/index.jsp.js"></script>
	</head>
	<body onload="getHotTheme();getPublicNotice()">
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
				 	if (username != null) {
				 		out.print("欢迎： " + username);
				 		String str = "<div class=\"user_handle\">\n";
				 		if(username.equals("admin"))
				 			str += "<a href='" + request.getContextPath() + "/permission/jumpPermissionPage'>权限管理</a>\n";
				 		
				 		 str += "<a href=\""
				 				+ request.getContextPath()
				 				+ "/password/reset\">修改密码</a>\n" + "<a href=\""
				 				+ request.getContextPath()
				 				+ "/jumpToMyStudyTask\">我的学习任务</a>\n" + "<a href=\""
				 				+ request.getContextPath()
				 				+ "/login/exitSys\">退出</a>\n" + "</div>";
				 		out.println(str);
// 				 		out.println("<div class=\"user_handle\">\n" + "<a href=\""
// 				 				+ request.getContextPath()
// 				 				+ "/password/reset\">修改密码</a>\n" + "<a href=\""
// 				 				+ request.getContextPath()
// 				 				+ "/jumpToMyStudyTask\">我的学习任务</a>\n" + "<a href=\""
// 				 				+ request.getContextPath()
// 				 				+ "/login/exitSys\">退出</a>\n" + "</div>");
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
						<h3><a href="${pageContext.request.contextPath}/notice/jumpPersonalNoticePage">公告通知</a></h3>
						<ul class="sub">
<%-- 							<li><a href="${pageContext.request.contextPath}/notice/jumpNoticeList">公告管理</a></li> --%>
							<%
								if(username != null){
									if(username.equals("admin") || username.equals("fyw0")){
										out.println("<li><a href=\"" + request.getContextPath() + "/notice/jumpNoticeList\">公告管理</a></li>");
									}
									out.println("<li><a href=\"" + request.getContextPath() + "/notice/jumpPersonalNoticePage\">个人通知</a></li>");
								}
							%>
						</ul>
					</li>
					<li class="nLi">
						<h3><a href="${pageContext.request.contextPath}/getAllRepositoryCategory">知识库</a></h3>
						<ul class="sub">
							<li><a href="${pageContext.request.contextPath}/getAllKnowledge">知识管理</a></li>
							<li><a href="${pageContext.request.contextPath}/getAllRepositoryCategory">知识库分类</a></li>
							<li><a href="${pageContext.request.contextPath}/questionbank">知识库</a></li>
							<li><a href="${pageContext.request.contextPath}/exam/all">试卷管理</a></li>
						</ul>
					</li>
					<li class="nLi">
						<h3><a href="${pageContext.request.contextPath}/getAllStrategy">在线练习</a></h3>
						<ul class="sub">
							<li><a href="${pageContext.request.contextPath}/getAllStrategy">策略管理</a></li>
<%-- 							<li><a href="${pageContext.request.contextPath}/getAllExam">练习</a> --%>
						</ul>
					</li>
					<li class="nLi">
						<h3><a href="${pageContext.request.contextPath}/jumpToLearningTask">应急学习</a></h3>
						<ul class="sub">
<!-- 							<li><a href="exam.html">考试安排</a></li> -->
							<li><a href="${pageContext.request.contextPath}/jumpToCourseware">课件</a></li>
							<li><a
								href="${pageContext.request.contextPath}/jumpToLearningTask">学习任务</a></li>
							<li><a
								href="${pageContext.request.contextPath}/getStudyStatistics">学习统计</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
		<!--banner start-->
		<div class="banner">
			<div class="bd">
				<ul>
					<li class="first"><a href="javascript:void(0);">
					<img alt="" src="${pageContext.request.contextPath}/img/index/banner1.jpg"></a></li>
					<li class="second"><a href="javascript:void(0);">
					<img alt="" src="${pageContext.request.contextPath}/img/index/banner2.jpg"></a></li>
					<li class="third"><a href="javascript:void(0);">
					<img alt="" src="${pageContext.request.contextPath}/img/index/banner3.jpg"></a></li>
					<li class="fourth"><a href="javascript:void(0);">
					<img alt="" src="${pageContext.request.contextPath}/img/index/banner4.jpg"></a></li>
				</ul>
			</div>
			<div class="hd"><ul></ul></div>
		</div>
		<!--notice start-->
		<div class="notice_wrap">
			<div class="notice">
				<div class="bd fl">
					<b>通知公告：</b>
					<ul class="infoList">
						<li><span class="date">[2017-09-05]</span><a href="${pageContext.request.contextPath}/notice/jumpPersonalNoticePage">企业学习目标发布</a></li>
						<li><span class="date">[2017-09-05]</span><a href="${pageContext.request.contextPath}/notice/jumpPersonalNoticePage">学习制度发布</a></li>
						<li><span class="date">[2017-09-05]</span><a href="${pageContext.request.contextPath}/notice/jumpPersonalNoticePage">应急在线练习任务发布</a></li>
						<li><span class="date">[2017-09-05]</span><a href="${pageContext.request.contextPath}/notice/jumpPersonalNoticePage">应急在线练习任务发布</a></li>
					</ul>
				</div>
				<a href="${pageContext.request.contextPath}/notice/jumpPersonalNoticePage" class="more fr">更多+</a>
				<div class="clear"></div>
			</div>
		</div>
		<!--content start-->
		<div class="content">
			<!--about、news and hot-->
			<div class="box1">
				<div class="fl">
					<div class="about">
						<div class="b_title">
							<h3>中心概况</h3>
							<a href="${pageContext.request.contextPath }/summary" class="more">更多+</a>
						</div>
						<div class="b_wrap">
							<div class="a_img fl">
								<img src="${pageContext.request.contextPath }/img/index/summary.jpg" />
							</div>
							<div class="a_text fl">
								<p>近年来，我国地质灾害频发，地震或者灾害使电力通信电路出现了大面积瘫痪，同时经常发生大幅度的洪涝、雨雪冰冻等天气也将导致各种线路倒塔以及其它灾害，为及时有效应对突发事件,保障电网安全稳定运行，提升应急指挥水平和员工应急抢险技能，四川省电力公司应急中心加快了应急救援培训体系建设步伐。为保证电力设施安全、稳定、高效运行，提高大电网安全生产运行的能力，预防大面积停电事故的发生，为此有必要对电力员工进行培训教育，了解各方面安全知识、应急知识、快速提高应急救援队伍体系，形成指挥有力、运转高效的电力应急体系。</p>
								<p>通过建立“统筹管理、科学分布、合理储备、统一调配、实时信息”的应急指挥体系。四川省电力公司定期对员工进行应急管理日常培训、练习、各种技术资料仓库建立，达到了应急处理的一般要求，但传统纸字方式，已不能满足信息化建设的基本需求，所以提出网络化应急培训教育平台。</p>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="news">
						<div class="b_title">
							<h3>公告通知</h3>
							<a href="${pageContext.request.contextPath}/notice/jumpSearchNoticePage" class="more">更多+</a>
						</div>
						<div class="b_wrap">
							<div class="fl n_list">
								<h4>系统通告</h4>
								<ul id="publicNotice"></ul>
							</div>
							<div class="fr n_list">
								<h4>制度 · 任务</h4>
								<ul>
									<li class="special">
										<div class="n_img">
											<img src="${pageContext.request.contextPath}/img/index/banner4.jpg" />
										</div>
										<div class="n_text">
											<b>最新的学习制度发布</b>
											<p>最新的任务发布<a href="${pageContext.request.contextPath}/jumpToLearningTask" class="detail">详细</a></p>
										</div>
									</li>
									<li><a href="${pageContext.request.contextPath}/jumpToLearningTask">最新的学习制度发布</a></li>
									<li><a href="${pageContext.request.contextPath}/jumpToLearningTask">最新的任务发布</a></li>
									<li><a href="${pageContext.request.contextPath}/jumpToLearningTask">最新的学习制度发布</a></li>
								</ul>
							</div>
							<div class="clear"></div>
						</div>
					</div>
				</div>
				<div class="hot fr">
					<div class="b_title">
						<h3>热门主题</h3>
						<a href="${pageContext.request.contextPath }/forum/index" class="more">更多+</a>
					</div>
					<div class="b_wrap">
						<ul id="hostTheme"></ul>
					</div>
				</div>
				<div class="clear"></div>
			</div>

			</div>
			<!--resource and exam-->
			<div class="box3">
<!-- 				<div class="resource fl"> -->
<!-- 					<div class="b_title"> -->
<!-- 						<h3>知识资源</h3> -->
<!-- 						<a href="resource.html" class="more">更多+</a> -->
<!-- 					</div> -->
<!-- 					<div class="b_wrap"> -->
<!-- 						<div class="fl n_list"> -->
<!-- 							<h4>知识 · 资料</h4> -->
<!-- 							<ul> -->
<!-- 								<li><a href="tcDetail.html">文献名称文献名称文献名称文献名称</a></li> -->
<!-- 								<li><a href="tcDetail.html">文献名称文献名称文献名称文献名称</a></li> -->
<!-- 								<li><a href="tcDetail.html">文献名称文献名称文献名称文献名称</a></li> -->
<!-- 								<li><a href="tcDetail.html">文献名称文献名称文献名称文献名称</a></li> -->
<!-- 								<li><a href="tcDetail.html">文献名称文献名称文献名称文献名称</a></li> -->
<!-- 							</ul> -->
<!-- 						</div> -->
<!-- 						<div class="fr n_list"> -->
<!-- 							<h4>学习 · 资料</h4> -->
<!-- 							<ul> -->
<!-- 								<li><a href="tcDetail.html">资料名称资料名称资料名称资料名称</a></li> -->
<!-- 								<li><a href="tcDetail.html">资料名称资料名称资料名称资料名称</a></li> -->
<!-- 								<li><a href="tcDetail.html">资料名称资料名称资料名称资料名称</a></li> -->
<!-- 								<li><a href="tcDetail.html">资料名称资料名称资料名称资料名称</a></li> -->
<!-- 								<li><a href="tcDetail.html">资料名称资料名称资料名称资料名称</a></li> -->
<!-- 							</ul> -->
<!-- 						</div> -->
<!-- 						<div class="clear"></div> -->
<!-- 						<div class="t_list"> -->
<!-- 							<h4>知识 · 视频</h4> -->
<!-- 							<ul> -->
<!-- 								<li><a href="tcDetail.html"><img src="images/v1.jpg"/></a></li> -->
<!-- 								<li><a href="tcDetail.html"><img src="images/v1.jpg"/></a></li> -->
<!-- 								<li><a href="tcDetail.html"><img src="images/v1.jpg"/></a></li> -->
<!-- 								<li><a href="tcDetail.html"><img src="images/v1.jpg"/></a></li> -->
<!-- 							</ul> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="exam fr"> -->
<!-- 					<div class="b_title"> -->
<!-- 						<h3>练习安排</h3> -->
<!-- 						<a href="exam.html" class="more">更多+</a> -->
<!-- 					</div> -->
<!-- 					<div class="b_wrap"> -->
<!-- 						<div class="n_list"> -->
<!-- 							<ul> -->
<!-- 								<li><a href="eDetail.html">课程名称</a><span class="plan">2016-06-06&nbsp;&nbsp;10:00-12:00(上午)</span></li> -->
<!-- 								<li><a href="eDetail.html">课程名称课程名称</a><span class="plan">2016-06-06&nbsp;&nbsp;10:00-12:00(上午)</span></li> -->
<!-- 								<li><a href="eDetail.html">课程名称</a><span class="plan">2016-06-06&nbsp;&nbsp;10:00-12:00(上午)</span></li> -->
<!-- 								<li><a href="eDetail.html">课程名称课程名称</a><span class="plan">2016-06-06&nbsp;&nbsp;10:00-12:00(上午)</span></li> -->
<!-- 								<li><a href="eDetail.html">课程名称</a><span class="plan">2016-06-06&nbsp;&nbsp;10:00-12:00(上午)</span></li> -->
<!-- 								<li><a href="eDetail.html">课程名称</a><span class="plan">2016-06-06&nbsp;&nbsp;10:00-12:00(上午)</span></li> -->
<!-- 							</ul> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
				<div class="clear"></div>
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
			jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true, autoPage:true, trigger:"click" });
			jQuery(".notice").slide({mainCell:".bd ul",autoPage:true,effect:"top",autoPlay:true,vis:1});
			jQuery(".schoolmate .b_wrap").slide({titCell:".hd ul",mainCell:".bd ul",autoPage:true,effect:"left",autoPlay:true,vis:5,trigger:"click"});
		</script>
	</body>
</html>
