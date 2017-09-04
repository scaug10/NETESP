<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>公告通知管理</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/login/manhuaDate.1.0.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/login/jquery-3.2.1.min.js"></script>
<style>
table {
	border-collapse: collapse;
	border: 1px;
	border-style: solid;
	border-color: #003300;
}

td {
	border: 0px solid #dcdbdb;
	border-collapse: separate;
	text-align: center;
	height: 25px;
}

th {
	border: 1px;
	border-bottom-style: solid;
	border-bottom-color: #003300;
	background-color: #BCFB84;
	border-collapse: separate;
}

.box1 {
	float: left;
	margin: 10px;
}

.box22 {
	float: right;
	margin-top: 10px;
}

.box111 {
	width: 1000px;
	height: 1000px;
}

.clear {
	clear: both;
}

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
	/*border-radius: 4px;    */
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
		var id = document.getElementsByName('noticeIdList');
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
			var url = "${pageContext.request.contextPath}/notice/deleteManyNotice";
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
						getNoticeList();
					}
				}
			}
		} else {
			return false;
		}
	}
	function delete2({noticeId:noticeId}) {
		var r = confirm("确定删除这行数据？");
		if (r == true) {
			var url = "${pageContext.request.contextPath}/notice/deleteNotice";
			var xmlhttp = createXmlHttpRequest();
			xmlhttp.open("post", url, true);
			xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xmlhttp.send("noticeId=" + noticeId);
			xmlhttp.onreadystatechange = function() {
				if (this.status == 200 && this.readyState == 4) {
					if (this.responseText.trim() == "") {
						alert("删除失败！");
					} else {
						alert("删除成功！");
						getNoticeList();
					}
				}
			}
		} else {
			return false;
		}
	}
	function getNoticeList() {
		var url = "${pageContext.request.contextPath}/notice/getAllNotice";
		var xmlhttp = createXmlHttpRequest();
		xmlhttp.open("post", url, true);
		xmlhttp.send();
		xmlhttp.onreadystatechange = function() {
			if (this.status == 200 && this.readyState == 4) {
				var jsonObject = this.responseText;
				var result = eval("(" + jsonObject + ")"); //json转为js数组
				var str = ""
				for (var i = 0; i < result.length; ++i) {
					var noticeId=result[i].noticeId;
					var title = result[i].title;
					var noticeType=result[i].noticeType;
					var isPublic=result[i].isPublic;
					var s1=""
					if(isPublic)
						s1="公开";
					else
						s1="非公开";
					var createTime=result[i].createTime;
					str += "<tr>\n" +
						"	<td>" + "<input type='checkbox' name='noticeIdList' value='" + noticeId + "'/>" + "</td>\n" +
						"	<td>" + title + "</td>\n" +
						"	<td>" + noticeType + "</td>\n" +
						"	<td>" + s1 + "</td>\n" +
						"	<td>" + new Date(createTime).toLocaleString() + "</td>\n" +
						"	<td>" + 
						"<a  onclick=\"delete2({noticeId:'" + noticeId + "'})\"><img src=\"${pageContext.request.contextPath}/img/login/delete.png\"></a>" +
						"</td>\n" +
						"</tr>"
				}
				document.getElementById("tbody").innerHTML = str;
			}
		}
	}
</script>
</head>

<body onload="getNoticeList()">
	<div id="pageAll">
		<div style="width: 1000px;">
			<div class="box2">
				&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/notice/jumpNoticeList">公告通知管理</a>&nbsp;&nbsp;
			</div>
			<div class="box">
				&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/notice/jumpAddNoticePage">公告新增</a>&nbsp;&nbsp;
			</div>
		</div>
		<div class="linkgreen">
			<div style="width: 1000px;">
				&nbsp;<input onclick="delete1()" class="button1" name="delete"
					type="button" value="批量删除" />&nbsp; <input
					onclick="window.location.href='${pageContext.request.contextPath}/notice/jumpAddNoticePage'" class="button1"
					name="add" type="button" value="新增" />
			</div>
			<div class="box111">
				<div class="box1">
					<table width="700" border="0" cellspacing="5">
						<tr>
							<th colspan="6">
								<div align="left">通知公告</div>
						</tr>
						<tbody id="tbody">
						</tbody>
					</table>

				</div>

			</div>
			<div class="clear"></div>
		</div>
</body>

</html>