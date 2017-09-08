<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>知识库管理</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/css.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="js/page.js" ></script> -->
<style>
.right {
	float: right;
}

.input1 {
	line-height: 36px;
	width: 200px;
}
</style>
</head>

<body onload="showReviewType();">
	<div id="pageAll">
		<!--导航栏-->
		<div class="pageTop">
			<div class="page">
				<img src="${pageContext.request.contextPath}/views/img/coin02.png" /><span><a
					href="${pageContext.request.contextPath}/index">首页</a>&nbsp;-&nbsp;</span>&nbsp;<a
					href="getAllRepositoryCategory">知识分类管理</a>
			</div>
		</div>

		<div class="page">
			<!-- 页面样式 -->
			<div class="connoisseur">
				<div class="conform">
					<div class="cfD">
						<button class="userbtn right" onclick="check()">查询</button>
						<input type="text" id="name" name="name" placeholder="请输入要查询的分类名称"
							class="right input1">
						<button class="userbtn" onclick="add()">添加</button>
						<button class="userbtn" onclick="del()">删除</button>
					</div>
				</div>
				<!-- 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0" width=100%>
						<tr>
							<td width="10%" class="tdColor"><input type="checkbox"
								onclick="changeState(this.checked)"></td>
							<td width="10%" class="tdColor">ID</td>
							<td width="10%" class="tdColor">创建者</td>
							<td width="10%" class="tdColor">分类名称</td>
							<td width="10%" class="tdColor">上级分类</td>
							<td width="30%" class="tdColor">备注</td>
							<td width="10%" class="tdColor">审核状态</td>
							<td width="10%" class="tdColor">操作</td>
						</tr>
						<c:forEach var="list" items="${list }">
							<tr height="40px">
								<td><input type="checkbox" class='checkbox' name="id"
									value="${list.categoryId}"></td>
								<td>${list.categoryId}</td>
								<td>${list.creator}</td>
								<td>${list.name}</td>
								<td>${list.parentName}</td>
								<td style="text-align: left">${list.note}</td>
								<td class="reviewType">${list.reviewType}</td>
								<td><a href="javascript:void(0)"
									onclick="modify(${list.categoryId})"> <img title="修改"
										src="${pageContext.request.contextPath}/views/img/update.png">
								</a>&nbsp;<a href="javascript:void(0)"
									onclick="verify('${list.categoryId}')"> <img title="审核"
										src="${pageContext.request.contextPath}/views/img/check.png">
								</a></td>
							</tr>
						</c:forEach>
					</table>
					<!-- <div class="paging">此处是分页</div> -->
				</div>
				<!--  表格 显示 end-->
			</div>
			<!-- 页面样式end -->
		</div>
	</div>
</body>
<script type="text/javascript">
    function changeState(isChecked){
        var chk_list=document.getElementsByTagName("input");
        for(var i=0;i<chk_list.length;i++)
        {
            if(chk_list[i].type=="checkbox")
            {
                chk_list[i].checked=isChecked;
            }
        }
    }
    function showReviewType() {
        var tds = document.getElementsByClassName('reviewType');
        for (var i = 0; i < tds.length; i++) {
            var td = tds[i];
            var status = td.innerHTML;
            if (status == "0") {
                td.innerHTML = "未审核";
            } else if (status >= "1") {
                td.innerHTML = "已审核";
            }
        }
    }

    function add() {
        var url = "addRepositoryCategory";
        window.location.href = url;
    }

    function modify(categoryId){
        var url = "modifyRepositoryCategory?categoryId="+categoryId;
        window.location.href=url;
    }

    function verify(categoryId){
        var url = "verifyRepositoryCategory?categoryId="+categoryId;
        window.location.href = url;
    }
    
    function check(){
    	var name = document.getElementById("name").value;
    	 var url = "getRepositoryCategoryByName?name="+name;
        window.location.href = url;
    }
    
	function createXmlHttpRequest() {
		if (window.ActiveXObject) { //如果是IE浏览器
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) { //非IE浏览器
			return new XMLHttpRequest();
		}
	}
   function del(){
	   var checkboxArray = document.getElementsByClassName("checkbox");
	   var sendArray = new Array();
	   for(var i=0;i<checkboxArray.length;i++){
		   if(checkboxArray[i].checked){
			   sendArray.push(checkboxArray[i].value);
		   }
	   }
	   var message = "确认删除这"+sendArray.length+"个知识分类吗？";
	   if(confirm(message)){
	   var xhr = createXmlHttpRequest();
		var url = "deleteRepositoryCategory";
		xhr.open('post', url, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		xhr.send("categoryId=" + sendArray);/*发送http body*/
		xhr.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				if (this.responseText > 0) {
					alert("删除知识分类成功！");
				} else {
					alert("删除知识分类失败！");
				}
				window.location.href = "getAllRepositoryCategory";
			}
		}
	   }
   }
</script>
</html>