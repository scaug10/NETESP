<%@page
	import="com.g10.ssm.po.testdatabase.ClassificationOfTestdatabase"%>
<%@page import="java.util.List"%>
<%@page import="com.g10.ssm.po.testdatabase.Strategy"%>
<%@page import="com.g10.ssm.po.testdatabase.TestItemsDesign"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改策略</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/css.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/Strategy.js"></script>
<style>
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

#classification {
	margin: auto;
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
}
</style>
</head>
<script>
	function modify(strategyId) {
		var message = "确认修改？";
		if (confirm(message)) {
			modifyStrategy(strategyId);
			modifyStrategyTestDatabaseDesign(strategyId);
			var testItemsDesignId = new Array(6);
			for (var i = 0; i < 6; i++) {
				testItemsDesignId[i] = document
						.getElementById("testItemDesignId" + i).value;
			}
			var lowerlimitDifficultyId = document
					.getElementsByClassName("lower_difficulty");
			var toplimitDifficultyId = document
					.getElementsByClassName("upper_difficulty");
			var number = document.getElementsByClassName("number");
			var score = document.getElementsByClassName("score");
			var order = document.getElementsByClassName("order");
			var examType;
			for (var i = 0; i < 6; i++) {
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
				if (number[i].value > 0) {
					if (testItemsDesignId[i] == -1) {
						saveTestItemsDesign(strategyId, examType,
								lowerlimitDifficultyId[i].value,
								toplimitDifficultyId[i].value, number[i].value,
								score[i].value, order[i].value);
					} else {
						modifyTestItemsDesign(examType, testItemsDesignId[i],
								lowerlimitDifficultyId[i].value,
								toplimitDifficultyId[i].value, number[i].value,
								score[i].value, order[i].value);
					}
				} else {
					if (testItemsDesignId[i] != -1) {
						deleteTestItemsDesign(testItemsDesignId[i], examType);
					}
				}
			}
			window.location.href = "getAllStrategy";
		}
	}

	function saveTestItemsDesign(strategyId, examType, lowerlimitDifficultyId,
			toplimitDifficultyId, number, score, itemsOrder) {
		var xhr = createXmlHttpRequest();
		var url = "saveTestItemsDesign";
		xhr.open('post', url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("strategyId=" + strategyId + "&examType=" + examType
				+ "&lowerlimitDifficultyId=" + lowerlimitDifficultyId
				+ "&toplimitDifficultyId=" + toplimitDifficultyId + "&number="
				+ number + "&score=" + score + "&itemsOrder=" + itemsOrder);
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

	function modifyTestItemsDesign(examType, testItemsDesignId,
			lowerlimitDifficultyId, toplimitDifficultyId, number, score,
			itemsOrder) {
		var xhr = createXmlHttpRequest();
		var url = "editTestItemsDesign";
		xhr.open('post', url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("testItemsDesignId=" + testItemsDesignId
				+ "&lowerlimitDifficultyId=" + lowerlimitDifficultyId
				+ "&toplimitDifficultyId=" + toplimitDifficultyId + "&number="
				+ number + "&score=" + score + "&itemsOrder=" + itemsOrder);
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				if (this.responseText == 1) {
					alert(examType + "修改成功！");
				} else {
					alert(examType + "修改失败！");
				}
			}
		}
	}

	function deleteTestItemsDesign(testItemsDesignId, examType) {
		var xhr = createXmlHttpRequest();
		var url = "deleteTestItemsDesign";
		xhr.open('post', url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("testItemsDesignId=" + testItemsDesignId);
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				if (this.responseText == 1) {
					alert(examType + "删除成功！");
				} else {
					alert(examType + "删除失败！");
				}
			}
		}
	}

	function modifyStrategy(strategyId) {
		var strategyName = document.getElementById("strategyName").value;
		var fullScore = document.getElementById("fullScore").value;
		var passScore = document.getElementById("passScore").value;
		var status = document.getElementById("strategyStatus").value
		var strategyPurpose = document.getElementById("strategyPurpose").value;
		var xhr = createXmlHttpRequest();
		var url = "editStrategy";
		xhr.open('post', url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("strategyId=" + strategyId + "&strategyName=" + strategyName
				+ "&fullScore=" + fullScore + "&status=" + status
				+ "&passScore=" + passScore + "&strategyPurpose="
				+ strategyPurpose);
		/*发送http body*/
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				if (this.responseText == 1) {
					alert("策略修改成功！");
				} else {
					alert("策略修改失败！");
				}
			}
		}
	}

	function modifyStrategyTestDatabaseDesign(strategyId) {
		var checkboxArray = document.getElementsByClassName("checkbox");
		var sendArray = new Array();
		for (var i = 0; i < checkboxArray.length; i++) {
			if (checkboxArray[i].checked) {
				sendArray.push(checkboxArray[i].id);
			}
		}
		var xhr = createXmlHttpRequest();
		var url = "editStrategyTestDatabaseClassification";
		xhr.open('post', url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("strategyId=" + strategyId + "&testDatabaseId=" + sendArray);
		/*发送http body*/
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				if (this.responseText == 1) {
					alert("题库分类修改成功！");
				} else {
					alert("题库分类修改失败！");
				}
			}
		}
	}

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
		document.getElementById("pageAll").hidden = true;
	}

	function shut() {
		document.getElementById("classification").hidden = true;
		document.getElementById("pageAll").hidden = false;
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
<body onload="count(),totalscore(),fun()">
	<div id="pageAll">

		<!--导航栏-->

		<div class="pageTop">
			<div class="page">
				<img src="${pageContext.request.contextPath}/img/coin02.png" /><span><a
					href="../main.html">首页</a>&nbsp;-&nbsp;<a href="getAllStrategy">策略管理</a>&nbsp;-</span>&nbsp;修改策略
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
						<td class="tdC" width="60px">策略名称</td>
						<td colspan="8" width="1600px" class="tdC left"><input
							type="text" class="StrategyInput" id="strategyName"
							value="${Strategy.strategyName }"></td>
					</tr>
					<tr>
						<td>策略总分</td>
						<td colspan="8" class="left"><input type="text"
							id="fullScore" class="StrategyInput"
							value="${Strategy.fullScore }"></td>
					</tr>
					<tr>
						<td>及格分数</td>
						<td colspan="8" class="left"><input type="text"
							id="passScore" class="StrategyInput"
							value="${Strategy.passScore }"></td>
					</tr>
					<tr>
						<td>策略状态</td>
						<td colspan="8" class="left"><select id="strategyStatus"
							class="StrategySelect">
								<%
									Strategy strategy = (Strategy) request.getAttribute("Strategy");
									if (strategy.getStatus()) {
										out.print("<option value='1' selected='selected'> " + "可用" + "</option>");
										out.print("<option value='0'> " + "不可用" + "</option>");
									} else {
										out.print("<option value='1' > " + "可用" + "</option>");
										out.print("<option value='0' selected='selected'> " + "不可用" + "</option>");
									}
								%>
						</select></td>
					</tr>
					<tr>
						<td>策略用途</td>
						<td colspan="8" class="left"><select id="strategyPurpose"
							class="StrategySelect">
								<%
									if (strategy.getPurpose().equals("正规考试")) {
										out.print("<option value='正规考试' selected='selected'> " + "正规考试" + "</option>");
										out.print("<option value='非正规考试'> " + "非正规考试" + "</option>");
									} else {
										out.print("<option value='正规考试' > " + "正规考试" + "</option>");
										out.print("<option value='非正规考试' selected='selected'> " + "非正规考试" + "</option>");
									}
								%>
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
					<%
						TestItemsDesign[] list = (TestItemsDesign[]) request.getAttribute("list");
					%>
					<tr>
						<td>单选题</td>
						<td><select id="lower_difficulty" class="lower_difficulty">
								<%
									int[] i = new int[6];
									for (i[0] = 0; i[0] < list.length; i[0]++) {
										if (list[i[0]].getExamType().equals("单选题"))
											break;
									}
									if (i[0] < list.length) {
										for (int j = 1; j < 11; j++) {
											out.print("<option value='" + j + "'");
											if (list[i[0]].getLowerlimitDifficultyId() == j) {
												out.print("selected='selected'");
											}
											out.print("'>" + j);
											out.print("</option>");
										}
									} else {
								%>
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
								<%
									}
								%>
						</select> <select id="upper_difficulty" class="upper_difficulty">
								<%
									if (i[0] < list.length) {
										for (int j = 10; j > 0; j--) {
											out.print("<option value='" + j + "'");
											if (list[i[0]].getToplimitDifficultyId() == j) {
												out.print("selected='selected'");
											}
											out.print("'>" + j);
											out.print("</option>");
										}
									} else {
								%>
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
								<%
									}
								%>
						</select></td>
						<td><input type="text" id="number1" class="number"
							onchange="total(1),totalscore()"
							<%if (i[0] < list.length) {
				out.print("value='" + list[i[0]].getNumber() + "'");
			} else {
				out.print("value='0'");
			}%>></td>

						<td><input type="text" id="score1" class="score"
							onchange="total(1),totalscore()"
							<%if (i[0] < list.length) {
				out.print("value='" + list[i[0]].getScore() + "'");
			} else {
				out.print("value='0'");
			}%>></td>
						<td><select id="order" class="order">
								<%
									if (i[0] < list.length) {
										for (int j = 1; j < 7; j++) {
											out.print("<option value='" + j + "'");
											if (list[i[0]].getItemsOrder() == j) {
												out.print("selected='selected'");
											}
											out.print(">" + j + "</option>");
										}
									} else {
								%>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<%
									}
								%>
						</select></td>
						<td id="total1"></td>
					</tr>
					<tr>
						<td>多选题</td>
						<td><select id="lower_difficulty" class="lower_difficulty">
								<%
									for (i[1] = 0; i[1] < list.length; i[1]++) {
										if (list[i[1]].getExamType().equals("多选题"))
											break;
									}
									if (i[1] < list.length) {
										for (int j = 1; j < 11; j++) {
											out.print("<option value='" + j + "'");
											if (list[i[1]].getLowerlimitDifficultyId() == j) {
												out.print("selected='selected'");
											}
											out.print("'>" + j);
											out.print("</option>");
										}
									} else {
								%>
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
								<%
									}
								%>
						</select> <select id="upper_difficulty" class="upper_difficulty">
								<%
									if (i[1] < list.length) {
										for (int j = 10; j > 0; j--) {
											out.print("<option value='" + j + "'");
											if (list[i[1]].getToplimitDifficultyId() == j) {
												out.print("selected='selected'");
											}
											out.print("'>" + j);
											out.print("</option>");
										}
									} else {
								%>
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
								<%
									}
								%>
						</select></td>
						<td><input type="text" id="number2" class="number"
							onchange="total(2),totalscore()"
							<%if (i[1] < list.length) {
				out.print("value='" + list[i[1]].getNumber() + "'");
			} else {
				out.print("value='0'");
			}%>></td>
						<td><input type="text" id="score2" class="score"
							onchange="total(2),totalscore()"
							<%if (i[1] < list.length) {
				out.print("value='" + list[i[1]].getScore() + "'");
			} else {
				out.print("value='0'");
			}%>></td>
						<td><select id="order" class="order">
								<%
									if (i[1] < list.length) {
										for (int j = 1; j < 7; j++) {
											out.print("<option value='" + j + "'");
											if (list[i[1]].getItemsOrder() == j) {
												out.print("selected='selected'");
											}
											out.print(">" + j + "</option>");
										}
									} else {
								%>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<%
									}
								%>
						</select></td>
						<td id="total2"></td>
					</tr>
					<tr>
						<td>判断题</td>
						<td><select id="lower_difficulty" class="lower_difficulty">
								<%
									for (i[2] = 0; i[2] < list.length; i[2]++) {
										if (list[i[2]].getExamType().equals("判断题"))
											break;
									}
									if (i[2] < list.length) {
										for (int j = 1; j < 11; j++) {
											out.print("<option value='" + j + "'");
											if (list[i[2]].getLowerlimitDifficultyId() == j) {
												out.print("selected='selected'");
											}
											out.print("'>" + j);
											out.print("</option>");
										}
									} else {
								%>
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
								<%
									}
								%>
						</select> <select id="upper_difficulty" class="upper_difficulty">
								<%
									if (i[2] < list.length) {
										for (int j = 10; j > 0; j--) {
											out.print("<option value='" + j + "'");
											if (list[i[2]].getToplimitDifficultyId() == j) {
												out.print("selected='selected'");
											}
											out.print("'>" + j);
											out.print("</option>");
										}
									} else {
								%>
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
								<%
									}
								%>
						</select></td>
						<td><input type="text" id="number3" class="number"
							onchange="total(3),totalscore()"
							<%if (i[2] < list.length) {
				out.print("value='" + list[i[2]].getNumber() + "'");
			} else {
				out.print("value='0'");
			}%>></td>
						<td><input type="text" id="score3" class="score"
							onchange="total(3),totalscore()"
							<%if (i[2] < list.length) {
				out.print("value='" + list[i[2]].getScore() + "'");
			} else {
				out.print("value='0'");
			}%>></td>
						<td><select id="order" class="order">
								<%
									if (i[2] < list.length) {
										for (int j = 1; j < 7; j++) {
											out.print("<option value='" + j + "'");
											if (list[i[2]].getItemsOrder() == j) {
												out.print("selected='selected'");
											}
											out.print(">" + j + "</option>");
										}
									} else {
								%>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<%
									}
								%>
						</select></td>
						<td id="total3"></td>
					</tr>
					<tr>
						<td>填空题</td>
						<td><select id="lower_difficulty" class="lower_difficulty">
								<%
									for (i[3] = 0; i[3] < list.length; i[3]++) {
										if (list[i[3]].getExamType().equals("填空题"))
											break;
									}
									if (i[3] < list.length) {
										for (int j = 1; j < 11; j++) {
											out.print("<option value='" + j + "'");
											if (list[i[3]].getLowerlimitDifficultyId() == j) {
												out.print("selected='selected'");
											}
											out.print("'>" + j);
											out.print("</option>");
										}
									} else {
								%>
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
								<%
									}
								%>
						</select> <select id="upper_difficulty" class="upper_difficulty">
								<%
									if (i[3] < list.length) {
										for (int j = 10; j > 0; j--) {
											out.print("<option value='" + j + "'");
											if (list[i[3]].getToplimitDifficultyId() == j) {
												out.print("selected='selected'");
											}
											out.print("'>" + j);
											out.print("</option>");
										}
									} else {
								%>
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
								<%
									}
								%>
						</select></td>
						<td><input type="text" id="number4" class="number"
							onchange="total(4),totalscore()"
							<%if (i[3] < list.length) {
				out.print("value='" + list[i[3]].getNumber() + "'");
			} else {
				out.print("value='0'");
			}%>></td>
						<td><input type="text" id="score4" class="score"
							onchange="total(4),totalscore()"
							<%if (i[3] < list.length) {
				out.print("value='" + list[i[3]].getScore() + "'");
			} else {
				out.print("value='0'");
			}%>></td>
						<td><select id="order" class="order">
								<%
									if (i[3] < list.length) {
										for (int j = 1; j < 7; j++) {
											out.print("<option value='" + j + "'");
											if (list[i[3]].getItemsOrder() == j) {
												out.print("selected='selected'");
											}
											out.print(">" + j + "</option>");
										}
									} else {
								%>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<%
									}
								%>
						</select></td>
						<td id="total4"></td>
					</tr>
					<tr>
						<td>计算题</td>
						<td><select id="lower_difficulty" class="lower_difficulty">
								<%
									for (i[4] = 0; i[4] < list.length; i[4]++) {
										if (list[i[4]].getExamType().equals("计算题"))
											break;
									}
									if (i[4] < list.length) {
										for (int j = 1; j < 11; j++) {
											out.print("<option value='" + j + "'");
											if (list[i[4]].getLowerlimitDifficultyId() == j) {
												out.print("selected='selected'");
											}
											out.print("'>" + j);
											out.print("</option>");
										}
									} else {
								%>
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
								<%
									}
								%>
						</select> <select id="upper_difficulty" class="upper_difficulty">
								<%
									if (i[4] < list.length) {
										for (int j = 10; j > 0; j--) {
											out.print("<option value='" + j + "'");
											if (list[i[4]].getToplimitDifficultyId() == j) {
												out.print("selected='selected'");
											}
											out.print("'>" + j);
											out.print("</option>");
										}
									} else {
								%>
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
								<%
									}
								%>
						</select></td>
						<td><input type="text" id="number5" class="number"
							onchange="total(5),totalscore()"
							<%if (i[4] < list.length) {
				out.print("value='" + list[i[4]].getNumber() + "'");
			} else {
				out.print("value='0'");
			}%>></td>
						<td><input type="text" id="score5" class="score"
							onchange="total(5),totalscore()"
							<%if (i[4] < list.length) {
				out.print("value='" + list[i[4]].getScore() + "'");
			} else {
				out.print("value='0'");
			}%>></td>
						<td><select id="order" class="order">
								<%
									if (i[4] < list.length) {
										for (int j = 1; j < 7; j++) {
											out.print("<option value='" + j + "'");
											if (list[i[4]].getItemsOrder() == j) {
												out.print("selected='selected'");
											}
											out.print(">" + j + "</option>");
										}
									} else {
								%>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<%
									}
								%>
						</select></td>
						<td id="total5"></td>
					</tr>
					<tr>
						<td>简答题</td>
						<td><select id="lower_difficulty" class="lower_difficulty">
								<%
									for (i[5] = 0; i[5] < list.length; i[5]++) {
										if (list[i[5]].getExamType().equals("简答题"))
											break;
									}
									if (i[5] < list.length) {
										for (int j = 1; j < 11; j++) {
											out.print("<option value='" + j + "'");
											if (list[i[5]].getLowerlimitDifficultyId() == j) {
												out.print("selected='selected'");
											}
											out.print("'>" + j);
											out.print("</option>");
										}
									} else {
								%>
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
								<%
									}
								%>
						</select> <select id="upper_difficulty" class="upper_difficulty">
								<%
									if (i[5] < list.length) {
										for (int j = 10; j > 0; j--) {
											out.print("<option value='" + j + "'");
											if (list[i[5]].getToplimitDifficultyId() == j) {
												out.print("selected='selected'");
											}
											out.print("'>" + j);
											out.print("</option>");
										}
									} else {
								%>
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
								<%
									}
								%>
						</select></td>
						<td width="130px"><input type="text" id="number6"
							class="number" onchange="total(6),totalscore()"
							<%if (i[5] < list.length) {
				out.print("value='" + list[i[5]].getNumber() + "'");
			} else {
				out.print("value='0'");
			}%>></td>
						<td width="130px"><input type="text" id="score6"
							class="score" onchange="total(6),totalscore()"
							<%if (i[5] < list.length) {
				out.print("value='" + list[i[5]].getScore() + "'");
			} else {
				out.print("value='0'");
			}%>></td>
						<td width="130px"><select id="order" class="order">
								<%
									if (i[5] < list.length) {
										for (int j = 1; j < 7; j++) {
											out.print("<option value='" + j + "'");
											if (list[i[5]].getItemsOrder() == j) {
												out.print("selected='selected'");
											}
											out.print(">" + j + "</option>");
										}
									} else {
								%>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<%
									}
								%>
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
			<input type="hidden" id="testItemDesignId0"> <input
				type="hidden" id="testItemDesignId1"> <input type="hidden"
				id="testItemDesignId2"> <input type="hidden"
				id="testItemDesignId3"> <input type="hidden"
				id="testItemDesignId4"> <input type="hidden"
				id="testItemDesignId5">
			<%
				for (int j = 0; j < 6; j++) {
					if (i[j] < list.length) {
						out.print("<script type='text/javascript'>document.getElementById('testItemDesignId'");
						out.print("+" + j + ").value= " + list[i[j]].getTestItemsDesignId() + ";</script>");
					} else {
						out.print("<script type='text/javascript'>document.getElementById('testItemDesignId'");
						out.print("+" + j + ").value= -1;</script>");
					}
				}
			%>
			<!-- 页面样式end -->
		</div>
		<div class="bbD">
			<p class="bbDP">
				<input type="submit" class="btn_ok btn_yes box1" value="确定"
					onclick="modify('${Strategy.strategyId}')" /> <a
					class="btn_ok btn_no box1" href="getAllStrategy">返回</a>
			</p>
		</div>

	</div>
	<div class="selectbox" id="classification">
		<div class="delete">
			<div class="close">
				<a><img onclick="cancel()"
					src="${pageContext.request.contextPath}/img/shanchu.png" /></a>
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
						List<ClassificationOfTestdatabase> cotlist = (List<ClassificationOfTestdatabase>) request
								.getAttribute("cotlist");
						ClassificationOfTestdatabase[] COTlist = (ClassificationOfTestdatabase[]) request.getAttribute("COTlist");
						for (int j = 0; j < cotlist.size(); j++) {
							out.print("<tr id='classification" + j + "'></tr>");
							out.print("<td><input type='checkbox' class='checkbox' id='" + cotlist.get(j).getTestDatabaseId()
									+ "' name='classificationId' value='" + j + "'");
							for (int k = 0; k < COTlist.length; k++) {
								if (cotlist.get(j).getTestDatabaseId() == COTlist[k].getTestDatabaseId())
									out.print("checked='checked'");
							}
							out.print("><td class='testDatabaseId'>" + cotlist.get(j).getTestDatabaseId() + "</td>"
									+ "<td><input type='text' value='" + cotlist.get(j).getName() + "' id='td_" + j + "' hidden>"
									+ cotlist.get(j).getName() + "</td>");
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
</body>
</html>