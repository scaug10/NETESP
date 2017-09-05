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
												"<a href=\"personal.html\">个人中心</a>\n"+
												"<a href=\"ownTopic.html\">我的学习任务</a>\n"+
												"<a href=\""+ request.getContextPath() +"/login/exitSys\">退出</a>\n"+
												"</div>"
											);
								}
							%>
							</a>
<!-- 							<div class="user_handle"> -->
<!-- 								<a href="personal.html">个人中心</a> -->
<!-- 								<a href="ownTopic.html">我的学习任务</a> -->
<%-- 								<a href="${pageContext.request.contextPath }/login/exitSys">退出</a> --%>
<!-- 							</div> -->
						</li>
					</ul>
					<div class="clear"></div>
				</span>
				<div class="clear"></div>
			</div>
			<!--<div id="gray"></div>				
			<div class="popup" id="popup">				
				<div class="top_nav" id='top_nav'>
					<div align="center">
						<i></i>
						<span>登录账号</span>
						<a class="guanbi"></a>
					</div>
				</div>					
				<div class="min">					
					<div class="tc_login">											
						<div class="login_register">
							<form method="POST" name="form_login" target="_top">
								<div align="center">
									<span class="error">错误提示</span>
									<i class="icon-mobile-phone"></i>
									<input type="text" name="name" id="name" required="required" placeholder="用户名" autocomplete="off" class="input_yh">
									<input type="password" name="pass" id="pass" required="required" placeholder="密码" autocomplete="off" class="input_mm">
								</div>
								<dd>
									<div class="user">
										<input type="checkbox" name="user" id="user" value="记住用户" class="r_user" />记住用户
										<a href="password.html" target="_blank">忘记密码？</a>
									</div>
								</dd>
								<div align="center">
									<input type="submit" class="button" title="Sign In" value="登录">
								</div>
								<dd>
									<div align="center"><a href="register.html" target="_blank">立即注册！</a></div>
								</dd>
							</form>
						</div>
					</div>
				</div>
			</div>-->
		</div>
		<!--nav start-->
		<div class="nav_menu">
			<a href="index.html" class="logo fl"><img src="images/logo.png" /></a>
			<div class="nav_list fr">
				<ul id="nav" class="nav clearfix">
					<li class="nLi"></li>
					<li class="nLi">
						<h3><a href="about.html">中心概况</a></h3>
					</li>
					<!--<li class="nLi">
						<h3><a href="news.html">新闻热点</a></h3>
						<ul class="sub">
							<li><a href="news.html">教育新闻</a></li>
							<li><a href="news.html">工作动态</a></li>
						</ul>
					</li>
					<li class="nLi">
						<h3><a href="topic.html"></a></h3>
					</li>-->
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
							<li><a href="${pageContext.request.contextPath}/notice/jumpPersonalNoticePage">个人通知</a></li>
