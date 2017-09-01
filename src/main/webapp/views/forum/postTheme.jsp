<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>发布帖子</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/postTheme.css"/>
    

    <script type="text/javascript">

        function postReply() {
            url="${pageContext.request.contextPath}/forum/createTheme";
            var xhr = window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHTTP");
            xhr.open("POST", url, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send("topicName=" + document.getElementById("themeTitle").value + "&content=" + ue.getContent() + 
            		"&boardName=" + document.getElementById("getBoardName").value +
            		"&username=fyw");
            //发送标题、内容、版块名
            xhr.onreadystatechange = function () {
                if(xhr.status == 200 && xhr.readyState == 4){
                	var json = this.responseText;
                	if(json == 1)
	                    history.go(-1);//返回上一页
	                else alert("创建失败，请检查标题或内容是否为空");
                }
            }
        }

    </script>


</head>
<body>
<input id="getBoardName" type="hidden" value="${boardName}">

<div class="header">
    <span>当前版块：<a class="backButton" href=\"javascript:history.go(-1);\">${boardName}</a></span>
</div>

<div id="editor">
    <strong class="editorTitle">发表主题</strong><br>
    <input id="themeTitle" type="text" placeholder="标题">

    <script id="container" name="content" type="text/plain"></script>
    <!-- 配置文件 -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/utf8-jsp/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/utf8-jsp/ueditor.all.js"></script>
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
        var option = {
            toolbars:["undo", "redo"]
        }
        var ue = UE.getEditor('container', {
            initialFrameHeight: [300],
            autoWidthEnabled: true
        });

    </script>
    <button class="postReplyButton" onclick="postReply()"><!--此处发表回复调用postReply()方法-->
        <strong>发表主题</strong>
    </button>
</div>

</body>
</html>