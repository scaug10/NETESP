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