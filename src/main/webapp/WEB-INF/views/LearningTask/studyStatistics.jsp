<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学习统计</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/JFTable.css">
<style type="text/css">
#departmentlisttitle {
	margin-left: 1%;
}

#departmentlist {
	height: 30px;
}
</style>
</head>
<body>

	<div id="department">
		<span id="departmentlisttitle">部门：</span> <select id="departmentlist">
			<option value="0">请选择部门</option>
			<c:forEach var="item" items="${department}">
				<option value="${item.departmentId}">${item.name}</option>
			</c:forEach>
		</select>
	</div>

	<div id="departmentdetail" style="text-align: center">
		<h1>学习任务完成情况</h1>
		<table id="studyTaskList">

		</table>
	</div>

</body>

<script type="text/javascript">
	document.getElementById("departmentlist").onchange = function() {
		if (document.getElementById("departmentlist").value == 0) {
			document.getElementById("studyTaskList").innerHTML = "";
		} else {
			var xhr = window.XMLHttpRequest ? new XMLHttpRequest()
					: new ActiveXObject("Microsoft.XMLHTTP");
			var url = "getDepartmentLearningTask";
			xhr.open("post", url, true);
			xhr.setRequestHeader('Content-Type',
					'application/x-www-form-urlencoded');
			xhr.send("departmentId="
					+ document.getElementById("departmentlist").value);
			xhr.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {

					document.getElementById("studyTaskList").innerHTML = "<tr><th>学习任务</th><th>完成情况</th><th>学习人员</th><th>学习总时长</th></tr>";

					var jsonObject = this.responseText;
					var resultArray = JSON.parse(jsonObject);
					for (var i = 0; i < resultArray.length; i++) {
						var newTr = document.createElement('tr');
						var td0 = document.createElement('td');
						var td1 = document.createElement('td');
						var td2 = document.createElement('td');
						var td3 = document.createElement('td');
						td0.innerHTML = resultArray[i].taskName;
						var endTime = new Date(resultArray[i].endTime);
						var date = new Date();
						if (date > endTime) {
							td1.innerHTML = '已完成';
						} else {
							td1.innerHTML = '未完成';
						}
						td2.innerHTML = resultArray[i].userName[0] + "等"
								+ resultArray[i].userName.length + "人";
						td3.innerHTML = resultArray[i].endTime;
						if (date < endTime) {
							td3.innerHTML = ((date - resultArray[i].startTime) / 3600000)
									.toFixed(0)
									+ "h";
						} else {
							td3.innerHTML = ((endTime - resultArray[i].startTime) / 3600000)
									.toFixed(0)
									+ "h";
						}
						newTr.appendChild(td0);
						newTr.appendChild(td1);
						newTr.appendChild(td2);
						newTr.appendChild(td3);
						document.getElementById("studyTaskList").appendChild(
								newTr);
					}
				}
			}
		}
	}
</script>

</html>