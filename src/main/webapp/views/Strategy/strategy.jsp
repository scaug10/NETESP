<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>策略管理</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/css.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
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
/*下拉列表位置*/
select.seek {
	margin: 5px;
	color: black;
}
</style>
<!--全选-->
<script type="text/javascript">
	function createXmlHttpRequest() {
		if (window.ActiveXObject) { //如果是IE浏览器
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) { //非IE浏览器
			return new XMLHttpRequest();
		}
	}

	function changeState(isChecked) {
		var chk_list = document.getElementsByTagName("input");
		for (var i = 0; i < chk_list.length; i++) {
			if (chk_list[i].type == "checkbox") {
				chk_list[i].checked = isChecked;
			}
		}
	}

	function showStatus() {
		var tds = document.getElementsByClassName('status');
		for (var i = 0; i < tds.length; i++) {
			var td = tds[i];
			var status = td.innerHTML;
			if (status == "false") {
				td.innerHTML = "不可用";
			} else if (status == "true") {
				td.innerHTML = "可用";
			}
		}
	}

	function modify(strategyId) {
		var url = "queryTestItemsDesignByStrategyId?strategyId=" + strategyId;
		window.location.href = url;
	}

	function search() {
		var strategyName = document.getElementById("strategyName").value;
		var status = document.getElementById("status").value;
		url = "queryStrategy?strategyName=" + strategyName + "&status="
				+ status;
		window.location.href = url;
	}

	function del() {
		var sendArray = new Array();
		var strategyArray = document.getElementsByClassName("checkbox");
		for (var i = 0; i < strategyArray.length; i++) {
			if (strategyArray[i].checked) {
				sendArray.push(strategyArray[i].id);
			}
		}
		if (confirm("是否删除这" + sendArray.length + "个策略？")) {
			var xhr = createXmlHttpRequest();
			var url = "deleteStrategy";
			xhr.open("post", url, true);
			xhr.setRequestHeader('Content-Type',
					'application/x-www-form-urlencoded');
			xhr.send("strategyId=" + sendArray);
			xhr.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var result = this.responseText;
					if (result > 0) {
						alert("删除策略成功!");
					} else {
						alert("删除策略失败!");
					}
					location.reload();
				}
			}
		}
	}
</script>
</head>

<body onload="showStatus()">
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="${pageContext.request.contextPath}/views/img/coin02.png" /><span><a
					href="${pageContext.request.contextPath}/index">首页</a>&nbsp;-&nbsp;</span><a href="getAllStrategy">策略管理</a>
			</div>
		</div>

		<div class="page">
			<!-- 页面样式 -->
			<div class="connoisseur">
				<!--搜索框-->
				<div class="conform">
					<div class="cfD clearfix">
						<button class="userbtn"
							onclick="javascrtpt:window.location.href='addStrategy'">增加</button>
						<button class="userbtn btn_ok btn_yes operation delban"
							onclick="del()">删除</button>
						<button class="button1 seek" onclick="search()">查询</button>
						<select id="status" class="seek ">
							<option value="2">全部</option>
							<option value="1">可用</option>
							<option value="0">不可用</option>
						</select> <span class="seek">策略状态：</span> <input type="text" class="seek"
							id="strategyName" value=""> <span class="seek">策略名称：</span>

					</div>
				</div>

				<!--  表格 显示 -->
				<div class="conShow">
					<table>
						<tr>
							<td width="80px" class="tdColor"><input type="checkbox"
								name="id" onclick="changeState(this.checked)">全选</td>
							<td width="80px" class="tdColor">ID</td>
							<td width="435px" class="tdColor">策略名称</td>
							<td width="90px" class="tdColor">用途</td>
							<td width="90px" class="tdColor">策略总分</td>
							<td width="90px" class="tdColor">及格分数</td>
							<td width="90px" class="tdColor">创建者</td>
							<!-- <td width="90px" class="tdColor">单位</td> -->
							<td width="240px" class="tdColor">时间</td>
							<td width="90px" class="tdColor">状态</td>
							<td width="90px" class="tdColor">操作</td>
						</tr>
						<c:forEach items="${list }" var="list">
							<tr>
								<td><input type="checkbox" id="${list.strategyId }"
									class="checkbox"></td>
								<td>${list.strategyId }</td>
								<td>${list.strategyName }</td>
								<td>${list.purpose }</td>
								<td>${list.fullScore }</td>
								<td>${list.passScore }</td>
								<td>${list.createrId }</td>
								<td><fmt:formatDate value="${list.createTime }"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td class="status">${list.status }</td>
								<td><a title="修改" href=javaScript:void(0)
									onclick="modify('${list.strategyId }')"><img
										src='${pageContext.request.contextPath}/views/img/update.png'></a></td>
							</tr>
						</c:forEach>
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
</body>
</html>