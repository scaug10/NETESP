<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>审核试题信息</title>
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
<body onload="showReviewType();buttonDisplay()">
	<div id="pageAll">
		<!--导航栏-->
		<div class="pageTop">
			<div class="page">
				<img src="${pageContext.request.contextPath}/views/img/coin02.png" /><span><a
					href="${pageContext.request.contextPath}/index">首页</a>&nbsp;-&nbsp;<a
					href="${pageContext.request.contextPath}/questionbank">题库管理</a>&nbsp;-</span>&nbsp;审核试题信息
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
						题目内容：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label>${Question.content}</label>
					</div>
					<div class="bbD">
						审核状态：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="" id="reviewType">${Question.reviewType}</label>
					</div>

					<div id="reviewMessage" class="bbD"></div>

					<div id="buttonId" class="bbD"></div>

					<a class="btn_no" href="${pageContext.request.contextPath}/questionbank">返回</a>
				</div>
			</div>
		</div>
	</div>
	<input id="getSubjectId" type="hidden" value="${Question.subjectId}">
		<input id="getReviewType" type="hidden" value="${Question.reviewType}">
</body>
<script type="text/javascript">
	function pass() {
		var message = "确定审核通过？";
		if (confirm(message)) {
			var reviewType = 1;
			var subjectId = document.getElementById("getSubjectId").value;
			var xhr = createXmlHttpRequest();
			var url = "${pageContext.request.contextPath}/subject/update";
			xhr.open('post', url, true);
			xhr.setRequestHeader('Content-Type',
					'application/x-www-form-urlencoded');
			xhr.send("subjectId=" + subjectId + "&reviewType=" + reviewType);/*发送http body*/
			xhr.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					if (this.responseText == 0) {
						alert("审核失败！");
					} else {
						alert("审核成功！");
					}
					/* var url = "verifyRepositoryCategory?categoryId="
							+ categoryId;
					window.location.href = url; */
					location.reload();
				}
			}
		}
	}

	function noPass() {
		var message = "确定审核不通过？";
		if (confirm(message)) {
			var reviewMessage = prompt("不通过意见:");
			if (reviewMessage != null && reviewMessage != "" && reviewMessage.length != 0) {
				var reviewType = 2;
				var subjectId = document.getElementById("getSubjectId").value;
				var xhr = createXmlHttpRequest();
				var url = "${pageContext.request.contextPath}/subject/update";
				xhr.open('post', url, true);
				xhr.setRequestHeader('Content-Type',
						'application/x-www-form-urlencoded');
				xhr.send("subjectId=" + subjectId + "&reviewType=" + reviewType
						+ "&reviewMessage=" + reviewMessage);/*发送http body*/
				xhr.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
						if (this.responseText == 0) {
							alert("审核失败！");
						} else {
							alert("审核成功！");
						}
						location.reload();
					}
				}
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

	function showReviewType() {
		var td = document.getElementById('reviewType');
		var status = td.innerHTML;
		if (status == "0") {
			td.innerHTML = "未审核";
		} else if (status == "1") {
			td.innerHTML = "审核已通过";
		} else if (status == "2") {
			td.innerHTML = "审核未通过 ";
		}
	}

	function buttonDisplay() {
		var reviewType = document.getElementById("getReviewType").value;
		if (reviewType == 0) {
			document.getElementById("buttonId").innerHTML = "<button class='btn' onclick='pass()'>审核通过</button><button class='btn' onclick='noPass()'>审核不通过</button>";
		} else if (reviewType == 2) {
			document.getElementById("reviewMessage").innerHTML = "审核信息：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for='' class='reviewType'>${Question.reviewMessage }</label>"
		} else {

		}
	}
</script>
</html>