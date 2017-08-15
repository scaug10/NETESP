<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>单位详情页</title>
<script type="text/javascript">
	function edit(departmentId,name){
	    var newName = prompt("单位名：", name);
        if (newName.length != 0 && name!=newName) {
            var xhr = createXmlHttpRequest();
            var url = "checkDepartment";
            xhr.open('post', url, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send("name="+newName);/*发送http body*/
            xhr.onreadystatechange = function () {
                if(this.readyState == 4 && this.status == 200) {
                	if(this.responseText == 0){
                	    editDepartment(departmentId, newName);
					}
                else{
                    alert("单位已存在！");
                }
            }
        }
	}
	}
	function editDepartment(departmentId, name) {
        var url = "editDepartment";
        var xhr = createXmlHttpRequest();
        xhr.open('post', url, true);
        xhr.setRequestHeader('Content-Type',
            'application/x-www-form-urlencoded');
        xhr.send("departmentId=" + departmentId + "&name=" + name);
        /*发送http body*/
        xhr.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
            	alert("修改成功！");
				location.reload();
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
			    	alert("删除成功！");
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

    function addDepartment(name) {
        var xhr = createXmlHttpRequest();
        var url = "saveDepartment";
        xhr.open('post', url, true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.send("name="+name);/*发送http body*/
        xhr.onreadystatechange = function () {
            if(this.readyState == 4 && this.status == 200){
                alert("添加成功！");
                location.reload();
			}
		}
    }

    function check() {
		var name = prompt("请输入单位名:");
		if(name.length!=0){
            var xhr = createXmlHttpRequest();
            var url = "checkDepartment";
            xhr.open('post', url, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send("name="+name);/*发送http body*/
            xhr.onreadystatechange = function () {
                if(this.readyState == 4 && this.status == 200){
                    if(this.responseText == 0){
                        addDepartment(name);
					}else{
                        alert("单位已存在！");
					}
                }
            }
		}
    }
</script>
<style type="text/css">
button {
	margin-left: 10%;
	margin-bottom: 2px;
	height: 30px;
	width: 84px;
	font-family: "榛戜綋";
	font-size: 14px;
}

table {
	margin: 0px 10%;
	border-collapse: collapse;
	width: 80%;
}

td {
	border: 1px dimgray solid;
}

th {
	border: 1px dimgray solid;
	text-align: left;
	background-color: #bfa;
	color: darkblue;
}

a {
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}

.id {
	width: 80px;
}

.operation {
	width: 80px;
}
</style>
</head>

<!-- <link rel="stylesheet" type="text/css" href="../css/department.css" /> -->


<body>

	<button onclick="check()">添加单位</button>

	<table>
		<tr>
			<th class="id">单位ID</th>
			<th class="name">单位名</th>
			<th class="operation">操作</th>
		</tr>
		<c:forEach items="${list }" var="list">
			<tr>
				<td>${list.departmentId }</td>
				<td>${list.name }</td>
				<td><a href="javascript:void(0)"
					onclick="edit('${list.departmentId }', '${list.name }')">修改</a> <a
					href="javascript:void(0)" onclick="del(${list.departmentId })">删除</a>
				</td>
			</tr>
		</c:forEach>

		<!--<c:forEach items="${list }" var="list">-->
		<!--<tr>-->
		<!--<td>1</td>-->
		<!--<td>华南农业大学</td>-->
		<!--<td><a href="javascript:void(0)"-->
		<!--onclick="edit('${list.departmentId }', '${list.name }')">修改</a> <a-->
		<!--href="javascript:void(0)" onclick="del(${list.departmentId })">删除</a>-->
		<!--</td>-->
		<!--</tr>-->
		<!--<tr>-->
		<!--<td>11</td>-->
		<!--<td>华南农业大</td>-->
		<!--<td><a href="javascript:void(0)"-->
		<!--onclick="edit('${list.departmentId }', '${list.name }')">修改</a> <a-->
		<!--href="javascript:void(0)" onclick="del(${list.departmentId })">删除</a>-->
		<!--</td>-->
		<!--</tr>-->
		<!--<tr>-->
		<!--<td>111</td>-->
		<!--<td>华南农业</td>-->
		<!--<td><a href="javascript:void(0)"-->
		<!--onclick="edit('${list.departmentId }', '${list.name }')">修改</a> <a-->
		<!--href="javascript:void(0)" onclick="del(${list.departmentId })">删除</a>-->
		<!--</td>-->
		<!--</tr>-->
		<!--<tr>-->
		<!--<td>1111</td>-->
		<!--<td>农业大学</td>-->
		<!--<td><a href="javascript:void(0)"-->
		<!--onclick="edit('${list.departmentId }', '${list.name }')">修改</a> <a-->
		<!--href="javascript:void(0)" onclick="del(${list.departmentId })">删除</a>-->
		<!--</td>-->
		<!--</tr>-->
		<!--<tr>-->
		<!--<td>1111</td>-->
		<!--<td>华南农业大学软件学院</td>-->
		<!--<td><a href="javascript:void(0)"-->
		<!--onclick="edit('${list.departmentId }', '${list.name }')">修改</a> <a-->
		<!--href="javascript:void(0)" onclick="del(${list.departmentId })">删除</a>-->
		<!--</td>-->
		<!--</tr>-->
		<!--</c:forEach>-->

	</table>
</body>

</html>