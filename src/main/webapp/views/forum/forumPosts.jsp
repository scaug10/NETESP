<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>论坛帖子</title>
    
    <link rel="stylesheet" type="text/css" 
    	href ="${pageContext.request.contextPath }/css/forum/forumPosts.jsp.css">

    <script type="text/javascript">
        var boardName;

        function onloadFunction() {
            boardName = document.getElementById("getboardname").value;/*获取论坛名*/
            getTopPosts();
            getPosts(1);
        }

        function createXmlHttpRequest() {
            if (window.ActiveXObject) { //如果是IE浏览器
                return new ActiveXObject("Microsoft.XMLHTTP");
            } else if (window.XMLHttpRequest) { //非IE浏览器
                return new XMLHttpRequest();
            }
        }

        function getTopPosts() {/*载入置顶主题*/
            /*表头*/
            var htmlCode = 
            	"	<tr class=\"postTitle\">\n" +
                "        <td class=\"firstColumnInTable\">置顶主题</td>\n" +
                "        <td>作者</td>\n" +
                "        <td>评论数</td>\n" +
                "        <td>最后回复</td>\n" +
                "    </tr>";

            var url = "${pageContext.request.contextPath }/forum/loadThemes";//***获取置顶主题的接口***
            var xhr = createXmlHttpRequest();
            xhr.open('post', url, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            var params = "boardName="+boardName+"&pageNum=1&isScream=1";
            xhr.send(params);
            /*发送http body*/
            xhr.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    var jsonObject = this.responseText;
                    var result = eval("(" + jsonObject + ")");//json转为js数组
                    for (var i = 0; i < result.list.length; i++) {
                        var topicName = result.list[i].topicName;
                        var creator = result.list[i].creator;
                        var postNum = result.list[i].postCount;
                        var lastPoster = result.list[i].lastPoster; 
                        var postURL = "${pageContext.request.contextPath}/forum/themeDetail?topicId="+
                        			result.list[i].topicId + "&topicName="+topicName;//帖子链接***
                        var createTime = result.list[i].createTime;
                        var lastPostTime = result.list[i].lastPostTime; 

                        htmlCode += "<tr class=\"post\">\n" +
                        "        <td><a href=\"" + postURL + "\"><img src="+
                        "		 \"${pageContext.request.contextPath }/views/forum/IMG/top_posts.gif\" alt=\"top_post\">" + topicName + "</a></td>\n" +
                        "        <td>" + creator + "<br />"+
                        "		 <span>"+ (new Date(createTime)).toLocaleDateString() +"</span></td>\n" +
                        "        <td>" + postNum + "</td>\n" +
                        "        <td>" + lastPoster + "<br />" + (new Date(createTime)).toLocaleDateString() + 
                        "		 </td>\n" +
                        "    </tr>";
                    }

                    document.getElementById("topPosts").innerHTML = htmlCode;
                }
            }
        }

        function getPosts(page) {/*载入该page的普通主题*/
         displayPage(page);  //显示最底部页面切换
            /*表头*/
            var htmlCode = "<tr class=\"postTitle\">\n" +
                "        <td class=\"firstColumnInTable\">普通主题</td>\n" +
                "        <td>作者</td>\n" +
                "        <td>评论数</td>\n" +
                "        <td>最后回复</td>\n" +
                "    </tr>";

            var url = "${pageContext.request.contextPath }/forum/loadThemes";//***获取普通主题的接口***
            var xhr = createXmlHttpRequest();
            xhr.open('post', url, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send("boardName=" + document.getElementById("getboardname").value + 
            		"&pageNum=" + page+"&isScream=0");//***发送需要获取的页数***
            /*发送http body*/
            xhr.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    var jsonObject = this.responseText;
                    var result = eval("(" + jsonObject + ")");//json转为js数组
                    for (var i = 0; i < result.list.length; i++) {
                        var topicName = result.list[i].topicName;
                        var creator = result.list[i].creator;
                        var postNum = result.list[i].postCount;
                        var lastPoster = result.list[i].lastPoster; //最后回复人
                        var postURL = "${pageContext.request.contextPath}/forum/themeDetail?topicId="
                        		+result.list[i].topicId + "&topicName="+topicName;
                        var createTime = result.list[i].createTime;
                        var lastPostTime = result.list[i].lastPostTime;//最后回复帖子时间***

                        htmlCode += "<tr class=\"post\">\n" +
                            "        <td><a href=\"" + postURL + "\"><img src="+
                            "\"${pageContext.request.contextPath }/views/forum/IMG/top_posts.gif\" alt=\"top_post\">" + topicName + "</a></td>\n" +
                            "        <td>" + creator + "<br />"+
                            "		<span>"+ (new Date(createTime)).toLocaleDateString() +"</span></td>\n" +
                            "        <td>" + postNum + "</td>\n" +
                            "        <td>" + (lastPoster == null ? "" : lastPoster) + "<br />" + (lastPostTime != null ? (new Date(lastPostTime)).toLocaleDateString() : "") + 
                            "		</td>\n" +
                            "    </tr>";
                    }

                    document.getElementById("posts").innerHTML = htmlCode;
                }
            }

        }

        function displayPage(page) {
        //显示底部页数跳转
            var htmlCode = "<tr class=\"postTitle\">\n" +
                "        <td class=\"firstColumnInTable\">普通主题</td>\n" +
                "        <td>作者</td>\n" +
                "        <td>评论数</td>\n" +
                "        <td>最后回复</td>\n" +
                "    </tr>";

            var url = "${pageContext.request.contextPath }/forum/normalThemeNum";
            var xhr = createXmlHttpRequest();
            xhr.open('post', url, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.send("boardName=" + document.getElementById("getboardname").value);
            /*发送http body*/
            xhr.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    var jsonObject = this.responseText;
                    var result = eval("(" + jsonObject + ")");
                    /*帖子页数填充*/
                    var totalPostNumber = result;/*该论坛包含的总主题数*/
                    var postsPerPage = 20;/*每页包含的主题数*/
                    var lastPage = Math.ceil(totalPostNumber / postsPerPage);
                    document.getElementById("bottom").innerHTML = "<span class=\"pageButton\"><a href=\"javascript:void(0)\" onclick='getPosts(" + page + "+1)'>下一页</a></span>\n" +
                        "    <span class=\"pageButton\"><a href=\"javascript:void(0)\" onclick='getPosts(" + lastPage + ")'>..." + lastPage + "</a></span>\n" +
                        "    <span class=\"pageButton\"><input onchange='jumpToPage()' id='page' class=\"inputPage\" value=\" " + page + " \" type=\"text\">/页</span>\n" +
                        "    <span class=\"pageButton\"><a href=\"javascript:void(0)\" onclick='getPosts(1)'>1</a></span>\n" +
                        "    <span class=\"pageButton\"><a href=\"javascript:void(0)\" onclick='getPosts(" + page + "-1==0?1:" + page + "-1)'>上一页</a></span>";

                    document.getElementById("page").value = page;
                }
            }



        }

        function jumpToPage() {
            getPosts(document.getElementById("page").value);
        }


    </script>

</head>
<body onload="onloadFunction()">

<input id="getboardname" type="hidden" name="pwd" value="${boardName}"><!--放置隐藏的input标签以便js获取该属性-->

<div class="header"><span>${boardName}</span><a style="color: white;float: right;margin-top:15px;margin-right:15px;" href="${pageContext.request.contextPath }/index">返回主页</a></div>

<div class="header">
    <a href="${pageContext.request.contextPath }/forum/index" class="backButton">返回论坛列表</a>
    <a href="${pageContext.request.contextPath }/forum/postTheme?boardName=${boardName}" class="postLink">发布帖子</a>
    <button>搜索</button>
    <input class="searchBar" type="text" placeholder="搜索内容">
</div>

<table class="topPosts" id="topPosts"><!--置顶帖子-->
</table>


<table class="posts" id="posts"><!--普通帖子-->
</table>


<div id="bottom" class="bottom">
</div>

</body>
</html>