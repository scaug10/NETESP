<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login/public.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login/page.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/login/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/login/public.js"></script>
<script>
	function checkName() {
		var name1 = document.form1.text1.value;
		if (name1.trim() == "") {
			alert("账号不能为空！");
			return false;
		}
		if (name1.length < 4 || name1.length > 16) {
			alert("账号输入的长度4-16个字符！");
			return false;
		}
		var charname1 = name1.toLowerCase();
		for (var i = 0; i < name1.length; i++) {
			var charname = charname1.charAt(i);
			if (!(charname >= 0 && charname <= 9) && (!(charname >= 'a' && charname <= 'z')) && (charname != '_')) {
				alert("账号包含非法字母，只能包含字母，数字，和下划线");
				return false;
			}
		}
		return true;
	}

	function checkPassword() {
		var password = document.form1.text2.value;
		if (password.trim() == "") {
			alert("密码不为空！");
			return false;
		}
		if (password.length < 4 || password.length > 12) {
			alert("密码长度4-12位");
			return false;
		}
		return true;
	}
	function createXmlHttpRequest() {
		if (window.ActiveXObject) { //如果是IE浏览器
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) { //非IE浏览器
			return new XMLHttpRequest();
		}
	}
	function login() {
		if (!checkName() ||!checkPassword()) {
			return false;
		} 
		var url = "${pageContext.request.contextPath}/login/login";
		var xmlhttp = createXmlHttpRequest();
		xmlhttp.open("post", url, true);
		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlhttp.send("userName=" + document.getElementById("text1").value +
			"&password=" + document.getElementById("text2").value);
		xmlhttp.onreadystatechange = function() {
			if (this.status == 200 && this.readyState == 4) {
 				if(this.responseText.trim()==""){
 					alert("用户输入的用户名不存在或用户输入密码与用户名不匹配");
 				}else{
 					alert("登录成功！");
//  					登录页面跳转的还没做
					window.location.href='${pageContext.request.contextPath}/notice/jumpNoticeList';
 				}
			}
		}
	}
</script>
</head>
<body>
	<!-- 登录页面头部 -->
	<div class="logHead">
		<img src="${pageContext.request.contextPath}/img/login/logLOGO.png" />
	</div>
	<!-- 登录页面头部结束 -->

	<!-- 登录body -->
	<div class="logDiv">
		<img class="logBanner"
			src="${pageContext.request.contextPath}/img/login/logBanner.png" />
		<div class="logGet">
			<!-- 头部提示信息 -->
			<div class="logD logDtip">
				<p class="p1">登录</p>
				<a href="${pageContext.request.contextPath}/login/jumpForgetPassword1">
					<p class="p2">忘记密码</p></a> 
				<a href="${pageContext.request.contextPath}/login/jumpRegisterPage">
					<p class="p2">注册&nbsp;&nbsp;</p></a>
			</div>
			<!-- 输入框 -->
			<form name="form1" >
				<div class="lgD">
					<img class="img1"
						src="${pageContext.request.contextPath}/img/login/logName.png" /><input
						id="text1" type="text" name="userName" placeholder="输入用户名"
						value="${userName}" />
					<div id="div1" style="display:inline"></div>
				</div>
				<div class="lgD">
					<img class="img1"
						src="${pageContext.request.contextPath}/img/login/logPwd.png" /><input
						id="text2" type="password" name="password" placeholder="输入用户密码" />
					<div id="div2" style="display:inline"></div>
				</div>
				<div class="logC">
					<button type="button" onclick="login()">登 录</button>
				</div>
			</form>
		</div>
	</div>
	<!-- 登录body  end -->

<!-- 	登录页面底部 -->
		<div class="logFoot">
			<p class="p1">版权所有：</p>
			<p class="p2">网络应急化学习平台</p>
		</div>
	
	<!-- 登录页面底部end -->
</body>
</html>