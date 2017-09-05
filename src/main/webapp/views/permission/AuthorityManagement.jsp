<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>系统权限管理</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login/reset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login/css.css" />
<style>
button {
	width: 139px;
	height: 40px;
	font-size: 20px;
	background-color: #00FF00;
	margin-left: 20px;
	margin-top: 10px;
}

table {
	margin-left: 20px;
	margin-top: 20px;
}

td {
	width: 300px;
	height: 30px;
	text-align: center;
	line-height: 30px;
}

a {
	cursor: pointer;
}
</style>
<script>
	function createXmlHttpRequest() {
		if (window.ActiveXObject) { //如果是IE浏览器
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) { //非IE浏览器
			return new XMLHttpRequest();
		}
	}
	function delete1() {
		var id = document.getElementsByName('permissionIdList');
		var list = new Int8Array(id.length);
		list.fill(-1);
		var flag = 0;
		for (var i = 0; i < id.length; i++) {
			if (id[i].checked) {
				list[i] = (parseInt(id[i].value));
				flag = 1;
			}
		}
		if (flag == 0) {
			alert("你没有选中要删除的数据，删除失败！");
			return false;
		}
		var r = confirm("确定删除这几行数据？");
		if (r == true) {
			var url = "${pageContext.request.contextPath}/permission/deleteManyPermission";
			var xmlhttp = createXmlHttpRequest();
			xmlhttp.open("post", url, true);
			xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xmlhttp.send("list=" + list);
			xmlhttp.onreadystatechange = function() {
				if (this.status == 200 && this.readyState == 4) {
					if (this.responseText.trim() == "") {
						alert("删除失败！");
					} else {
						alert("删除成功！");
						getPermissionList();
					}
				}
			}
		} else {
			return false;
		}
	}
	function delete2({permissionId:permissionId}) {
		var r = confirm("确定删除这行数据？");
		if (r == true) {
			var url = "${pageContext.request.contextPath}/permission/deleteOnePermission";
			var xmlhttp = createXmlHttpRequest();
			xmlhttp.open("post", url, true);
			xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xmlhttp.send("permissionId=" + permissionId);
			xmlhttp.onreadystatechange = function() {
				if (this.status == 200 && this.readyState == 4) {
					if (this.responseText.trim() == "") {
						alert("删除失败！");
					//getPermissionList();
					} else {
						alert("删除成功！");
						getPermissionList();
					}
				}
			}
		} else {
			return false;
		}
	}
	function search2({permissionId:permissionId,name:name}) {
		window.location.href='${pageContext.request.contextPath}/permission/jumpModifyPermissionPage?permissionId='+permissionId+"&name="+name;
	}
	function givePermission({permissionId:permissionId,name:name}) {
		window.location.href='${pageContext.request.contextPath}/permission/jumpPermissionDistributePage?permissionId='+permissionId+"&name="+name;
	}
	function getPermissionList() {
		var url = "${pageContext.request.contextPath}/permission/searchPermissionList";
		var xmlhttp = createXmlHttpRequest();
		xmlhttp.open("post", url, true);
		xmlhttp.send();
		xmlhttp.onreadystatechange = function() {
			if (this.status == 200 && this.readyState == 4) {
				var jsonObject = this.responseText;
				var result = eval("(" + jsonObject + ")"); //json转为js数组
				var str = ""
				for (var i = 0; i < result.length; ++i) {
					var permissionId = result[i].permissionId;
					var name = result[i].name;
					str += "<tr>\n" +
						"	<td>" + "<input type='checkbox' name='permissionIdList' value='" + permissionId + "'/>" + "</td>\n" +
						"	<td>" + name + "</td>\n" +
						"	<td>" + "<a onclick=\"search2({ permissionId:'" + permissionId +"',name:'"+name+"'})\"><img src=\"${pageContext.request.contextPath}/img/login/update.png\"></a>"  +
						"<a  onclick=\"delete2({permissionId:'" + permissionId + "'})\"><img src=\"${pageContext.request.contextPath}/img/login/delete.png\"></a>" + 
						"<a onclick=\"givePermission({ permissionId:'" + permissionId +"',name:'"+name+"'})\"><img src=\"${pageContext.request.contextPath}/img/login/coin07.png\"></a>"+
					"</td>\n" +
					"</tr>"
				}
				document.getElementById("tbody").innerHTML = str;
			}
		}
	}
</script>
</head>
<body onload="getPermissionList()">
	<div id="pageAll">
		<!--导航栏-->
		<div class="pageTop">
			<div class="page" style="width: 1200px;">
				<img src="${pageContext.request.contextPath}/img/login/coin02.png" /><span><a
					href="../main.html">首页(还未实现)</a>&nbsp;-&nbsp; 系统权限管理</span>
			</div>
		</div>
	</div>
	<!--功能栏-->
	<div style="width: 800px;">
		<button
			onclick="window.location.href='${pageContext.request.contextPath}/permission/jumpInsertPermissionPage'">新增权限</button>
		<button
			onclick="window.location.href='${pageContext.request.contextPath}/permission/jumpSearchPermissionPage'">查询权限</button>
		<button onclick="delete1()">批量删除</button>
	</div>
	<!--内容页-->
	<div style="width: 1000px;">
		<div>
			<table>
				<tr style="background-color: #00FF00;">
					<td>&nbsp;</td>
					<td>权限名称</td>
					<td>操作</td>
				</tr>
				<tbody id="tbody">

				</tbody>
			</table>
		</div>
	</div>
</body>
</html>

