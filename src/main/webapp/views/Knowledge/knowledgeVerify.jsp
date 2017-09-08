<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>审核知识分类信息</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/css.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<style>
.box {
	margin-left: 60px;
	width: 135px;
	height: 40px;
	border: none;
	font-size: 16px;
	color: #fff;
	background-color: #47a4e1;
}

.btn_no {
	display: inline-block;
	width: 100px;
	height: 40px;
	line-height: 40px;
	color: #333;
	background-color: #fff;
	border: 1px solid #3695cc;
	margin-top: 10px;
	margin-right: 25px;
	font-size: 16px;
	cursor: pointer;
	text-align: center;
	margin-bottom: 150px;
}

.btn {
	display: inline-block;
	width: 100px;
	height: 40px;
	line-height: 40px;
	background-color: #3695cc;
	color: #fff;
	margin-top: 10px;
	margin-right: 25px;
	font-size: 16px;
	cursor: pointer;
	text-align: center;
	margin-bottom: 10px;
	border: none;
}
</style>
</head>
<body onload="showReviewType(); buttonDisplay();">
	<div id="pageAll">
		<!--导航栏-->
		<div class="pageTop">
			<div class="page">
				<img src="${pageContext.request.contextPath}/views/img/coin02.png" /><span><a
					href="${pageContext.request.contextPath}/index">首页</a>&nbsp;-&nbsp;<a href="getAllKnowledge">知识管理</a>&nbsp;-</span>&nbsp;审核分类信息
			</div>
		</div>
		<div class="page ">
			<!-- 页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>分类信息</span>
				</div>
				<div class="baBody">
					<div class="bbD">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ID号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
							for="">${Knowledge.categoryId }</label>
					</div>
					<div class="bbD">
						&nbsp;&nbsp;&nbsp; 创建人：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="">${Knowledge.creator }</label>
					</div>
					<div class="bbD">
						知识名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="">${Knowledge.name }</label>
					</div>
					<div class="bbD">
						知识分类：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="">${Knowledge.categoryName }</label>
					</div>

					<div class="bbD">
						审核状态：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="" id="reviewType">${Knowledge.reviewType}</label>
					</div>

					<div id="reviewMessage" class="bbD">
						<%-- 审核信息：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for=""
							class="input3 reviewType">${Knowledge.reviewMessage }</label> --%>
					</div>

					<input id="getKnowledgeId" type="hidden"
						value="${Knowledge.knowledgeId}"> <input
						id="getReviewType" type="hidden" value="${Knowledge.reviewType}">

					<div id="buttonId" class="bbD">
						<!-- <button class="btn_ok btn_yes operation" onclick="pass()">审核通过</button>
							<button class="btn_ok operation" onclick="noPass()">审核不通过</button>
							<a class="btn_ok btn_no" href="KnowledgeClassificationCheck.html">返回</a> -->

					</div>
					<a class="btn_no" href="getAllKnowledge">返回</a>
				</div>
			</div>

			<!-- 页面样式end -->
		</div>
	</div>
</body>

<script type="text/javascript">
	function pass() {
		var message = "确定审核通过？";
		if (confirm(message)) {
			var reviewType = 1;
			var knowledgeId = document.getElementById("getKnowledgeId").value;
			var xhr = createXmlHttpRequest();
			var url = "editKnowledge";
			xhr.open('post', url, true);
			xhr.setRequestHeader('Content-Type',
					'application/x-www-form-urlencoded');
			xhr
					.send("knowledgeId=" + knowledgeId + "&reviewType="
							+ reviewType);/*发送http body*/
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
			if (reviewMessage.length != 0) {
				var reviewType = 2;
				var knowledgeId = document.getElementById("getKnowledgeId").value;
				var xhr = createXmlHttpRequest();
				var url = "editKnowledge";
				xhr.open('post', url, true);
				xhr.setRequestHeader('Content-Type',
						'application/x-www-form-urlencoded');
				xhr.send("knowledgeId=" + knowledgeId + "&reviewType="
						+ reviewType + "&reviewMessage=" + reviewMessage);/*发送http body*/
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
			document.getElementById("reviewMessage").innerHTML = "审核信息：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for='' class='reviewType'>${Knowledge.reviewMessage }</label>"
		} else {

		}
	}
</script>
</html>