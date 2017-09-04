<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>知识信息预览</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/css.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/comment.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/comment.js"></script>
<style type="text/css">
.box {
	margin-left: 60px;
	width: 135px;
	height: 40px;
	border: none;
	font-size: 16px;
	color: #fff;
	background-color: #47a4e1;
}

#editor {
	position: relative;
	left: 103px;
	bottom: 23px;
}

.linkStyle:visited {
	color: black;
}

.linkStyle:hover {
	color: #47a4e1;
}

.linkStyle:active {
	color: black;
}

.clearfix:after {
	content: ".";
	display: block;
	height: 0;
	clear: both;
	visibility: hidden;
}

.clearfix {
	*height: 1%;
}

hr {
	color: #ccc;
}

.btn_no {
	display: inline-block;
	width: 100px;
	height: 40px;
	line-height: 40px;
	color: #333;
	background-color: #fff;
	border: 1px solid #3695cc;
	margin-top: 50px;
	margin-left: 60px;
	margin-right: 25px;
	font-size: 16px;
	cursor: pointer;
	text-align: center;
	margin-bottom: 150px;
	margin-right: 25px;
}
</style>
</head>
<body>
	<div id="pageAll">
		<!--导航栏-->
		<div class="pageTop">
			<div class="page">
				<img src="${pageContext.request.contextPath}/img/coin02.png" /><span><a
					href="../main.html">首页</a>&nbsp;-&nbsp;<a href="getAllKnowledge">知识管理</a>&nbsp;-</span>&nbsp;知识预览
			</div>
		</div>
		<!--内容-->
		<div class=" bor clearfix">
			<div class="baTopNo">
				<span>知识信息</span>
			</div>
			<div class="baBody">
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;知识ID：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="">${Knowledge.knowledgeId }</label>
				</div>
				<div class="bbD">
					&nbsp;&nbsp;&nbsp;创建人：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="">${Knowledge.creator }</label>
				</div>
				<div class="bbD">
					知识名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="">${Knowledge.name }</label>
				</div>
				<div class="bbD">
					知识分类：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="">${Knowledge.categoryName }</label>
				</div>
				<div class="bbD">
					<!--PDF文档预览-->
					相关资料：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
						href="KnowledgePDF.html" target="_blank" class="linkStyle">PDF文档</a>
				</div>
				<div class="bbD">
					<!--视频预览-->
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
						href="KnowledgeVideo.html" target="_self" class="linkStyle">视频</a>
				</div>
				<a class="btn_no" href="getAllKnowledge">返回</a>

				<!-- 				<ul id="pn" width="100%">
					<li class="list0" width="100%">
						<div class="baTopNo">
							<span>评论</span>
						</div>
						<div class="content" width="100%">
							<div class="comment-list">
								<div class="comment" user="self">
									<div class="comment-right">
										<div class="comment-text">
											<span class="user">老王：</span>很好
										</div>
										<div class="comment-date">
											02-14 22:00 <a class="comment-zan" href="javascript:;"
												total="23" my="1">23 取消赞</a> <a class="comment-dele"
												href="javascript:;">回复</a>
										</div>
									</div>
								</div>
								<div class="comment" user="self">
									<div class="comment-right">
										<div class="comment-text">
											<span class="user">我：</span>看哭了留卡号吧
										</div>
										<div class="comment-date">
											02-14 24:00 <a class="comment-zan" href="javascript:;"
												total="0" my="0">赞</a> <a class="comment-dele"
												href="javascript:;">删除</a>
										</div>
									</div>
								</div>
							</div>
							<div class="hf">
								<textarea type="text" class="hf-text" autocomplete="on"
									maxlength="100">评论…</textarea>
								<button class="hf-btn">回复</button>
								<span class="hf-nub">0/100</span>
							</div>
						</div>
					</li>
				</ul> -->
			</div>
		</div>
	</div>
</body>
</html>