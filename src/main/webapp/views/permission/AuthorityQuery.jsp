<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询权限</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login/reset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login/css.css" />
<style>
.boxbig {
	width: 80%;
	margin: auto;
}

.box {
	height: 20px;
	width: 200px;
}

p {
	margin-top: 10px;
}

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

	function checkName() {
		var div = document.getElementById("div1");
		div.innerHTML = "";
		var name1 = document.getElementById("authorityName1").value;
		if (name1.trim() == "") {
			div.innerHTML = "权限名称不能为空！";
			return false;
		}
		if (name1.length < 4 || name1.length > 16) {
			div.innerHTML = "权限名称的输入的长度1-50个字符！";
			return false;
		}
		var charname1 = name1.toLowerCase();
		for (var i = 0; i < name1.length; i++) {
			var charname = charname1.charAt(i);
			if (!(charname >= 'a' && charname <= 'z')) {
				div.innerHTML = "权限名称只能包含字母";
				return false;
			}
		}
		return true;

	}
	function delete2(permissionId) {
		alert(permissionId);
		var r = confirm("确定删除这行数据？");
		if (r == true) {
			var url = "${pageContext.request.contextPath}/permission/deleteOnePermission";
			var xmlhttp = createXmlHttpRequest();
			xmlhttp.open("post", url, true);
			xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xmlhttp.send("permissionId=" + permissionId);
			xmlhttp.onreadystatechange = function() {
				if (this.status == 200 && this.readyState == 4) {
					if(this.responseText.trim()==""){
 						alert("删除失败！");
 					}else{
 						alert("删除成功！");
 						query();
 					}
				} 
			}
		}else {
			return false;
		}
	}
	function query() {
		if (!checkName()) {
			return false;
		} else {
			var url = "${pageContext.request.contextPath}/permission/searchPermissionByName";
			var xmlhttp = createXmlHttpRequest();
			xmlhttp.open("post", url, true);
			xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xmlhttp.send("name=" + document.getElementById("authorityName1").value);
			xmlhttp.onreadystatechange = function() {
				if (this.status == 200 && this.readyState == 4) {
					var jsonObject = this.responseText;
					var result = eval("(" + jsonObject + ")"); //json转为js数组
					var str = "<tr style=\"background-color: #00FF00;\">\n" +
						"<td>权限名称</td>\n" +
						"<td>操作</td>\n" +
						"</tr>";
					for (var i = 0; i < result.length; ++i) {
						var permissionId = result[i].permissionId;
						var name = result[i].name;
						str += "<tr>\n" +
							"	<td>" + name + "</td>\n" +
							"	<td>" + "<a href=\"AuthorityRevise.html\"><img src=\"${pageContext.request.contextPath}/img/login/update.png\"></a>" + "&nbsp;" +
							"<a  onclick=\"delete2("+permissionId+")\"><img src=\"${pageContext.request.contextPath}/img/login/delete.png\"></a>" + "<a href=\"AuthoritySetUp.html\"><img src=\"${pageContext.request.contextPath}/img/login/coin07.png\"></a>"
						"</td>\n" +
						"</tr>"
					}
					document.getElementById("tbody").innerHTML = str;
				}
			}
		}
	}
</script>
</head>
<body>
	<div id="pageAll">
		<!--导航栏-->
		<div class="pageTop">
			<div class="page" style="width: 1200px;">
				<img src="${pageContext.request.contextPath}/img/login/coin02.png" /><span><a
					href="../main.html">首页（还未实现）</a>&nbsp;-&nbsp <a
					href="${pageContext.request.contextPath}/permission/jumpPermissionPage">系统权限管理</a>&nbsp;-&nbsp;查询权限</span>
			</div>
		</div>
		<!--内容页-->
		<div class="boxbig">
			<div style="width: 800px;">
				<p>
					<input type="text" id="authorityName1" class="box"
						placeholder="请输入完整的权限名称" value='${name}'>&nbsp;&nbsp;
				<button style="width: 100px;" onclick="query()">查询</button>
				<div id="div1" style="display:inline"></div>
				</p>

				<div>
					<div>
						<table id="tbody">
						</table>
					</div>
				</div>
				<button onclick="javascript:history.back(-1);">返回</button>
			</div>
		</div>
	</div>
</body>
</html>
