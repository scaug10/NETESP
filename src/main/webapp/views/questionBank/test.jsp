﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>远程教育考试平台_在线考试</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/test/test.css">
    <script type="text/javascript"></script>
    <style type="text/css">
        .hasBeenAnswer {
            background: #5d9cec;
            color:#fff;
        }

        [type=text]{
            width: 20em;
            margin-top: 8px;
        }

        label{
            padding-top: 5px;
        }
    </style>
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
<div class="main">
    <!--nr start-->
    <!-- 单选题 -->
    <div class="test_main">
        <div class="nr_left">
            <div class="test">
                <form action="" method="post">
                    <div class="test_title">
                        <input type="button" name="test_jiaojuan" value="交卷">
                    </div>
                    <div class="test_content">
                        <div class="test_content_title">
                            <script type="text/javascript">
                            	var url = "${pageContext.request.contextPath}/test/singleChoice";
                            	var data = "examId=1&strategyId=1&subjectType=单选题";
                            	var xhr = createXmlHttpRequest();
                            	xhr.open('post', url, true);
                                xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                                xhr.send(data);
                                xhr.onreadystatechange = function () {
                                    if (this.readyState == 4 && this.status == 200) {
                                        var json = JSON.parse(this.responseText);
                                        if(json != undefined && json != null){
                                        	var radioQuestionNumber = json.list.length;
                                            var radioQuestionScore = json.singleScore * json.list.length;
                                            document.getElementsByClassName("test_content_title")[0].innerHTML="<h2>单选题</h2>" +
                                                "<p>" +
                                                "<span>共</span>" +
                                                "<i class='content_lit'>"+radioQuestionNumber+"</i>" +
                                                "<span>题，</span>" +
                                                "<span>合计</span>" +
                                                "<i class='content_fs'>"+radioQuestionScore+"</i>" +
                                                "<span>分</span>" +
                                                "</p>";
                                                
                                            singleChoiceQuestion(json);
                                        }
                                    }
                                }
                                
                            </script>

                        </div>
                    </div>
                    <div class="test_content_nr">
                        <ul id="radio">
                            <script type="text/javascript">
                            var frontQuestionNumber = 0
                           	function singleChoiceQuestion(json){
                                var radioQuestionNumber = json.list.length;
                                var radioQuestionScore = json.singleScore;
                           		for(var i = 0; i < json.list.length; ++i){
                           			var questionTitle = json.list[i].content;
                           			var AOption = json.list[i].choice.optionA;
                                       var BOption = json.list[i].choice.optionB;
                                       var COption = json.list[i].choice.optionC;
                                       var DOption = json.list[i].choice.optionD;
                                       var radio = document.getElementById("radio");
                                       radio.innerHTML = radio.innerHTML + "<li id='qu_" + (i + 1) + "'></li>";
                                       document.getElementById("qu_"+(i+1)+"").innerHTML=
                                           "<div class='test_content_nr_tt'>" +
                                           "<i>"+(i+1)+"</i><span>("+radioQuestionScore+"分)</span>"+questionTitle+"" +
                                           "</div>" +
                                           "<div class='test_content_nr_main'>" +
                                           "<ul>" +
                                           "<li class='option'>" +
                                           "<input type='radio' class='radioOrCheck' name='answer"+(i+1)+"' id='answer_"+(i+1)+"_option_1' />" +
                                           "<label for='answer_"+(i+1)+"_option_1'>" +
                                           "A.&nbsp;" +
                                           "<p class='ue' style='display:inline '>"+AOption+"</p>" +
                                           "</label>" +
                                           "</li>" +
                                           "<li class='option'>" +
                                           "<input type='radio' class='radioOrCheck' name='answer"+(i+1)+"' id='answer_"+(i+1)+"_option_2' />" +
                                           "<label for='answer_"+(i+1)+"_option_2'>" +
                                           "B.&nbsp;" +
                                           "<p class='ue' style='display:inline '>"+BOption+"</p>" +
                                           "</label>" +
                                           "</li>" +
                                           "<li class='option'>" +
                                           "<input type='radio' class='radioOrCheck' name='answer"+(i+1)+"' id='answer_"+(i+1)+"_option_3' />" +
                                           "<label for='answer_"+(i+1)+"_option_3'>" +
                                           "C.&nbsp;" +
                                           "<p class='ue' style='display:inline '>"+COption+"</p>" +
                                           "</label>" +
                                           "</li>" +
                                           "<li class='option'>" +
                                           "<input type='radio' class='radioOrCheck' name='answer"+(i+1)+"' id='answer_"+(i+1)+"_option_4' />" +
                                           "<label for='answer_"+(i+1)+"_option_4'>" +
                                           "D.&nbsp;" +
                                           "<p class='ue' style='display:inline '>"+DOption+"</p>" +
                                           "</label>" +
                                           "</li>" +
                                           "</ul>" +
                                           "</div>";
                           		}
                           	}
                            </script>
                        </ul>
                    </div>
                    
                    <!-- 多选题 -->
                    <div class="test_content">
                        <div class="test_content_title">
                            <script type="text/javascript">
                            	function checkBoxQuestion(){
                            		var url = "${pageContext.request.contextPath}/test/singleChoice";
                                	var data = "examId=1&strategyId=1&subjectType=多选题";
                                	var xhr = createXmlHttpRequest();
                                	xhr.open('post', url, true);
                                    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                                    xhr.send(data);
                                    xhr.onreadystatechange = function () {
                                        if (this.readyState == 4 && this.status == 200) {
                                            var json = JSON.parse(this.responseText);
                                            if(json != undefined && json != null){
                                            	var checkboxQuestionNumber = json.list.length;
                                                var checkboxQuestionScore = json.singleScore * checkboxQuestionNumber;
                                                document.getElementsByClassName("test_content_title")[1].innerHTML="<h2>多选题</h2>" +
                                                "<p>" +
                                                "<span>共</span>" +
                                                "<i class='content_lit'>"+checkboxQuestionNumber+"</i>" +
                                                "<span>题，</span>" +
                                                "<span>合计</span>" +
                                                "<i class='content_fs'>"+checkboxQuestionScore+"</i>" +
                                                "<span>分</span>" +
                                                "</p>";
                                            }
                                        }
                                     }
                            	}
                            </script>
                        </div>
                    </div>
                    <div class="test_content_nr">
                        <ul id="checkbox">
                            <script type="text/javascript">
                                frontQuestionNumber += checkboxQuestionNumber;
                                for(var i=radioQuestionNumber;i<radioQuestionNumber+checkboxQuestionNumber;i++){
                                    var questionTitle="在生产管理信息系统中，下列操作步骤能正确将工单推进流程的是（  ）";
                                    var AOption = "A";
                                    var BOption = "B";
                                    var COption = "C";
                                    var DOption = "D";
                                    var checkbox = document.getElementById("checkbox");
                                    checkbox.innerHTML += "<li id='qu_" + (i + 1) + "'></li>";
                                    document.getElementById("qu_"+(i+1)+"").innerHTML=
                                        "<div class='test_content_nr_tt'>" +
                                        "<i>"+(i+1)+"</i><span>("+(checkboxQuestionScore/checkboxQuestionNumber)+"分)</span>"+questionTitle+"" +
                                        "</div>" +
                                        "<div class='test_content_nr_main'>" +
                                        "<ul>" +
                                        "<li class='option'>" +
                                        "<input type='checkbox' class='radioOrCheck' name='answer"+(i+1)+"' id='answer_"+(i+1)+"_option_1'/>" +
                                        "<label for='answer_"+(i+1)+"_option_1'>" +
                                        "A.&nbsp;" +
                                        "<p class='ue' style='display:inline '>"+AOption+"</p>" +
                                        "</label>" +
                                        "</li>" +
                                        "<li class='option'>" +
                                        "<input type='checkbox' class='radioOrCheck' name='answer"+(i+1)+"' id='answer_"+(i+1)+"_option_2'/>" +
                                        "<label for='answer_"+(i+1)+"_option_2'>" +
                                        "B.&nbsp;" +
                                        "<p class='ue' style='display:inline '>"+BOption+"</p>" +
                                        "</label>" +
                                        "</li>" +
                                        "<li class='option'>" +
                                        "<input type='checkbox' class='radioOrCheck' name='answer"+(i+1)+"' id='answer_"+(i+1)+"_option_3'/>" +
                                        "<label for='answer_"+(i+1)+"_option_3'>" +
                                        "C.&nbsp;" +
                                        "<p class='ue' style='display:inline '>"+COption+"</p>" +
                                        "</label>" +
                                        "</li>" +
                                        "<li class='option'>" +
                                        "<input type='checkbox' class='radioOrCheck' name='answer"+(i+1)+"' id='answer_"+(i+1)+"_option_4'/>" +
                                        "<label for='answer_"+(i+1)+"_option_4'>" +
                                        "D.&nbsp;" +
                                        "<p class='ue' style='display:inline '>"+DOption+"</p>" +
                                        "</label>" +
                                        "</li>" +
                                        "</ul>" +
                                        "</div>";
                                }

                            </script>
                        </ul>
                    </div>
                    <div class="test_content">
                        <div class="test_content_title">
                            <script type="text/javascript">
                                var fillQuestionNumber = 2;
                                var fillQuestionScore = 2;
                                document.getElementsByClassName("test_content_title")[2].innerHTML="<h2>填空题</h2>" +
                                    "<p>" +
                                    "<span>共</span>" +
                                    "<i class='content_lit'>"+fillQuestionNumber+"</i>" +
                                    "<span>题，</span>" +
                                    "<span>合计</span>" +
                                    "<i class='content_fs'>"+fillQuestionScore+"</i>" +
                                    "<span>分</span>" +
                                    "</p>";
                            </script>
                        </div>
                    </div>
                    <div class="test_content_nr">
                        <ul id="fill">
                            <script type="text/javascript">
                                frontQuestionNumber += checkboxQuestionNumber;
                                var fillQuestionNumber = 2;
                                for(var i=frontQuestionNumber;i<frontQuestionNumber+fillQuestionNumber;i++){
                                    var fillNumber = 2;
                                    var questionTitle="以下属于南方电网员工职业操守中明文规定的有__________。";
                                    var fill = document.getElementById("fill");
                                    fill.innerHTML+="<li id='qu_" + (i + 1) + "'></li>";
                                    document.getElementById("qu_" + (i + 1) + "").innerHTML=
                                        "<div class='test_content_nr_tt'>" +
                                        "<i>"+(i+1)+"</i><span>("+(fillQuestionScore/fillQuestionNumber)+"分)</span>"+questionTitle+"" +
                                        "</div>" +
                                        "<div class='test_content_nr_main' id='fillMain"+(i+1)+"'>" +
                                        "</div>"
                                    ;
                                    for(var j=0;j<fillNumber;j++){
                                        var fillMain = document.getElementById("fillMain"+(i+1)+"");
                                        fillMain.innerHTML += "<div id='ans_"+(i+1)+"_"+(j+1)+"'></div>";
                                        document.getElementById("ans_"+(i+1)+"_"+(j+1)+"").innerHTML=
                                            "<input type='text' class='radioOrCheck' name='answer"+(i+1)+"' " +
                                            "id='answer_"+(i+1)+"_"+(j+1)+"'/>" +
                                            "<br />";
                                    }
                                }
                            </script>
                        </ul>
                    </div>
                    <div class="test_content">
                        <div class="test_content_title">
                            <script type="text/javascript">
                                var judgmentQuestionNumber = 2;
                                var judgmentQuestionScore = 2;
                                document.getElementsByClassName("test_content_title")[3].innerHTML="<h2>判断题</h2>" +
                                    "<p>" +
                                    "<span>共</span>" +
                                    "<i class='content_lit'>"+judgmentQuestionNumber+"</i>" +
                                    "<span>题，</span>" +
                                    "<span>合计</span>" +
                                    "<i class='content_fs'>"+judgmentQuestionScore+"</i>" +
                                    "<span>分</span>" +
                                    "</p>";
                            </script>
                        </div>
                    </div>
                    <div class="test_content_nr">
                        <ul id="judgment">
                            <script type="text/javascript">
                                frontQuestionNumber += fillQuestionNumber;
                                var judgmentQuestionNumber = 2;
                                for(var i = frontQuestionNumber;i<frontQuestionNumber+judgmentQuestionNumber;i++) {
                                    var questionTitle = "在生产管理信息系统中，下列操作步骤能正确将工单推进流程的是（  ）";
                                    var AOption = "A";
                                    var BOption = "B";
                                    var judgment = document.getElementById("judgment");
                                    judgment.innerHTML += "<li id='qu_" + (i + 1) + "'></li>";
                                    document.getElementById("qu_"+(i+1)+"").innerHTML =
                                        "<div class='test_content_nr_tt'>" +
                                        "<i>"+(i+1)+"</i><span>("+(judgmentQuestionScore/judgmentQuestionNumber)+"分)</span>"+questionTitle+"" +
                                        "</div>" +
                                        "<div class='test_content_nr_main'>" +
                                        "<ul>" +
                                        "<li class='option'>" +
                                        "<input type='radio' class='radioOrCheck' name='answer"+(i+1)+"' id='answer_"+(i+1)+"_option_1' onclick='radioClick("+(i+1)+")'/>" +
                                        "<label for='answer_"+(i+1)+"_option_1'>" +
                                        "A.&nbsp;" +
                                        "<p class='ue' style='display:inline '>"+AOption+"</p>" +
                                        "</label>" +
                                        "</li>" +
                                        "<li class='option'>" +
                                        "<input type='radio' class='radioOrCheck' name='answer"+(i+1)+"' id='answer_"+(i+1)+"_option_2' onclick='radioClick("+(i+1)+")'/>" +
                                        "<label for='answer_"+(i+1)+"_option_2'>" +
                                        "B.&nbsp;" +
                                        "<p class='ue' style='display:inline '>"+BOption+"</p>" +
                                        "</label>" +
                                        "</li>" +
                                        "</ul>" +
                                        "</div>";
                                }
                            </script>
                        </ul>
                    </div>
                    <div class="test_content">
                        <div class="test_content_title">
                            <script type="text/javascript">
                                var countQuestionNumber = 2;
                                var countQuestionScore = 2;
                                document.getElementsByClassName("test_content_title")[4].innerHTML="<h2>计算题</h2>" +
                                    "<p>" +
                                    "<span>共</span>" +
                                    "<i class='content_lit'>"+countQuestionNumber+"</i>" +
                                    "<span>题，</span>" +
                                    "<span>合计</span>" +
                                    "<i class='content_fs'>"+countQuestionScore+"</i>" +
                                    "<span>分</span>" +
                                    "</p>";
                            </script>
                        </div>
                    </div>
                    <div class="test_content_nr">
                        <ul id="count">
                            <script type="text/javascript">
                                frontQuestionNumber += judgmentQuestionNumber;
                                var countQuestionNumber = 2;
                                for(var i=frontQuestionNumber;i<frontQuestionNumber+countQuestionNumber;i++) {
                                    var countNumber = 2;
                                    var questionTitle = "以下属于南方电网员工职业操守中明文规定的有?";
                                    var count =document.getElementById("count");
                                    count.innerHTML += "<li id='qu_" + (i + 1) + "'></li>";
                                    document.getElementById("qu_" + (i + 1) + "").innerHTML=
                                        "<div class='test_content_nr_tt'>" +
                                        "<i>"+(i+1)+"</i><span>("+(countQuestionScore/countQuestionNumber)+"分)</span>"+questionTitle+"" +
                                        "</div>" +
                                        "<div class='test_content_nr_main' id='countMain"+(i+1)+"'>" +
                                        "</div>"
                                    ;
                                    for(var j=0;j<countNumber;j++){
                                        var countMain = document.getElementById("countMain"+(i+1)+"");
                                        countMain.innerHTML += "<div id='answer_"+(i+1)+"_"+(j+1)+"'></div>";
                                        document.getElementById("answer_"+(i+1)+"_"+(j+1)+"").innerHTML=
                                            "<input type='text' class='radioOrCheck' name='answer"+(i+1)+"' " +
                                            "id='answer_"+(i+1)+"_"+(j+1)+"'/>" +
                                            "<br />";
                                    }

                                }
                            </script>
                        </ul>
                    </div>
                    <div class="test_content">
                        <div class="test_content_title">
                            <script>
                                var shortAnswerQuestionNumber = 2;
                                var shortAnswerQuestionScore = 3;
                                document.getElementsByClassName("test_content_title")[5].innerHTML="<h2>简答题</h2>" +
                                    "<p>" +
                                    "<span>共</span>" +
                                    "<i class='content_lit'>"+shortAnswerQuestionNumber+"</i>" +
                                    "<span>题，</span>" +
                                    "<span>合计</span>" +
                                    "<i class='content_fs'>"+shortAnswerQuestionScore+"</i>" +
                                    "<span>分</span>" +
                                    "</p>";
                            </script>
                        </div>
                    </div>
                    <div class="test_content_nr">
                        <ul id="shortAnswer">
                            <script type="text/javascript">
                                frontQuestionNumber += countQuestionNumber;
                                var shortAnswerQuestionNumber = 2;
                                for(var i = frontQuestionNumber;i < frontQuestionNumber + shortAnswerQuestionNumber;i++){
                                    var questionTitle="以下属于南方电网员工职业操守中明文规定的有?";
                                    var shortAnswer = document.getElementById("shortAnswer");
                                    shortAnswer.innerHTML += "<li id='qu_" + (i + 1) + "'></li>";
                                    document.getElementById("qu_" + (i + 1) + "").innerHTML =
                                        "<div class='test_content_nr_tt'>" +
                                        "<i>"+(i+1)+"</i><span>("+(shortAnswerQuestionScore/shortAnswerQuestionNumber)+"分)</span>"+questionTitle+"" +
                                        "</div>" +
                                        "<div class='test_content_nr_main'>" +
                                        "<textarea name='answer"+(i+1)+"' id='answer_"+(i+1)+"' cols='100%' rows='10'></textarea>" +
                                        "</div>"
                                    ;
                                }
                            </script>
                        </ul>
                    </div>
                </form>
            </div>
        </div>
        <div class="nr_right">
            <div class="nr_rt_main">
                <div class="rt_nr1">
                    <div class="rt_nr1_title">
                        <h1>
                            <i class="icon iconfont">&#xe692;</i>答题卡
                        </h1>
                    </div>

                    <div class="rt_content">
                        <div class="rt_content_tt">
                            <script>
                                document.getElementsByClassName("rt_content_tt")[0].innerHTML="<h2>单选题</h2>" +
                                    "<p>" +
                                    "<span>共</span>" +
                                    "<i class='content_lit'>"+radioQuestionNumber+"</i>" +
                                    "<span>题</span>" +
                                    "</p>";
                            </script>
                        </div>
                        <div class="rt_content_nr answerSheet">
                            <ul id="answerSheet1">
                                <script>
                                    var frontQuestionNumber = 0;
                                    for(var i=frontQuestionNumber;i<radioQuestionNumber+frontQuestionNumber;i++){
                                        var answerSheet1 = document.getElementById("answerSheet1");
                                        answerSheet1.innerHTML += "<li><a href='#qu_"+(i+1)+"' id='an_"+(i+1)+"'>"+ (i+1) +"</a></li>";
                                    }
                                </script>
                            </ul>
                        </div>
                    </div>

                    <div class="rt_content">
                        <div class="rt_content_tt">
                            <script>
                                document.getElementsByClassName("rt_content_tt")[1].innerHTML="<h2>多选题</h2>" +
                                    "<p>" +
                                    "<span>共</span>" +
                                    "<i class='content_lit'>"+checkboxQuestionNumber+"</i>" +
                                    "<span>题</span>" +
                                    "</p>";
                            </script>
                        </div>
                        <div class="rt_content_nr answerSheet">
                            <ul id="answerSheet2">
                                <script>
                                    frontQuestionNumber += radioQuestionNumber;
                                    for(var i=frontQuestionNumber;i<checkboxQuestionNumber+frontQuestionNumber;i++){
                                        var answerSheet2 = document.getElementById("answerSheet2");
                                        answerSheet2.innerHTML += "<li><a href='#qu_"+(i+1)+"' >"+ (i+1) +"</a></li>";
                                    }
                                </script>
                            </ul>
                        </div>
                    </div>

                    <div class="rt_content">
                        <div class="rt_content_tt">

                            <script>
                                document.getElementsByClassName("rt_content_tt")[2].innerHTML="<h2>填空题</h2>" +
                                    "<p>" +
                                    "<span>共</span>" +
                                    "<i class='content_lit'>"+fillQuestionNumber+"</i>" +
                                    "<span>题</span>" +
                                    "</p>";
                            </script>
                        </div>
                        <div class="rt_content_nr answerSheet">
                            <ul id="answerSheet3">
                                <script>
                                    frontQuestionNumber += checkboxQuestionNumber;
                                    for(var i=frontQuestionNumber;i<fillQuestionNumber+frontQuestionNumber;i++){
                                        var answerSheet3 = document.getElementById("answerSheet3");
                                        answerSheet3.innerHTML += "<li><a href='#qu_"+(i+1)+"' >"+ (i+1) +"</a></li>";
                                    }
                                </script>
                            </ul>
                        </div>
                    </div>
                    <div class="rt_content">
                        <div class="rt_content_tt">
                            <script>
                                document.getElementsByClassName("rt_content_tt")[3].innerHTML="<h2>判断题</h2>" +
                                    "<p>" +
                                    "<span>共</span>" +
                                    "<i class='content_lit'>"+judgmentQuestionNumber+"</i>" +
                                    "<span>题</span>" +
                                    "</p>";
                            </script>
                        </div>
                        <div class="rt_content_nr answerSheet">
                            <ul id="answerSheet4">
                                <script>
                                    frontQuestionNumber+=fillQuestionNumber;
                                    for(var i=frontQuestionNumber;i<judgmentQuestionNumber+frontQuestionNumber;i++){
                                        var answerSheet4 = document.getElementById("answerSheet4");
                                        answerSheet4.innerHTML += "<li><a href='#qu_"+(i+1)+"' >"+ (i+1) +"</a></li>";
                                    }
                                </script>
                            </ul>
                        </div>
                    </div>
                    <div class="rt_content">
                        <div class="rt_content_tt">
                            <script>
                                document.getElementsByClassName("rt_content_tt")[4].innerHTML="<h2>计算题</h2>" +
                                    "<p>" +
                                    "<span>共</span>" +
                                    "<i class='content_lit'>"+fillQuestionNumber+"</i>" +
                                    "<span>题</span>" +
                                    "</p>";
                            </script>
                        </div>
                        <div class="rt_content_nr answerSheet">
                            <ul id="answerSheet5">
                                <script>
                                    frontQuestionNumber+=judgmentQuestionNumber;
                                    for(var i=frontQuestionNumber;i<countQuestionNumber+frontQuestionNumber;i++){
                                        var answerSheet5 = document.getElementById("answerSheet5");
                                        answerSheet5.innerHTML += "<li><a href='#qu_"+(i+1)+"' >"+ (i+1) +"</a></li>";
                                    }
                                </script>
                            </ul>
                        </div>
                    </div>
                    <div class="rt_content">
                        <div class="rt_content_tt">
                            <script>
                                document.getElementsByClassName("rt_content_tt")[5].innerHTML="<h2>简答题</h2>" +
                                    "<p>" +
                                    "<span>共</span>" +
                                    "<i class='content_lit'>"+fillQuestionNumber+"</i>" +
                                    "<span>题</span>" +
                                    "</p>";
                            </script>
                        </div>
                        <div class="rt_content_nr answerSheet">
                            <ul id="answerSheet6">
                                <script>
                                    frontQuestionNumber+=countQuestionNumber;
                                    for(var i=frontQuestionNumber;i<shortAnswerQuestionNumber+frontQuestionNumber;i++){
                                        var answerSheet6 = document.getElementById("answerSheet6");
                                        answerSheet6.innerHTML += "<li><a href='#qu_"+(i+1)+"' >"+ (i+1) +"</a></li>";
                                    }
                                </script>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="foot"></div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
