<%@page
	import="com.g10.ssm.po.testdatabase.ClassificationOfTestdatabase"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加策略</title>
<link rel="stylesheet" type="text/css" href="../css/css.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/Strategy.js"></script>

<style type="text/css">
/*考试试题分类栏样式*/
.white_content {
	display: none;
	position: absolute;
	top: 25%;
	left: 25%;
	width: 50%;
	height: 50%;
	padding: 16px;
	border: 16px solid gainsboro;
	margin: -32px;
	background-color: white;
	z-index: 1002;
	overflow: auto;
}

/*考试试题分类栏按钮样式*/
.box1 {
	margin: 10px;
	width: 135px;
	height: 40px;
	border: none;
	font-size: 16px;
	color: #fff;
	background-color: #47a4e1;
}

/*表格内容左对齐*/
.left {
	text-align: left;
}
/*输入栏样式*/
.StrategyInput {
	width: 25%;
	margin-left: 10px;
}
/*试题分类输入栏样式*/
.StrategyInput1 {
	width: 50%;
	margin-left: 10px;
}
/*用途下拉列表样式*/
.StrategySelect {
	width: 25%;
	margin-left: 10px;
}
/*试题分类选择框行高*/
#tr1 {
	height: 200px;
}
/*题分类选择框样式*/
.select1 {
	display: inline-block;
	width: 80%;
	overflow: auto;
	height: auto;
}
/*试题类型输入框样式*/
input {
	width: 50%;
}

.div1 {
	margin-top: 20px;
	margin-bottom: 20px;
}

.close {
	padding-bottom: 5px;
	background-color: lightgrey;
}

.delete {
	height: 335px;
}

.table {
	height: 300px;
	overflow: auto;
}

#delP1 {
	margin: 5px auto;
	overflow: auto;
}

.ok1 {
	display: inline-block;
	width: 100px;
	height: 40px;
	line-height: 40px;
	background-color: #3695cc;
	color: #fff;
	margin-top: 10px;
	margin-left: 25px;
	margin-right: 25px;
	font-size: 16px;
	cursor: pointer;
	margin-bottom: 10px;
}

