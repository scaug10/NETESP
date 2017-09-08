<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>远程教育考试平台_在线考试</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/test/test.css">
<script type="text/javascript"></script>
<style type="text/css">
.hasBeenAnswer {
	background: #5d9cec;
	color: #fff;
}



label {
	padding-top: 5px;
}
.clear:after{
	content:"";
	display:table;
	clear:both;
}
</style>
<script type="text/javascript">
	function createXmlHttpRequest() {
		if (window.ActiveXObject) { //如果是IE浏览器
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) { //非IE浏览器
			return new XMLHttpRequest();
		}
	}
	
	var frontQuestionNumber = 0;
	
	function singleChoice() {
		var url = "${pageContext.request.contextPath}/test/singleChoice";
		var data = "examId="+ document.getElementById("examId").value
				+ "&strategyId=" + document.getElementById("strategyId").value
				+ "&subjectType=单选题";
		var xhr = createXmlHttpRequest();
		xhr.open('post', url, true);
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhr.send(data);
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var json = JSON.parse(this.responseText);
				if (json != undefined && json != null) {
					var radioQuestionNumber = json.list.length;
					var radioQuestionScore = json.singleScore * json.list.length;
					document.getElementsByClassName("test_content_title")[0].innerHTML = "<h2>单选题</h2>"
							+ "<p><span>共</span>"
							+ "<i class='content_lit'>" + radioQuestionNumber + "</i><span>题，</span>"
							+ "<span>合计</span>"
							+ "<i class='content_fs'>" + radioQuestionScore
							+ "</i>"
							+ "<span>分</span>"
							+ "</p>";

					singleChoiceQuestion(json);
				}
			}
		};
		
	}
	
	function singleChoiceQuestion(json) {
		var radioQuestionNumber = json.list.length;
		var radioQuestionScore = json.singleScore;
		for (var i = 0; i < radioQuestionNumber; ++i) {
			var questionTitle = json.list[i].content;
			var AOption = json.list[i].choice.optionA;
			var BOption = json.list[i].choice.optionB;
			var COption = json.list[i].choice.optionC;
			var DOption = json.list[i].choice.optionD;
			var radio = document.getElementById("radio");
			radio.innerHTML = radio.innerHTML + "<li id='qu_" + (i + 1) + "'></li>";
			document.getElementById("qu_"+ (i + 1) + "").innerHTML = 
					"<div class='test_content_nr_tt'>"
					+ "<i>" + (i + 1)+"</i><span>("+radioQuestionScore+"分)</span>"+questionTitle
					+ "" + "</div>"
					+ "<div class='test_content_nr_main'>"
					+ "<ul>"+"<li class='option'>"
					+ "<input type='radio' class='radioOrCheck' name='answer"+(i + 1)
					+ "' id='answer_" + (i + 1)
					+ "_option_1' />"
					+ "<label for='answer_" + (i + 1)
					+ "_option_1'>"
					+ "A.&nbsp;"
					+ "<p class='ue' style='display:inline '>"
					+ AOption
					+ "</p>"
					+ "</label>"
					+ "</li>"
					+ "<li class='option'>"
					+ "<input type='radio' class='radioOrCheck' name='answer"
					+ (i + 1)
					+ "' id='answer_" + (i + 1)
					+ "_option_2' />"
					+ "<label for='answer_" + (i + 1)
					+ "_option_2'>"
					+ "B.&nbsp;"
					+ "<p class='ue' style='display:inline '>"
					+ BOption
					+ "</p>"
					+ "</label>"
					+ "</li>"
					+ "<li class='option'>"
					+ "<input type='radio' class='radioOrCheck' name='answer"
					+ (i + 1)
					+ "' id='answer_" + (i + 1)
					+ "_option_3' />"
					+ "<label for='answer_" + (i + 1)
					+ "_option_3'>" + "C.&nbsp;"
					+ "<p class='ue' style='display:inline '>" + COption
					+ "</p>"
					+ "</label>"
					+ "</li>"
					+ "<li class='option'>"
					+ "<input type='radio' class='radioOrCheck' name='answer"
					+ (i + 1)
					+ "' id='answer_" + (i + 1)
					+ "_option_4' />"
					+ "<label for='answer_" + (i + 1)
					+ "_option_4'>"
					+ "D.&nbsp;"
					+ "<p class='ue' style='display:inline '>" + DOption + "</p>"
					+ "</label>"
					+ "</li>"
					+ "</ul>" + "</div>";
		}
		frontQuestionNumber += radioQuestionNumber;
		checkBox();
	}
	
	function checkBox() {
		var url = "${pageContext.request.contextPath}/test/singleChoice";
		var data = "examId="+ document.getElementById("examId").value
				+ "&strategyId=" + document.getElementById("strategyId").value
				+ "&subjectType=多选题";
		var xhr = createXmlHttpRequest();
		xhr.open('post', url, true);
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhr.send(data);
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var json = JSON.parse(this.responseText);
				if (json != undefined && json != null) {
					var checkboxQuestionNumber = json.list.length;
					var checkboxQuestionScore = json.singleScore * checkboxQuestionNumber;
					var str = "";
					str += "<h2>多选题</h2>"
						+ "<p><span>共</span><i class='content_lit'>"
						+ checkboxQuestionNumber
						+ "</i><span>题，</span>"
						+ "<span>合计</span>"
						+ "<i class='content_fs'>" + checkboxQuestionScore
						+ "</i><span>分</span>"
						+ "</p>";
					document.getElementById("head2").innerHTML = str;
					checkBoxQuestion(json);
				}
			}
		};
	}
	
	function checkBoxQuestion(json) {
		var checkboxQuestionNumber = json.list.length;
		var checkboxQuestionScore = json.singleScore;
		for (var i = 0; i < json.list.length; i++) {
			var questionTitle = json.list[i].content;
			var AOption = json.list[i].choice.optionA;
			var BOption = json.list[i].choice.optionB;
			var COption = json.list[i].choice.optionC;
			var DOption = json.list[i].choice.optionD;
			var EOption = json.list[i].choice.optionE;
			var checkbox = document.getElementById("checkbox");
			checkbox.innerHTML += "<li id='qu_" + (frontQuestionNumber+i+1) + "'></li>";
			document.getElementById("qu_"+ (frontQuestionNumber+i+1) + "").innerHTML = 
					  "<div class='test_content_nr_tt'>"
					+ "	<i>" + (frontQuestionNumber+i+1) 
					+ "	</i><span>(" + checkboxQuestionScore + "分)</span>" + questionTitle
					+ "</div>"
					+ "<div class='test_content_nr_main'>"
					+ "<ul>" + "<li class='option'>"
					+ "<input type='checkbox' class='radioOrCheck' name='answer"
					+ (frontQuestionNumber+i+1)
					+ "' id='answer_" + (frontQuestionNumber+i+1)
					+ "_option_1'/>"
					+ "<label for='answer_" + (frontQuestionNumber+i+1)
					+ "_option_1'>"
					+ "A.&nbsp;"
					+ "<p class='ue' style='display:inline '>"+AOption+"</p>"
					+ "</label>"
					+ "</li>"+"<li class='option'>"
					+ "<input type='checkbox' class='radioOrCheck' name='answer"
					+ (frontQuestionNumber+i+1)
					+ "' id='answer_" + (frontQuestionNumber+i+1)
					+ "_option_2'/>"
					+ "<label for='answer_" + (frontQuestionNumber+i+1)
					+ "_option_2'>"
					+ "B.&nbsp;"
					+ "<p class='ue' style='display:inline '>"
					+ BOption
					+ "</p>"
					+ "</label>"
					+ "</li><li class='option'>"
					+ "<input type='checkbox' class='radioOrCheck' name='answer"
					+ (frontQuestionNumber+i+1)
					+ "' id='answer_" + (frontQuestionNumber+i+1)
					+ "_option_3'/>"
					+ "<label for='answer_" + (frontQuestionNumber+i+1)
					+ "_option_3'>"
					+ "C.&nbsp;"
					+ "<p class='ue' style='display:inline '>"+COption+"</p>"
					+ "</label>"
					+ "</li><li class='option'>"
					+ "<input type='checkbox' class='radioOrCheck' name='answer"
					+ (frontQuestionNumber+i+1)
					+ "' id='answer_" + (frontQuestionNumber+i+1)
					+ "_option_4'/>"
					+ "<label for='answer_" + (frontQuestionNumber+i+1)
					+ "_option_4'>"
					+ "D.&nbsp;"
					+ "<p class='ue' style='display:inline '>" + DOption
					+ "</p>"
					+ "</label></li><li class='option'>"
					+ "<input type='checkbox' class='radioOrCheck' name='answer"
					+ (frontQuestionNumber+i+1)
					+ "' id='answer_" + (frontQuestionNumber+i+1)
					+ "_option_5'/>"
					+ "<label for='answer_" + (frontQuestionNumber+i+1)
					+ "_option_5'>"
					+ "E.&nbsp;"
					+ "<p class='ue' style='display:inline '>" + EOption
					+ "</p>"
					+ "</label>"
					+ "</li>"
					+ "</ul>" + "</div>";
		}
		frontQuestionNumber += checkboxQuestionNumber;
		fill();
	}
	
	function fill() {
		var url = "${pageContext.request.contextPath}/test/singleChoice";
		var data = "examId=" + document.getElementById("examId").value
				+ "&strategyId=" + document.getElementById("strategyId").value
				+ "&subjectType=填空题";
		var xhr = createXmlHttpRequest();
		xhr.open('post', url, true);
		xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
		xhr.send(data);
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var json = JSON.parse(this.responseText);
				if (json != undefined && json != null) {
					var fillQuestionNumber = json.list.length;
					var fillQuestionScore = json.singleScore * json.list.length;
					document.getElementById("head3").innerHTML = "<h2>填空题</h2>"
							+ "<p><span>共</span>"
							+ "<i class='content_lit'>"+fillQuestionNumber+"</i>"
							+ "<span>题，</span>"+"<span>合计</span>"
							+ "<i class='content_fs'>"+fillQuestionScore+"</i>"
							+ "<span>分</span>"
							+ "</p>";

					fillQuestion(json);
				}
			}
		};
	}
	
	function fillQuestion(json) {
		var fillQuestionNumber = json.list.length;
		var fillQuestionScore = json.singleScore;
		for (var i = 0; i < fillQuestionNumber; i++) {
			var questionTitle = json.list[i].content;
			var block = document.getElementById("Block");
			block.innerHTML += "<li id='qu_"+ (frontQuestionNumber+i+1) + "'></li>";
			document.getElementById("qu_"
					+ (frontQuestionNumber+i+1) + "").innerHTML = "<div class='test_content_nr_tt'>"
					+ "<i>" + (frontQuestionNumber+i+1)+"</i>"
					+ "<span>("+ fillQuestionScore+ "分)</span>"
					+ questionTitle
					+ "</div><div class='test_content_nr_main'>"
					+ "<li class='clear'>"
					+ "<input type='text' class='radioOrCheck' name='answer style='width= '20em' margin-top= '8px''"
					+ (frontQuestionNumber+i+1)
					+ "' id='answer_"
					+ (frontQuestionNumber+i+1)
					+ "'/>"
					+ "</li>" 
					+ "</div>";
		}
		frontQuestionNumber += fillQuestionNumber;
		judgment();
	}
	
	function judgment() {
		var url = "${pageContext.request.contextPath}/test/singleChoice";
		var data = "examId="+ document.getElementById("examId").value
				+ "&strategyId="+ document.getElementById("strategyId").value
				+ "&subjectType=判断题";
		var xhr = createXmlHttpRequest();
		xhr.open('post', url, true);
		xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
		xhr.send(data);
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var json = JSON.parse(this.responseText);
				if (json != undefined && json != null) {
					var judgmentQuestionNumber = json.list.length;
					var judgmentQuestionScore = json.singleScore * json.list.length;
					document.getElementById("head4").innerHTML = "<h2>判断题</h2>"
							+ "<p><span>共</span>"
							+ "<i class='content_lit'>"+judgmentQuestionNumber+"</i><span>题，</span>"
							+ "<span>合计</span>"
							+ "<i class='content_fs'>"+ judgmentQuestionScore+ "</i>"
							+ "<span>分</span>"
							+ "</p>";
					judgmentQuestion(json);
				}
			}
		};
	}
	
	function judgmentQuestion(json) {
		var judgmentQuestionNumber = json.list.length;
		var judgmentQuestionScore = json.singleScore;
		for (var i = 0; i < judgmentQuestionNumber; i++) {
			var questionTitle = json.list[i].content;
			var AOption = json.list[i].choice.optionA;
			var BOption = json.list[i].choice.optionB;
			var judgment = document.getElementById("judgment");
			judgment.innerHTML += "<li id='qu_"+ (frontQuestionNumber+i+1) + "'></li>";
			document.getElementById("qu_"
					+ (frontQuestionNumber+i+1) + "").innerHTML = "<div class='test_content_nr_tt'>"
					+ "<i>"+ (frontQuestionNumber+i+1)
					+ "</i><span>("+ judgmentQuestionScore+"分)</span>"+ questionTitle
					+ "</div>"
					+ "<div class='test_content_nr_main'>"
					+ "<ul>"
					+ "<li class='option'>"
					+ "<input type='radio' class='radioOrCheck' name='answer"
					+ (frontQuestionNumber+i+1)
					+ "' id='answer_" + (frontQuestionNumber+i+1)
					+ "_option_1' onclick='radioClick(" + (frontQuestionNumber+i+1)+")'/>"
					+ "<label for='answer_"+(frontQuestionNumber+i+1)
					+ "_option_1'>"
					+ "A.&nbsp;"
					+ "<p class='ue' style='display:inline '>"+AOption+"</p>"
					+ "</label>"
					+ "</li>"
					+ "<li class='option'>"
					+ "<input type='radio' class='radioOrCheck' name='answer"
					+ (frontQuestionNumber+i+1)
					+ "' id='answer_"
					+ (frontQuestionNumber+i+1)
					+ "_option_2' onclick='radioClick("+ (frontQuestionNumber+i+1)+")'/>"
					+ "<label for='answer_"+(frontQuestionNumber+i+1)+"_option_2'>"
					+ "B.&nbsp;"
					+ "<p class='ue' style='display:inline '>"+BOption
					+ "</p>"
					+ "</label>"
					+ "</li>"
					+ "</ul>" + "</div>";
		}
		frontQuestionNumber += judgmentQuestionNumber;
		count();
	}
	
	function count() {
		var url = "${pageContext.request.contextPath}/test/singleChoice";
		var data = "examId="+ document.getElementById("examId").value
				+ "&strategyId="+ document.getElementById("strategyId").value
				+ "&subjectType=计算题";
		var xhr = createXmlHttpRequest();
		xhr.open('post', url, true);
		xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
		xhr.send(data);
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var json = JSON.parse(this.responseText);
				if (json != undefined && json != null) {
					var countQuestionNumber = json.list.length;
					var countQuestionScore = json.singleScore * json.list.length;
					document.getElementById("head5").innerHTML = "<h2>计算题</h2>"
							+ "<p>"
							+ "<span>共</span>"
							+ "<i class='content_lit'>"+countQuestionNumber+"</i>"
							+ "<span>题，</span>"
							+ "<span>合计</span>"
							+ "<i class='content_fs'>"+countQuestionScore+"</i>"
							+ "<span>分</span>"
							+ "</p>";
					countQuestion(json);
				}
			}
		};
	}
	
	function countQuestion(json) {
		var countQuestionNumber = json.list.length;
		var countQuestionScore = json.singleScore;
		for (var i = 0; i < countQuestionNumber; i++) {
			var questionTitle = json.list[i].content;
			var fill = document.getElementById("count");
			fill.innerHTML = "<li id='qu_" + (frontQuestionNumber+i+1) + "'></li>";
			document.getElementById("qu_"
					+ (frontQuestionNumber+i+1) + "").innerHTML = "<div class='test_content_nr_tt'>"
					+ "<i>"+ (frontQuestionNumber+i+1)
					+ "</i><span>("+ countQuestionScore+ "分)</span>"
					+ questionTitle
					+ "</div>"
					+ "<div class='test_content_nr_main'>"
					+ "<li class='clear'>"
					+ "<input type='text' class='radioOrCheck text' name='answer"
					+ (frontQuestionNumber+i+1)
					+ "' style='width= '20em' margin-top= '8px''"
					+ "id='answer_"+(frontQuestionNumber+i+1)+"'/>"
					+ "</li>"
					+ "</div>";
		}
		frontQuestionNumber += countQuestionNumber;
		shortAnswer();
	}
	
	function shortAnswer() {
		var url = "${pageContext.request.contextPath}/test/singleChoice";
		var data = "examId="+ document.getElementById("examId").value
				+ "&strategyId="+ document.getElementById("strategyId").value
				+ "&subjectType=简答题";
		var xhr = createXmlHttpRequest();
		xhr.open('post', url, true);
		xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
		xhr.send(data);
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var json = JSON.parse(this.responseText);
				if (json != undefined && json != null && json.list.length != 0) {
					var countQuestionNumber = json.list.length;
					var countQuestionScore = json.singleScore * countQuestionNumber;
					document.getElementById("head6").innerHTML = "<h2>简答题</h2>"
							+ "<p>"
							+ "<span>共</span>"
							+ "<i class='content_lit'>"+countQuestionNumber+"</i>"
							+ "<span>题，</span>"+"<span>合计</span>"
							+ "<i class='content_fs'>"+countQuestionScore+"</i>"
							+ "<span>分</span>"
							+ "</p>";

					shortAnswerQuestion(json);

				}
			}
		}
	}
	
	function shortAnswerQuestion(json) {
		var shortAnswerQuestionNumber = json.list.length;
		var shortAnswerQuestionScore = json.singleScore;
		for (var i = 0; i < shortAnswerQuestionNumber; i++) {
			var questionTitle = json.list[i].content;
			var shortAnswer = document.getElementById("shortAnswer");
			shortAnswer.innerHTML += "<li id='qu_"+ (frontQuestionNumber+i+1) + "'></li>";
			document.getElementById("qu_"
					+ (frontQuestionNumber+i+1) + "").innerHTML = "<div class='test_content_nr_tt'>"
					+ "<i>"+ (frontQuestionNumber+i+1)
					+ "</i><span>("+ shortAnswerQuestionScore+ "分)</span>"
					+ questionTitle
					+ "</div>"
					+ "<div class='test_content_nr_main'>"
					+ "<textarea name='answer"+ (frontQuestionNumber+i+1)
					+ "' id='answer_"
					+ (frontQuestionNumber+i+1)
					+ "' cols='100%' rows='10'></textarea>"
					+ "</div>";
		}
	}
	
