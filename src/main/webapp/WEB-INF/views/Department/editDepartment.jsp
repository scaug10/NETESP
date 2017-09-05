<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改单位</title>
</head>
<body>
	<div class='content'>
		<table>
			<tr>
				<td>单位ID:<input type="text" id="departmentId"
					value="${Department.departmentId}"></td>
			</tr>
			<tr>
				<td>单位名:<input type="text" id="name" value="${Department.name}"></td>
			</tr>
			<tr>
				<td><input type="button" value="确定" onclick="edit()"></td>
			</tr>
		</table>
	</div>
</body>
<script type="text/javascript">
	function edit() {
		var departmentId = document.getElementById("departmentId").value;
		var name = document.getElementById("name").value;
		var url = "editDepartment";
		var xhr = createXmlHttpRequest();
		xhr.open('post', url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("departmentId=" + departmentId + "&name=" + name);/*发送http body*/
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				location.reload();
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
</script>
</html>