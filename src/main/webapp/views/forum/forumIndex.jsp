<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>论坛列表</title>
<%--     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" /> --%>
<%-- 	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/popup.css"/> --%>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/forum/forumIndex.css" />

</head>
<body>

<div class="header">

    <span class="title">论坛版块</span>

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