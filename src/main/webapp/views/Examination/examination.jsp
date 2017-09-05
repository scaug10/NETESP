<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>试题管理</title>
<link rel="stylesheet" type="text/css" href="../css/css.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="js/page.js" ></script> -->
<style>
/*页码样式*/
.pageButton {
	margin: 10px 5px;
	padding: 5px;
	float: right;
	border: 1px solid lightgrey;
	display: inline-block;
}
/*页码超链接样式*/
.pageButton>a {
	padding: 0px;
	display: inline-block;
}
/*页码输入框*/
.inputPage {
	height: 15px;
	width: 20px;
}

/*超链接样式*/
.pageButton>a:visited {
	color: black;
}
/*超链接字体颜色*/
.pageButton>a {
	color: black;
}

/*解决高度塌陷*/
.clearfix:after {
	content: "";
	display: block;
	clear: both;
}
/*增加的按钮样式*/
.button1 {
	margin-left: 10px;
	width: 135px;
	height: 40px;
	border: none;
	font-size: 16px;
	color: #fff;
	background-color: #47a4e1;
}
/*搜索框右浮动*/
.seek {
	float: right;
	display: inline-block;
}
/*搜索内容位置*/
span.seek {
	padding: 10px;
}
/*搜索输入框位置*/
input.seek {
	margin: 10px;
}

a:visited {
	color: black;
}
</style>
<!--全选-->
</head>
<script type="text/javascript">
	function createXmlHttpRequest() {
		if (window.ActiveXObject) { //如果是IE浏览器
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) { //非IE浏览器
			return new XMLHttpRequest();
		}
	}

	function selectAllCheckBox(isChecked) {
		var checkBox = document.getElementsByClassName("checkbox");
		for (var i = 0; i < checkBox.length; i++) {
			checkBox[i].checked = isChecked;
		}
	}

	function add() {
		var name = prompt("请输入试卷名称:");
		if (name.length != 0) {
			var xhr = createXmlHttpRequest();
			var url = "saveExam";
			xhr.open("post", url, true);
			xhr.setRequestHeader('Content-Type',
					'application/x-www-form-urlencoded');
			xhr.send("name=" + name);
			xhr.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var result = this.responseText;
					if (result == 1) {
						alert("新增试卷成功！");
					} else if (result == 2) {
						alert("试卷名字已存在！");
					} else {
						alert("未知原因导致新建试卷失败！")
					}
					location.reload();
				}
			}
		}
	}

	function del() {
		var sendArray = new Array();
		var examArray = document.getElementsByClassName("checkbox");
		for (var i = 0; i < examArray.length; i++) {
			if (examArray[i].checked) {
				sendArray.push(examArray[i].id);
			}
		}
		if (confirm("是否删除这" + sendArray.length + "个试卷？")) {
			var xhr = createXmlHttpRequest();
			var url = "${pageContext.request.contextPath}/exam/delete";
			xhr.open("post", url, true);
			xhr.setRequestHeader('Content-Type',
					'application/x-www-form-urlencoded');
			xhr.send("examId=" + sendArray);
			xhr.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var result = this.responseText;
					if (result > 0) {
						alert("删除试卷成功!");
						location.reload();
					} else {
						alert("删除试卷失败!");
					}
				}
			}
		}
	}

	function search() {
		var name = document.getElementById("name").value;
		var url = "queryExam?name=" + name;
		window.location.href = url;
	}
</script>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="../img/coin02.png" /><span><a href="../main.html">首页</a>&nbsp;-&nbsp;</span><a
					href="getAllExam">试题管理</a>
			</div>
		</div>

		<div class="page">
			<!-- 页面样式 -->
			<div class="connoisseur">
				<!--搜索框-->
				<div class="conform">
					<div class="cfD clearfix">
						<button class="userbtn" onclick="add()">增加</button>
						<button class="userbtn btn_ok btn_yes operation delban"
							onclick="del()">删除</button>
						<button class="button1 seek" onclick="search()">查询</button>
						<input type="text" class="seek" id="name" value=""> <span
							class="seek">试卷名称：</span>

					</div>
				</div>

				<!--  表格 显示 -->
				<div class="conShow">
					<table>
						<tr>
							<td width="80px" class="tdColor"><input type="checkbox"
								name="id" onclick="selectAllCheckBox(this.checked)">全选</td>
							<td width="80px" class="tdColor">ID</td>
							<td width="435px" class="tdColor">试卷名称</td>
							<!-- <td width="435px" class="tdColor">策略名称</td>
							<td width="435px" class="tdColor">时间</td> -->

						</tr>
						<c:forEach items="${list }" var="list">
							<tr height="40px">
								<td><input type="checkbox" class="checkbox" name="id"
									id="${list.examId }" value="${list.examId }"></td>
								<td>${list.examId }</td>
								<td>${list.name }</td>

							</tr>
						</c:forEach>
						<!-- 	<script>
							for (var i = 0; i < 20; i++) {
								var id = i + 1;
								var examinationName = "英语4级";
								var strategyName = "4级";
								var time = "2017-8-8 11:44:45";
								document
										.write("<tr height=\"40px\">\n"
												+ "<td><input type=\"checkbox\" name=\"id\" value=\" + id + \"></td>\n"
												+ "<td>"
												+ id
												+ "</td>\n"
												+ "<td><a href=\"ExaminationPreview.html\">"
												+ examinationName + "</a></td>"
												+ "<td>" + strategyName
												+ "</td>\n" + "<td>" + time
												+ "</td>\n" + "</tr>\n");
							}
						</script>
 -->
					</table>
					<!-- <script type="text/javascript">
						/*页数填充*/
						var totalPostNumber = 1001;/*该模块包含的总内容数量数*/
						var postsPerPage = 20;/*每页包含的内容数量*/
						var currentPage = 1;/*当前页*/

						document
								.write("<span class=\"pageButton\"><a href=\"#\">下一页</a></span>\n"
										+ "    <span class=\"pageButton\"><a href=\"#\">..."
										+ Math.ceil(totalPostNumber
												/ postsPerPage)
										+ "</a></span>\n"
										+ "    <span class=\"pageButton\"><input class=\"inputPage\" value=\" " + currentPage + " \" type=\"text\">/页</span>\n"
										+ "    <span class=\"pageButton\"><a href=\"#\">1</a></span>\n"
										+ "    <span class=\"pageButton\"><a href=\"#\">上一页</a></span>");
					</script> -->

					<div class="paging"></div>
				</div>
				<!--  表格 显示 end-->
			</div>
			<!-- 页面样式end -->
		</div>

	</div>


	<!-- 删除弹出框 -->
	<!-- <div class="banDel">
		<div class="delete">
			<div class="close">
				<a><img src="../img/shanchu.png" /></a>
			</div>
			<p class="delP1">你确定要删除此条记录吗？</p>
			<p class="delP2">
				<a href="#" class="ok yes">确定</a><a class="ok no">取消</a>
			</p>
		</div>
	</div> -->
	<!-- 删除弹出框  end-->
</body>

<script type="text/javascript">
	// 广告弹出框

	/* $(".delban").click(function() {
		$(".banDel").show();
	});
	$(".close").click(function() {
		$(".banDel").hide();
	});
	$(".no").click(function() {
		$(".banDel").hide();
	}); */
	// 广告弹出框 end
</script>
</html>