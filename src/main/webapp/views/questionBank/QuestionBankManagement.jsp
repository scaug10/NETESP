<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>题库</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/css.css">
    <style type="text/css">

        * {
            margin: 0;
            padding: 0;
        }

        html, body {
            height: 100%;
        }

        a {
            text-decoration: none;
            color: black;
            font-size: 14px;
        }

        a:hover {
            text-decoration: underline;
        }

        a > img {
            width: 20px;
            height: 20px;
        }

        .left {
            display: inline-block;
            height: 75%;
            width: 19%;
            float: left;
            margin: 8px;
            border: 1px solid #e4e4e4;
            position:absolute;
            position:fixed;
        }
        .directory{
            margin-left: 20px;
        }
        .directory td{
            border: 0;
        }
        .right {
            display: inline-block;
            height: 100%;
            width: 80%;
            float: right;
        }

        .content {
            display: block;
            width: 100%;
        }

        .content > table {
            margin: 5px 2%;
            border-collapse: collapse;
            width: 96%;
        }

        .content td {
            border: 1px grey solid;
        }

        /*超链接样式*/
        .pageButton > a:visited {
            color: black;
        }

        /*超链接字体颜色*/
        .pageButton > a {
            color: black;
        }

        /*解决高度塌陷*/
        .clearfix:after {
            content: "";
            display: block;
            clear: both;
            margin-bottom: 10px;
        }

        /*增加的按钮样式*/
        .button1 {
            margin-left: 10px;
            width: 135px;
            height: 40px;
            border: none;
            font-size: 16px;
            color: #fff;
            background-color: #47a4e1;
        }

        /*搜索框右浮动*/
        .seek {
            float: right;
            display: inline-block;
        }

        /*搜索内容位置*/
        span.seek {
            padding: 10px;
        }

        /*搜索输入框位置*/
        input.seek {
            margin: 10px;
        }

        /*下拉列表位置*/
        select.seek {
            margin: 5px;
            color: black;
        }
        button.seek{
            margin-right: 25px;
        }

        select{
            width:100px;
            height: 30px;
        }

        .a1{
            margin: auto 5px;
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
            text-decoration: none;
        }

        .content > ul {
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

    </style>

    <!--全选-->
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">

        function createXmlHttpRequest() {
            if (window.ActiveXObject) { //如果是IE浏览器
                return new ActiveXObject("Microsoft.XMLHTTP");
            } else if (window.XMLHttpRequest) { //非IE浏览器
                return new XMLHttpRequest();
            }
        }

        //返回上一级时获取
        function getParentDirectory(id) {
            var xhr = createXmlHttpRequest();
            var url = "http://localhost:8080/getParentId";
            xhr.open('post', url, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send("id=" + id);
            /*发送http body*/
            xhr.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    getSubDirectory(this.responseText);
                }
            }
        }
        function getSubDirectory(id) {
            //获取并显示当前目录的子目录
            var xhr = createXmlHttpRequest();
            var url = "http://localhost:8080/getNode";
            xhr.open('post', url, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send("cwcfId=" + id);
            /*发送http body*/
            xhr.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    var result = this.responseText;
                    var resultArray = eval('(' + result + ')');
                    var number = resultArray.length;//子目录数
                    if (id == 0) {
                        var htmlCode = "";
                    } else {
                        var htmlCode = "<tr><td></td><td><a href=\"javascript:void(0);\" onclick='getParentDirectory(" + id + ")'>返回上一级目录</a></td></tr>";
                    }

                    for (var i = 0; i < number; i++) {
                        var subName = resultArray[i].classificationName;
                        var subId = resultArray[i].cwcfId;
                        var isParent = resultArray[i].parentId;

                        if (isParent) {
                            htmlCode +=
                                "<tr id=\"" + subId + "\">\n" +
                                "<td><a class=\"showHideButton\" href='javascript:void(0)' onclick=\"getSubDirectory(" + subId + "," + id + ")\"><img class=\"plus\" src='./IMG/plus.gif' alt='plus'></a></td>\n" +
                                "<td><a href=\"javascript:void(0)\" onclick=\"getCourseware(" + subId + "," + subName + ")\">" + subName + "</a></td>\n" +
                                "</tr>";
                        } else {
                            htmlCode +=
                                "<tr id=\"" + subId + "\">\n" +
                                "<td></td>" +
                                "<td><a href=\"javascript:void(0)\" onclick=\"getCourseware(" + subId + ")\">" + subName + "</a></td>\n" +
                                "</tr>";
                        }


                    }
                    document.getElementById("directory").innerHTML = htmlCode;
                }
            }
        }

        /*获取分类下的课件*/
        function getQuestionBank(id, name) {
            document.getElementById("classificationCRUD").innerHTML =
                "<ul>\n" +
                "<li><a class=\"navtablink\" href=\"javascript:void(0)\" onclick=\"createClassification()\">新增分类</a></li>\n" +
                "<li><a class=\"navtablink\" href=\"javascript:void(0)\" onclick=\"modifyClassification('" + name + "')\">修改分类</a></li>\n" +
                "<li><a class=\"navtablink\" href=\"javascript:void(0)\" onclick=\"deleteClassification(" + id + ")\">删除分类</a></li>\n" +
                "<li><a class=\"navtablink\" href=\"${pageContext.request.contextPath}/subject/add\" >新增试题</a></li>\n" +
                "<li><a class=\"navtablink\" href=\"javascript:void(0)\" onclick=\"confirm()\">删除试题</a></li>\n" +
                "</ul>" +
                ""
            ;
            document.getElementById("searchBar").innerHTML="<button class=\"button1 seek\">查询</button>\n" +
                "        <select name=\"condition\" class=\"seek \">\n" +
                "            <option value=\"\">不限</option>\n" +
                "            <option value=\"\">未审核</option>\n" +
                "            <option value=\"\">审核通过</option>\n" +
                "        </select>\n" +
                "        <span class=\"seek\">状态：</span>\n" +
                "        <select name=\"difficulty\" class=\"seek \">\n" +
                "            <option value=\"0\">不限</option>\n" +
                "            <option value=\"1\">1</option>\n" +
                "            <option value=\"2\">2</option>\n" +
                "            <option value=\"3\">3</option>\n" +
                "            <option value=\"4\">4</option>\n" +
                "            <option value=\"5\">5</option>\n" +
                "            <option value=\"6\">6</option>\n" +
                "            <option value=\"7\">7</option>\n" +
                "            <option value=\"8\">8</option>\n" +
                "            <option value=\"9\">9</option>\n" +
                "            <option value=\"10\">10</option>\n" +
                "        </select>\n"+
                " <span class=\"seek\">试题难度：</span>\n"+
                " <select name=\"subjectType\" class=\"seek \">\n"+
                " <option value=\"0\">不限</option>\n"+
                " <option value=\"1\">单选题</option>\n"+
                " <option value=\"2\">多选题</option>\n"+
                " <option value=\"3\">判断题</option>\n"+
                " <option value=\"4\">填空题</option>\n"+
                " <option value=\"5\">计算题</option>\n"+
                " <option value=\"6\">简答题</option>\n"+
                "        </select>\n"+
                " <span class=\"seek\">试题类型：</span>\n"+
                " <input type=\"text\" class=\"seek\" name=\"describe\">\n"+
                " <span class=\"seek\">试题描述：</span>";
            document.getElementById("questiontable").innerHTML = "" +
                "        <tr class=\"title\" width=\"100%\">\n" +
                "            <td class=\"tdColor\"><input type=\"checkbox\" name=\"id\" onclick=\"changeState(this.checked)\" style='vertical-align: middle'>全选</td>\n" +
                "            <td class=\"tdColor\">ID</td>\n" +
                "            <td class=\"tdColor\">试题描述</td>\n" +
                "            <td class=\"tdColor\">类型</td>\n" +
                "            <td class=\"tdColor\">难度</td>\n" +
                "            <td class=\"tdColor\">状态</td>\n" +
                "            <td class=\"tdColor\">操作</td>\n" +
                "        </tr>\n" +
                "";
            for(var i=0;i<20 ;i++){
                var id = i +1;
                var describe = "怎样正确验电？";
                var subjectType = "简答题";
                var difficulty = "5";
                var condition = "未审核";
                var questionTr = document.getElementById("questiontable");
                questionTr.innerHTML=questionTr.innerHTML+"<tr id='tr_"+(i+1)+"' height=\"40px\"></tr>";
                document.getElementById("tr_"+(i+1)+"").innerHTML="" +
                    "<td><input type=\"checkbox\" name=\"id\" value=\" + id + \"></td>\n" +
                    "<td>"+ id +"</td>\n" +
                    "<td>"+ describe +"</td>\n" +
                    "<td>"+ subjectType +"</td>\n" +
                    "<td>"+ difficulty +"</td>\n" +
                    "<td>"+ condition +"</td>\n"+
                    "<td>"+"<a class='a1' href='StrategyChange.html'><img src='../img/update.png'></a>"+
                    "<a class='a1' href='QuestionCheckMore.html'><img src='../img/check.png'></a>"+"</td>"
                    ;
            }

        }
        function createClassification() {
            //在本分类创建子课件分类
            var newClassName = prompt("在当前分类新建子分类：", "请输入分类名");
            if (newClassName.length != 0) {
                var xhr = createXmlHttpRequest();
                var url = "saveCoursewareClassification";
                xhr.open("post", url, true);
                xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                xhr.send("classificationName=" + newClassName + "&parentId=" + document.getElementById("getClassificationId").value);
                this.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        var result = this.responseText;
                        if (result == 1){
                            alert("新建子课件成功");
                            location.reload();
                        }else if(result == 2){
                            alert("当前分类名已存在！");
                        }else{
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
                if (newClassificationName == oldName){
                    alert("未修改分类名!");
                }else{
                    if(newClassificationName.length == 0){
                        alert("目录名不允许为空！");
                    }else{
                        var xhr = createXmlHttpRequest();
                        var url = "editCoursewareClassification";
                        xhr.open("post", url, true);
                        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                        xhr.send("classificationName=" + newClassificationName + "&cwcfId=" + classificationId);
                        this.onreadystatechange = function () {
                            if (this.readyState == 4 && this.status == 200) {
                                if(this.responseText == 1){
                                    alert("修改成功");
                                    getParentDirectory(classificationId);
                                }else{
                                    alert(this.responseText==2?"该分类名存在":"未知错误")
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
                    var xhr = createXmlHttpRequest();
                    var url = "deleteCoursewareClassification";
                    xhr.open("post", url, true);
                    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                    xhr.send("cwcfId=" + id);
                    this.onreadystatechange = function () {
                        if (this.readyState == 4 && this.status == 200) {
                            if (this.responseText == 1) {
                                alert("删除分类成功！");
                            } else {
                                alert("删除分类失败！");
                            }
                            location.reload();
                        }
                    }
                }
            }
        }

    </script>
    <script type="text/javascript">
        function changeState(isChecked) {
            var chk_list = document.getElementsByTagName("input");
            for (var i = 0; i < chk_list.length; i++) {
                if (chk_list[i].type == "checkbox") {
                    chk_list[i].checked = isChecked;
                }
            }
        }
    </script>
</head>


<body>
<!--<div id="pageAll content">-->
    <!--<div class="pageTop">-->
        <!--<div class="page">-->
            <!--<img src="../img/coin02.png" /><span><a href="../main.html">首页</a>&nbsp;-&nbsp;</span>题库管理-->
        <!--</div>-->
    <!--</div>-->
<!--</div>-->

<div class="left">

    <table id="directory" class="directory" >
        <tr id="0">
            <td>
                <a class="showHideButton" href="javascript:void(0)" onclick="getSubDirectory(1)"><img
                        src="../img/plus.gif" alt="plus"></a>
            </td>
            <td><a href="javascript:void(0)" onclick="getQuestionBank(1, '根目录')">根目录</a></td>
        </tr>
    </table>

</div>

<!--搜索框-->
<div class="right">
    <div id="classificationCRUD" class="clearfix"></div>
    <div id ="searchBar" class="clearfix"></div>
    <div class="content clearfix" >
        <table id="questiontable">
        </table>
    </div>
</div>
<div class="banDel">
    <div class="delete">
        <div class="close">
            <a><img src="../img/shanchu.png" /></a>
        </div>
        <p class="delP1">你确定要删除此条记录吗？</p>
        <p class="delP2">
            <a href="#" class="ok yes">确定</a><a class="ok no">取消</a>
        </p>
    </div>
</div>


</body>
<script type="text/javascript">
    function  confirm(){
        $(".banDel").show();
        $(".close").click(function () {
            $(".banDel").hide();
        });
        $(".no").click(function () {
            $(".banDel").hide();
        });
    }
</script>
</html>