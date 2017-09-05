<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学习任务管理</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/JFButtonList.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/JFTable.css">
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

.content {
	text-align: center;
}

#createbox {
	border: 1px darkgreen solid;
	width: 400px;
	height: 250px;
	background-color: #bfa;
	position: fixed;
	margin: auto;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
	text-align: center;
}

#modifybox {
	border: 1px darkgreen solid;
	width: 400px;
	height: 280px;
	background-color: #bfa;
	position: fixed;
	margin: auto;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
	text-align: center;
}

#selectstuff {
	border: 1px darkgreen solid;
	width: 400px;
	height: 400px;
	background-color: #bfa;
	position: fixed;
	margin: auto;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
	overflow: auto;
}

#selectcourseware {
	border: 1px darkgreen solid;
	width: 400px;
	height: 400px;
	background-color: #bfa;
	position: fixed;
	margin: auto;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
	overflow: auto;
}

.input {
	height: 25px;
	margin: 2px 5%;
	width: 90%;
}

button {
	margin: 5px;
	height: 30px;
	width: 60px;
}
</style>

</head>
<body onload="loadStudyTask()">
	<ul class="navtablist">
		<li style="width: 33.33%"><a href="javascript:void(0)"
			onclick="createStudyTask()" class="navtablink">增加学习任务</a></li>
		<li style="width: 33.33%"><a href="javascript:void(0)"
			onclick="deleteStudyTask()" class="navtablink">删除学习任务</a></li>
		<li style="width: 33.33%"><a href="javascript:void(0)"
			onclick="searchByKeyword()" class="navtablink">查询学习任务</a></li>

	</ul>

	<div class="content">

		<h1 style="font-size: 22px;">当前学习任务</h1>
		<table id="studyTaskTable">

		</table>

	</div>

	<div id="createbox" hidden>
		<h1 style="font-size: 20px">创建学习任务</h1>
		<table>
			<tr>
				<th>任务名称</th>
				<td><input id="taskname" class="input"></td>
			</tr>
			<tr>
				<th>开始日期</th>
				<td><input id="startdate" class="input" type="date"></td>
			</tr>
			<tr>
				<th>结束日期</th>
				<td><input id="enddate" class="input" type="date"></td>
			</tr>
			<tr>
				<th>参与人员</th>
				<td><button class="input" onclick="showStuffSelect()">选择参与人员</button></td>
			</tr>
			<tr>
				<th>学习课件</th>
				<td><button class="input" onclick="showCoursewareSelect()">选择学习课件</button></td>
			</tr>
		</table>
		<button onclick="createRequest()">新建</button>
		<button onclick="closeCreateBox()">取消</button>
	</div>
	<div id="selectstuff" hidden>
		<a href="javascript:void(0)" onclick="backToCreateBox()">&lt返回</a>
		<table>
			<tr>
				<th style="width: 4em"><input class="selectall" type="checkbox"
					onclick="selectAll(this.checked, 0)">全选</th>
				<th>部门</th>
			</tr>
			<c:forEach items="${department}" var="item">
				<tr>
					<th><input class="departmentinput"
						id="department${item.departmentId}" type="checkbox"></th>
					<th>${item.name}</th>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div id="selectcourseware" hidden>
		<a href="javascript:void(0)" onclick="backToCreateBox()">&lt返回</a>
		<table>
			<tr>
				<th style="width: 4em"><input class="selectall" type="checkbox"
					onclick="selectAll(this.checked, 1)">全选</th>
				<th>课件</th>
			</tr>
			<c:forEach items="${courseware}" var="item">
				<tr>
					<th><input class="coursewareinput"
						id="courseware${item.coursewareId}" type="checkbox"></th>
					<th>${item.coursewareName}</th>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div id="modifybox" hidden>
		<h1 style="font-size: 20px">修改学习任务</h1>
		<table>
			<tr>
				<th>任务ID</th>
				<td><input id="modifyid" class="input" disabled></td>
			</tr>
			<tr>
				<th>任务名称</th>
				<td><input id="newtaskname" class="input"></td>
			</tr>
			<tr>
				<th>开始日期</th>
				<td><input id="newestartdate" class="input" type="date"></td>
			</tr>
			<tr>
				<th>结束日期</th>
				<td><input id="newenddate" class="input" type="date"></td>
			</tr>
			<tr>
				<th>参与人员</th>
				<td><button class="input" onclick="showStuffSelect()">选择参与人员</button></td>
			</tr>
			<tr>
				<th>学习课件</th>
				<td><button class="input" onclick="showCoursewareSelect()">选择学习课件</button></td>
			</tr>
		</table>
		<button onclick="modifyRequest()">修改</button>
		<button onclick="closeModifyBox()">取消</button>
	</div>

