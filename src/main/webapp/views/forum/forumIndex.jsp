<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>论坛列表</title>

    <style>

        *{
            margin: 0;
            padding: 0;
        }

        table{
            border-bottom: 1px mediumpurple solid;
            font-family: "黑体";
        }

        td{
            height: 30px;
        }

        .header{
            width: 100%;
            height: 60px;
            background-color: rebeccapurple;
        }

        .title{
            display: inline-block;
            color:white;
            font-size: 30px;
            margin: 10px;
            font-family: "黑体";
        }

        .forumLogo{
            vertical-align: middle;
            width: 40px;
            height: 40px;
            margin: 0 10px;
        }

        .boardLogo{
            width: 60px;
            height: 60px;
        }

        .forumName{
            text-decoration: none;
            color: black;
            font-weight:bold;
        }

        .boardName:hover{
            text-decoration: underline;
        }

        .boardMaster{
            width: 120px;
            text-align: center;
            color: darkslategray;
            font-size: 14px;
            font-weight:bold;
        }

        .boardDescribe{
            font-size: 10px;
            color: grey;
        }

        table{
            border-collapse: collapse;
            width: 100%;
        }

    </style>

</head>
<body>

<div class="header">

    <span class="title">论坛版块</span>

</div>

</div>

<c:forEach items="${boardList}" var="arr">
    <table>
        <tr>
            <td class="boardLogo" rowSpan="2" ><img class="forumLogo" src="${pageContext.request.contextPath }/views/forum/IMG/forum_logo.gif"></td>
            <td class="boardName"><a class="forumName" href="${pageContext.request.contextPath }/forum/boardThemes?boardName=${arr.boardName}">${arr.boardName}</a></td>
            <td class="boardMaster" rowSpan="2"><span style="color: grey;font-size: 12px">版主:</span><br>${arr.boardMaster}</td>
        </tr>
        <tr>
            <td class="boardDescribe">${arr.boardDescribe}</td>
        </tr>
    </table>
</c:forEach>

<div id="boardlist"></div>

</body>
</html>