<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改信息</title>

</head>
<body>

	<form id="testTable"
		action="${pageContext.request.contextPath }/editTestTable"
		method="post">
		<input type="hidden" name="testId" value="${testTable.testId }" /> 修改信息：
		<table width="100%" border=1>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="testName" value="${testTable.testName }" /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="text" name="testSex"
					value="${testTable.testSex }" /></td>
			</tr>
<!-- 			<tr> -->
<!-- 				<td>生日</td> -->
<!-- 				<td><input type="text" name="birthday" -->
<%-- 					value="<fmt:formatDate value="${testTable.birthday}" pattern="yyyy-MM-dd HH:mm:ss"/>" /></td> --%>
<!-- 			</tr> -->
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>

	</form>
</body>

</html>