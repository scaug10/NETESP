<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>课件管理</title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

html, body {
	height: 100%;
}

.left a {
	text-decoration: none;
	color: black;
	font-size: 14px;
	font-family: "黑体";
}

.left a:hover {
	text-decoration: underline;
}

.plus {
	width: 30px;
	height: 30px;
}

.left {
	display: inline-block;
	background-color: white;
	height: 100%;
	width: 20%;
	float: left;
}

.content {
	display: inline-block;
	float: left;
	width: 80%;
}

.navtablink {
	display: inline-block;
	width: 100%;
	padding: 10px 0px;
	color: #fff;
	font-family: "黑体";
	text-decoration: none;
}

.navtablink:hover {
	background-color: yellowgreen;
}

.content>ul {
	width: 100%;
}

li {
	color: #fff;
	width: 20%;
	text-align: center;
	list-style-type: none;
	float: left;
	background-color: green;
}

.content>table {
	margin: 5px 2%;
	border-collapse: collapse;
	width: 96%;
}

.content td {
	border: 1px grey solid;
}

.content th {
	border: 1px grey solid;
}

.classificationname {
	text-align: center;
}

#modifycoursewarebox {
	width: 400px;
	height: 430px;
	position: fixed; 
	margin: auto;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	background-color: lightgreen;
}

#createcoursewarebox {
	width: 400px;
	height: 400px;
	position: fixed; 
	margin: auto;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	background-color: lightgreen;
}

#currentClassification {
	padding-left: 5%;
}

.createcoursetable {
	width: 100%;
	border-collapse: collapse;
	font-family: "黑体";
}

.createcoursetable tr {
	height: 35px;
}

.courseInput {
	margin: 1px 5%;
	width: 90%;
	font-size: 16px;
}

button {
	font-size: 16px;
	height: 30px;
	width: 60px;
}
</style>

