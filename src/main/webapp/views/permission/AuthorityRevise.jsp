<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改权限</title>
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
		if(window.ActiveXObject) { //如果是IE浏览器
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else if(window.XMLHttpRequest) { //非IE浏览器
			return new XMLHttpRequest();
		}
	}
	function getQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null) return unescape(r[2]);
		return null;
	}
	function query(){
		var name=getQueryString("name");
		document.getElementById("authorityName2").value = name;
	}
	function checkName() {
		var div = document.getElementById("div1");
		div.innerHTML = "";
		var name1 = document.getElementById("authorityName2").value;
		if (name1.trim() == "") {
			div.innerHTML = "权限名称不能为空！";
			return false;
		}
		if (name1.length < 1 || name1.length > 50) {
			div.innerHTML = "权限名称的输入的长度1-50个字符！";
			return false;
		}
		if(name1==getQueryString("name")){
			div.innerHTML = "你没有对权限名称进行修改！";
			return false;
		}
		return true;
	}
	function Revise(){
		if(!checkName()){
			return false;
		}
		else{
			var url="${pageContext.request.contextPath}/permission/updatePermission";
			var xmlhttp = createXmlHttpRequest();
			xmlhttp.open("post",url,true);
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xmlhttp.send("name="+document.getElementById("authorityName2").value+
			"&permissionId="+getQueryString("permissionId"));
			xmlhttp.onreadystatechange = function() {
			if (this.status == 200 && this.readyState == 4) {
 				if(this.responseText.trim()==""){
 					alert("修改权限失败，可能是你没有权限进行此操作");
 				}else{
 					alert("修改权限成功，返回权限列表页面");
 					window.location.href='${pageContext.request.contextPath}/permission/jumpPermissionPage';
 				}
			}
			}
		}
	}
</script>
</head>
<body onload="query()">
	<div id="pageAll">
		<!--导航栏-->
		<div class="pageTop">
			<div class="page" style="width: 1200px;">
				<img src="${pageContext.request.contextPath}/img/login/coin02.png" /><span><a
					href="${pageContext.request.contextPath}/index">首页</a>&nbsp;-&nbsp <a
					href="${pageContext.request.contextPath}/permission/jumpPermissionPage">系统权限管理</a>&nbsp;-&nbsp修改权限</span>
			</div>
		</div>
		<!--内容页-->
		<div class="boxbig">
			<p>权限名称：</p>
			<P>
				<input id="authorityName2" type="text" class="box" value="${name}" />
				<div id="div1" style="display:inline"></div>
			</P>
			<p>
				<button class="button1" onclick="Revise()">保存</button>
				&nbsp;&nbsp;&nbsp;
				<button class="button1" onclick="javascript:history.back(-1);">返回</button>
			</P>
		</div>
	</div>
	</div>
</body>
</html>