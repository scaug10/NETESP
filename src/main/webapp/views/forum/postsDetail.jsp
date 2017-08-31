<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>查看帖子</title>
    <style type="text/css">

        *{
            margin: 0px;
            padding: 0px;
        }

        .preload{
            display: none;
        }

        .header{
            background-color: rebeccapurple;
            color: white;
            width: 100%;
            height: 42px;
        }
        .backButton{
            color: white;
            text-decoration: none;
        }

        .backButton:hover{
            text-decoration: underline;
        }

        .header>span{
            display: inline-block;
            margin: 10px;
        }

        ul{
            background-color: rebeccapurple;
            width: 100%;
            list-style: none;
            overflow: auto;
        }

        li{
            float: left;
            width: 20%;
            text-align: center;
            margin: 0px;
        }

        .navtablink{
            text-decoration: none;
            color: #d5cbf7;
            display: inline-block;
            width: 100%;
            padding: 10px 0px;
        }

        .navtablink:hover{
            background-color: gray;
            color: #fff;
        }

        .content{
            width: 98%;
            border-collapse: collapse;
            margin: 10px auto;
        }

        td{
            border: 1px solid skyblue;
        }

        .userInfo{
            width: 150px;
            height: 200px;
            text-align: center;

        }

        .postTheme{
            height: 30px;
        }

        .postContent{
            height: 100px;
        }

        .postTime{
            height: 30px;
            text-align: right;
        }

        .postMenu{
            height: 30px;
            text-align: right;
        }

        .postMenu>a{
            text-decoration: none;
        }

        .replypostblock{
            padding: 10px;
        }

        .replyinput{
            width: 100%;
            height: 30px;
        }

        .replybutton{
            display: inline-block;
            height: 30px;
            width: 60px;
            margin:10px 0px;
        }

        .replybackbutton{
            float: right;
            text-decoration: none;
        }

        .pageButton{
            display: inline-block;
            border: 1px dimgray solid;
            float: right;
            padding: 5px;
            margin: 5px;
            height: 23px;
        }

        .pageButton>a{
            display: inline-block;
            color: #000;
            text-decoration: none;
            font-family: "黑体";
        }

        .pageButton>a:hover{
            text-decoration: underline;
        }

        .inputPage{
            width: 20px;
        }

        #editor{
            margin: 10px;
        }

        .postReplyButton{
            height: 30px;
            width: 80px;
            margin-top: 10px;
        }
        .waitimg{
            width: 50px;
            position: relative;
            left: 50%;
        }


    </style>

    <script type="text/javascript">
    
    	var topicId; //主题id
    	var topicName;  //主题标题
    	
    	function getRequest(){
			topicId = document.getElementById("topicId").value;
			topicName = document.getElementById("topicName").value;
    	}
		
        /*回复主题用此方法处理*/
        function themeReply() {
            var url = "${pageContext.request.contextPath}/forum/createPost";//*******************************
            var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP");
            xhr.open("post", url, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send("username=fyw&topicId=" + document.getElementById("topicId").value + "&content=" + ue.getContent());
            xhr.onreadystatechange = function () {
                if(this.status == 200 && this.readyState == 4){
                    getThemeContent();
                }
            };
        }

        /*回复帖子用此方法处理*/
        function postReply(postNum) {
            var url = "${pageContext.request.contextPath}/forum/createPostComment";
            var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP");
            xhr.open("POST", url, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send("username=fyw&postId=" + postNum + "&content=" + document.getElementById("replyinput"+postNum).value);
            xhr.onreadystatechange = function () {
                if(this.status == 200 && this.readyState == 4){
                	showReply(postNum);
                }
            };
        }

        /*删除主题*/
        function deleteTheme(){
            if(confirm("删除是不可恢复的，你确认要删除吗？")) {
                var url = "";
                var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP");
                xhr.open("POST", url, true);
                xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                xhr.send("topicId=" + document.getElementById("topicId").value);
                xhr.onreadystatechange(function () {
                    if (this.status == 200 && this.readyState == 4) {
                        alert("删除成功！");
                    }
                });
            }
        }

        /*删除帖子*/
        function deletePost(postNum) {
            if(confirm("删除是不可恢复的，你确认要删除吗？")) {
                var url = "${pageContext.request.contextPath}/forumManage/deletePost";
                var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP");
                xhr.open("POST", url, true);
                xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                xhr.send("postNum=" + postNum);
                xhr.onreadystatechange = function () {
                    if (this.status == 200 && this.readyState == 4) {
                    	alert("success");
                    	var json = this.responseText;
                    	if(json == 1)
                        	getThemeContent();
                    	else
                    		alert("删除失败");
                    }
                };
            }
        }

        /*设置置顶*/
        function setTop(){
            if(confirm("是否置顶该帖？")) {
                var url = "${pageContext.request.contextPath}/forumManage/topTheme";
                var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP");
                xhr.open("POST", url, true);
                xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                xhr.send("topicId=" + document.getElementById("topicId").value);
                xhr.onreadystatechange = function () {
                    if (this.status == 200 && this.readyState == 4) {
                    	var json = this.responseText;
                    	if(json == 1)
                        	alert("该帖已置顶！");
                    	else 
                    		alert("删除失败");
                    }
                };
            }
        }

        /*取消置顶*/
        function cancelTop(){
            if(confirm("是否取消置顶？")) {
                var url = "${pageContext.request.contextPath}/forumManage/cancelTopTheme";
                var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP");
                xhr.open("POST", url, true);
                xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                xhr.send("topicId=" + document.getElementById("topicId").value);
                xhr.onreadystatechange = function () {
                    if (this.status == 200 && this.readyState == 4) {
                        alert("取消置顶成功！");
                    }
                };
            }
        }

        /*获取主题的方法*/
        function getThemeContent() {
            var url = "${pageContext.request.contextPath}/forum/loadThemeDetail";//*******************************
            var xhr = window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHTTP");
            xhr.open("post", url, true);
			xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send("topicId=" + document.getElementById("topicId").value);
            xhr.onreadystatechange = function () {
                if(this.status == 200 && this.readyState == 4){
                    var json = this.responseText;
                    var result = eval("(" + json + ")");

                    var userIconAddress = "${pageContext.request.contextPath}/views/forum/IMG/user_icon.png";
                    var userName = result.creator;
                    var themeTitle = result.topicName;
                    var themeContent = result.content;
                    var postTime = new Date(result.createTime).toLocaleString();

                    document.getElementById("themeContent").innerHTML =
                        "<table class=\"content\">\n" +
                        "    <tr>\n" +
                        "        <tr>\n" +
                        "            <td class=\"userInfo\" rowspan=\"3\">\n" +
                        "                <div>\n" +
                        "                    <img class=\"userIcon\" src=\"" + userIconAddress + "\" alt=\"userIcon\"><br />\n" +
                        "                    <span>" + userName + "</span>\n" +
                        "                </div>\n" +
                        "\n" +
                        "            </td>\n" +
                        "            <td class=\"postTheme\">主题：" + themeTitle + "</td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td class=\"postContent\">\n" +
                        "" + themeContent + "\n" +
                        "            </td>\n" +
                        "        </tr>\n" +
                        "        <tr>\n" +
                        "            <td class=\"postTime\">发表时间：" + postTime + "</td>\n" +
                        "        </tr>\n" +
                        "    </tr>\n" +
                        "</table>";
                   getPosts(1);
                     
                }
            };


        }

        /*获取该主题第page页帖子*/
        function getPosts(page) {
            showPageControl(page);
            url = "${pageContext.request.contextPath}/forum/posts";
            var xhr = window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHTTP");
            xhr.open("POST", url, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send("pageNum=" + page + "&topicId=" + document.getElementById("topicId").value);//发送页数page、主题号topicId
            xhr.onreadystatechange = function () {
                if(this.status == 200&&this.readyState == 4){
                    var jsonObject = this.responseText;
                    var result = eval("(" + jsonObject + ")");
                    var htmlCode = "";
                    for(var i=0;i<result.length;i++) {
                        var userName = result[i].publisher;/*发帖人用户名*/
                        var postID = result[i].postId;/*帖子编号*/
                        var replyNumber = result[i].postCommentCount; /*评论数*/
                        var userIconAddress = "${pageContext.request.contextPath}/views/forum/IMG/user_icon.png";/*头像地址*/
                        var postContent = result[i].content;/*帖子内容*/
                        var postTime = result[i].createTime;/*发布时间*/
                        htmlCode +=
                            "<table id =' " + postID + " ' class=\"content\">\n" +
                            "    <tr>\n" +
                            "        <tr>\n" +
                            "            <td class=\"userInfo\" rowspan=\"3\">\n" +
                            "                <div>\n" +
                            "                    <img class=\"userIcon\" src=\"" + userIconAddress + "\" alt=\"userIcon\"><br />\n" +
                            "                    <span>" + userName + "</span>\n" +
                            "                </div>\n" +
                            "\n" +
                            "            </td>\n" +
                            "            <td class=\"postTime\">发表时间：" + (new Date(postTime)).toLocaleString() + "</td>\n" +
                            "        </tr>\n" +
                            "        <tr>\n" +
                            "            <td class=\"postContent\">\n" +
                            "                " + postContent + "\n" +
                            "            </td>\n" +
                            "        </tr>\n" +
                            "        <tr>\n" +
                            "            <td class=\"postMenu\"><a href='javascript:void(0)' onclick='deletePost(" + postID + ")'>删除</a> <a href='javascript:void(0)' onclick='showReply(" + postID + ")'>回复(" + replyNumber + ")</a>&nbsp;</td>\n" +
                            "        </tr>\n" +
                            "    </tr>\n" +
                            "   <tr><td class='replypostblock' id='replypostblock" + postID + "' colspan='2'></td></tr>" +
                            "</table>\n";
                    }
                    document.getElementById("postContent").innerHTML = htmlCode;
                }
            }

        }

        /*传入帖子id，获取并展开当前帖子下的评论*/
        function showReply(postNum) {
            var url = "${pageContext.request.contextPath}/forum/postComments";//*******************************
            var img = "<img class='waitimg' src=\"${pageContext.request.contextPath}/views/forum/IMG/wait.gif\" alt=\"\">";
            var replyBackButton = "<a class='replybackbutton' id='replybackbutton" + postNum + "' href='javascript:void(0)' onclick='replyBackFunction(" + postNum + ")'>收回↑</a>";
            document.getElementById("replypostblock" + postNum).innerHTML = img+replyBackButton;

            var xhr = window.XMLHttpRequest?new XMLHttpRequest():new XMLHttpRequest();
            xhr.open("POST", url, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send("postId=" + postNum);
            xhr.onreadystatechange = function () {
                if(this.status = 200 && this.readyState == 4){
                    var jsonObject = this.responseText;
                    var result = eval("(" + jsonObject + ")");
                    var postReply = "<input class='replyinput' id='replyinput" + postNum + "'><br><button class='replybutton' id='replybutton" + postNum + "' onclick='postReply(" + postNum + ")'>发表</button><br>";
                    var replyContent = "";/*不用管我*/
                    for(var i = 0; i < result.length; i++){
                        replyContent +=  result[i].publisher + ":" + result[i].content + "<br>";
                    }
                    document.getElementById("replypostblock" + postNum).innerHTML = postReply + replyContent + replyBackButton;
                }
            };
        }
        
        function replyBackFunction(postNum) {//令回复内容收起
            document.getElementById("replypostblock" + postNum).innerHTML = "";/*replypostblock里面的东西消失*/
        }

        //输入当前页page显示当前页page显示控制模块
        function showPageControl(page){
            var url = "${pageContext.request.contextPath}/forum/postNum";//*******************************
            var xhr = window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHTTP");
            xhr.open('post', url, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send("topicId=" + document.getElementById("topicId").value);
            /*发送http body*/
            xhr.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    var jsonObject = this.responseText;
//                     var result = eval('(' + jsonObject + ')');
                    /*帖子页数填充*/
                    var totalPostNumber = jsonObject;/*该主题包含的总帖子数*/
                    var postsPerPage = 20;/*每页包含的帖子数*/
                    var lastPage = Math.ceil(totalPostNumber * 1.0 / postsPerPage);
                    document.getElementById("bottom").innerHTML = "<span class=\"pageButton\"><a href=\"javascript:void(0)\" onclick='getPosts(" + page + "+1)'>下一页</a></span>\n" +
                        "    <span class=\"pageButton\"><a href=\"javascript:void(0)\" onclick='getPosts(" + lastPage + ")'>..." + lastPage + "</a></span>\n" +
                        "    <span class=\"pageButton\"><input onchange='jumpToPage()' id='page' class=\"inputPage\" value=\" " + page + " \" type=\"text\">/页</span>\n" +
                        "    <span class=\"pageButton\"><a href=\"javascript:void(0)\" onclick='getPosts(1)'>1</a></span>\n" +
                        "    <span class=\"pageButton\"><a href=\"javascript:void(0)\" onclick='getPosts(" + page + "-1==0?1:" + page + "-1)'>上一页</a></span>";

                    document.getElementById("page").value = page;
                }
            }
        }
        
        function jumpToPage(){
            getPosts(document.getElementById("page").value);
        }

    </script>
</head>
<body onload="getThemeContent()">
<input id="topicId"  type="text" value="${topicId}"><!-- 获取服务器发送的attribute-->
<input id="topicName" type="text" value="${topicName }">
<img class="preload" src="${pageContext.request.contextPath}/views/forum/IMG/wait.gif" alt=""><!--预加载等待图片-->

<div class="header">
    <script>
        var forumName = "应急学习版块";
        document.write("<span>当前版块：<a class=\"backButton\" href=\"javascript:history.go(-1);\">" + forumName +"</a></span>");
    </script>

</div>

<ul class="nav">

    <li><a href="#editor" class="navtablink">发表回复</a></li>
    <li><a href="javascript:void(0)" class="navtablink" onclick="setTop()">设置置顶</a></li>
    <li><a href="javascript:void(0)" class="navtablink" onclick="cancelTop()">取消置顶</a></li>
    <li><a href="javascript:void(0)" class="navtablink" onclick="deleteTheme()">删除主题</a></li>
    <li><a href="javascript:history.go(-1)" class="navtablink">返回版块</a></li>

</ul>

<!--帖子内容-->
<div id="themeContent"></div>
<div id="postContent"></div>
<div id="pageControl"></div>
<div id="bottom"></div><br><br>
<strong>&nbsp;发表回复</strong>

<div id="editor">
    <script id="container" type="text/plain"></script>
    <!-- 配置文件 -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/views/forum/utf8-jsp/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/views/forum/utf8-jsp/ueditor.all.js"></script>
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
         var ue = UE.getEditor('container', { 
             initialFrameHeight: [300], 
             autoWidthEnabled: true
         });
     </script> 
    <button class="postReplyButton" onclick="themeReply()"><!--此处发表回复调用postReply()方法-->
        <strong>发表回复</strong>
    </button>
</div>
</body>
</html>
