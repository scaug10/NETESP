<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>知识库管理</title>
<link rel="stylesheet" type="text/css" href="../css/css.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>

<body>
	<div id="pageAll">
		<!--导航栏-->
		<div class="pageTop">
			<div class="page">
				<img src="../img/coin02.png" /><span><a href="../main.html">首页</a>&nbsp;-&nbsp;-</span>&nbsp;知识分类管理
			</div>
		</div>

		<div class="page">
			<!-- 页面样式 -->
			<div class="connoisseur">
				<div class="conform">
					<div class="cfD">
						<button class="userbtn" onclick="add()">添加</button>
						<!-- <button class="userbtn"
							onclick="javascrtpt:window.location.href='KnowledgeClassificationChange.html'">修改</button> -->
						<button class="userbtn"
							onclick="javascrtpt:window.location.href='KnowledgeClassificationDelete.html'">删除</button>
						<!-- <button class="userbtn"
							onclick="javascrtpt:window.location.href='KnowledgeClassificationCheck.html'">审核</button> -->
					</div>
				</div>
				<!-- 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0" width=100%>
						<tr>
							<td width="10%" class="tdColor">ID</td>
							<td width="12%" class="tdColor">创建者</td>
							<td width="12%" class="tdColor">分类名称</td>
							<td width="12%" class="tdColor">上级分类</td>
							<td width="30%" class="tdColor">备注</td>
							<td width="12%" class="tdColor">审核状态</td>
							<td width="12%" class="tdColor">操作</td>
						</tr>
						<c:forEach var="list" items="${list }">
							<tr height="40px">
								<td>${list.categoryId}</td>
								<td>${list.creator}</td>
								<td>${list.name}</td>
								<td>${list.parentName}</td>
								<td style="text-align: left">${list.note}</td>
								<td class="reviewType">${list.reviewType}</td>
								<td><a href="javascript:void(0)"
									onclick="modify(${list.categoryId})"> <img title="修改"
										src="../img/update.png">
								</a>&nbsp;<a href="javascript:void(0)"
									onclick="verify('${list.categoryId}')"> <img title="审核"
										src="../img/update.png">
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
	<!-- 	<div class="banDel">
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
	showReviewType();

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
	/* // 广告弹出框
	$(".delban").click(function() {
		$(".banDel").show();
	});
	$(".close").click(function() {
		$(".banDel").hide();
	});
	$(".no").click(function() {
		$(".banDel").hide();
	});
	// 广告弹出框 end */
</script>
</html>