input:disabled {
	border: 1px solid #a9a9a9;
	background-color: white;
	color: #ACA899;
	padding: 1px;
}
</style>
</head>
<script>
	function add() {
		var strategy = 0;
		var createrId = "test";
		var strategyName = document.getElementById("strategyName").value;
		var fullScore = document.getElementById("fullScore").value;
		var passScore = document.getElementById("passScore").value;
		var strategyPurpose = document.getElementById("strategyPurpose").value;
		/*获取对应Class的值*/
		var TestDatabaseId = document.getElementsByClassName("testDatabaseId");
		var testDatabaseId = new Array();
		for (var i = 0; i < TestDatabaseId.length; i++) {
			testDatabaseId[i] = TestDatabaseId[i].innerText;
		}

		var lower_difficulty = document
				.getElementsByClassName("lower_difficulty");
		var lowerlimitDifficultyId = new Array();
		for (var i = 0; i < lower_difficulty.length; i++) {
			lowerlimitDifficultyId[i] = lower_difficulty[i].value;
		}

		var upper_difficulty = document
				.getElementsByClassName("upper_difficulty");
		var toplimitDifficultyId = new Array();
		for (var i = 0; i < upper_difficulty.length; i++) {
			toplimitDifficultyId[i] = upper_difficulty[i].value;
		}

		var num = document.getElementsByClassName("number");
		var number = new Array();
		for (var i = 0; i < num.length; i++) {
			number[i] = num[i].value;
		}

		var scores = document.getElementsByClassName("score");
		var score = new Array();
		for (var i = 0; i < scores.length; i++) {
			score[i] = scores[i].value;
		}

		var order = document.getElementsByClassName("order");
		var itemsOrder = new Array();
		for (var i = 0; i < order.length; i++) {
			itemsOrder[i] = order[i].value;
		}

		var examType = [ "单选题", "多选题", "判断题", "填空题", "计算题", "简答题" ];
		/*for (var i = 0; i < 6; i++) {
			 	if (i == 0) {
					examType = "单选题";
				} else if (i == 1) {
					examType = "多选题";
				} else if (i == 2) {
					examType = "判断题";
				} else if (i == 3) {
					examType = "填空题";
				} else if (i == 4) {
					examType = "计算题";
				} else if (i == 5) {
					examType = "简答题";
				} 
			if (number[i].value > 0 && strategyId > 0) {
				saveTestItemsDesign(strategyId, examType,
						lowerlimitDifficultyId[i].value,
						toplimitDifficultyId[i].value,
						number[i].value, score[i].value,
						order[i].value);
			} else {
				addStrategy(strategyName, createrId, fullScore,
						passScore, strategyPurpose, examType,
						lowerlimitDifficultyId[i].value,
						toplimitDifficultyId[i].value,
						number[i].value, score[i].value,
						order[i].value);
			}
		}*/
		var xhr = createXmlHttpRequest();
		var url = "saveStrategy";
		xhr.open('post', url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("strategyName=" + strategyName + "&createrId=" + createrId
				+ "&fullScore=" + fullScore + "&passScore=" + passScore
				+ "&purpose=" + strategyPurpose + "&testDatabaseId="
				+ testDatabaseId + "&examType=" + examType
				+ "&lowerlimitDifficultyId=" + lowerlimitDifficultyId
				+ "&toplimitDifficultyId=" + toplimitDifficultyId + "&number="
				+ number + "&score=" + score + "&itemsOrder=" + itemsOrder);
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				if (this.responseText == 1) {
					alert("新增成功！");
				} else {
					alert("新增失败！");
				}
				window.location.href = "getAllStrategy";
			}
		}
	}
	/* 
	 function saveTestItemsDesign(strategyId, examType,
	 lowerlimitDifficultyId, toplimitDifficultyId, number,
	 score, itemsOrder) {
	 var xhr = createXmlHttpRequest();
	 var url = "saveTestItemsDesign";
	 xhr.open('post', url, true);
	 xhr.setRequestHeader('Content-Type',
	 'application/x-www-form-urlencoded');
	 xhr.send("strategyId=" + strategyId + "&examType="
	 + examType + "&lowerlimitDifficultyId="
	 + lowerlimitDifficultyId + "&toplimitDifficultyId="
	 + toplimitDifficultyId + "&number=" + number
	 + "&score=" + score + "&itemsOrder=" + itemsOrder);
	 xhr.onreadystatechange = function() {
	 if (this.readyState == 4 && this.status == 200) {
	 if (this.responseText == 1) {
	 alert(examType + "新增成功！");
	 } else {
	 alert(examType + "新增失败！");
	 }
	 }
	 }
	 }

	 function addStrategy(strategyName, createrId, fullScore,
	 passScore, strategyPurpose) {
	 var xhr = createXmlHttpRequest();
	 var url = "saveStrategy";
	 xhr.open('post', url, true);
	 xhr.setRequestHeader('Content-Type',
	 'application/x-www-form-urlencoded');
	 xhr.send("strategyName=" + strategyName + "&createrId="
	 + createrId + "&fullScore=" + fullScore
	 + "&passScore=" + passScore + "&strategyPurpose="
	 + strategyPurpose);
	 /*发送http body*/
	/*	xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				if (this.responseText == 1) {
					alert("策略新增成功！");
				} else {
					alert("策略新增失败！");
				}
			}
		}
	} */

	function createXmlHttpRequest() {
		if (window.ActiveXObject) { //如果是IE浏览器
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) { //非IE浏览器
			return new XMLHttpRequest();
		}
	}

	function total(id) {
		document.getElementById("total" + id).innerText = document
				.getElementById("number" + id).value
				* document.getElementById("score" + id).value;
	}
	function totalscore() {
		var total = 0;
		for (var i = 1; i < 7; i++) {
			total += document.getElementById("number" + i).value
					* document.getElementById("score" + i).value;
		}
		document.getElementById("totalscore").innerText = total;
	}
	function count() {
		for (var i = 1; i < 7; i++) {
			total(i);
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

	function show() {
		document.getElementById("classification").hidden = false;
	}

	function shut() {
		document.getElementById("classification").hidden = true;
	}

	function cancel() {
		var chk_list = document.getElementsByTagName("input");
		for (var i = 0; i < chk_list.length; i++) {
			if (chk_list[i].type == "checkbox") {
				chk_list[i].checked = false;
			}
		}
		fun();
	}
	function fun() {
		obj = document.getElementsByName("classificationId");// 取值核心方法
		check_val = [];
		for (k in obj) {
			if (obj[k].checked) {
				var val = document.getElementById("td_" + k);
				check_val.push(val.value);
			}
		}
		document.getElementById("StrategyClassification").value = check_val;
		shut();
	}
</script>
<body>
	<div id="pageAll">
		<!--导航栏-->
		<div class="pageTop">
			<div class="page">
				<img src="../img/coin02.png" /><span><a href="../main.html">首页</a>&nbsp;-&nbsp;<a
					href="StrategyManagement.html">策略管理</a>&nbsp;-</span>&nbsp;添加策略
			</div>
		</div>
		<div class="page ">
			<!-- 页面样式 -->
			<div class="baTopNo">
				<span>策略信息</span>
			</div>
			<div class="bor div1">
				<table>
					<tr>
						<td class="tdC" width="60px">策略名称：</td>
						<td colspan="8" width="1600px" class="tdC left"><input
							type="text" class="StrategyInput" id="strategyName"></td>
					</tr>
					<tr>
						<td>策略总分</td>
						<td colspan="8" class="left"><input type="text"
							class="StrategyInput" id="fullScore"></td>
					</tr>
					<tr>
						<td>及格分数</td>
						<td colspan="8" class="left"><input type="text"
							class="StrategyInput" id="passScore"></td>
					</tr>
					<tr>
						<td>策略用途</td>
						<td colspan="8" class="left"><select id="strategyPurpose"
							class="StrategySelect" id="strategyId">
								<option value="正规考试">正规考试</option>
								<option value="非正规考试">非正规考试</option>
						</select></td>
					</tr>
					<tr>
						<td>考试试题分类</td>
						<td colspan="8" class="left"><input type="text"
							class="StrategyInput1" id="StrategyClassification"
							disabled="disabled" name="StrategyClassification" value="">
							<button class="delban" onclick="show()">请选择分类</button></td>

					</tr>
					<tr>
						<td rowspan="7" width="60px">试题类型</td>
						<td width="12.5%">题型</td>
						<td width="12.5%">难度</td>
						<td width="12.5%">数量</td>
						<td width="12.5%">分数</td>
						<td width="12.5%">顺序</td>
						<td width="12.5%">总计</td>
					</tr>
					<tr>
						<td>单选题</td>
						<td><select id="lower_difficulty" class="lower_difficulty">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
						</select> <select id="upper_difficulty" class="upper_difficulty">
								<option value="10">10</option>
								<option value="9">9</option>
								<option value="8">8</option>
								<option value="7">7</option>
								<option value="6">6</option>
								<option value="5">5</option>
								<option value="4">4</option>
								<option value="3">3</option>
								<option value="2">2</option>
								<option value="1">1</option>
						</select></td>
						<td><input type="text" id="number1" class="number"
							onchange="total(1),totalscore()" value="0"></td>
						<td><input type="text" id="score1" class="score"
							onchange="total(1),totalscore()" value="0"></td>
						<td><select id="order" class="order">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
						</select></td>
						<td id="total1"></td>
					</tr>
					<tr>
						<td>多选题</td>
						<td><select id="lower_difficulty" class="lower_difficulty">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
						</select> <select id="upper_difficulty" class="upper_difficulty">
								<option value="10">10</option>
								<option value="9">9</option>
								<option value="8">8</option>
								<option value="7">7</option>
								<option value="6">6</option>
								<option value="5">5</option>
								<option value="4">4</option>
								<option value="3">3</option>
								<option value="2">2</option>
								<option value="1">1</option>
						</select></td>
						<td><input type="text" id="number2" class="number"
							onchange="total(2),totalscore()" value="0"></td>
						<td><input type="text" id="score2" class="score"
							onchange="total(2),totalscore()" value="0"></td>
						<td><select id="order" class="order">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
						</select></td>
						<td id="total2"></td>
					</tr>
					<tr>
						<td>判断题</td>
						<td><select id="lower_difficulty" class="lower_difficulty">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
						</select> <select id="upper_difficulty" class="upper_difficulty">
								<option value="10">10</option>
								<option value="9">9</option>
								<option value="8">8</option>
								<option value="7">7</option>
								<option value="6">6</option>
								<option value="5">5</option>
								<option value="4">4</option>
								<option value="3">3</option>
								<option value="2">2</option>
								<option value="1">1</option>
						</select></td>
						<td><input type="text" id="number3" class="number"
							onchange="total(3),totalscore()" value="0"></td>
						<td><input type="text" id="score3" class="score"
							onchange="total(3),totalscore()" value="0"></td>
						<td><select id="order" class="order">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
						</select></td>
						<td id="total3"></td>
					</tr>
					<tr>
						<td>填空题</td>
						<td><select id="lower_difficulty" class="lower_difficulty">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
						</select> <select id="upper_difficulty" class="upper_difficulty">
								<option value="10">10</option>
								<option value="9">9</option>
								<option value="8">8</option>
								<option value="7">7</option>
								<option value="6">6</option>
								<option value="5">5</option>
								<option value="4">4</option>
								<option value="3">3</option>
								<option value="2">2</option>
								<option value="1">1</option>
						</select></td>
						<td><input type="text" id="number4" class="number"
							onchange="total(4),totalscore()" value="0"></td>
						<td><input type="text" id="score4" class="score"
							onchange="total(4),totalscore()" value="0"></td>
						<td><select id="order" class="order">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
						</select></td>
						<td id="total4"></td>
					</tr>
					<tr>
						<td>计算题</td>
						<td><select id="lower_difficulty" class="lower_difficulty">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
						</select> <select id="upper_difficulty" class="upper_difficulty">
								<option value="10">10</option>
								<option value="9">9</option>
								<option value="8">8</option>
								<option value="7">7</option>
								<option value="6">6</option>
								<option value="5">5</option>
								<option value="4">4</option>
								<option value="3">3</option>
								<option value="2">2</option>
								<option value="1">1</option>
						</select></td>
						<td><input type="text" id="number5" class="number"
							onchange="total(5),totalscore()" value="0"></td>
						<td><input type="text" id="score5" class="score"
							onchange="total(5),totalscore()" value="0"></td>
						<td><select id="order" class="order">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
						</select></td>
						<td id="total5"></td>
					</tr>
					<tr>
						<td>简答题</td>
						<td><select id="lower_difficulty" class="lower_difficulty">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
						</select> <select id="upper_difficulty" class="upper_difficulty">
								<option value="10">10</option>
								<option value="9">9</option>
								<option value="8">8</option>
								<option value="7">7</option>
								<option value="6">6</option>
								<option value="5">5</option>
								<option value="4">4</option>
								<option value="3">3</option>
								<option value="2">2</option>
								<option value="1">1</option>
						</select></td>
						<td width="130px"><input type="text" id="number6"
							class="number" onchange="total(6),totalscore()" value="0"></td>
						<td width="130px"><input type="text" id="score6"
							class="score" onchange="total(6),totalscore()" value="0"></td>
						<td width="130px"><select id="order" class="order">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
						</select></td>
						<td id="total6"></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td id="totalscore"></td>
					</tr>
				</table>
			</div>

			<!-- 页面样式end -->
		</div>
		<div class="bbD">
			<p class="bbDP">
				<input type="submit" class="btn_ok btn_yes box1" value="添加"
					onclick="add()" /> <a class="btn_ok btn_no box1"
					href="getAllStrategy">返回</a>
			</p>
		</div>
		<div></div>

		<div class="banDel" id="classification" hidden>
			<div class="delete">
				<div class="close">
					<a><img onclick="cancel()" src="../img/shanchu.png" /></a>
				</div>
				<div class="table">
					<table id="delP1" width="95%">
						<tr>
							<td class="tdColor"><input type="checkbox" name="id"
								onclick="changeState(this.checked)">全选</td>
							<td class="tdColor">题目分类Id</td>
							<td class="tdColor">题目分类名称</td>
						</tr>
						<%
							@SuppressWarnings("unchecked")
							List<ClassificationOfTestdatabase> list = (List<ClassificationOfTestdatabase>) request.getAttribute("list");
							for (int i = 0; i < list.size(); i++) {
								out.print("<tr id='classification" + i + "'></tr>");
								out.print("<td><input type='checkbox' name='classificationId' value='" + i + "'>");
								out.print("<td class='testDatabaseId'>" + list.get(i).getTestDatabaseId() + "</td>"
										+ "<td><input type='text' value='" + list.get(i).getName() + "' id='td_" + i + "' hidden>"
										+ list.get(i).getName() + "</td>");
							}
						%>
					</table>
					<p class="delP2">
						<button class="ok1 yes" onclick="fun()">确定</button>
						<a class="ok1 no" onclick="cancel()">取消</a>
					</p>
				</div>
			</div>
		</div>

	</div>
</body>
</html>