<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.g10.ssm.po.knowledge.RepositoryCategoryExt"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加知识信息</title>
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

.select1 {
	width: 242px;
	height: 40px;
	border: 1px solid #ccc;
	text-indent: 15px;
	margin-left: 6px;
}

#editor {
	position: relative;
	left: 103px;
	bottom: 23px;
}
</style>
<script type="text/javascript">
	function createXmlHttpRequest() {
		if (window.ActiveXObject) { //如果是IE浏览器
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) { //非IE浏览器
			return new XMLHttpRequest();
		}
	}

	function add() {
		var name = document.getElementById("name").value;
		var categoryId = document.getElementById("categoryId").value;
		var dataUrl = document.getElementById("dataUrl").value;
		var xhr = createXmlHttpRequest();
		var url = "saveKnowledge";
		xhr.open('post', url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("name=" + name + "&categoryId=" + categoryId + "&dataUrl="
				+ dataUrl);/*发送http body*/
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				if (this.responseText == 2) {
					alert("知识已存在！");
				} else if (this.responseText == 1) {
					alert("知识新增成功！");
					window.location.href = "getAllKnowledge";
				} else {
					alert("未知错误导致新增失败！");
				}
			}
		}
	}
</script>

</head>
<body>
	<div id="pageAll">
		<!--导航栏-->
		<div class="pageTop">
			<div class="page">
				<img src="../img/coin02.png" /><span><a href="../main.html">首页</a>&nbsp;-&nbsp;<a
					href="KnowledgeManagement.html">知识管理</a>&nbsp;-</span>&nbsp;添加知识信息
			</div>
		</div>
		<div class="page ">
			<!-- 内容页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo">
					<span>知识信息</span>
				</div>
				<div class="baBody">
					<div class="bbD">
						知识名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="name"
							class="input3" />
					</div>
					<div class="bbD">
						知识分类：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select id="categoryId"
							name="categoryId" class="select1">
							<%
								@SuppressWarnings("unchecked")
								List<RepositoryCategoryExt> list = (List<RepositoryCategoryExt>) request.getAttribute("list");
								for (int i = 0; i < list.size(); i++) {
									out.print("<option value='" + list.get(i).getCategoryId() + "'>");
									out.print(list.get(i).getName() + "</option>");
								}
							%>
						</select>
					</div>
					<div class="bbD">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地址：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="text" id="dataUrl" class=" input3" />
					</div>

					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" onclick='add()'>提交</button>
							<a class="btn_ok btn_no" href="getAllKnowledge">取消</a>
						</p>
					</div>
				</div>
			</div>

			<!--页面样式end -->
		</div>
	</div>
</body>
</html>