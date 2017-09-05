<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>忘记密码</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login/reset.css" />
<style>
<!--
头部样式 -->.header {
	width: 100%;
	height: 60px;
	background-color: #00FF00;
}

.header .header1 {
	width: 1127px;
	height: 60px;
	margin: 0 auto 0;
	/*background-color: #0061DE;*/
}

.header .header1 .leftblock {
	width: 263.72px;
	height: 60px;
	/*background-color: #313131;*/
}

h1 {
	float: right;
	padding: 20px 0 0;
	border-left-style: solid;
}

h2 {
	float: right;
	padding: 20px 0 0;
}

<!--
栏目样式 -->.box {
	width: 100%;
	background-color: #000099;
}

.section {
	width: 100%;
	height: 51px;
	/*background-color: #003300;*/
}

.section_subnav {
	width: 45%;
	height: 51px;
	margin: 0 auto 0;
	/*background-color: #036CB4;*/
}

.section_process {
	width: 946.4px;
	height: 34px;
	padding-top: 17px;
	/*background-color: #0066A7;*/
}

.action {
	width: 276px;
	height: 34px;
	float: left;
	/*background-color: #99210B;*/
}

.action2 {
	width: 28px;
	height: 28px;
	float: left;
}

#div1 {
	width: 56px;
	height: 34px;
	/*background-color: #303030;*/
}

#div2 {
	width: 28px;
	height: 28px;
	border-radius: 15px;
	background-color: #0080FF;
	margin-left: 14px;
	text-align: center;
	line-height: 28px;
}

#div22 {
	width: 28px;
	height: 28px;
	border-radius: 15px;
	background-color: #D6D6D6;
	margin-left: 14px;
	text-align: center;
	line-height: 28px;
}

p {
	font-size: 14px;
}

#div3 {
	margin-top: 14px;
	width: 220px;
	height: 2px;
	background: linear-gradient(to right, blue, white);
	float: right;
}

#div33 {
	margin-top: 14px;
	width: 220px;
	height: 2px;
	background-color: #D6D6D6;
	float: right;
}

<!--
内容样式 -->.section_main {
	width: 100%;
	height: 216px;
	background-color: #0061DE;
}

#container.section_main {
	width: 1000px;
	height: 216px;
	margin: 0 auto 0;
	/*background-color: #313031;*/
}

.main_form {
	width: 262px;
	height: 216px;
	margin: 50px auto 0;
	/*background-color: #00FF00;*/
}

.mod-name-form {
	width: 262px;
	height: 68;
	margin-bottom: 15px;
	/*background-color: #0080FF;*/
}

.mod-btn-green {
	background-color: #00FF00;
	color: #000000;
	box-shadow: 0 3px 0 #4CAF50;
	border-radius: 2px;
	cursor: pointer;
	display: inline-block;
	box-sizing: border-box;
	transition: color .2s, background-color .2s;
}

span {
	display: inline-block;
	width: 70px;
	height: 37px;
	line-height: 37px;
	padding-left: 30px;
}

<!--
底部样式 -->.footer {
	position: absolute;
	top: 100%;
	margin-top: -90px;
	left: 0;
	width: 100%;
	background-color: #D6D6D6;
}

.footer .div {
	width: 450px;
	height: 90px;
	margin: 0 auto;
	padding-top: 15px;
	box-sizing: border-box;
	/*background-color: #000000;*/
}

.footer .about {
	width: 450px;
	height: 46.4px;
}