<script>
    $(function() {//设置单选题已答题
        $(":radio").click(function () {
            debugger;
            var examId = $(this).closest('.test_content_nr_main').closest('li').attr('id'); // 得到题目ID
            var cardLi = $("a[href='#" + examId + "']"); // 根据题目ID找到对应答题卡
            // 设置已答题
            if (!cardLi.hasClass('hasBeenAnswer')) {
                cardLi.addClass('hasBeenAnswer');
            }

        });
        $(":checkbox").click(function () {//设置多选已答题
            debugger;
            var examId = $(this).closest('.test_content_nr_main').closest('li').attr('id'); // 得到题目ID
            var targetName = $(this).attr('name');
            var cardLi = $("a[href='#" + examId + "']"); // 根据题目ID找到对应答题卡
            // 设置已答题
            if ($(":checkbox[name='" + targetName + "']:checked").length != 0) {
                cardLi.addClass('hasBeenAnswer');
            }
            else {
                cardLi.removeClass('hasBeenAnswer');
            }

        });
        $(":text").change(function () {//设置填空计算已答题

            var examId = $(this).closest('.test_content_nr_main').closest('li').attr('id'); // 得到题目ID
            var targetId = $(this).attr('id');//得到目标ID
            var cardLi = $("a[href='#" + examId + "']"); // 根据题目ID找到对应答题卡

            // 设置已答题
            if ($('#' + targetId).val() == "") {
                cardLi.removeClass('hasBeenAnswer');
            }
            else {
                cardLi.addClass('hasBeenAnswer');
            }
        });
        $("textarea").change(function () {//设置简单已答题
            debugger;
            var examId = $(this).closest('.test_content_nr_main').closest('li').attr('id'); // 得到题目ID
            var targetId = $(this).attr('id');//得到目标ID
            var cardLi = $("a[href='#" + examId + "']"); // 根据题目ID找到对应答题卡

            // 设置已答题

            if ($('#' + targetId).val() == "") {
                cardLi.removeClass('hasBeenAnswer');
            }
            else {
                cardLi.addClass('hasBeenAnswer');
            }
        });
    })
</script>

</body>
</html>