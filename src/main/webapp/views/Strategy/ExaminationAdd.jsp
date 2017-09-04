<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>添加知识信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/css.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
    <style>
        .box{
            margin-left: 60px;
            width: 135px;
            height: 40px;
            border: none;
            font-size: 16px;
            color: #fff;
            background-color: #47a4e1;
        }
        #editor{
            position: relative;
            left:103px;
            bottom:23px;

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
    
    	function submitForm(){
    		var url = "${pageContext.request.contextPath}/test/singleChoice";
        	var data = "name=" + document.getElementById("name").value;
        	data += "&examName=" + document.getElementById("examName").value;
        	var xhr = createXmlHttpRequest();
        	xhr.open('post', url, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send(data);
            xhr.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    var json = JSON.parse(this.responseText);
                    if(json != undefined && json != null){
                    	if(json == 1) alert("提交成功");
                    	else alert("提交失败");
                    }
                }
            }
    	}
    </script>
    
</head>
<body>
<div id="pageAll">
    <!--导航栏-->
    <div class="pageTop">
        <div class="page">
            <img src="${pageContext.request.contextPath }/img/coin02.png" /><span><a href="../main.html">首页</a>&nbsp;-&nbsp;<a
                href="ExaminationManagement.html">试题管理</a>&nbsp;-</span>&nbsp;添加试题信息
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
                    试卷名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="text" id="exam_name" class="input3" />
                </div>
                <div class="bbD">
                    策略名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               	<select name="name" class="input3" id="name">
               		<script>
	               		var url = "${pageContext.request.contextPath}/test/strategy/all";
	                	var xhr =new XMLHttpRequest();
	                	alert("step..");
	                	xhr.open('post', url, true);
	                    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	                    xhr.send();
	                    xhr.onreadystatechange = function () {
	                        if (this.readyState == 4 && this.status == 200) {
	                            var json = JSON.parse(this.responseText);
	                            if(json != undefined && json != null){
		                            var htm = "";
	                            	for(var i = 0; i < json.length; ++i){
	                            		htm += "<option value="+json[i].strategyId+">" +
	                            			json[i].strategyName+"</option>";
	                            	}
	                            	document.getElementById("name").innerHTML = htm;
	                            }
	                        }
	                    }
               		</script>
                </select>
                </div>
                <div class="bbD">
                    <p class="bbDP">
                        <button class="btn_ok btn_yes" onclick="submitForm()">提交</button>
                        <a class="btn_ok btn_no" href="ExaminationManagement.html">取消</a>
                    </p>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>