.footer .about_link {
	width: 450px;
	height: 32px;
	text-align: center;
	line-height: 32px;
}
</style>
<script>
	function checkVerificationCode() {
		var div = document.getElementById("div4");
		div.innerHTML = "";
		var name1 = document.getElementById("verificationCode").value;
		if (name1.trim() == "") {
			div.innerHTML = "验证码不能为空！";
			// 			document.input_account_form.verificationCode.focus();
			return false;
		}
		if (name1.length != 6) {
			div.innerHTML = "验证码的长度为6个字符！";
			// 			document.input_account_form.verificationCode.select();
			return false;
		}
		var charname1 = name1.toLowerCase();
		for (var i = 0; i < name1.length; i++) {
			var charname = charname1.charAt(i);
			if (!(charname >= 0 && charname <= 9) && (!(charname >= 'a' && charname <= 'z'))) {
				div.innerHTML = "验证码包含非法字母，只能包含字母和数字";
				// 				document.input_account_form.verificationCode.select();
				return false;
			}
		}
		return true;
	}
	function getQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null) return unescape(r[2]);
		return null;
	}
	
	function createXmlHttpRequest() {
		if (window.ActiveXObject) { //如果是IE浏览器
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) { //非IE浏览器
			return new XMLHttpRequest();
		}
	}
	function sendPassword() {
		if (!checkVerificationCode()) {
			return false;
		}
		var userName =""+getQueryString("userName");
		if (userName.trim() == "") {
			alert("你好，你还没有验证你的用户名和邮箱，请回到忘记密码第一步！");
			window.location.href = '${pageContext.request.contextPath}/login/jumpForgetPassword1';
		}
		var url = "${pageContext.request.contextPath}/login/sendOriginPassword";
		var xmlhttp = createXmlHttpRequest();
		xmlhttp.open("post", url, true);
		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlhttp.send("verificationCode=" + document.getElementById("verificationCode").value+
						"&userName="+userName);
		xmlhttp.onreadystatechange = function() {
			if (this.status == 200 && this.readyState == 4) {
				if (this.responseText.trim() == "") {
					alert("用户名不存在或用户输入的验证码与数据库的验证码不一致");
				} else {
					alert("验证成功！");
					window.location.href = '${pageContext.request.contextPath}/login/jumpForgetPassword3';
				}
			}
		}
	}
</script>
</head>

<body>
	<div class="header">
		<div class="header1">
			<a href="${pageContext.request.contextPath}/login/jumpLoginPage"><h2>登录</h2></a>
			<div class="leftblock">
				<h1>忘记密码</h1>
				<img src="" width="176.72" height="60" />
			</div>
		</div>
	</div>
	<div class="box" style="height: 80px;background-color: #EEEEEE;">
		<div class="section">
			<div class="section_subnav">
				<ul class="section_process">
					<li class="action">
						<div id=div33></div>
						<div id=div1>
							<div id=div22>1</div>
							<p>填写账号</p>
						</div>
					</li>
					<li class="action">
						<div id=div3></div>
						<div id=div1>
							<div id=div2>2</div>
							<p>身份验证</p>
						</div>
					</li>
					<li class="action2">
						<div id=div1>
							<div id=div22>3</div>
							<p style="text-align: center;">完成</p>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class=" section_main">
		<div id="container" class="section_main">
			<div class="main_form">
				<form id="input_account_form">
					<div class="mod-name-form">
						<label style="font-size: 14px;line-height: 32px;">验证码：</label>
						<div>
							<input id="verificationCode" name="verificationCode"
								style="width: 264px;height: 36px;" placeholder="请填写已发送到邮箱中的验证码"
								type="text" value="${verificationCode}" />
							<div id="div4" style="display:inline"></div>
						</div>
					</div>
					<br> <br>
					<button class="mod-btn-green" onclick="sendPassword()"
						type="button">
						<span>确定</span>
					</button>
				</form>
			</div>
		</div>
	</div>
	<div class="footer"
		style="position:absolute;
    				top: 100%;
    				margin-top: -90px;
    				left: 0;
    				width: 100%;
    				background-color: #D6D6D6;">
		<div class="div">
			<div class="about">
				<p class="about_link">
					<a>关于我们</a>
				</p>
				<p style="text-align: center;">网络应急化学习平台</p>
			</div>
		</div>
	</div>
</body>

</html>