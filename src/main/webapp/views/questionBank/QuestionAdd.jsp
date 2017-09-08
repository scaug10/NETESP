<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>添加知识信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <style>
        .box {
            margin-left: 60px;
            width: 135px;
            height: 40px;
            border: none;
            font-size: 16px;
            color: #fff;
            background-color: #47a4e1;
        }

        #editor {
            position: relative;
            left: 103px;
            bottom: 23px;

        }
        
        .position{
            position:relative;
            bottom: 188px;
        }
        
         textarea{
            width: 800px;
            height: 200px;
            border: 1px solid #ccc;
            text-indent: 15px;
            margin-left: 10px;
        }
    </style>
    <script>
	    function createXmlHttpRequest() {
	        if (window.ActiveXObject) { //如果是IE浏览器
	            return new ActiveXObject("Microsoft.XMLHTTP");
	        } else if (window.XMLHttpRequest) { //非IE浏览器
	            return new XMLHttpRequest();
	        }
	    }
	    
	    function check() {
	        var questionBank = document.getElementsByName("testDatabaseMatter");
	        var flag = 0;
	        for (var i = 0; i < 4; i++) {
	            if(questionBank[i].checked ){
	                flag = 1;
	            }
	        }
	        if(!flag){
	            alert("所属题库不得为空"); return false;
	        }
	        var subjectType = document.getElementById("subjectType");
	        if (subjectType.value == ""){
	            alert("题目类型不得为空"); return false;
	        }
	        var content = ue.getContent();
	        if (content == ""){
	            alert("题目内容不得为空"); return false;
	        }
	        var answer = document.getElementById("answer").value;
	        if(answer == null || answer == ""){
	        	alert("题目答案不能为空"); return false;
	        }
	        addNewSubject();
	    }
    
    	function addNewSubject(){
    		var xhr = createXmlHttpRequest();
            var url = "${pageContext.request.contextPath}/subject/save";
            var data="";
            var tdm = document.getElementsByName("testDatabaseMatter");
            for(var i = 0; i < tdm.length; ++i) if(tdm[i].checked) data += "testDatabaseMatter=" + tdm[i].value;
            data += "&subjectMatter=" + document.getElementById("subjectMatter").value;
            data += "&knowlegePoint=" + document.getElementById("knowlegePoint").value;
            data += "&subjectType=" + document.getElementById("subjectType").value;
            data += "&name=" + document.getElementById("name").value;
			data += "&content=" + ue.getContentTxt();
			data += "&answer=" + document.getElementById("answer").value;
			var subjectType=document.getElementById("subjectType").value;
			
			if(subjectType=="单选题" || subjectType=="多选题" || subjectType=="判断题"){
				data += "&optionA="+document.getElementById("optionA").value;
				data += "&optionB="+document.getElementById("optionB").value;
			}
			if(subjectType=="单选题" || subjectType=="多选题"){
				data += "&optionC="+document.getElementById("optionC").value;
				data += "&optionD="+document.getElementById("optionD").value;
			}
			if(subjectType=="多选题"){
				data += "&optionE="+document.getElementById("optionE").value;
			}
			
            xhr.open('post', url, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send(data);
            /*发送http body*/
            xhr.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    alert("提交成功")
                    
                }
            }
    	}
    </script>
