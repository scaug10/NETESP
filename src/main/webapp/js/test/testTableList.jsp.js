 $(document).ready(function () {
	 
	 $("#submit2").click(function () {
     	$("#testName").val("ffy");
         $.ajax({
             type:'POST',
             dataType:'text',
             url: '${pageContext.request.contextPath }/saveTestTable',
             data:$("#formId2").serializeArray(),
             contentType:"application/x-www-form-urlencoded",
             success : function (data) {
                 
             },
         });
     });
     
	 
     $.ajax({
     	 type: "GET",
		 url: "queryTestTables",
		 dataType: "json",
//		 contentType: "text/html; charset=UTF-8",
		 data: {"name":"fyw"},
		 success: function(json){
			 if(json != undefined && json != null){
				 $.each(json, function (indenx, testTable) {
	                 var $tr = $("<tr class='table-center'></tr>");
	                 var $td1 = $("<td></td>");
	                 $tr.append($td1.clone().text(testTable.testName));
	                 var $td2 = $("<td></td>");
	                 $tr.append($td2.clone().text(testTable.testSex));
	                 var $td3 = $("<td></td>");
//	                 var $fmt=$("<fmt:formatDate value=" + testTable.birthday + 
//	                		" pattern= \"yyyy-MM-dd HH:mm:ss\" />");
//	                 $td3.append($fmt.clone());
	                 $tr.append($td3.clone().text(testTable.birthday));
	                 
	                 var $td4=$("<td></td>");
	                 var $a1 = $("<a href=\"updateTestTable?id=" + testTable.testId + "\">修改</a>");
	                 var $a2 = $("<a href=\"deleteTestTable?id=" + testTable.testId + "\">删除</a>");
	                 $td4.append($a1.clone()); $td4.append($a2.clone());
	                 $tr.append($td4.clone());
	                 $tr.appendTo($("#tbody_data"));
	            
	         	});
			 }
	         
		 },
		 error: function(data){
			 alert("加载失败");
         }
     });
 })