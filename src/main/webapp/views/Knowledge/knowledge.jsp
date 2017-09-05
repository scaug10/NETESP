<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>知识管理</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/css.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="js/page.js" ></script> -->
<style>
.right {
	float: right;
}

.linkStyle:visited {
	color: black;
}

.linkStyle:hover {
	color: #47a4e1;
}

.linkStyle:active {
	color: black;
}
.searchInput{
	width: 180px;
	height: 40px;
	border: 1px solid #ccc;
	text-indent: 15px;
}

</style>
</head>

<body onload="showReviewType();">
	<div id="pageAll">
		<!--导航栏-->
		<div class="pageTop">
			<div class="page">
				<img src="${pageContext.request.contextPath}/img/coin02.png" /><span><a
					href="${pageContext.request.contextPath }/index">首页</a>&nbsp;-&nbsp;-</span>&nbsp;<a
					href="getAllKnowledge">知识管理</a>
			</div>
		</div>

		<div class="page">
			<!-- 页面样式 -->
			<div class="connoisseur">
				<div class="conform">
					<div class="cfD">
						<button class="userbtn right" onclick="check()">查询</button>
						<input type="text" id="name" name="name" placeholder="请输入要查询的知识名称"
							class="right searchInput">
						<button class="userbtn"
							onclick="javascrtpt:window.location.href='KnowledgeAdd.html'">添加</button>
						<button class="userbtn" onclick="del()">删除</button>
					</div>
				</div>
				<!--  表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0" width="100%">
						<tr>
							<td width="5%" class="tdColor"><input type="checkbox"
								onclick="changeState(this.checked)"></td>
							<td width="10%" class="tdColor">ID</td>
							<td width="12%" class="tdColor">创建者</td>
							<td width="20%" class="tdColor">知识名称</td>
							<td width="20%" class="tdColor">知识分类</td>
							<td width="15%" class="tdColor">审核信息</td>
							<td width="18%" class="tdColor">操作</td>
						</tr>
						<c:forEach var="list" items="${list }">
							<tr height="40px">
								<td><input type="checkbox" class='checkbox' name="id"
									value="${list.categoryId}"></td>
								<td>${list.knowledgeId }</td>
								<td>${list.creator}</td>
								<td>${list.name }</td>
								<td>${list.categoryName }</td>
								<td class="reviewType">${list.reviewType }</td>
								<td><a href="javascript:void(0)"
									onclick="overlook(${list.knowledgeId })"> <img title="预览"
										src="${pageContext.request.contextPath}/img/yulan.png">
								</a><a href="javascript:void(0)"
									onclick="modify(${list.knowledgeId })"> <img title="修改"
										src="${pageContext.request.contextPath}/img/update.png">
								</a>&nbsp;<a href="javascript:void(0)"
									onclick="verify(${list.knowledgeId })"> <img title="审核"
										src="${pageContext.request.contextPath}/img/check.png">
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


	<!-- 删除弹出框 -->
	<!-- <div class="banDel">
		<div class="delete">
			<div class="close">
				<a><img src="../img/shanchu.png" /></a>
			</div>
			<p class="delP1">你确定要删除此条记录吗？</p>
			<p class="delP2">
				<a href="#" class="ok yes">确定</a><a class="ok no">取消</a>
			</p>
		</div>
	</div> -->
	<!-- 删除弹出框  end-->
</body>

<script type="text/javascript">
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

	function overlook(knowledgeId){
		 var url = "queryKnowledge?knowledgeId="+knowledgeId;
	     window.location.href = url;
	}
	
	function modify(knowledgeId){
		var url = "modifyKnowledge?knowledgeId="+knowledgeId;
	     window.location.href = url;
	}
	
	function verify(knowledgeId){
		var url = "verifyKnowledge?knowledgeId="+knowledgeId;
	     window.location.href = url;
	}
	
	function check(){
		var name = document.getElementById("name").value;
		var url = "getKnowledgeByName?name="+name;
        window.location.href = url;
	}
	function del(){
		  var checkboxArray = document.getElementsByClassName("checkbox");
		   var sendArray = new Array();
		   for(var i=0;i<checkboxArray.length;i++){
			   if(checkboxArray[i].checked){
				   sendArray.push(checkboxArray[i].value);
			   }
		   }
		   var message = "确认删除这"+sendArray.length+"个知识吗？";
		   if(confirm(message)){
		   var xhr = createXmlHttpRequest();
			var url = "deleteKnowledge";
			xhr.open('post', url, true);
			xhr.setRequestHeader('Content-Type',
					'application/x-www-form-urlencoded');
			xhr.send("knowledgeId=" + sendArray);/*发送http body*/
			xhr.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					if (this.responseText > 0) {
						alert("删除知识成功！");
					} else {
						alert("删除知识失败！");
					}
					location.reload();
				}
			}
		   }
	}
	function createXmlHttpRequest() {
		if (window.ActiveXObject) { //如果是IE浏览器
			return new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) { //非IE浏览器
			return new XMLHttpRequest();
		}
	}
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
</script>
</html>