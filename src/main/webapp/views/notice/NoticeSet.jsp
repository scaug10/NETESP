<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公告新增</title>
<style>
.box {
	height: auto;
	/*border-radius: 4px;    */
	border-top-right-radius: 5px;
	border-top-left-radius: 5px;
	border-color: #80FF80;
	border-style: solid;
	display: inline;
	background-color: #80FF80;
	color: #999999;
}

.box2 {
	/*border-radius: 4px;   */
	border-top-right-radius: 5px;
	border-top-left-radius: 5px;
	border-style: solid;
	border-color: #00FF00;
	display: inline;
	background-color: #00FF00;
}

.linkgreen {
	margin-top: 3px;
	background-color: #00FF00;
	height: 30px;
	width: 100%;
}

.write {
	margin-top: 30px;
	margin-bottom: 30px;
}

.user {
	float: right;
}

table {
	margin-top: 200px;
	border-style: solid;
	border-collapse: collapse
}

td {
	width: 90px;
	height: 30px;
	text-align: center;
	line-height: 30px;
	border: 1px;
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
	function checkTitle() {
		var name1 = document.getElementById("title").value;
		if (name1.trim() == "") {
			alert("标题不能为空！");
			return false;
		}
		if (name1.length < 1 || name1.length > 50) {
			alert("标题的输入的长度1-50个字符！");
		}
		return true;
	}
	function checkContent() {
		var name1 = ue.getContent();
		if (name1.trim() == "") {
			alert("公告内容不能为空");
			return false;
		}
		if (name1.length < 1 || name1.length > 500) {
			alert("公告内容的输入的长度1-500个字符！");
			return false;
		}
		return true;
	}
	function writeUserList() {
		var url = "${pageContext.request.contextPath}/login/searchUserList";
		var xmlhttp = createXmlHttpRequest();
		xmlhttp.open("post", url, true);
		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlhttp.send();
		xmlhttp.onreadystatechange = function() {
			if (this.status == 200 && this.readyState == 4) {
				var jsonObject = this.responseText;
				var result = eval("(" + jsonObject + ")"); //json转为js数组
				var str = "<tr style='background-color: #00FF00;'>\n" +
					"<th colspan='2'>" +
					"用户列表\n" +
					"</tr>";
				for (var i = 0; i < result.length; ++i) {
					var userName = result[i].userName;
					str += "<tr>\n" +
						"	<td>" + "<input type='checkbox' name='userNameList' value='" + userName + "'/>" + "</td>\n" +
						"	<td>" + userName + "</td>\n" +
						"</tr>"
				}
				document.getElementById("tbody").innerHTML = str;
			}
		}
	}
	function showUserList(str) {
		if (str == "非公开") {
			writeUserList();
			return;
		} else {
			var i = document.getElementById("tbody");
			var str = "";
			i.innerHTML = str;
		}
	}
	function sendNotice() {
		if (!checkTitle() || !checkContent()) {
			return false;
		}
		var isPublic = document.getElementById("isPublic").value;
		if (isPublic == "公开") {
			var url = "${pageContext.request.contextPath}/notice/saveNotice";
			var xmlhttp = createXmlHttpRequest();
			xmlhttp.open("post", url, true);
			xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xmlhttp.send("title=" + document.getElementById("title").value +
				"&noticeType=" + document.getElementById("noticeType").value +
				"&isPublic=true" +
				"&content=" + ue.getContent());
			xmlhttp.onreadystatechange = function() {
				if (this.status == 200 && this.readyState == 4) {
					if (this.responseText.trim() == "") {
						alert("发布公告失败，可能是你没有权限进行此操作");
					} else {
						alert("发布公告成功，返回公告通知查询页面");
						window.location.href = '${pageContext.request.contextPath}/notice/jumpSearchNoticePage';
					}
				}
			}
		} else {
			var id = document.getElementsByName('userNameList');
			var list = new Array();
			for (var i = 0; i < id.length; i++) {
				if (id[i].checked) {
					list.push(id[i].value);
				}
			}
			if (list.length == 0) {
				alert("你没有选中要发布公告的用户，发布公告失败！");
				return false;
			}
			var r = confirm("确定发布公告给这些用户？");
			if (r == true) {
				var url = "${pageContext.request.contextPath}/notice/saveNotice";
				var xmlhttp = createXmlHttpRequest();
				xmlhttp.open("post", url, true);
				xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xmlhttp.send("title=" + document.getElementById("title").value +
					"&noticeType=" + document.getElementById("noticeType").value +
					"&isPublic=false" +
					"&content=" + ue.getContent()+
					"&userList="+list);
				xmlhttp.onreadystatechange = function() {
					if (this.status == 200 && this.readyState == 4) {
						if (this.responseText.trim() == "") {
							alert("发布公告失败，可能是你没有权限进行此操作");
						} else {
							alert("发布公告成功，返回公告通知列表页面");
							window.location.href = '${pageContext.request.contextPath}/notice/jumpNoticeList';
						}
					}
				}
			} else {
				return false;
			}
		}
	}
</script>
</head>
<body>
	<div style="width: 1200px;">
		<div class="user">
			<table id="tbody">
			</table>
		</div>
		<div style="width: 1000px;">
			<div class="box">
				&nbsp;&nbsp; <a
					href="${pageContext.request.contextPath}/notice/jumpNoticeList">公告通知管理</a>&nbsp;&nbsp;
			</div>
			<div class="box2">&nbsp;&nbsp;公告新增&nbsp;&nbsp;</div>
			<div class="linkgreen">
				<div style="width: 1000px;">
					&nbsp;<input name="set" type="button" onclick="sendNotice()"
						value="发布" />&nbsp; <input onclick="javascript:history.back(-1);"
						name="close" type="button" value="关闭" />
				</div>
			</div>
			<div class="write">
				标题&nbsp; <input id="title" name="title" type="text"
					value='${title}'/>
			</div>
			<div class="write">
				类型&nbsp; <select id="noticeType">
					<option value="企业学习目标">企业学习目标</option>
					<option value="学习制度">学习制度</option>
					<option value="学习练习通知">学习练习通知</option>
				</select> 性质&nbsp; <select id="isPublic" onchange="showUserList(this.value)">
					<option value="公开">公开</option>
					<option value="非公开">非公开</option>
				</select>
			</div>

			<div id="editor">
				<strong class="editorTitle">公告内容</strong>

				<script id="container" name="content" type="text/plain"></script>
				<!-- 配置文件 -->
				<script type="text/javascript"
					src="${pageContext.request.contextPath}/utf8-jsp/ueditor.config.js"></script>
				<!-- 编辑器源码文件 -->
				<script type="text/javascript"
					src="${pageContext.request.contextPath}//utf8-jsp/ueditor.all.js"></script>
				<!-- 实例化编辑器 -->
				<script type="text/javascript">
					var ue = UE.getEditor('container', {
						initialFrameHeight : [ 300 ],
						autoWidthEnabled : true
					});
				</script>
				<button class="postReplyButton" onclick="sendNotice()">
					<strong>发布</strong>
				</button>
			</div>
		</div>
</body>
</html>