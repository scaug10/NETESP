<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询列表</title>
</head>
<body>
	<form
		action="${pageContext.request.contextPath }/queryTestTables.action"
		method="post">
		查询条件：
		<table width="100%" border=1>
			<tr>
				<td><input type="submit" value="查询" /></td>
			</tr>
		</table>
		列表：
		<table width="100%" border=1>
			<tr>
				<td>姓名</td>
				<td>性别</td>
				<td>生日</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${testTables }" var="testTable">
				<tr>
					<td>${testTable.testName }</td>
					<td>${testTable.testSex }</td>
					<td><fmt:formatDate value="${testTable.birthday}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td><a
						href="${pageContext.request.contextPath }/updateTestTable?id=${testTable.testId}">修改</a>
						<a
						href="${pageContext.request.contextPath }/deleteTestTable?id=${testTable.testId}">删除</a>
					</td>

				</tr>
			</c:forEach>

		</table>
	</form>
	
	<br><br><br>
	
	<form action="${pageContext.request.contextPath}/saveTestTable" method="post">
		姓名：<input type="text" name="testName" /><br>
		性别：<input type="text" name="testSex" /><br>
		生日：<input type="text" name="birthday" value="yyyy-MM-dd HH:mm:ss"/><br>
		<input type="submit" name="submit" /><br>
	</form>
	
</body>

</html>