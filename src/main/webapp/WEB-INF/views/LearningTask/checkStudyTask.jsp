<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线学习管理</title>
<style>
* {
	margin: 0;
	padding: 0;
}

.header {
	height: 50px;
}

.content {
	text-align: center;
}

a {
	color: blue;
}

.selected {
	background-color: yellowgreen;
}
</style>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/JFTable.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/JFButtonList.css">

<script type="text/javascript">
	function getAllStudyTask() {
		document.getElementById("title").innerText = "我的学习任务";

		document.getElementById("1").className = "selected";
		document.getElementById("2").className = "";
		document.getElementById("3").className = "";
		var userName = "test";
		var xhr = window.XMLHttpRequest ? new XMLHttpRequest()
				: new ActiveXObject("Microsoft.XMLHTTP");
		var url = "getStudyTask";
		xhr.open("post", url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("userName=" + userName);
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("studyTaskTable").innerHTML = "<tr>"
						+ "<th>学习任务名称</th>" + "<th>开始日期</th>" + "<th>结束日期</th>"
						+ "<th>查看课件</th>" + "<th>完成情况</th>" + "</tr>";
				var js = this.responseText;
				var resultArray = JSON.parse(js);
				for (var j = 0; j < resultArray.length; j++) {
					var newTr = document.createElement('tr');
					var taskName = document.createElement('td');
					var startDate = document.createElement('td');
					var endDate = document.createElement('td');
					var courseware = document.createElement('td');
					var isFinished = document.createElement('td');

					taskName.innerText = resultArray[j].taskName;
					startDate.innerText = new Date(resultArray[j].startTime)
							.toLocaleDateString();
					endDate.innerText = new Date(resultArray[j].startTime)
							.toLocaleDateString();
					for (var i = 0; i < resultArray[j].coursewareUrl.length; i++) {
						var br = document.createElement('br');
						var newCourseware = document.createElement('a');
						newCourseware.href = resultArray[j].coursewareUrl[i];
						newCourseware.innerText = resultArray[j].coursewareUrl[i];
						courseware.appendChild(newCourseware);
						courseware.appendChild(br);
					}
					isFinished.innerText = resultArray[j].isComplete ? "已完成"
							: "未完成";
					newTr.appendChild(taskName);
					newTr.appendChild(startDate);
					newTr.appendChild(endDate);
					newTr.appendChild(courseware);
					newTr.appendChild(isFinished);
					document.getElementById("studyTaskTable")
							.appendChild(newTr);
				}
			}
		}
	}

	function getFinishedStudyTask() {
		document.getElementById("title").innerText = "已完成的学习任务";
		document.getElementById("1").className = "";
		document.getElementById("2").className = "selected";
		document.getElementById("3").className = "";
		var userName = "test";
		var xhr = window.XMLHttpRequest ? new XMLHttpRequest()
				: new ActiveXObject("Microsoft.XMLHTTP");
		var url = "getStudyTask";
		xhr.open("post", url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("userName=" + userName);
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("studyTaskTable").innerHTML = "<tr>"
						+ "<th>学习任务名称</th>" + "<th>开始日期</th>" + "<th>结束日期</th>"
						+ "<th>查看课件</th>" + "<th>完成情况</th>" + "</tr>";
				var js = this.responseText;
				var resultArray = JSON.parse(js);
				for (var j = 0; j < resultArray.length; j++) {
					if (resultArray[j].isComplete) {
						var newTr = document.createElement('tr');
						var taskName = document.createElement('td');
						var startDate = document.createElement('td');
						var endDate = document.createElement('td');
						var courseware = document.createElement('td');
						var isFinished = document.createElement('td');

						taskName.innerText = resultArray[j].taskName;
						startDate.innerText = new Date(resultArray[j].startTime)
								.toLocaleDateString();
						endDate.innerText = new Date(resultArray[j].startTime)
								.toLocaleDateString();
						for (var i = 0; i < resultArray[j].coursewareUrl.length; i++) {
							var br = document.createElement('br');
							var newCourseware = document.createElement('a');
							newCourseware.href = resultArray[j].coursewareUrl[i];
							newCourseware.innerText = resultArray[j].coursewareUrl[i];
							courseware.appendChild(newCourseware);
							courseware.appendChild(br);
						}
						isFinished.innerText = resultArray[j].isComplete ? "已完成"
								: "未完成";
						newTr.appendChild(taskName);
						newTr.appendChild(startDate);
						newTr.appendChild(endDate);
						newTr.appendChild(courseware);
						newTr.appendChild(isFinished);
						document.getElementById("studyTaskTable").appendChild(
								newTr);
					}
				}
			}
		}
	}

	function getOngoingStudyTask() {
		document.getElementById("title").innerText = "进行中的学习任务";

		document.getElementById("1").className = "";
		document.getElementById("2").className = "";
		document.getElementById("3").className = "selected";

		var userName = "test";
		var xhr = window.XMLHttpRequest ? new XMLHttpRequest()
				: new ActiveXObject("Microsoft.XMLHTTP");
		var url = "getStudyTask";
		xhr.open("post", url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("userName=" + userName);
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("studyTaskTable").innerHTML = "<tr>"
						+ "<th>学习任务名称</th>" + "<th>开始日期</th>" + "<th>结束日期</th>"
						+ "<th>查看课件</th>" + "<th>完成情况</th>" + "</tr>";
				var js = this.responseText;
				var resultArray = JSON.parse(js);
				for (var j = 0; j < resultArray.length; j++) {
					if (resultArray[j].isComplete == 0) {
						var newTr = document.createElement('tr');
						var taskName = document.createElement('td');
						var startDate = document.createElement('td');
						var endDate = document.createElement('td');
						var courseware = document.createElement('td');
						var isFinished = document.createElement('td');

						taskName.innerText = resultArray[j].taskName;
						startDate.innerText = new Date(resultArray[j].startTime)
								.toLocaleDateString();
						endDate.innerText = new Date(resultArray[j].startTime)
								.toLocaleDateString();
						for (var i = 0; i < resultArray[j].coursewareUrl.length; i++) {
							var br = document.createElement('br');
							var newCourseware = document.createElement('a');
							newCourseware.href = resultArray[j].coursewareUrl[i];
							newCourseware.innerText = resultArray[j].coursewareUrl[i];
							courseware.appendChild(newCourseware);
							courseware.appendChild(br);
						}
						isFinished.innerText = resultArray[j].isComplete ? "已完成"
								: "未完成";
						newTr.appendChild(taskName);
						newTr.appendChild(startDate);
						newTr.appendChild(endDate);
						newTr.appendChild(courseware);
						newTr.appendChild(isFinished);
						document.getElementById("studyTaskTable").appendChild(
								newTr);
					}
				}
			}
		}
	}
</script>

</head>
<body onload="getAllStudyTask()">

	<div class="header">
		<ul class="navtablist">
			<li style="width: 33.33%"><a id="1" href="javascript:void(0)"
				onclick="getAllStudyTask()">我的学习任务</a></li>
			<li style="width: 33.33%"><a id="2" href="javascript:void(0)"
				onclick="getFinishedStudyTask()">已完成的学习任务</a></li>
			<li style="width: 33.33%"><a id="3" href="javascript:void(0)"
				onclick="getOngoingStudyTask()">进行中的学习任务</a></li>
		</ul>
	</div>

	<div class="content">
		<h1 id="title"></h1>
		<table id="studyTaskTable">

		</table>
	</div>
</body>
</html>