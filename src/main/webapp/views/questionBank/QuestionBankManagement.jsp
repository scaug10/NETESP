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

        a{
            text-decoration: none;
            color: black;
            font-size: 14px;
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
        .directory tr{
            display: inline-block;
            margin: 10px 50px;
        }
        .directory td{
            border: 0;
            padding: 10px;
            background-color:#47a4e1;
        }

        td a{
            color: white;
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
            margin-top: 10px;
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

      
        /*获取分类下的课件*/
        function getQuestionBank(id) {
            document.getElementById("classificationCRUD").innerHTML ="" +
                "<button class='button1' onclick=\"javascript:window.location.href='${pageContext.request.contextPath}/subject/add'\">新增试题</button>"+
                "<button class='button1' onclick='deleteSubject("+id+")'>删除试题</button>";
            document.getElementById("searchBar").innerHTML="<button class=\"button1 seek\" onclick='searchSubject()'>查询</button>\n" +
                "        <select name=\"condition\" class=\"seek \" id='reviewType'>\n" +
                "            <option value=\"\">不限</option>\n" +
                "            <option value=\"0\">未审核</option>\n" +
                "            <option value=\"1\">审核通过</option>\n" +
                "            <option value=\"2\">审核未通过</option>\n" +
                "        </select>\n" +
                "        <span class=\"seek\">状态：</span>\n" +
                "        <select name=\"difficulty\" class=\"seek \" id='name'>\n" +
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
                " <select name=\"subjectType\" class=\"seek \" id='subjectType'>\n"+
                " <option value=\"\">不限</option>\n"+
                " <option value=\"单选题\">单选题</option>\n"+
                " <option value=\"多选题\">多选题</option>\n"+
                " <option value=\"判断题\">判断题</option>\n"+
                " <option value=\"填空题\">填空题</option>\n"+
                " <option value=\"计算题\">计算题</option>\n"+
                " <option value=\"简答题\">简答题</option>\n"+
                "        </select>\n"+
                " <span class=\"seek\">试题类型：</span>\n"+
                " <input type=\"text\" class='seek' name=\"describe\" id='content'>\n"+
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
            var xhr = window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHTTP");
            var url = "${pageContext.request.contextPath}/subject/all";
            xhr.open("post", url, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send("id="+id);
            xhr.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    var jsonobject= this.responseText;
                    var resultArray = JSON.parse(jsonobject);
                    for(var i=0;i< resultArray.length ;i++){
                        var id = resultArray[i].subjectId;//题目ID
                        var describe = resultArray[i].content;//题目描述
                        var subjectType = resultArray[i].subjectType;//题目类型
                        var difficulty = resultArray[i].name;//题目难度
                        var condition = resultArray[i].reviewType == 0 ? "未审核" : "已审核";//题目审核状态
                        var questionTr = document.getElementById("questiontable");
                        questionTr.innerHTML=questionTr.innerHTML+"<tr id='tr_"+(i+1)+"' height=\"40px\"></tr>";
                        document.getElementById("tr_"+(i+1)+"").innerHTML="" +
                            "<td><input type=\"checkbox\" name=\"id\" value=\""+id+"\"></td>\n" +
                            "<td>"+ id +"</td>\n" +
                            "<td>"+ describe +"</td>\n" +
                            "<td>"+ subjectType +"</td>\n" +
                            "<td>"+ difficulty +"</td>\n" +
                            "<td>"+ condition +"</td>\n"+
                            "<td>"+"<a class='a1' href='${pageContext.request.contextPath}/subject/edit?subjectId="+id+"'><img src='${pageContext.request.contextPath}/views/img/update.png'></a>"+
                            "<a class='a1' href='${pageContext.request.contextPath}/subject/check?subjectId="+id+"'><img src='${pageContext.request.contextPath}/views/img/check.png'></a>"+"</td>"
                        ;
                    }
                }
            }


        }
        
        function searchSubject(){
        	var name = document.getElementById("name").value;
        	var reviewType = document.getElementById("reviewType").value;
        	var content = document.getElementById("content").value;
        	var subjectType = document.getElementById("subjectType").value;
        	var data = "name="+name+"&reviewType="+reviewType+"&content="+content+
        		"&subjectType="+subjectType;
//         	alert(data);
        	var xhr = window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHTTP");
            var url = "${pageContext.request.contextPath}/subject/search";
            xhr.open("post", url, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send(data);
            xhr.onreadystatechange = function () {
//             	alert(this.readyState);
                if (this.readyState == 4 && this.status == 200) {
                    var jsonobject= this.responseText;
                    var resultArray = JSON.parse(jsonobject);
                    var questionTr = document.getElementById("questiontable");
                    questionTr.innerHTML="";
                    for(var i=0;i< resultArray.length ;i++){
                        var id = resultArray[i].subjectId;//题目ID
                        var describe = resultArray[i].content;//题目描述
                        var subjectType = resultArray[i].subjectType;//题目类型
                        var difficulty = resultArray[i].name;//题目难度
                        var condition = resultArray[i].reviewType == 0 ? "未审核" : "已审核";//题目审核状态
//                         var questionTr = document.getElementById("questiontable");
                        questionTr.innerHTML+="<tr id='tr_"+(i+1)+"' height=\"40px\"></tr>";
                        document.getElementById("tr_"+(i+1)+"").innerHTML="" +
                            "<td><input type=\"checkbox\" name=\"id\" value=\""+id+"\"></td>\n" +
                            "<td>"+ id +"</td>\n" +
                            "<td>"+ describe +"</td>\n" +
                            "<td>"+ subjectType +"</td>\n" +
                            "<td>"+ difficulty +"</td>\n" +
                            "<td>"+ condition +"</td>\n"+
                            "<td>"+"<a class='a1' href='${pageContext.request.contextPath}/subject/edit?subjectId="+id+"'><img src='${pageContext.request.contextPath}/views/img/update.png'></a>"+
                            "<a class='a1' href='${pageContext.request.contextPath}/subject/check?subjectId="+id+"'><img src='${pageContext.request.contextPath}/views/img/check.png'></a>"+"</td>"
                        ;
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
<div class="pageTop">
			<div class="page">
				<img src="${pageContext.request.contextPath}/views/img/coin02.png" /><span><a
					href="${pageContext.request.contextPath }/index">首页</a>&nbsp;-&nbsp;-</span>&nbsp;<a
					href="${pageContext.request.contextPath }/questionbank">知识库</a>
			</div>
		</div>

<div class="left">
	
    <table id="directory" class="directory" >
        <tr id="0">
            <td><a href="javascript:void(0)" onclick="getQuestionBank(0)">正规题库</a></td>
        </tr>
        <tr id="1">
            <td><a href="javascript:void(0)" onclick="getQuestionBank(1)">练习题库</a></td>
        </tr>
        <tr id="2">
            <td><a href="javascript:void(0)" onclick="getQuestionBank(2)">模拟题库</a></td>
        </tr>
        <tr id="3">
            <td><a href="javascript:void(0)" onclick="getQuestionBank(3)">竞赛题库</a></td>
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
            <a><img src="${pageContext.request.contextPath}/views/img/shanchu.png" /></a>
        </div>
        <p class="delP1">你确定要删除此条记录吗？</p>
        <p class="delP2">
            <a href="javascript:void(0)"  onclick="deleteSubject()">确定</a><a class="ok no">取消</a>
        </p>
    </div>
</div>


</body>
<script type="text/javascript">
    
    function deleteSubject(id)
    {
    	 if(!confirm("是否删除")) return false;
    	 var idList = document.getElementsByName("id");
    	 var list = new Array();
    	 for(var i = 0; i < idList.length; ++i){
    		 if(idList[i].checked) list.push(idList[i].value);
    	 }
    	 var xhr = window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHTTP");
         var url = "${pageContext.request.contextPath}/subject/delete";
         xhr.open("post", url, true);
         xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
         xhr.send("idList="+list);
         xhr.onreadystatechange = function () {
             if (this.readyState == 4 && this.status == 200) {
                 var json = JSON.parse(this.responseText);
                 if(json != 0){
                	 alert("删除成功");
                	 getQuestionBank(id);
                 }
                 else alert("删除失败");
             }
         }
    }
    
</script>
</html>