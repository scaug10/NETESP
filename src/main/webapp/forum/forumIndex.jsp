<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE htm>

<!--
    这一页是论坛首页，
    显示版块列表，
    在此填充论坛列表数据
-->

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>论坛</title>

    <script>

    </script>

    <style type="text/css">

        * {
            margin: 0px;
            padding: 0px;
            width: 100%;
        }

        .header{
            width: 100%;
            background-color: rebeccapurple;
            color: #fff;
            font-size: 36px;
            padding: 5px;
        }

        .forum{
            display: block;
            border-bottom: 1px dashed black;
            height: 60px;
        }

        .forumlogo{
            width: 40px;
            height: 40px;
            margin: 10px;
            display: inline-block;
        }

        .forumname{
            font-size: 20px;
            display: inline-block;
            width: 30%;
            position: relative;
            bottom: 20px;
        }

        .forumdetail{
            font-size: 20px;
            display: inline-block;
            width: 40%;
            color: #000;
            position: relative;
            bottom: 20px;
        }

        .forumowner{
            font-size: 20px;
            color: #000;
            width: 15%;
            position: relative;
            bottom: 20px;
        }

        a{
            text-decoration: none;
            color: black;
        }

        a:hover{
            background-color: gray;
            color: #fff;
        }

        li:nth-child(even){
            background-color: #f9f7f7;
        }

    </style>

    <script type="text/javascript">
        function createXmlHttpRequest(){
            if(window.ActiveXObject){ //如果是IE浏览器
                return new ActiveXObject("Microsoft.XMLHTTP");
            }else if(window.XMLHttpRequest){ //非IE浏览器
                return new XMLHttpRequest();
            }
        }
        
        function onloadFunction() {
            /*这里给出论坛列表填充数据*/
            var url = "/forum/loadBoardInfo";
            var xhr = createXmlHttpRequest();
            xhr.open('post', url, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send(null);/*发送http body*/
            xhr.onreadystatechange = function () {
                if(this.readyState == 4 && this.status == 200){
					alert("200");
                }

            }
        }
    </script>
</head>

<body onload="onloadFunction()">

<p class="header">
    论坛列表
</p>

<div class="content">
    <ul id="forumlist" class="forumlist">
        <!--表格数据-->
        <c:forEach var="list" items="${boardList}">
        		<li>
   				<a class="forum" href="#">
				<img class="forumlogo" src="./IMG/forum_logo" alt="forumlogo">
				<span class="forumname">${list.boardName}</span>
				<span class="forumdetail">${list.boardDescribe}</span>
				<span class="forumowner">版主：${list.boardMaster}</span>
				</a>
             </li>
        </c:forEach>
    </ul>
</div>

</body>
</html>