<script type="text/javascript">
	/*按照浏览器类型返回*/
	function createXmlHttpRequest() {
		if (window.ActiveXObject) { //如果是IE浏览器
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) { //非IE浏览器
			return new XMLHttpRequest();
		}
	}
	/*************/

	/*动态创建目录*/
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
				for (var i = 0; i < number; i++) {
					var subName = resultArray[i].classificationName;
					var subId = resultArray[i].cwcfId;
					var isParent = resultArray[i].parentId;
					if (isParent) {
						htmlCode += "<tr id=\"" + subId + "\">\n"
								+ "<td><a class=\"showHideButton\" href='javascript:void(0)' onclick=\"getSubDirectory("
								+ subId
								+ ","
								+ id
								+ ")\"><img class=\"plus\" src='${pageContext.request.contextPath}/img/plus.gif' alt='plus'></a></td>\n"
								+ "<td><a href=\"javascript:void(0)\" onclick=\"getCourseware("
								+ subId + ",'" + subName + "')\">" + subName
								+ "</a></td>\n" + "</tr>";
					} else {
						htmlCode += "<tr id=\"" + subId + "\">\n"
								+ "<td></td>"
								+ "<td><a href=\"javascript:void(0)\" onclick=\"getCourseware("
								+ subId + ",'" + subName + "')\">" + subName
								+ "</a></td>\n" + "</tr>";
					}

				}
				document.getElementById("directory").innerHTML = htmlCode;
			}
		}
	}
	/*************/

	/*获取分类下的课件*/
	function getCourseware(id, name) {
		document.getElementById("classificationCRUD").innerHTML = "<ul>\n"
				+ "<li><a class=\"navtablink\" href=\"javascript:void(0)\" onclick=\"createClassification()\">新增分类</a></li>\n"
				+ "<li><a class=\"navtablink\" href=\"javascript:void(0)\" onclick=\"modifyClassification('"
				+ name
				+ "')\">修改分类</a></li>\n"
				+ "<li><a class=\"navtablink\" href=\"javascript:void(0)\" onclick=\"deleteClassification("
				+ id
				+ ")\">删除分类</a></li>\n"
				+ "<li><a class=\"navtablink\" href=\"javascript:void(0)\" onclick=\"createCourseware("
				+ id
				+ ")\">新增课件</a></li>\n"
				+ "<li><a class=\"navtablink\" href=\"javascript:void(0)\" onclick=\"deleteCourseware()\">删除课件</a></li>\n"
				+ "</ul>";
		//获取并显示当前目录的课件
		document.getElementById("getClassificationId").value = id;
		document.getElementById("getClassificationName").value = name;
		document.getElementById("contenttitle").innerText = name;
		document.getElementById("currentClassification").innerHTML = name;
		var htmlCode = //课件表表头
		"<tr class=\"title\">\n"
				+ "<th><input id='selectAllCheckBox' type='checkbox' onclick='selectAllCheckBox(this.checked)'>全选</th>"
				+ "<th>课件名</th>\n" + "<th>主讲人</th>\n" + "<th>主讲人概述</th>\n"
				+ "<th>课件时长</th>\n" + "<th>推荐等级</th>\n" + "<th>课件描述</th>\n"
				+ "<th>课件类型</th>\n" + "<th>url</th>\n" + "<th>操作</th>\n"
				+ "</tr>";

		var xhr = createXmlHttpRequest();
		var url = "getCoursewareByCategoryId";
		xhr.open("post", url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("cwcfId=" + id);
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var resultArray = eval("(" + this.responseText + ")");
				for (var i = 0; i < resultArray.length; i++) {
					htmlCode += //课件表内容
					"<tr><td><input class='checkbox' type='checkbox' id='" + resultArray[i].coursewareId + "'></td>\n"
							+ "<td>"
							+ resultArray[i].coursewareName
							+ "</td>\n"
							+ "<td>"
							+ resultArray[i].speakerName
							+ "</td>\n"
							+ "<td>"
							+ resultArray[i].speakerInfo
							+ "</td>\n"
							+ "<td>"
							+ resultArray[i].coursewareDuration
							+ "</td>\n"
							+ "<td>"
							+ resultArray[i].commendLevel
							+ "</td>\n"
							+ "<td>"
							+ resultArray[i].description
							+ "</td>\n"
							+ "<td>"
							+ resultArray[i].cpursewareType
							+ "</td>\n"
							+ "<td><a target='_blank' href='" + resultArray[i].contentUrl + "'>"
							+ resultArray[i].contentUrl
							+ "</a></td>\n"
							+ "<td><button onclick=\"modifyCourseware("
							+ "'"
							+ resultArray[i].coursewareId
							+ "','"
							+ resultArray[i].coursewareName
							+ "','"
							+ resultArray[i].speakerName
							+ "','"
							+ resultArray[i].speakerInfo
							+ "','"
							+ resultArray[i].coursewareDuration
							+ "','"
							+ resultArray[i].commendLevel
							+ "','"
							+ resultArray[i].description
							+ "','"
							+ resultArray[i].cpursewareType
							+ "','"
							+ resultArray[i].contentUrl
							+ "','"
							+ name
							+ "')\">修改</button></td></tr>";
				}

				document.getElementById("coursewaretable").innerHTML = htmlCode;

			}
		}
	}
	/*************/

	/*新建修改删除课件相关方法*/
	function createCourseware(name) {
		document.getElementById("createcoursewarebox").hidden = false;
	}
	function closeCreateCourseware() {
		document.getElementById("newCoursewareName").value = "";
		document.getElementById("newCoursewareSpeaker").value = "";
		document.getElementById("newCoursewareSpeakerInfo").value = "";
		document.getElementById("newCoursewareTime").value = "";
		document.getElementById("newCoursewareCommendLevel").value = 1;
		document.getElementById("newCoursewareDescription").value = "";
		document.getElementById("newCoursewareType").value = "";
		document.getElementById("newCoursewareUrl").value = "";
		document.getElementById("createcoursewarebox").hidden = true;
	}
	function sendCreateCoursewareRequest() {
		var coursewareName = document.getElementById("newCoursewareName").value;
		var speakerName = document.getElementById("newCoursewareSpeaker").value;
		var speakerInfo = document.getElementById("newCoursewareSpeakerInfo").value;
		var coursewareDuration = document.getElementById("newCoursewareTime").value;
		var commendLevel = document.getElementById("newCoursewareCommendLevel").value;
		var description = document.getElementById("newCoursewareDescription").value;
		var cwcfId = document.getElementById("getClassificationId").value;
		var coursewareType = document.getElementById("newCoursewareType").value;
		var contentUrl = document.getElementById("newCoursewareUrl").value;

		var xhr = createXmlHttpRequest();
		var url = "saveCourseware";
		xhr.open("post", url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		var classificationId = document.getElementById("getClassificationId").value;
		xhr.send("cwcfId=" + cwcfId + "&coursewareName=" + coursewareName
				+ "&speakerName=" + speakerName + "&speakerInfo=" + speakerInfo
				+ "&coursewareDuration=" + coursewareDuration
				+ "&commendLevel=" + commendLevel + "&description="
				+ description + "&cpursewareType=" + coursewareType
				+ "&contentUrl=" + contentUrl);
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				if (this.responseText == 1) {
					alert("新建课件成功！");
					closeCreateCourseware();
					getCourseware(cwcfId, document
							.getElementById("getClassificationName").value);
				} else {
					alert("新建课件失败！");
				}

			}
		}
	}
	function modifyCourseware(id, name, speakerName, speakerInfo, Duration,
			commandLevel, description, type, contentUrl,
			currentClassificationName) {
		document.getElementById("modifyCoursewareId").value = id;
		document.getElementById("modifyCoursewareName").value = name;
		document.getElementById("modifyCoursewareSpeaker").value = speakerName;
		document.getElementById("modifyCoursewareSpeakerInfo").value = speakerInfo;
		document.getElementById("modifyCoursewareTime").value = Duration;
		document.getElementById("modifyCoursewareCommendLevel").value = commandLevel;
		document.getElementById("modifyCoursewareDescription").value = description;
		document.getElementById("modifyCoursewareType").value = type;
		document.getElementById("modifyCoursewareUrl").value = contentUrl;

		var xhr = createXmlHttpRequest();
		var url = "getAllCoursewareClassification";
		xhr.open("post", url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		var classificationId = document.getElementById("getClassificationId").value;
		xhr.send(null);
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var jsonObject = this.responseText;
				var result = eval("(" + jsonObject + ")");
				var select = document.getElementById("cwcfid");
				var currentOption = document.createElement('option');
				var currentClassificationId = document
						.getElementById("getClassificationId").value;
				currentOption.value = currentClassificationId;
				currentOption.innerText = currentClassificationName;
				select.appendChild(currentOption);
				for (var i = 0; i < result.length; i++) {
					var newOption = document.createElement('option');
					if (result[i].cwcfId != currentClassificationId) {
						newOption.value = result[i].cwcfId;
						newOption.innerText = result[i].classificationName;
						select.appendChild(newOption);
					}
				}
			}
		}
		document.getElementById("modifycoursewarebox").hidden = false;
	}
	function sendModifyCoursewareRequest() {
		var coursewareName = document.getElementById("modifyCoursewareName").value;
		var speakerName = document.getElementById("modifyCoursewareSpeaker").value;
		var speakerInfo = document
				.getElementById("modifyCoursewareSpeakerInfo").value;
		var coursewareDuration = document
				.getElementById("modifyCoursewareTime").value;
		var commendLevel = document
				.getElementById("modifyCoursewareCommendLevel").value;
		var description = document
				.getElementById("modifyCoursewareDescription").value;
		var coursewareId = document.getElementById("modifyCoursewareId").value;
		var coursewareType = document.getElementById("modifyCoursewareType").value;
		var cwcfId = document.getElementById("cwcfid").value;
		var contentUrl = document.getElementById("modifyCoursewareUrl").value;

		var xhr = createXmlHttpRequest();
		var url = "editCourseware";
		xhr.open("post", url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		var classificationId = document.getElementById("getClassificationId").value;
		xhr.send("coursewareId=" + coursewareId + "&cwcfId=" + cwcfId
				+ "&coursewareName=" + coursewareName + "&speakName="
				+ speakerName + "&speakerInfo=" + speakerInfo
				+ "&coursewareDuration=" + coursewareDuration
				+ "&commendLevel=" + commendLevel + "&description="
				+ description + "&cpursewareType=" + coursewareType
				+ "&contentUrl=" + contentUrl);
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				if (this.responseText == 1) {
					alert("修改课件成功！");
					closeModifyCourseware();
					getCourseware(classificationId, document
							.getElementById("getClassificationName").value);
				} else {
					alert("修改课件失败！");
				}
			}
		}
	}
	function closeModifyCourseware() {
		document.getElementById("modifyCoursewareName").value = "";
		document.getElementById("modifyCoursewareSpeaker").value = "";
		document.getElementById("modifyCoursewareSpeakerInfo").value = "";
		document.getElementById("modifyCoursewareTime").value = "";
		document.getElementById("modifyCoursewareCommendLevel").value = 1;
		document.getElementById("modifyCoursewareDescription").value = "";
		document.getElementById("modifyCoursewareType").value = "";
		document.getElementById("modifyCoursewareUrl").value = "";
		document.getElementById("cwcfid").innerHTML = "";
		document.getElementById("modifycoursewarebox").hidden = true;
	}
	function deleteCourseware() {
		//删除课件
		var sendArray = new Array();
		var courseArray = document.getElementsByClassName("checkbox");
		for (var i = 0; i < courseArray.length; i++) {
			if (courseArray[i].checked) {
				sendArray.push(courseArray[i].id);
			}
		}
		if (confirm("是否删除这" + sendArray.length + "个课件？")) {
			var xhr = createXmlHttpRequest();
			var url = "deleteCourseware";
			xhr.open("post", url, true);
			xhr.setRequestHeader('Content-Type',
					'application/x-www-form-urlencoded');
			xhr.send("coursewareId=" + sendArray);
			xhr.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var result = this.responseText;
					if (result) {
						alert("删除课件成功!");
						getCourseware(
								document.getElementById("getClassificationId").value,
								document
										.getElementById("getClassificationName").value);
					} else {
						alert("删除失败!");
					}
				}
			}
		}
	}
	function selectAllCheckBox(isChecked) {
		var checkBox = document.getElementsByClassName("checkbox");
		for (var i = 0; i < checkBox.length; i++) {
			checkBox[i].checked = isChecked;
		}
		//            if(document.getElementById("selectAllCheckBox").checked){
		//                for(var object in checkBox){
		//                    object.check = true;
		//                }
		//            }else{
		//                for(var object in checkBox){
		//                    object.check = false;
		//                }
		//            }
	}
	/**************/

	/*新增修改删除分类的方法*/
	function createClassification() {
		//在本分类创建子课件分类
		var newClassName = prompt("在当前分类新建子分类：");
		if (newClassName.length != 0) {
			var parentId = document.getElementById("getClassificationId").value;
			var xhr = createXmlHttpRequest();
			var url = "saveCoursewareClassification";
			xhr.open("post", url, true);
			xhr.setRequestHeader('Content-Type',
					'application/x-www-form-urlencoded');
			xhr.send("classificationName=" + newClassName + "&parentId="
					+ parentId);
			xhr.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var result = this.responseText;
					if (result == 1) {
						alert("新建子课件成功");
						getSubDirectory(parentId);
					} else if (result == 2) {
						alert("当前分类名已存在！");
					} else {
						alert("未知原因导致新建分类失败！")
					}
				}
			}
		}
	}
	function modifyClassification(oldName) {
		var classificationId = document.getElementById("getClassificationId").value;
		if (classificationId == 1) {
			alert("不允许修改根目录!");
		} else {
			var newClassificationName = prompt("新分类名：", oldName);
			if (newClassificationName == oldName) {
				alert("未修改分类名!");
			} else {
				if (newClassificationName.length == 0) {
					alert("目录名不允许为空！");
				} else {
					var xhr = createXmlHttpRequest();
					var url = "editCoursewareClassification";
					xhr.open("post", url, true);
					xhr.setRequestHeader('Content-Type',
							'application/x-www-form-urlencoded');
					xhr.send("classificationName=" + newClassificationName
							+ "&cwcfId=" + classificationId);
					xhr.onreadystatechange = function() {
						if (this.readyState == 4 && this.status == 200) {
							if (this.responseText == 1) {
								alert("修改成功");
								getParentDirectory(classificationId);
								getCourseware(classificationId,
										newClassificationName);
							} else {
								alert(this.responseText == 2 ? "该分类名存在"
										: "未知错误")
							}
						}
					}
				}
			}
		}
	}
	function deleteClassification(id) {
		//删除本课件分类
		if (id == 1) {
			alert("不允许删除根目录！");
		} else {
			if (confirm("确定删除本分类吗？")) {
				getParentDirectory(id);
				var xhr = createXmlHttpRequest();
				var url = "deleteCoursewareClassification";
				xhr.open("post", url, true);
				xhr.setRequestHeader('Content-Type',
						'application/x-www-form-urlencoded');
				xhr.send("cwcfId=" + id);
				xhr.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
						if (this.responseText >= 1) {
							alert("删除分类成功！");
							getSubDirectory(this.responseText);
							document.getElementsByClassName("content")[0].innerHTML = "<div id='classificationCRUD'></div><div class='classificationname'><h1 id='contenttitle'></h1></div><table id='coursewaretable'></table>";
						} else {
							alert("删除分类失败！");
						}
					}
				}
			}
		}
	}
	/**************/
