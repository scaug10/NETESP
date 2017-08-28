<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>登录</title>
		<link rel="stylesheet" type="text/css" href="../css/public.css" />
		<link rel="stylesheet" type="text/css" href="../css/page.css" />
		<script type="text/javascript" src="../js/jquery.min.js"></script>
		<script type="text/javascript" src="../js/public.js"></script>
	</head>

	<body>

		<!-- 登录页面头部 -->
		<div class="logHead">
			<img src="../img/logLOGO.png" />
		</div>
		<!-- 登录页面头部结束 -->

		<!-- 登录body -->
		<div class="logDiv">
			<img class="logBanner" src="../img/logBanner.png" />
			<div class="logGet">
				<!-- 头部提示信息 -->
				<div class="logD logDtip">
					<p class="p1">登录</p>
					<a href="ResetPassword1.html">
						<p class="p2">忘记密码</p>
					</a>
					<a href="sign.html">
						<p class="p2">注册&nbsp;&nbsp;</p>
					</a>
				</div>
				<!-- 输入框 -->
				<div class="lgD">
					<img class="img1" src="../img/logName.png" /><input type="text" name="userName" placeholder="输入用户名" />
				</div>
				<div class="lgD">
					<img class="img1" src="../img/logPwd.png" /><input type="password" name="password" placeholder="输入用户密码" />
				</div>
				<div class="lgD logD2">
					<input class="getYZM" type="text" />
					<div class="logYZM">
						<img class="yzm" src="../img/logYZM.png" />
					</div>
				</div>
				<div class="logC">
					<button onclick="javascript:window.location.href='index2.html'" type="submit">登 录</button>
				</div>
			</div>
		</div>
		<!-- 登录body  end -->

		<!-- 登录页面底部 -->
		<div class="logFoot">
			<p class="p1">版权所有：</p>
			<p class="p2">123</p>
		</div>
		<!-- 登录页面底部end -->
	</body>

</html>