</body>

<script type="text/javascript">
	/*需要隐藏操作的四个box*/
	var createBox = document.getElementById("createbox");
	var modifyBox = document.getElementById("modifybox");
	var stuffSelectBox = document.getElementById("selectstuff");
	var coursewareSelectBox = document.getElementById("selectcourseware");

	/*createbox里的三个参数*/
	var taskNameInput = document.getElementById("taskname");
	var startDateInput = document.getElementById("startdate");
	var endDateInput = document.getElementById("enddate");

	/*modifybox里的四个参数*/
	var newId = document.getElementById("modifyid");
	var newTaskNameInput = document.getElementById("newtaskname");
	var newStartDateInput = document.getElementById("newestartdate");
	var newEndDateInput = document.getElementById("newenddate");

	/*checkbox数组*/
	var studyTaskArray = document.getElementsByClassName("studyTaskInput");
	var departmentArray = document.getElementsByClassName("departmentinput");
	var coursewareArray = document.getElementsByClassName("coursewareinput");
	var selectAllArray = document.getElementsByClassName("selectall");

	/*判断是create还是modify的参数, 0为create, 1为modify*/
	var CorM;
	/*用于保存要修改项目的id*/
	var modifyId;

	/*异步获取学习计划*/
	function loadStudyTask() {
		var table = document.getElementById("studyTaskTable");
		table.innerHTML = "";
		table.innerHTML = "<tr>\n"
				+ "<th style=\"width: 3em\"><input id='selectAllDelete' onclick='selectAll(this.checked, 2)' type=\"checkbox\">全选</th>\n"
				+ "<th>任务名称</th>\n" + "<th>参与人员</th>\n" + "<th>开始日期</th>\n"
				+ "<th>结束日期</th>\n" + "<th>学习课件</th>\n"
				+ "<th style='width:3em;'>操作</th>"
		"</tr>";

		/*for (var i = 0; i < 5; i++){
		    var newTr = document.createElement('tr');
		    var newCheckBoxTd = document.createElement('td');
		    var newCheckBox = document.createElement('input');
		    newCheckBox.type = "checkbox";
		    newCheckBox.className = "studyTaskInput";
		    newCheckBox.onclick = selectAll(newCheckBox.checked, 2);
		    newCheckBoxTd.appendChild(newCheckBox);
		    var taskName = document.createElement('td');
		    var stuff = document.createElement('td');
		    var beginDate = document.createElement('td');
		    var endDate = document.createElement('td');
		    var courseware = document.createElement('td');
		    var operation = document.createElement('td');
		    newCheckBox.id = "delete" + i;
		    taskName.innerText = "test";
		    stuff.innerText = "tester";
		    beginDate.innerText = "tester";
		    endDate.innerText = "tester";
		    courseware.innerText = "tester";
		    operation.innerHTML = "<a class='modifybutton' onclick='modifyStudyTask(" + i + ")'>修改</a>"
		    newTr.appendChild(newCheckBoxTd);
		    newTr.appendChild(taskName);
		    newTr.appendChild(stuff);
		    newTr.appendChild(beginDate);
		    newTr.appendChild(endDate);
		    newTr.appendChild(courseware);
		    newTr.appendChild(operation)
		    table.appendChild(newTr);
		}*/

		var xhr = window.XMLHttpRequest ? new XMLHttpRequest()
				: new ActiveXObject("Microsoft.XMLHTTP");
		var url = "getAllLearningTask";
		xhr.open("post", url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send();
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var jsonObject = this.responseText;
				var resultArray = JSON.parse(jsonObject);
				for (var i = 0; i < resultArray.length; i++) {
					var newTr = document.createElement('tr');
					var newCheckBoxTd = document.createElement('td');
					var newCheckBox = document.createElement('input');
					newCheckBox.type = "checkbox";
					newCheckBox.className = "studyTaskInput";
					newCheckBox.onclick = selectAll(newCheckBox.checked, 2);
					newCheckBoxTd.appendChild(newCheckBox);
					var taskName = document.createElement('td');
					var stuff = document.createElement('td');
					var beginDate = document.createElement('td');
					var endDate = document.createElement('td');
					var courseware = document.createElement('td');
					var operation = document.createElement('td');
					newCheckBox.id = "course" + resultArray[i].learningTaskId;
					taskName.innerText = resultArray[i].taskName;
					for (var j = 0; j < resultArray[i].departmentName.length; j++) {
						stuff.innerText += resultArray[i].departmentName[j];
						if (j != resultArray[i].departmentName.length - 1)
							stuff.innerText += "、";
					}
					beginDate.innerText = new Date(resultArray[i].startTime)
							.toLocaleString('chinese', {
								hour12 : false
							});
					endDate.innerText = new Date(resultArray[i].endTime)
							.toLocaleString('chinese', {
								hour12 : false
							});
					for (var j = 0; j < resultArray[i].coursewareUrl.length; j++) {
						courseware.innerHTML += "<a target='_blank' href='"+resultArray[i].coursewareUrl[j]+"'>"
								+ resultArray[i].coursewareUrl[j] + "</a>";
						courseware.innerHTML += "<br>";
					}
					operation.innerHTML = "<a class='modifybutton' href='javascript:void(0)' onclick='modifyStudyTask("
							+ resultArray[i].learningTaskId + ")'>修改</a>"
					newTr.appendChild(newCheckBoxTd);
					newTr.appendChild(taskName);
					newTr.appendChild(stuff);
					newTr.appendChild(beginDate);
					newTr.appendChild(endDate);
					newTr.appendChild(courseware);
					newTr.appendChild(operation);
					table.appendChild(newTr);
				}
			}
		}
	}

	/*新建、修改学习计划*/
	function createStudyTask() {
		CorM = 0;
		createBox.hidden = false;
	}
	function modifyStudyTask(id) {
		modifyId = id;
		CorM = 1;
		//获取已勾选选项
		var xhr = window.XMLHttpRequest ? new XMLHttpRequest()
				: new ActiveXObject("Microsoft.XMLHTTP");
		var url = "queryLearningTask";
		xhr.open("post", url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("learningTaskId=" + modifyId);
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var jsonObject = this.responseText;
				var result = JSON.parse(jsonObject);
				newId.value = id;
				newTaskNameInput.value = result.taskName;
				/* var starttime = new Date(result.startTime);
				var endtime = new Date(result.endTime);
				var year = starttime.getFullYear();
				month = starttime.getMonth() + 1;
				if (month < 10) {
					month = "0" + month;
					console.log(1);
				}
				var date = starttime.getDate();
				if (date < 10) {
					date = "0" + date;
					console.log(1);
				}
				starttime = [ year, month, date ].join('-');
				year = endtime.getFullYear();
				month = endtime.getMonth() + 1;
				if (month.length == 1) {
					month = "0" + month;
				}
				date = endtime.getDate();
				if (date.length == 1) {
					date = "0" + date;
				}
				endtime = [ year, month, date ].join('-');
				console.log(starttime);
				console.log(endtime);
				newStartDateInput.value = starttime;
				newEndDateInput.value = endtime; */

				var timeString = new Date(result.startTime)
						.toLocaleDateString();
				var timeArray = timeString.split('/');
				if (timeArray[1].length == 1) {
					timeArray[1] = "0" + timeArray[1];
				}
				if (timeArray[2].length == 1) {
					timeArray[2] = "0" + timeArray[2];
				}
				var starttime = timeArray.join("-");

				timeString = new Date(result.endTime).toLocaleDateString();
				timeArray = timeString.split('/');
				if (timeArray[1].length == 1) {
					timeArray[1] = "0" + timeArray[1];
				}
				if (timeArray[2].length == 1) {
					timeArray[2] = "0" + timeArray[2];
				}
				var endtime = timeArray.join("-");
				newStartDateInput.value = starttime;
				newEndDateInput.value = endtime;
				//填充department数据
				for (var i = 0; i < result.departmentId.length; i++) {
					document.getElementById("department"
							+ result.departmentId[i]).checked = true;
				}
				//填充courseware数据
				for (var i = 0; i < result.coursewareId.length; i++) {
					document.getElementById("courseware"
							+ result.coursewareId[i]).checked = true;
				}
				modifyBox.hidden = false;
			}
		}
		newId.value = id;
		modifyBox.hidden = false;
	}
	function showStuffSelect() {
		createBox.hidden = true;
		modifyBox.hidden = true;
		stuffSelectBox.hidden = false;
	}
	function showCoursewareSelect() {
		createBox.hidden = true;
		modifyBox.hidden = true;
		coursewareSelectBox.hidden = false;
	}
	function backToCreateBox() {
		if (CorM == 0) {//如果是在执行create操作
			stuffSelectBox.hidden = true;
			coursewareSelectBox.hidden = true;
			createBox.hidden = false;
		} else if (CorM == 1) {//如果在执行modify操作
			backToModifyBox();
		}
	}
	function backToModifyBox() {
		stuffSelectBox.hidden = true;
		coursewareSelectBox.hidden = true;
		modifyBox.hidden = false;
	}
	function closeCreateBox() {
		/*删除列表各项*/
		taskNameInput.value = "";
		startDateInput.value = "";
		endDateInput.value = "";
		for (var i = 0; i < departmentArray.length; i++) {
			departmentArray[i].checked = false;
		}
		for (var i = 0; i < coursewareArray.length; i++) {
			coursewareArray[i].checked = false;
		}
		for (var i = 0; i < selectAllArray.length; i++) {
			selectAllArray[i].checked = false;
		}
		/*隐藏createbox*/
		createBox.hidden = true;
	}
	function closeModifyBox() {
		/*删除各项数据*/
		newTaskNameInput.value = "";
		newStartDateInput.value = "";
		newEndDateInput.value = "";
		for (var i = 0; i < departmentArray.length; i++) {
			departmentArray[i].checked = false;
		}
		for (var i = 0; i < coursewareArray.length; i++) {
			coursewareArray[i].checked = false;
		}
		for (var i = 0; i < selectAllArray.length; i++) {
			selectAllArray[i].checked = false;
		}
		/*隐藏modifybox*/
		modifyBox.hidden = true;
	}

	function selectAll(checked, number) {
		if (number == 0) {
			for (var i = 0; i < departmentArray.length; i++) {
				departmentArray[i].checked = checked;
			}
		} else if (number == 1) {
			for (var i = 0; i < coursewareArray.length; i++) {
				coursewareArray[i].checked = checked;
			}
		} else if (number == 2) {
			for (var i = 0; i < studyTaskArray.length; i++) {
				studyTaskArray[i].checked = checked;
			}
		}
	}
	function createRequest() {
		var taskName = document.getElementById("taskname").value;
		var startTime = document.getElementById("startdate").value
				+ " 00:00:00";
		var endTime = document.getElementById("enddate").value + " 23:59:59";

		var selectedDepartmentArray = new Array();
		var selectedCoursewareArray = new Array();
		for (var i = 0; i < departmentArray.length; i++) {
			if (departmentArray[i].checked) {
				selectedDepartmentArray.push(departmentArray[i].id
						.substring(10));
			}
		}
		for (var i = 0; i < coursewareArray.length; i++) {
			if (coursewareArray[i].checked) {
				selectedCoursewareArray.push(coursewareArray[i].id
						.substring(10));
			}
		}
		var xhr = window.XMLHttpRequest ? new XMLHttpRequest()
				: new ActiveXObject("Microsoft.XMLHTTP");
		var url = "saveLearningTask";
		xhr.open("post", url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("taskName=" + taskName + "&startTime=" + startTime
				+ "&endTime=" + endTime + "&departmentId="
				+ selectedDepartmentArray + "&coursewareId="
				+ selectedCoursewareArray);
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var result = this.responseText;
				if (result == 1) {
					alert("创建学习计划成功！");
					closeCreateBox();
					loadStudyTask();
				} else {
					alert("未知错误导致新增失败！");
				}
			}
		}
	}
	function modifyRequest() {
		var id = document.getElementById("modifyid").value;
		var taskName = document.getElementById("newtaskname").value;
		var startTime = document.getElementById("newestartdate").value
				+ " 00:00:00";
		var endTime = document.getElementById("newenddate").value + " 23:59:59";
		var departmentId = new Array();
		var coursewareId = new Array();
		for (var i = 0; i < departmentArray.length; i++) {
			if (departmentArray[i].checked) {
				departmentId.push(departmentArray[i].id.substring(10));
			}
		}
		for (var i = 0; i < coursewareArray.length; i++) {
			if (coursewareArray[i].checked) {
				coursewareId.push(coursewareArray[i].id.substring(10));
			}
		}
		var xhr = window.XMLHttpRequest ? new XMLHttpRequest()
				: new ActiveXObject("Microsoft.XMLHTTP");
		var url = "editLearningTask";
		xhr.open("post", url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("learningTaskId=" + id + "&taskName=" + taskName
				+ "&startTime=" + startTime + "&endTime=" + endTime
				+ "&departmentId=" + departmentId + "&coursewareId="
				+ coursewareId);
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				if (this.responseText == 1) {
					alert("修改成功！");
					loadStudyTask();
					closeModifyBox();
				} else if (this.responseText == 2) {
					alert("学习任务名已存在！");
				} else {
					alert("未知错误导致修改失败！");
				}
			}
		}

	}

	/*删除学习计划*/
	function deleteStudyTask() {
		var deleteArray = new Array();
		for (var i = 0; i < studyTaskArray.length; i++) {
			if (studyTaskArray[i].checked) {
				deleteArray.push(studyTaskArray[i].id.substring(6));
			}
		}
		if (deleteArray.length == 0) {
			alert("未选择需要删除的项目！");
		} else {
			if (confirm("是否删除该" + deleteArray.length + "项？")) {
				var xhr = window.XMLHttpRequest ? new XMLHttpRequest()
						: new ActiveXObject("Microsoft.XMLHTTP");
				var url = "deleteLearningTask";
				xhr.open("post", url, true);
				xhr.setRequestHeader('Content-Type',
						'application/x-www-form-urlencoded');
				xhr.send("learningTaskId=" + deleteArray);
				xhr.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
						if (this.responseText > 1) {
							alert("删除成功！");
						} else {
							alert("删除失败！");
						}
						loadStudyTask();
					}
				}
			}
		}
	}
	function searchByKeyword() {
		var keyword = prompt("请输入搜索关键词：");
		if (keyword.length != 0) {
			var table = document.getElementById("studyTaskTable");
			table.innerHTML = "";
			table.innerHTML = "<tr>\n"
					+ "<th style=\"width: 3em\"><input id='selectAllDelete' onclick='selectAll(this.checked, 2)' type=\"checkbox\">全选</th>\n"
					+ "<th>任务名称</th>\n" + "<th>参与人员</th>\n" + "<th>开始日期</th>\n"
					+ "<th>结束日期</th>\n" + "<th>学习课件</th>\n"
					+ "<th style='width:3em;'>操作</th>"
			"</tr>";
			var xhr = window.XMLHttpRequest ? new XMLHttpRequest()
					: new ActiveXObject("Microsoft.XMLHTTP");
			var url = "searchLearningTask";
			xhr.open("post", url, true);
			xhr.setRequestHeader('Content-Type',
					'application/x-www-form-urlencoded');
			xhr.send("taskName=" + keyword);
			xhr.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var jsonObject = this.responseText;
					var resultArray = JSON.parse(jsonObject);
					for (var i = 0; i < resultArray.length; i++) {
						var newTr = document.createElement('tr');
						var newCheckBoxTd = document.createElement('td');
						var newCheckBox = document.createElement('input');
						newCheckBox.type = "checkbox";
						newCheckBox.className = "studyTaskInput";
						newCheckBox.onclick = selectAll(newCheckBox.checked, 2);
						newCheckBoxTd.appendChild(newCheckBox);
						var taskName = document.createElement('td');
						var stuff = document.createElement('td');
						var beginDate = document.createElement('td');
						var endDate = document.createElement('td');
						var courseware = document.createElement('td');
						var operation = document.createElement('td');
						newCheckBox.id = "course"
								+ resultArray[i].learningTaskId;
						taskName.innerText = resultArray[i].taskName;
						for (var j = 0; j < resultArray[i].departmentName.length; j++) {
							stuff.innerText += resultArray[i].departmentName[j];
							if (j != resultArray[i].departmentName.length - 1)
								stuff.innerText += "、";
						}
						beginDate.innerText = new Date(resultArray[i].startTime)
								.toLocaleString('chinese', {
									hour12 : false
								});
						endDate.innerText = new Date(resultArray[i].endTime)
								.toLocaleString('chinese', {
									hour12 : false
								});
						for (var j = 0; j < resultArray[i].coursewareUrl.length; j++) {
							courseware.innerHTML += "<a target='_blank' href='"+resultArray[i].coursewareUrl[j]+"'>"
									+ resultArray[i].coursewareUrl[j] + "</a>";
							courseware.innerHTML += "<br>";
						}
						operation.innerHTML = "<a class='modifybutton' href='javascript:void(0)' onclick='modifyStudyTask("
								+ resultArray[i].learningTaskId + ")'>修改</a>"
						newTr.appendChild(newCheckBoxTd);
						newTr.appendChild(taskName);
						newTr.appendChild(stuff);
						newTr.appendChild(beginDate);
						newTr.appendChild(endDate);
						newTr.appendChild(courseware);
						newTr.appendChild(operation);
						table.appendChild(newTr);
					}
				}
			}
		}
	}
</script>

</html>