<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>单位详情页</title>
<script type="text/javascript">
	function edit(departmentId,name){
		var url = "edit";
	/* 	"=departmentId&name=name" */
		var xhr = createXmlHttpRequest();
        xhr.open("post", url, true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.send("departmentId="+departmentId+"&name="+name);/*发送http body*/
        xhr.onreadystatechange = function () {
        	 if(this.readyState == 4 && this.status == 200){
					document.write(this.responseText);
      		 }
		}
	}
	
	function del(departmentId){
		var url = "deleteDepartment";
		var message = "是否删除？";
		if(confirm(message)){
			 var xhr = createXmlHttpRequest();
	            xhr.open('post', url, true);
	            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	            xhr.send("departmentId="+departmentId);/*发送http body*/
	            xhr.onreadystatechange = function () {
	           	 if(this.readyState == 4 && this.status == 200){
	           		location.reload();
	         		 }
	   		}
		}
	}
	
	function createXmlHttpRequest(){
        if(window.ActiveXObject){ //如果是IE浏览器
            return new ActiveXObject("Microsoft.XMLHTTP");
        }else if(window.XMLHttpRequest){ //非IE浏览器
            return new XMLHttpRequest();
        }
    }
</script>
</head>
<body>
	<table border=1>
		<tr>
			<td>单位ID</td>
			<td>单位名</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list }" var="list">
			<tr>
				<td>${list.departmentId }</td>
				<td>${list.name }</td>
				<td><a href="javascript:void(0)"
					onclick="edit('${list.departmentId }', '${list.name }')">修改</a> <a
					href="javascript:void;" onclick="del(${list.departmentId })">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>

</html>