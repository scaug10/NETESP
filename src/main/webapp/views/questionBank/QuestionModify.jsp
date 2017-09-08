<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改试题信息</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/css.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<style>
* {
	margin: 0;
	padding: 0;
}

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

.banDel {
	z-index: 9999;
}
</style>
</head>
<body>
	<div id="pageAll">
		<!--导航栏-->
		<div class="pageTop">
			<div class="page">
				<img src="${pageContext.request.contextPath}/views/img/coin02.png" /><span><a
					href="${pageContext.request.contextPath}/index">首页</a>&nbsp;-&nbsp;<a
					href="${pageContext.request.contextPath}/getAllRepositoryCategory">题库管理</a>&nbsp;-</span>&nbsp;修改试题信息
			</div>
		</div>
		<div class="page ">
			<!-- 内容页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>试题信息</span>
				</div>
				<div class="baBody">
					<div class="bbD">
						题库ID：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>${Question.subjectId}</label>
					</div>
					<div class="bbD">
						所属题库：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>${Question.testDatabaseMatter}</label>
					</div>
					<div class="bbD">
						所属科目：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>${Question.subjectMatter}</label>
					</div>
					<div class="bbD">
						&nbsp;&nbsp; 知识点：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>${Question.knowlegePoint}</label>
					</div>
					<div class="bbD">
						题目类型：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>${Question.subjectType}</label>
					</div>
					<div class="bbD">
						难易程度：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>${Question.name}</label>
					</div>
					<div class="bbD">
						题目内容：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
							id='content' class='input3' value=' ${Question.content}' />
					</div>
					<div class="bbD">
						题目答案：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" id='answer'
							class='input3' value=' ${Question.answer}' />
					</div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes"
								onclick="modify(${Question.subjectId })">保存</button>
							<a class="btn_ok btn_no" href="subject/all">取消</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function modify(subjectId) {
		var content = document.getElementById("content").value;
		var answer = document.getElementById("answer").value;
		var xhr = createXmlHttpRequest();
		var url = "${pageContext.request.contextPath}/subject/update";
		xhr.open('post', url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("subjectId=" + subjectId + "&content=" + content
				+ "&answer=" + answer);/*发送http body*/
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				if (this.responseText == 0) {
					alert("修改失败！");
				} else {
					alert("修改成功！");
				}
				window.location.href = "${pageContext.request.contextPath}/questionbank";
			}
		}
	}
	function createXmlHttpRequest() {
		if (window.ActiveXObject) { //如果是IE浏览器
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) { //非IE浏览器
			return new XMLHttpRequest();
		}
	}
</script>
</html>