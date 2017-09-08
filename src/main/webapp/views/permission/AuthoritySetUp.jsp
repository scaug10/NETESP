<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>设置用户权限</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login/reset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login/css.css" />
<style>
button {
	width: 139px;
	height: 40px;
	font-size: 20px;
	background-color: #00FF00;
	margin-left: 20px;
	margin-top: 10px;
}

table {
	margin-left: 20px;
	margin-top: 20px;
}

td {
	width: 200px;
	height: 30px;
	text-align: center;
	line-height: 30px;
}

a {
	cursor: pointer;
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
	function getQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null) return unescape(r[2]);
		return null;
	}
	function givePermission(){
		var id = document.getElementsByName('userNameList');
		var list = new Array();
		for (var i = 0; i < id.length; i++) {
			if (id[i].checked) {
				list.push(id[i].value);
			}
		}
		if (list.length==0) {
			alert("你没有选中要分配权限的用户，分配权限失败！");
			return false;
		}
		var r = confirm("确定分配这项权限给这些用户？");
		if (r == true) {
			var url = "${pageContext.request.contextPath}/permission/givePermission";
			var xmlhttp = createXmlHttpRequest();
			xmlhttp.open("post", url, true);
			xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xmlhttp.send("list=" + list+"&permissionId="+getQueryString("permissionId"));
			xmlhttp.onreadystatechange = function() {
				if (this.status == 200 && this.readyState == 4) {
					if (this.responseText.trim() == "") {
						alert("分配权限失败！");
					} else {
						alert("分配权限成功,返回权限列表页面！");
						window.location.href='${pageContext.request.contextPath}/permission/jumpPermissionPage';
					}
				}
			}
		} else {
			return false;
		}
	}
	function searchUserList() {
		document.getElementById("name").innerHTML="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;权限名称："+getQueryString("name");
		var url = "${pageContext.request.contextPath}/login/searchUserList";
		var xmlhttp = createXmlHttpRequest();
		xmlhttp.open("post", url, true);
		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlhttp.send();
		xmlhttp.onreadystatechange = function() {
			if (this.status == 200 && this.readyState == 4) {
				var jsonObject = this.responseText;
				var result = eval("(" + jsonObject + ")"); //json转为js数组
				var str = ""
				for (var i = 0; i < result.length; ++i) {
					var userName = result[i].userName;
					str += "<tr>\n" +
						"	<td>" + "<input type='checkbox' name='userNameList' value='" + userName + "'/>" + "</td>\n" +
						"	<td>" + userName + "</td>\n" +
						"</tr>"
				}
				document.getElementById("tbody").innerHTML = str;
			}
		}
	}
</script>
</head>
<body onload="searchUserList()">
	<div id="pageAll">
		<!--导航栏-->
		<div class="pageTop">
			<div class="page" style="width: 1200px;">
				<img src="${pageContext.request.contextPath}/img/login/coin02.png" /><span><a
					href="${pageContext.request.contextPath}/index">首页</a>&nbsp;-&nbsp; <a
					href="${pageContext.request.contextPath}/permission/jumpPermissionPage">系统权限管理</a>&nbsp;-&nbsp;设置用户权限</span>
			</div>
		</div>
		<!--用户列表-->
		<div>
			<div>
				<br>
				<p id="name"></p>
				<table>
					<tr style="background-color: #00FF00;">
						<td></td>
						<td>用户名称</td>
					</tr>
					<tbody id=tbody>

					</tbody>
				</table>
				<div style="width: 800px;">
					<button onclick="givePermission()">设置</button>
					<button onclick="javascript:history.back(-1);">返回</button>
				</div>
			</div>
		</div>
</body>
</html>