</head>
<body>
<div id="pageAll">
    <div class="pageTop">
        <div class="page">
            <img src="${pageContext.request.contextPath}/img/coin02.png"/><span><a href="${pageContext.request.contextPath}/index">首页</a>&nbsp;-&nbsp;<a
                href="${pageContext.request.contextPath}/questionbank">题库管理</a>&nbsp;-</span>&nbsp;添加试题信息
        </div>
    </div> 
    <div class="page ">
        <!-- 内容页面样式 -->
        <div class="banneradd bor">
            <div class="baTopNo">
                <span>知识信息</span>
            </div>
            <div class="baBody">
                <div class="bbD">
                    所属题库：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="testDatabaseMatter" value="正规题库"/>&nbsp;正规题库&nbsp;
                    <input type="radio" name="testDatabaseMatter" value="练习题库"/>&nbsp;练习题库&nbsp;
                    <input type="radio" name="testDatabaseMatter" value="模拟题库"/>&nbsp;模拟题库&nbsp;
                    <input type="radio" name="testDatabaseMatter" value="竞赛题库"/>&nbsp;竞赛题库&nbsp;
                </div>
                <div class="bbD">
                    所属科目：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select class="input3" id="subjectMatter"name="subjectMatter">
                    <option value="法律">法律</option>
                    <option value="机制">机制</option>
                    <option value="处理">处理</option>
                    <option value="常识">常识</option>
                </select>
                </div>
                <div class="bbD">
                    &nbsp;&nbsp;  知识点：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <select class="input3" name="knowlegePoint" id="knowlegePoint">
                    <option value="中华人民共和国突发应对法">中华人民共和国突发应对法</option>
                    <option value="突发事件预警机制">突发事件预警机制</option>
                    <option value="应急处理">应急处理</option>
                    <option value="应急常识">应急常识</option>
                </select>
                </div>
                <div class="bbD">
                    题目类型：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select class="input3" id="subjectType"name="subjectType">
                    <option selected="selected"></option>
                    <option value="单选题">单选题</option>
                    <option value="多选题">多选题</option>
                    <option value="判断题">判断题</option>
                    <option value="填空题">填空题</option>
                    <option value="计算题">计算题</option>
                    <option value="简答题">简答题</option>
                </select>
                </div>
                <div class="bbD">
                    	难易程度：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <select class="input3" id="name"name="name">
	                    <script>
	                        var difficulty = document.getElementsByName("name")[0];
	                        for(var i = 0 ; i < 10;i++){
	                            difficulty.innerHTML += "<option value='"+ (i+1) + "'>"+ (i+1) +"</option>";
	                        }
	                    </script>
                	</select>
                </div>
                <div class="bbD"><span class="position">正确答案：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><textarea id="answer" cols="10" rows="10"></textarea>
</div>
                <div class="bbD">
                    题目内容：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <div id="editor">
                        <!--百度编辑器配置-->
                        <script id="container" name="content" type="text/plain"></script>
                        <script type="text/javascript" src="${pageContext.request.contextPath}/utf8-jsp/ueditor.config.js"></script>
                        <script type="text/javascript" src="${pageContext.request.contextPath}/utf8-jsp/ueditor.all.js"></script>
                        <script type="text/javascript">
                            var ue = UE.getEditor('container', {
                                initialFrameWidth: [800],
                                initialFrameHeight: [300],
                                autoHeightEnabled: false,
                            });

                        </script>
                    </div>
                </select>
                </div>
                <div id="option1"></div>
                
                <div class="bbD">
                    <p class="bbDP">
                        <button class="btn_ok btn_yes" onclick="check()">提交</button>
                        <a class="btn_ok btn_no" href="QuestionManagement.html">取消</a>
                    </p>
                </div>
            </div>
        </div>

        <!--页面样式end -->
    </div>
</div>
<script>
    $(function () {
        $("#subjectType").change(function () {
            var option = document.getElementById("subjectType");
            switch (option.value){
                case "单选题" :{
                    document.getElementById("option1").innerHTML="" +
                        "<div class='bbD'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' id='optionA' name='optionA' class='input3'></div>" +
                        "<div class='bbD'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;B:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' id='optionB' name='optionB' class='input3'></div>" +
                        "<div class='bbD'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;C:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' id='optionC' name='optionC' class='input3'></div>" +
                        "<div class='bbD'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;D:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' id='optionD' name='optionD' class='input3'></div>" +
                        "";
                    break;
                }
                case "多选题" :{
                    document.getElementById("option1").innerHTML="" +
                        "<div class='bbD'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' id='optionA' name='optionA' class='input3'></div>" +
                        "<div class='bbD'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;B:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' id='optionB' name='optionB' class='input3'></div>" +
                        "<div class='bbD'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;C:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' id='optionC' name='optionC' class='input3'></div>" +
                        "<div class='bbD'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;D:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' id='optionD' name='optionD' class='input3'></div>" +
                        "<div class='bbD'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;E:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' id='optionE' name='optionE' class='input3'></div>" +
                        "";
                    break;
                }
                case "判断题" :{
                    document.getElementById("option1").innerHTML="" +
                        "<div class='bbD'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' id='optionA' name='optionA' class='input3'></div>" +
                        "<div class='bbD'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;B:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' id='optionB' name='optionB' class='input3'></div>" +
                        "";
                    break;
                }
                default :{
                    document.getElementById("option1").innerHTML="";
                    break;
                }
            }
        })
    })
</script>

</body>
</html>