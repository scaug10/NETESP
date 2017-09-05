<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login/reset.css" />
<title>注册界面</title>
<style>
/*头部与内容分隔页*/
.link {
	height: 3px;
	background-color: #00FF00;
}
/*文本框样式*/
.text {
	width: 86%;
	margin: 0px auto;
	position: relative;
	margin-bottom: 20px;
}

.box {
	width: 468px;
	height: 500px;
	background-color: white;
	position: absolute;
	top: 2px;
	right: 448px;
}

input {
	width: 100%;
	height: 42px;
	text-indent: 2.5rem;
}

.top {
	width: 88%;
	border-bottom: 1px solid #ee7700;
	margin: 0px auto;
	margin-bottom: 20px
}
/*图片样式*/
.img1 {
	position: absolute;
	top: 12px;
	left: 15px;
}
/*注册*/
.sign {
	width: 86%;
	margin: 0px auto;
	margin-top: 30px;
}

.sign button {
	width: 100%;
	height: 45px;
	background-color: #00CC66;
	border: none;
	color: white;
	font-size: 18px;
}
/*注册背景*/
.sign2 {
	width: 100%;
	position: relative;
	z-index: 0;
}

.sign2 img.banner {
	width: 100%;
	overflow: hidden;
}

.p1 {
	display: inline-block;
	font-size: 28px;
	margin-top: 30px;
}

.p2 {
	display: inline-block;
	font-size: 14px;
	margin-top: 45px;
	float: right;
	color: #ee7700;
}

.selet11 {
	margin-left: 35px;
	width: 200px;
	height: 20px;
	margin-bottom: 20px;
}
</style>
<script language="JavaScript">
	function checkName() {
		var div = document.getElementById("div1");
		div.innerHTML = "";
		var name1 = document.form1.text1.value;
		if (name1.trim() == "") {
			div.innerHTML = "账号不能为空！";
			document.form1.text1.focus();
			return false;
		}
		if (name1.length < 4 || name1.length > 16) {
			div.innerHTML = "账号输入的长度4-16个字符！";
			document.form1.text1.select();
			return false;
		}
		var charname1 = name1.toLowerCase();
		for (var i = 0; i < name1.length; i++) {
			var charname = charname1.charAt(i);
			if (!(charname >= 0 && charname <= 9) && (!(charname >= 'a' && charname <= 'z')) && (charname != '_')) {
				div.innerHTML = "账号包含非法字母，只能包含字母，数字，和下划线";
				document.form1.text1.select();
				return false;
			}
		}
		return true;

	}

	function checkPassword() {
		var div = document.getElementById("div2");
		div.innerHTML = "";
		var password = document.form1.text2.value;
		if (password.trim() == "") {
			div.innerHTML = "密码不为空！";
			document.form1.text2.focus();
			return false;
		}
		if (password.length < 4 || password.length > 12) {
			div.innerHTML = "密码长度4-12位";
			document.form1.text2.select();
			return false;
		}
		return true;
	}

	function checkRepassword() {
		var div = document.getElementById("div3");
		div.innerHTML = "";
		var password = document.form1.text2.value;
		var repass = document.form1.text3.value;
		if (repass.trim() == "") {
			div.innerHTML = "密码不为空！";
			document.form1.text3.focus();
			return false;
		}
		if (password != repass) {
			div.innerHTML = "输入密码和确认密码不一致";
			document.form1.text3.select();
			return false;
		}
		return true;
	}

	function checkEmail() {
		var div = document.getElementById("div4");
		div.innerHTML = "";
		var email = document.form1.text5.value;
		var sw = email.indexOf("@", 0);
		var sw1 = email.indexOf(".", 0);
		var tt = sw1 - sw;
		if (email.trim().length == 0) {
			div.innerHTML = "电子邮件不能为空";
			document.form1.text5.focus();
			return false;
		}
		if (email.indexOf("@", 0) == -1) {
			div.innerHTML = "电子邮件格式不正确，必须包含@符号！";
			document.form1.text5.select();
			return false;
		}
		if (email.indexOf(".", 0) == -1) {
			div.innerHTML = "电子邮件格式不正确，必须包含.符号!";
			document.form1.text5.select();
			return false;
		}
		if (tt == 1) {
			div.innerHTML = "邮件格式不对。@和.不可以挨着！";
			document.form1.text5.select();
			return false;
		}
		if (sw > sw1) {
			div.innerHTML = "电子邮件格式不正确，@符号必须在.之前";
			document.form1.text5.select();
			return false;
		} else {
			return true;
		}

		return ture;
	}
	
	function createXmlHttpRequest() {
		if (window.ActiveXObject) { //如果是IE浏览器
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) { //非IE浏览器
			return new XMLHttpRequest();
		}
	}
	function register() {
		if (!checkName() ||!checkPassword()||!checkRepassword()||!checkEmail()) {
			return false;
		} 
		var url = "${pageContext.request.contextPath}/login/register";
		var xmlhttp = createXmlHttpRequest();
		xmlhttp.open("post", url, true);
		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlhttp.send("userName=" + document.getElementById("text1").value +
			"&departmentId="+document.getElementById("departmentId").value+
			"&password="+document.getElementById("text2").value+
			"&email=" + document.getElementById("text5").value+
			"&job="+document.getElementById("text6").value);
		xmlhttp.onreadystatechange = function() {
			if (this.status == 200 && this.readyState == 4) {
 				if(this.responseText.trim()==""){
 					alert("用户输入的用户名已存在，注册失败,请重新注册！");
 				}else{
 					alert("注册成功，进入登录页面！");
 					window.location.href='${pageContext.request.contextPath}/login/jumpLoginPage';
 				}
			}
		}
	}
