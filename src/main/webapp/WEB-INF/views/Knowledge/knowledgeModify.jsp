<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.g10.ssm.po.knowledge.RepositoryCategoryExt"%>
<%@page import="com.g10.ssm.po.knowledge.KnowledgeExt"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改知识信息</title>
<link rel="stylesheet" type="text/css" href="../css/css.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
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

#editor {
	position: relative;
	left: 103px;
	bottom: 23px;
}
</style>

<script type="text/javascript">
	function check(oldname, knowledgeId) {
		var name = document.getElementById("name").value;
		if (name == oldname) {
			editKnowledge(name, knowledgeId);
		} else {
			var xhr = createXmlHttpRequest();
			var url = "checkKnowledgeName";
			xhr.open('post', url, true);
			xhr.setRequestHeader('Content-Type',
					'application/x-www-form-urlencoded');
			xhr.send("name=" + name);/*发送http body*/
			xhr.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					if (this.responseText == 0) {
						editKnowledge(name, knowledgeId);
					} else {
						alert("知识已存在！");
					}
				}
			}
		}
	}
	function editKnowledge(name, knowledgeId) {
		var categoryId = document.getElementById("categoryId").value;
		var xhr = createXmlHttpRequest();
		var url = "editKnowledge";
		xhr.open('post', url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("knowledgeId=" + knowledgeId + "&name=" + name
				+ "&categoryId=" + categoryId);/*发送http body*/
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				if (this.responseText == 0) {
					alert("修改失败！");
				} else {
					alert("修改成功！");
				}
				window.location.href = "getAllKnowledge";
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

</head>
<body>
	<div id="pageAll">
		<!--导航栏-->
		<div class="pageTop">
			<div class="page">
				<img src="../img/coin02.png" /><span><a href="../main.html">首页</a>&nbsp;-&nbsp;<a
					href="KnowledgeManagement.html">知识管理</a>&nbsp;-</span>&nbsp;修改知识信息
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
						&nbsp;&nbsp;&nbsp;知识ID：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
							id="knowledgeId" name="knowledgeId"
							value="${Knowledge.knowledgeId }" class="input3"
							disabled="disabled">
					</div>
					<div class="bbD">
						&nbsp;&nbsp;&nbsp;创建人：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
							id="creator" name="creator" value="${Knowledge.creator }"
							class="input3" disabled="disabled">
					</div>
					<div class="bbD">
						知识名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="name"
							name="name" value="${Knowledge.name }" class="input3" />
					</div>
					<div class="bbD">
						知识分类：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select id="categoryId"
							name="categoryId" class="select1">
							<%
								@SuppressWarnings("unchecked")
								List<RepositoryCategoryExt> list = (List<RepositoryCategoryExt>) request.getAttribute("list");
								KnowledgeExt record = (KnowledgeExt) request.getAttribute("Knowledge");
								for (int i = 0; i < list.size(); i++) {
									out.print("<option value='" + list.get(i).getCategoryId() + "'");
									if (record.getCategoryId() == list.get(i).getCategoryId()) {
										out.print("selected = 'selected'");
									}
									out.print(">");
									out.print(list.get(i).getName() + "</option>");
								}
							%>
						</select>
					</div>
					<div class="bbD">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;内容：</div>
					<div id="editor">
						<!--百度编辑器配置-->
						<script id="container" name="content" type="text/plain"></script>
						<script type="text/javascript"
							src="../js/utf8-jsp/ueditor.config.js"></script>
						<script type="text/javascript" src="../js/utf8-jsp/ueditor.all.js"></script>
						<script type="text/javascript">
							var ue = UE.getEditor('container', {
								initialFrameWidth : [ 800 ],
								initialFrameHeight : [ 300 ],
								autoHeightEnabled : false,
							});
						</script>
					</div>
					<!--保存和取消按钮-->
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes"
								onclick="check('${Knowledge.name}','${Knowledge.knowledgeId }')">保存</button>
							<a class="btn_ok btn_no" href="getAllKnowledge">取消</a>
						</p>
					</div>
				</div>
			</div>

			<!-- 页面样式end -->
		</div>
	</div>
</body>
</html>