<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE>
<html>
	<head>
		<meta charset="UTF-8">
		<title>忘记密码</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login/reset.css"/>
			<style>
				<!-- 头部样式 -->
				.header{
					width: 100%;
					height: 60px;
					background-color: #00FF00;
				}
				.header .header1{
					width: 1127px;
					height: 60px;
					margin: 0 auto 0;
					/*background-color: #0061DE;*/
				}
				.header .header1 .leftblock{
					width: 263.72px;
					height: 60px;
					/*background-color: #313131;*/
				}
				h1{
					float: right;
					padding: 20px 0 0;
					border-left-style: solid;
				}
				h2{
					float: right;
					padding: 20px 0 0;
				}
				<!-- 栏目样式 -->
				.box{
					width: 100%;
					background-color: #000099;
				}
				.section{
					width: 100%;
					height: 51px;
					/*background-color: #003300;*/
				}
				.section_subnav{
					width: 45%;
					height: 51px;
					margin: 0 auto 0;
					/*background-color: #036CB4;*/ 
				}
				.section_process{
					width: 946.4px;
					height: 34px;
					padding-top: 17px;
					/*background-color: #0066A7;*/
				}
				.action{
					width: 276px;
					height: 34px;
					float: left;
					/*background-color: #99210B;*/
				}
				.action2{
					width: 28px;
					height: 28px;
					float: left;
				}
				#div1{
					width: 56px;
					height: 34px;
					/*background-color: #303030;*/
				}
				#div2{
					width: 28px;
					height: 28px;
					border-radius: 15px;
					background-color:  #0080FF;
					margin-left: 14px;
					text-align: center;
					line-height: 28px;
				}
				#div22{
					width: 28px;
					height: 28px;
					border-radius: 15px;
					background-color:  #D6D6D6;
					margin-left: 14px;
					text-align: center;
					line-height: 28px;
				}
				p{
					font-size: 14px;
				}
				#div3{
				    margin-top: 14px;
					width: 220px;
					height: 2px;
					background: linear-gradient(to right, blue , white);
					float: right;
				}
				#div33{
				    margin-top: 14px;
					width: 220px;
					height: 2px;
					background-color:  #D6D6D6;
					float: right;
				}
				<!-- 内容样式 -->
				.section_main{
					width: 100%;
					height:216px;
					background-color: #0061DE;
				}
				#container.section_main{
					width: 1000px;
					height:216px;
					margin: 0 auto 0;
					/*background-color: #313031;*/
				}
				.main_form{
					width: 262px;
					height: 216px;
					margin: 50px auto 0;
					/*background-color: #00FF00;*/
						   }
			    .mod-name-form{
			    	width: 262px;
			    	height: 68;
			    	margin-bottom: 15px;
			    	/*background-color: #0080FF;*/
			    }
			    .mod-btn-green{
			    	background-color: #00FF00;
			    	color: #000000;
			        box-shadow: 0 3px 0 #4CAF50;
			        border-radius: 2px;
			        cursor: pointer;
			        display: inline-block;
			        box-sizing: border-box;
			        transition: color .2s,background-color .2s;
			    }
                span{
                	display: inline-block;
                	width: 70px;
                	height: 37px;
                	line-height: 37px;
                	padding-left: 30px;
                }
                #fin{
                	padding-top: 40px;
                	padding-left: 95px;
                }
                <!-- 底部样式 -->
                .footer {
    				position:absolute;
    				top: 100%;
    				margin-top: -90px;
    				left: 0;
    				width: 100%;
    				background-color: #D6D6D6;
				}
				.footer .div{
					width: 450px;
					height: 90px;
					margin: 0 auto;
					padding-top: 15px;
					box-sizing: border-box;
					/*background-color: #000000;*/
				}
				.footer .about{
					width: 450px;
					height: 46.4px;
				}
				.footer .about_link{
					width: 450px;
					height: 32px;
					text-align: center;
					line-height: 32px;
				}
			</style>
	</head>
	<body>
		<div class="header">
			<div class="header1">
				<a href="${pageContext.request.contextPath}/login/jumpLoginPage"><h2>登录</h2></a>
				<div class="leftblock">
					<h1>忘记密码</h1>
					<img src="" width="176.72" height="60"/>
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
						<div id=div33></div>
						<div id=div1>
							<div id=div22>2</div>
							<p>身份验证</p>
						</div>
					</li>
					<li class="action2">
						<div id=div1>
							<div id=div2>3</div>
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
				    <!--
                    	<form id="input_account_form">
						<div class="mod-name-form">
							<label style="font-size: 14px;line-height: 32px;">新密码：</label>
							<div>
								<input name="userName" style="width: 264px;height: 36px;" type="password" />
							</div>
						</div>
						<div class="mod-name-form">
							<label style="font-size: 14px;line-height: 32px;">重新输入新密码：</label>
							<div>
								<input name="userName" style="width: 264px;height: 36px;" type="password" />
							</div>
						</div>
						<a class="mod-btn-green" href="###"><span>确定</span></a>
					</form>
                    -->
                    <div style="text-align: center;color: blue;">原密码已发送到您的邮箱，建议您登陆后尽快修改用户密码。点击以下按钮进入登录页面</div>
                    <div id="fin">
                    	<a class="mod-btn-green" href="${pageContext.request.contextPath}/login/jumpLoginPage"><span>登录</span></a>
                    </div>
				</div>
			</div>
		</div>
		<div class="footer" style="position:absolute;
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
