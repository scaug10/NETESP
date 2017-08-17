<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		alert("test");
			$("#pid").html("Success");
			$.ajax({
	            url: "${pageContext.request.contextPath }/testTableDetail",
	            data: {"id":1},
	            dataType: "json",
// 	            async: false,//同步  
	            type: "GET", //默认值便是GET
	            success: function (json) {
	            	$("#pid").html("Yesss");
	            	alert(json);
	                if(json != undefined && json != null){
	                	$("#pid").html("YYesss");
	                    $tr = $("<tr></tr>");
	                    $td1 = $("<td></td>");
	                    $td2 = $("<td></td>");
	                    $td3 = $("<td></td>");
	                    $tr.append($td1.clone().text(json.testName));
	                    $tr.append($td2.clone().text(json.testSex));
	                    $tr.append($td3.clone().text(json.birthday));
	                    $tr.appendTo($("#tbody"));
	                }
	            },
	            error:function(data){
	            	$("#pid").html("No");
	            }
	        })
	})
</script>

<body>

	<form>
		<input name="id" value="${id }" type="text">
		<table>
			<tr>
				<td>姓名</td>
				<td>性别</td>
				<td>生日</td>
			<tr>
			<tbody id="tbody"></tbody>
		</table>
		<p id="pid" >2345</p>
	</form>

</body>
</html>