</script>
</head>

<body onload="singleChoice()">
	<div class="main">
		<!--nr start-->
		<!-- 单选题 -->
		<div class="test_main">
			<div class="nr_left">
				<div class="test">
					<form action="" method="post">
						<div class="test_title">
							<input type="button" name="test_jiaojuan" value="交卷">
						</div>
						<!-- 单选题头部 -->
						<div class="test_content">
							<div class="test_content_title" id="head1">
							</div>
						</div>
						<!-- 单选题题目 -->
						<div class="test_content_nr">
							<ul id="radio"></ul>
						</div>
						<!-- 多选题 -->
						<div class="test_content">
							<div class="test_content_title" id="head2"></div>
						</div>
						<!-- 多选题题目 -->
						<div class="test_content_nr">
							<ul id="checkbox"></ul>
						</div>
						<!-- 填空题  -->
						<div class="test_content">
							<div class="test_content_title" id="head3"></div>
						</div>
						<div class="test_content_nr">
							<ul id="Block"></ul>
						</div>
						<!--判断题 -->
						<div class="test_content">
							<div class="test_content_title" id="head4"></div>
						</div>
						<div class="test_content_nr">
							<ul id="judgment"></ul>
						</div>
						<!-- 计算题 -->
						<div class="test_content">
							<div class="test_content_title" id="head5"></div>
						</div>
						<div class="test_content_nr">
							<ul id="count"></ul>
						</div>
						<!-- 简答题 -->
						<div class="test_content">
							<div class="test_content_title" id="head6"></div>
						</div>
						<div class="test_content_nr">
							<ul id="shortAnswer"></ul>
						</div>
					</form>
				</div>
			</div>
			
		<div class="foot"></div>
	</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
	
<input type="text" hidden="hidden" id="examId" name="examId" value="${examId }">
<input type="text" hidden="hidden" id="strategyId" name="strategyId" value="${strategyId }">
</body>
</html>