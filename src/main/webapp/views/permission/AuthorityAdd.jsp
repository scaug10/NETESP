<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增权限</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login/reset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login/css.css" />
<style>
.boxbig {
	width: 80%;
	margin: auto;
}

.box {
	height: 20px;
	width: 200px;
}

p {
	margin-top: 10px;
}

.button1 {
	height: 40px;
	width: 80px;
	background-color: #00FF00;
}
</style>
<script>
	function createXmlHttpRequest() {
		if (window.ActiveXObject) { //如果是IE浏览器
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) { //非IE浏览器
			return new XMLHttpRequest();
		}
	}

	function checkName() {
		var div = document.getElementById("div1");
		div.innerHTML = "";
		var name1 = document.getElementById("authorityName").value;
		if (name1.trim() == "") {
			div.innerHTML = "权限名称不能为空！";
			return false;
		}
		if (name1.length < 1 || name1.length > 50) {
			div.innerHTML = "权限名称的输入的长度1-50个字符！";
			return false;
		}
		return true;
	}
	function add() {
		if(!checkName()){
			return false;
		}
		var url = "${pageContext.request.contextPath}/permission/insertPermission";
		var xmlhttp = createXmlHttpRequest();
		xmlhttp.open("post", url, true);
		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlhttp.send("name=" + document.getElementById("authorityName").value);
		xmlhttp.onreadystatechange = function() {
			if (this.status == 200 && this.readyState == 4) {
 				if(this.responseText.trim()==""){
 					alert("新增权限失败，可能是你没有权限进行此操作或者该权限名已存在");
 				}else{
 					alert("新增权限成功，返回权限列表页面");
 					window.location.href='${pageContext.request.contextPath}/permission/jumpPermissionPage';
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
			<div class="page" style="width: 1200px;">
				<img src="${pageContext.request.contextPath}/img/login/coin02.png" /><span><a
					href="../main.html">首页(还未实现)</a>&nbsp;-&nbsp <a
					href="${pageContext.request.contextPath}/permission/jumpPermissionPage">系统权限管理</a>&nbsp;-&nbsp新增权限</span>
			</div>
		</div>
		<!--内容页-->
		<div class="boxbig">
			<div>
				<p>权限名称：</p>
				<P>
					<input id="authorityName" type="text" class="box" value='${name}' />
					<div id="div1" style="display:inline"></div>
				</P>
				<p>
					<button class="button1" onclick="add()">保存</button>
					&nbsp;&nbsp;&nbsp;
					<button class="button1">取消</button>
				</P>
			</div>
		</div>
	</div>
</body>
</html>
