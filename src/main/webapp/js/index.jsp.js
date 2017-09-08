/**
 * 
 */
function getHotTheme(){
	var url = "forum/hostTheme";
	var xhr = window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHTTP");
	xhr.open("post", url, true);
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send("name=fyw");
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			var json = JSON.parse(this.responseText);
			if(json != undefined && json != null){
				var str = "";
				for(var i = 0; i < json.length; ++i){
					str += "<li>"+
						"		<div class='h_img'>"+
						"			<img src='img/forum/forum.jpg' />"+
						"		</div>"+
						"		<div class=\"h_text\">"+
						"			<b><a href=\"forum/themeDetail?topicName="+
						"				"+ json[i].topicName + "&topicId="+json[i].topicId+"\">"+json[i].topicName+"</a></b>"+
						"		</div>"+
						"	</li>";
				}
				document.getElementById("hostTheme").innerHTML = str;
			}
		}
	}
}

function getPublicNotice(){
	var url = "notice/getFourPublicNotice";
	var xhr = window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHTTP");
	xhr.open("post", url, true);
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send();
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			var json = JSON.parse(this.responseText);
			if(json != undefined && json != null){
				var str = "<li class=\"special\">"+
						  "		<div class=\"n_img\">"+
						  "			<img src=\"img/index/personalnotice.jpg\" />"+
						  "		</div>";
				if(json.length > 0){
					str += "<div class=\"n_text\">" +
						"	<b>" + json[0].title + 
						"	<a href=\"notice/jumpSearchNoticePage?noticeId="+ json[0].noticeId+
						"\" class=\"detail\">详细</a></b>"+
						"	</div>";
				}
				str += "</li>";
				for(var i = 1; i < json.length; ++i){
					str += "<li><a href=\"notice/jumpSearchNoticePage?noticeId=" + json[i].noticeId +
						"\">"+ json[i].title +"</a></li>"+
						"	</li>";
				}
				document.getElementById("publicNotice").innerHTML = str;
			}
		}
	}
}