</script>
</head>


<body>
	<input id="getClassificationId" type="hidden">
	<input id="getClassificationName" type="hidden">
	<div class="left">

		<table id="directory" class="directory">

			<tr id="0">
				<td><a class="showHideButton" href="javascript:void(0)"
					onclick="getSubDirectory(1)"><img class="plus"
						src="${pageContext.request.contextPath}/img/plus.gif" alt="plus"></a></td>
				<td><a href="javascript:void(0)"
					onclick="getCourseware(1, '根目录')">根目录</a></td>
			</tr>

		</table>

	</div>

	<div class="content">
		<div id="classificationCRUD"></div>
		<div class="classificationname">
			<h1 id="contenttitle"></h1>
		</div>
		<table id="coursewaretable"></table>
	</div>

	<div id="createcoursewarebox" class="coursewarebox" hidden>
		<table class="createcoursetable">
			<tr>
				<th colspan="2">课件信息</th>
			</tr>
			<tr>
				<td style="width: 6em">课件名称：</td>
				<td><input id="newCoursewareName" class="courseInput"><br></td>
			</tr>
			<tr>
				<td>主讲人：</td>
				<td><input id="newCoursewareSpeaker" class="courseInput"></td>
			</tr>
			<tr>
				<td>主讲人概况：</td>
				<td><input id="newCoursewareSpeakerInfo" class="courseInput"></td>
			</tr>
			<tr>
				<td>课件时长：</td>
				<td><input id="newCoursewareTime" class="courseInput"></td>
			</tr>
			<tr>
				<td>推荐等级：</td>
				<td><select id="newCoursewareCommendLevel" class="courseInput"
					name="commendLevel" id="commendLevel">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
				</select></td>
			</tr>
			<tr>
				<td>课件描述：</td>
				<td><input id="newCoursewareDescription" class="courseInput"></td>
			</tr>
			<tr>
				<td>课件类型：</td>
				<td><input id="newCoursewareType" class="courseInput"></td>
			</tr>
			<tr>
				<td>课件地址：</td>
				<td><input id="newCoursewareUrl" class="courseInput"></td>
			</tr>
			<tr>
				<td>当前分类：</td>
				<td id="currentClassification"></td>
			</tr>
		</table>
		<div class="buttonBox" style="text-align: center; padding: 5px">
			<button onclick="sendCreateCoursewareRequest()">确认</button>
			<button onclick="closeCreateCourseware()">取消</button>
		</div>
	</div>

	<div id="modifycoursewarebox" class="coursewarebox" hidden=hidden>
		<table class="createcoursetable">
			<tr>
				<th colspan="2">课件信息</th>
			</tr>
			<tr>
				<td style="width: 6em">课件ID：</td>
				<td><input id="modifyCoursewareId" disabled class="courseInput"><br></td>
			</tr>
			<tr>
				<td>课件名称：</td>
				<td><input id="modifyCoursewareName" class="courseInput"><br></td>
			</tr>
			<tr>
				<td>主讲人：</td>
				<td><input id="modifyCoursewareSpeaker" class="courseInput"></td>
			</tr>
			<tr>
				<td>主讲人概况：</td>
				<td><input id="modifyCoursewareSpeakerInfo" class="courseInput"></td>
			</tr>
			<tr>
				<td>课件时长：</td>
				<td><input id="modifyCoursewareTime" class="courseInput"></td>
			</tr>
			<tr>
				<td>推荐等级：</td>
				<td><select id="modifyCoursewareCommendLevel"
					class="courseInput" name="commendLevel">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
				</select></td>
			</tr>
			<tr>
				<td>课件描述：</td>
				<td><input id="modifyCoursewareDescription" class="courseInput"></td>
			</tr>
			<tr>
				<td>课件类型：</td>
				<td><input id="modifyCoursewareType" class="courseInput"></td>
			</tr>
			<tr>
				<td>课件地址：</td>
				<td><input id="modifyCoursewareUrl" class="courseInput"></td>
			</tr>
			<tr>
				<td>课件分类：</td>
				<td id="modifyCousewareClassification"><select
					class="courseInput" name="cwcfId" id="cwcfid"></select></td>
			</tr>
		</table>
		<div class="buttonBox" style="text-align: center; padding: 5px">
			<button onclick="sendModifyCoursewareRequest()">修改</button>
			<button onclick="closeModifyCourseware()">取消</button>
		</div>
	</div>

</body>
</html>