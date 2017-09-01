<%@page import="com.g10.ssm.po.knowledge.RepositoryCategoryExt"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加分类信息</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/css.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript">
	function check() {
		var name = document.getElementById("name").value;
		var xhr = createXmlHttpRequest();
		var url = "checkName";
		xhr.open('post', url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("name=" + name);/*发送http body*/
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				if (this.responseText == 0) {
					addKnowledgeClassification(name);
				} else {
					alert("分类已存在！");
				}
			}
		}
	}

	function addKnowledgeClassification(name) {
		var creator = "test";
		var parentId = document.getElementById("parentId").value;
		var note = document.getElementById("note").value;
		var xhr = createXmlHttpRequest();
		var url = "saveRepositoryCategory";
		xhr.open('post', url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("creator=" + creator + "&name=" + name + "&parentId="
				+ parentId + "&note=" + note);/*发送http body*/
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				if (this.responseText == 0) {
					alert("添加失败！");
				} else {
					alert("添加成功！");
				}
				window.location.href = "getAllRepositoryCategory";
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

.input3 {
	width: 240px;
	height: 40px;
	border: 1px solid #ccc;
	text-indent: 15px;
	margin-left: 10px;
}
</style>
</head>
<body>
	<div id="pageAll">
		<!--导航栏-->
		<div class="pageTop">
			<div class="page">
				<img src="${pageContext.request.contextPath}/img/coin02.png" /><span><a
					href="../main.html">首页</a>&nbsp;-&nbsp;<a
					href="getAllRepositoryCategory">知识分类管理</a>&nbsp;-</span>&nbsp;添加分类信息
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
						上级分类：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select id="parentId"
							name="parentId" class="select1">
							<%
								@SuppressWarnings("unchecked")
								List<RepositoryCategoryExt> list = (List<RepositoryCategoryExt>) request.getAttribute("list");
								for (int i = 0; i < list.size(); i++) {
									out.print("<option value='" + list.get(i).getCategoryId() + "'>");
									//	list.get(i).getCategoryId();
									//out.print("'>");
									out.print(list.get(i).getName() + "</option>");
									//list.get(i).getName();
								}
							%>
						</select>
					</div>
					<div class="bbD">
						分类名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="name"
							name="name" class="input3" />
					</div>

					<div class="bbD">
						<!-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
							type="text" id="note" name="note" class="input3" />
					</div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" onclick="check()">提交</button>
							<a class="btn_ok btn_no" href="getAllRepositoryCategory">取消</a>
						</p>
					</div>
				</div>
			</div>

			<!-- 页面样式end -->
		</div>
	</div>
</body>

</html>