</script>
</head>

<body>
	<div>
		<img name=""
			src="${pageContext.request.contextPath}/img/index/logo.jpg"
			width="150" height="70" alt="" />用户注册
	</div>
	<div class="link"></div>
	<div class="sign2">
		<!-- <img class="banner" src="img/logBanner.png" />-->
		<div class="box">
			<div class="top">
				<p class="p1">注册</p>
				<p class="p2">123</p>
			</div>
			<form name="form1" 
				onsubmit="check()">
				<div class="text">
					<img class="img1"
						src="${pageContext.request.contextPath}/img/login/logName.png" />
					<input id="text1" name="userName" type="text" maxlength="20"
						placeholder="请输入用户昵称" value="${user.userName}"/>
					<div id="div1" style="display:inline"></div>
				</div>

				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择用户单位： 
				<select id="departmentId" name="departmentId" class="selet11">
					<c:forEach items="${departments}" var="department">
						<option value="${department.key}">${department.value}</option>
					</c:forEach>
				</select>

				<div class="text">
					<img class="img1"
						src="${pageContext.request.contextPath}/img/login/logPwd.png" />
					<input id="text2" name="password" type="password" maxlength="20"
						placeholder="请输入用户密码" />
					<div id="div2" style="display:inline"></div>
				</div>

				<div class="text">
					<img class="img1"
						src="${pageContext.request.contextPath}/img/login/logPwd.png" />
					<input id="text3" name="password2" type="password" maxlength="20"
						placeholder="请再次输入用户密码" />
					<div id="div3" style="display:inline"></div>
				</div>

				<div class="text">
					<img class="img1"
						src="${pageContext.request.contextPath}/img/login/coin22.png" />
					<input id="text5" name="email" type="email" maxlength="20"
						placeholder="请输入邮箱地址" value="${user.email}"/>
					<div id="div4" style="display:inline"></div>
				</div>

				<div class="text">
					<img class="img1"
						src="${pageContext.request.contextPath}/img/login/logJob.png" />
					<input id="text6" name="job" type="text" maxlength="20"
						placeholder="请输入工作岗位" value="${user.job}"/>
					<div id="div6" style="display:inline"></div>
				</div>

				<div class="sign">
					<button type="button" onclick="register()">注 册</button>
				</div>		
			</form>
		</div>
	</div>
</body>
</html>
