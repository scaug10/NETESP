<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>试题管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/css.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <style type="text/css">
        /*页码样式*/
        .pageButton{
            margin: 10px 5px;
            padding: 5px;
            float: right;
            border: 1px solid lightgrey;
            display: inline-block;
        }
        /*页码超链接样式*/
        .pageButton >  a{
            padding: 0;
            display: inline-block;
        }
        /*页码输入框*/
        .inputPage{
            height: 15px;
            width: 20px;
        }

        /*超链接样式*/
        .pageButton > a:visited{
            color: black;
        }
        /*超链接字体颜色*/
        .pageButton > a{
            color: black;
        }


        /*解决高度塌陷*/
        .clearfix:after{
            content: "";
            display: block;
            clear:both;
        }
        /*增加的按钮样式*/
        .button1{
            margin-left: 10px;
            width: 135px;
            height: 40px;
            border: none;
            font-size: 16px;
            color: #fff;
            background-color: #47a4e1;
        }
        /*搜索框右浮动*/
        .seek{
            float: right;
            display: inline-block;
        }
        /*搜索内容位置*/
        span.seek{
            padding: 10px;
        }
        /*搜索输入框位置*/
        input.seek{
            margin: 10px;
        }

        a:visited{
            color: black;
        }
    </style>
    <!--全选-->
    <script type="text/javascript">
        function createXmlHttpRequest() {
            if (window.ActiveXObject) { //如果是IE浏览器
                return new ActiveXObject("Microsoft.XMLHTTP");
            } else if (window.XMLHttpRequest) { //非IE浏览器
                return new XMLHttpRequest();
            }
        }
        
    </script>
</head>

<body>
<div id="pageAll">
    <div class="pageTop">
        <div class="page">
            <img src="${pageContext.request.contextPath }/views/img/coin02.png" /><span><a href="${pageContext.request.contextPath }/index">首页</a>&nbsp;-&nbsp;</span>试题管理
        </div>
    </div>

    <div class="page">
        <!-- 页面样式 -->
        <div class="connoisseur">
            <!--搜索框-->
            <div class="conform">
                <div class="cfD clearfix">
                    <button class="userbtn" onclick=""><a href="${pageContext.request.contextPath }/test/add/exam">增加</a></button>
                    <button class="userbtn btn_ok btn_yes operation delban" >删除</button>
                    <button class="button1 seek">查询</button>
                    <input type="text" class="seek" name="name" value="">
                    <span class="seek">试卷名称：</span>

                </div>
            </div>

            <!--  表格 显示 -->
            <div class="conShow">
                <table id="table">
                    <tr>
                        <td width="80px" class="tdColor"><input type="checkbox" name="id" onclick="changeState(this.checked)">全选</td>
                        <td width="80px" class="tdColor">ID</td>
                        <td width="435px" class="tdColor">试卷名称</td>
                        <td width="435px" class="tdColor">策略名称</td>
                        <td width="435px" class="tdColor">操作</td>

                    </tr>
                    <script type="text/javascript">
                        var url = "${pageContext.request.contextPath}/exam/query";
                        var xhr = createXmlHttpRequest();
                        xhr.open('post',url,true);
                        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                        xhr.send();
                        xhr.onreadystatechange=function () {
                            if(this.readyState ==4 && this.status == 200){
                                var json = JSON.parse(this.responseText);
                                if(json != undefined && json != null){
                                    var examinationNumber = json.length;
                                    for(var i = 0 ; i<examinationNumber ; i++){
                                        var examinationName = json[i].name;
                                        var examinationId = json[i].examId;
                                        var strategyName = json[i].strategyName;
                                        $("#table").append("<tr height='40px' id='tr_" + i + "'></tr>");
                                        document.getElementById("tr_" + i + "").innerHTML = "<td><input type=\"checkbox\" name=\"id\" value=\" + id + \"></td>\n" +
                                            "<td>" + examinationId + "</td>\n" +
                                            "<td><a href='${pageContext.request.contextPath}/test/testpaper?examId="+examinationId+
                                            "&strategyId="+json[i].strategyId+"'>" + examinationName + "</a></td>" +
                                            "<td>" + strategyName + "</td>\n" +
                                            "<td><a href=\"ExaminationPreview.html\"><img src='${pageContext.request.contextPath}/views/img/preview.png'></a></td>";
                                    }
                                }
                            }
                        }
                    </script>

                </table>
                <div class="paging"></div>
            </div>
            <!--  表格 显示 end-->
        </div>
        <!-- 页面样式end -->
    </div>
    <input type="hidden" name="strategyId" id="strategyId">

</div>


<!-- 删除弹出框 -->
<div class="banDel">
    <div class="delete">
        <div class="close">
            <a><img src="${pageContext.request.contextPath}/views/img/shanchu.png" /></a>
        </div>
        <p class="delP1">你确定要删除此条记录吗？</p>
        <p class="delP2">
            <a href="${pageContext.request.contextPath }/exam/delete" class="ok yes">确定</a><a class="ok no">取消</a>
        </p>
    </div>
</div>
<!-- 删除弹出框  end-->
</body>

<script type="text/javascript">
    // 广告弹出框
    $(".delban").click(function(){
        $(".banDel").show();
    });
    $(".close").click(function(){
        $(".banDel").hide();
    });
    $(".no").click(function(){
        $(".banDel").hide();
    });
    // 广告弹出框 end
</script>
</html>