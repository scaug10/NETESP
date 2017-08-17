<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询列表</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/test/testTableList.jsp.js"></script>
</head>
<body>

<div class="testTableList">
	查询条件：
	<table width="100%" border=1>
		<tr>
			<td><input type="submit" value="查询" /></td>
		</tr>
	</table>
    <table width="100%" border=1>
        <thead>
            <tr>
                <th class="table-center">姓名</th>
                <th class="table-center">性别</th>
                <th class="table-center">生日</th>
                <th class="table-center">操作</th>
            </tr>
        </thead>
        <tbody id="tbody_data">
        </tbody>
    </table>
</div>
    
	<br>
	<br>
	<br>

	<form id="formId2"
		method="post">
		姓名：<input id="testName" type="text" name="testName" /><br> 性别：<input
			type="text" name="testSex" /><br> 生日：<input type="text"
			name="birthday" value="yyyy-MM-dd HH:mm:ss" /><br>
		<button type="button" id="submit2">提交</button>
	</form>

</body>

</html>