<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课件管理</title>
<script type="text/javascript">
	function createXmlHttpRequest() {
		if (window.ActiveXObject) { //如果是IE浏览器
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) { //非IE浏览器
			return new XMLHttpRequest();
		}
	}

	function getParentDirectory(id) {
		var xhr = createXmlHttpRequest();
		var url = "getParentId";
		xhr.open('post', url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("cwcfId=" + id);
		/*发送http body*/
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				getSubDirectory(this.responseText);
			}
		}
	}
	function getSubDirectory(id) {
		//获取并显示当前目录的子目录
		var xhr = createXmlHttpRequest();
		var url = "getNode";
		xhr.open('post', url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("cwcfId=" + id);
		/*发送http body*/
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var result = this.responseText;
				var resultArray = eval('(' + result + ')');
				var number = resultArray.length;//子目录数
				if (id == 0) {
					var htmlCode = "";
				} else {
					var htmlCode = "<tr><td></td><td><a href=\"javascript:void(0);\" onclick='getParentDirectory("
							+ id + ")'>返回上一级目录</a></td></tr>";
				}
			}
			for (var i = 0; i < number; i++) {
				var subName = resultArray[i].classificationName;
				var subId = resultArray[i].cwcfId;
				var isParent = resultArray[i].parentId;

				if (isParent) {
					htmlCode += "<tr id=\"" + subId + "\">\n"
							+ "            <td><button class=\"showHideButton\" onclick=\"getSubDirectory("
							+ subId
							+ ","
							+ id
							+ ")\">+</button></td>\n"
							+ "            <td><a href=\"javascript:void(0)\" onclick=\"getCourseware("
							+ subId + ")\">" + subName + "</a></td>\n"
							+ "        </tr>";
				} else {
					htmlCode += "<tr id=\"" + subId + "\">\n"
							+ "        <td></td>"
							+ "        <td><a href=\"javascript:void(0)\" onclick=\"getCourseware("
							+ subId + ")\">" + subName + "</a></td>\n"
							+ "        </tr>";
				}

			}
			document.getElementById("directory").innerHTML = htmlCode;
		}
	}

	function getCourseware(id) {
		//获取并显示当前目录的课件
	}
</script>
<style type="text/css">
.showHideButton {
	height: 20px;
	width: 20px;
	text-align: center;
}
</style>

</head>
<body>

	<div class="left">

		<table id="directory" class="directory">

			<tr id="0">
				<td><button class="showHideButton" onclick="getSubDirectory(1)">+</button></td>
				<td><a href="javascript:void(0)" onclick="getCourseware(1)">课件分类</a></td>
			</tr>

		</table>

	</div>

	<div class="content"></div>

</body>
</html>