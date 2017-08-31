<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style type="text/css">

        *{
            margin: 0;
            padding: 0;
        }

        table{
            border-top: 1px skyblue solid;
            border-bottom: 1px skyblue solid;
            font-family: "黑体";
        }

        td{
            height: 30px;
        }

        .header{
            width: 100%;
            height: 60px;
            background-color: rebeccapurple;
            margin-bottom: 10px;
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

        .boardName{
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
    <script src="${pageContext.request.contextPath }/js/react.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/react-dom.min.js"></script>
    <script src="https://cdn.bootcss.com/babel-standalone/6.22.1/babel.min.js"></script>

</head>
<body onload="postRequest()">

<div class="header">

    <span class="title">论坛版块</span>

</div>


<div id="boardlist"></div>

<script type="text/babel">

    function displayBoard(board, i) {
        var aBoard = <table><tr><td className="boardLogo" rowSpan="2" ></td><td className="boardName"></td><td className="boardMaster" rowSpan="2"></td></tr><tr><td className="boardDescribe"></td></tr></table>;
        ReactDOM.render(aBoard, document.getElementById("boardlist"));
		var href_s = "${pageContext.request.contextPath }/forum/boardThemes?boardName="+board.boardName;
        var forumLogo = <img className="forumLogo" src="${pageContext.request.contextPath }/views/forum/IMG/forum_logo.gif" alt="forumLogo"/>;
        var boardName = <a className="forumName" href={href_s}>{board.boardName}</a>;
        var boardDescribe = <span>{board.boardDescribe}</span>;
        var boardMaster = <span>{board.boardMaster}</span>;

        ReactDOM.render(forumLogo, document.getElementsByClassName("boardLogo")[i]);
        ReactDOM.render(boardName, document.getElementsByClassName("boardName")[i]);
        ReactDOM.render(boardDescribe, document.getElementsByClassName("boardDescribe")[i]);
        ReactDOM.render(boardMaster, document.getElementsByClassName("boardMaster")[i]);
    }

    function postRequest(){
        var url="${pageContext.request.contextPath }/forum/loadBoardInfo";
        var xhr = window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHTTP");
        xhr.open("POST", url, true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.send(null);
        xhr.onreadystatechange = function () {
            if(this.readyState == 4 && this.status == 200){
                var jsonObject = this.responseText;
                var result = eval("(" + jsonObject + ")");
                for(var i = 0; i < result.length; i++){
                    displayBoard(result[i], i);
                }
            }
        }
    }

</script>

</body>
</html>