<!-- 							<li><a href="notice/Notice3.html">学习制度</a></li> -->
						</ul>
					</li>
					<li class="nLi">
						<h3><a href="teachers.html">在线知识</a></h3>
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
		<!--banner start-->
		<div class="banner">
			<div class="bd">
				<ul>
					<li class="first"><a href="javascript:void(0);"></a></li>
					<li class="second"><a href="javascript:void(0);"></a></li>
					<li class="third"><a href="javascript:void(0);"></a></li>
					<li class="fourth"><a href="javascript:void(0);"></a></li>
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
						<li><span class="date">[2016-05-05]</span><a href="nDetail.html">通知公告名称通知公告名称，通知公告名称通知公告名称通知公告，名称通知公告名...</a></li>
						<li><span class="date">[2016-05-05]</span><a href="nDetail.html">通知公告名称通知公告名称，通知公告名称通知公告名称通知公告...</a></li>
						<li><span class="date">[2016-05-05]</span><a href="nDetail.html">通知公告名称通知公告名称，通知公告名称通知公告名称</a></li>
						<li><span class="date">[2016-05-05]</span><a href="nDetail.html">通知公告名称通知公告名称，通知公告名称通知公告名称通知公告，名称通知公告名名称通知公告名...</a></li>
					</ul>
				</div>
				<a href="notice.html" class="more fr">更多+</a>
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
							<a href="about.html" class="more">更多+</a>
						</div>
						<div class="b_wrap">
							<div class="a_img fl">
								<img src="images/about.jpg" />
							</div>
							<div class="a_text fl">
								<p>基础教育语文研究中心基础，教育语文研究中心基础教育语文，研究中心基础教育语文研究中心基础教育语文研究中心。基础教育语文研究中心基础，教育语文研究中心基础教育语文，研究中心基础教育语文研究中心基础教育语文研究中心。基础教育语文研究中心基础，教育语文研究中心基础教育语文，研究中心基础教育语文研究中心基础教育语文研究中心。</p>
								<p>基础教育语文研究中心基础，教育语文研究中心基础教育语文，研究中心基础教育语文研究中心基础教育语文研究中心。基础教育语文研究中心基础，教育语文研究中心基础教育语文，研究中心基础教育语文研究中心基础教育语文研究中心...</p>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="news">
						<div class="b_title">
							<h3>公告通知</h3>
							<a href="news.html" class="more">更多+</a>
						</div>
						<div class="b_wrap">
							<div class="fl n_list">
								<h4>系统通告</h4>
								<ul>
									<li class="special">
										<div class="n_img">
											<img src="images/n1.jpg" />
										</div>
										<div class="n_text">
											<b>新闻标题新闻标题新闻标题新闻标题</b>
											<p>新闻标题新闻标题新闻标题新闻,标题新,标题新闻标题新闻标题新闻标题...<a href="nDetail.html" class="detail">详细</a></p>
										</div>
									</li>
									<li><a href="nDetail.html">新闻标题新闻标题新闻标题新闻</a></li>
									<li><a href="nDetail.html">新闻标题新闻标题新闻标题新闻</a></li>
									<li><a href="nDetail.html">新闻标题新闻标题新闻标题新闻</a></li>
								</ul>
							</div>
							<div class="fr n_list">
								<h4>制度 · 任务</h4>
								<ul>
									<li class="special">
										<div class="n_img">
											<img src="images/n2.jpg" />
										</div>
										<div class="n_text">
											<b>新闻标题新闻标题新闻标题新闻标题</b>
											<p>闻标题新闻标题新闻标题新闻标题新闻,标题新闻标题新闻标题新闻标题...<a href="nDetail.html" class="detail">详细</a></p>
										</div>
									</li>
									<li><a href="nDetail.html">新闻标题新闻标题新闻标题新闻</a></li>
									<li><a href="nDetail.html">新闻标题新闻标题新闻标题新闻</a></li>
									<li><a href="nDetail.html">新闻标题新闻标题新闻标题新闻</a></li>
								</ul>
							</div>
							<div class="clear"></div>
						</div>
					</div>
				</div>
				<div class="hot fr">
					<div class="b_title">
						<h3>热门主题</h3>
						<a href="topic.html" class="more">更多+</a>
					</div>
					<div class="b_wrap">
						<ul>
							<li>
								<div class="h_img">
									<img src="images/favicon.jpg" />
								</div>
								<div class="h_text">
									<b><a href="tDetail.html">话题名称话题名称话题名称</a></b>
									<p>话题名称话题名称话题名称,话题名称话题名称话题名称...<a href="tDetail.html" class="detail">详细</a></p>
								</div>
							</li>
							<li>
								<div class="h_img">
									<img src="images/favicon.jpg" />
								</div>
								<div class="h_text">
									<b><a href="tDetail.html">话题名称话题名称话题名称</a></b>
									<p>话话题名称话题名称话名称,话题名称话题名称话题名称...<a href="tDetail.html" class="detail">详细</a></p>
								</div>
							</li>
							<li>
								<div class="h_img">
									<img src="images/favicon.jpg" />
								</div>
								<div class="h_text">
									<b><a href="tDetail.html">话题名称话题名称话题名称</a></b>
									<p>话题名称话称话题名称,话题名称话题名称话题名称...<a href="tDetail.html" class="detail">详细</a></p>
								</div>
							</li>
							<li>
								<div class="h_img">
									<img src="images/favicon.jpg" />
								</div>
								<div class="h_text">
									<b><a href="tDetail.html">话题名称话题名称话题名称</a></b>
									<p>话题名称称话题名称,话题名称话题名称话题名称...<a href="tDetail.html" class="detail">详细</a></p>
								</div>
							</li>
							<li>
								<div class="h_img">
									<img src="images/favicon.jpg" />
								</div>
								<div class="h_text">
									<b><a href="tDetail.html">话题名称话题名称话题名</a></b>
									<p>题名称话题名称话题名称话题名称话题名称...<a href="tDetail.html" class="detail">详细</a></p>
								</div>
							</li>
							<li>
								<div class="h_img">
									<img src="images/favicon.jpg" />
								</div>
								<div class="h_text">
									<b><a href="tDetail.html">话题名称话题名称话题名称话</a></b>
									<p>名称话题名称话题名称,话题名称话题名话题名称...<a href="tDetail.html" class="detail">详细</a></p>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<!--teachers and course-->
			<!--<div class="box2">
				<div class="teachers fl">
					<div class="b_title">
						<h3>名师风采</h3>
						<a href="teachers.html" class="more">更多+</a>
					</div>
					<div class="b_wrap">
						<div class="fl n_list">
							<h4>名师 · 资源</h4>
							<ul>
								<li><a href="tcDetail.html">论文标题论文标题论文标题论文标题</a></li>
								<li><a href="tcDetail.html">论文标题论文标题论文标题论文标题</a></li>
								<li><a href="tcDetail.html">论文标题论文标题论文标题论文标题</a></li>
								<li><a href="tcDetail.html">论文标题论文标题论文标题论文标题</a></li>
								<li><a href="tcDetail.html">论文标题论文标题论文标题论文标题</a></li>
							</ul>
						</div>
						<div class="fr n_list">
							<h4>名师 · 推荐</h4>
							<ul>
								<li><a href="tcDetail.html">人名：课程名称课程名称课程名称</a></li>
								<li><a href="tcDetail.html">人名：课程名称课程名称课程名称</a></li>
								<li><a href="tcDetail.html">人名：课程名称课程名称课程名称</a></li>
								<li><a href="tcDetail.html">人名：课程名称课程名称课程名称</a></li>
								<li><a href="tcDetail.html">人名：课程名称课程名称课程名称</a></li>
							</ul>
						</div>
						<div class="clear"></div>
						<div class="t_list">
							<h4>名师 · 简介</h4>
							<ul>
								<li><a href="tDetail.html"><img src="images/t1.jpg"/><span>老师</span></a></li>
								<li><a href="tDetail.html"><img src="images/t2.jpg"/><span>老师</span></a></li>
								<li><a href="tDetail.html"><img src="images/t1.jpg"/><span>老师</span></a></li>
								<li><a href="tDetail.html"><img src="images/t2.jpg"/><span>老师</span></a></li>
								<li><a href="tDetail.html"><img src="images/t1.jpg"/><span>老师</span></a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="course fr">
					<div class="b_title">
						<h3>课程改革</h3>
						<a href="course.html" class="more">更多+</a>
					</div>
					<div class="b_wrap">
						<div class="n_list">
							<div class="intro">
								<img src="images/course.jpg"/>
								<p>课程改革简介课程改革简介，课程改革简介课程改革简介课程改革，简介课程改革简介课程改革简介课程改革简介，课程改革简介课程改革简介...<a href="nDetail.html" class="detail">详细</a></p>
							</div>
							<ul>
								<li><a href="tcDetail.html">课程名称</a></li>
								<li><a href="tcDetail.html">课程名称课程名称</a></li>
								<li><a href="tcDetail.html">课程名称</a></li>
								<li><a href="tcDetail.html">课程名称课程名称</a></li>
								<li><a href="tcDetail.html">课程名称</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<!--schoolmate-->
			<!--<div class="schoolmate">
				<div class="b_title">
					<h3>学友之家</h3>
					<a href="schoolmate.html" class="more">更多+</a>
				</div>
				<div class="b_wrap">
					<div class="hd">
						<a class="next"></a>
						<a class="prev"></a>
					</div>
					<div class="s_list bd">
						<ul>
							<li><a href="tDetail.html"><img src="images/ac1.jpg"/><span>活动名称</span></a></li>
							<li><a href="tDetail.html"><img src="images/ac2.jpg"/><span>活动名称</span></a></li>
							<li><a href="tDetail.html"><img src="images/ac1.jpg"/><span>活动名称</span></a></li>
							<li><a href="tDetail.html"><img src="images/ac2.jpg"/><span>活动名称</span></a></li>
							<li><a href="tDetail.html"><img src="images/ac1.jpg"/><span>活动名称</span></a></li>
							<li><a href="tDetail.html"><img src="images/ac1.jpg"/><span>活动名称</span></a></li>
							<li><a href="tDetail.html"><img src="images/ac2.jpg"/><span>活动名称</span></a></li>
						</ul>
					</div>
				</div>
			</div>-->
			<!--resource and exam-->
			<div class="box3">
				<div class="resource fl">
					<div class="b_title">
						<h3>知识资源</h3>
						<a href="resource.html" class="more">更多+</a>
					</div>
					<div class="b_wrap">
						<div class="fl n_list">
							<h4>知识 · 资料</h4>
							<ul>
								<li><a href="tcDetail.html">文献名称文献名称文献名称文献名称</a></li>
								<li><a href="tcDetail.html">文献名称文献名称文献名称文献名称</a></li>
								<li><a href="tcDetail.html">文献名称文献名称文献名称文献名称</a></li>
								<li><a href="tcDetail.html">文献名称文献名称文献名称文献名称</a></li>
								<li><a href="tcDetail.html">文献名称文献名称文献名称文献名称</a></li>
							</ul>
						</div>
						<div class="fr n_list">
							<h4>学习 · 资料</h4>
							<ul>
								<li><a href="tcDetail.html">资料名称资料名称资料名称资料名称</a></li>
								<li><a href="tcDetail.html">资料名称资料名称资料名称资料名称</a></li>
								<li><a href="tcDetail.html">资料名称资料名称资料名称资料名称</a></li>
								<li><a href="tcDetail.html">资料名称资料名称资料名称资料名称</a></li>
								<li><a href="tcDetail.html">资料名称资料名称资料名称资料名称</a></li>
							</ul>
						</div>
						<div class="clear"></div>
						<div class="t_list">
							<h4>知识 · 视频</h4>
							<ul>
								<li><a href="tcDetail.html"><img src="images/v1.jpg"/></a></li>
								<li><a href="tcDetail.html"><img src="images/v1.jpg"/></a></li>
								<li><a href="tcDetail.html"><img src="images/v1.jpg"/></a></li>
								<li><a href="tcDetail.html"><img src="images/v1.jpg"/></a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="exam fr">
					<div class="b_title">
						<h3>练习安排</h3>
						<a href="exam.html" class="more">更多+</a>
					</div>
					<div class="b_wrap">
						<div class="n_list">
							<ul>
								<li><a href="eDetail.html">课程名称</a><span class="plan">2016-06-06&nbsp;&nbsp;10:00-12:00(上午)</span></li>
								<li><a href="eDetail.html">课程名称课程名称</a><span class="plan">2016-06-06&nbsp;&nbsp;10:00-12:00(上午)</span></li>
								<li><a href="eDetail.html">课程名称</a><span class="plan">2016-06-06&nbsp;&nbsp;10:00-12:00(上午)</span></li>
								<li><a href="eDetail.html">课程名称课程名称</a><span class="plan">2016-06-06&nbsp;&nbsp;10:00-12:00(上午)</span></li>
								<li><a href="eDetail.html">课程名称</a><span class="plan">2016-06-06&nbsp;&nbsp;10:00-12:00(上午)</span></li>
								<li><a href="eDetail.html">课程名称</a><span class="plan">2016-06-06&nbsp;&nbsp;10:00-12:00(上午)</span></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<!--friendly link-->
			<div class="friendlink">
				<b>友情链接：</b><a href="">友情链接</a><a href="">友情链接</a><a href="">友情链接</a><a href="">友情链接</a><a href="">友情链接</a>
			</div>
		</div>
		<!--footer start-->
		<div class="footer_wrap">
			<div class="line"></div>
			<div class="footer">
				<p>版权所有：应急化教育与培训平台</p>
				<!--<p>电话：029-8888888&nbsp;&nbsp;&nbsp;邮箱：XXXXXXXX@163.com</p>-->
				<!--<p>地址：陕西省西安市XXXXXXXXX  更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
				<img src="images/er.png" class="er" />-->
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
