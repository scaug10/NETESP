/**
 * 
 */
 $(document).ready(function () {
    $.ajax({
        url: "${pageContext.request.contextPath }/forum/loadBoardInfo",
        dataType: "json",
        type: "post",
// 	            data: {"name":"fyw"},
        success: function (json) {
            if (json != undefined && json != null) {
                $.each(json, function (index, boardCustom) {
                    $li = $("<li></li>");
                    $a = $("<a class=\"forum\" href='" + 
                    		"${pageContext.request.contextPath }/forum/boardThemes?boardName=" +
                    		boardCustom.boardName + "'></a>");
                    $img = $("<img class=\"forumlogo\" src='"+ 
                    		"${pageContext.request.contextPath }/views/forum/IMG/forum_logo.gif' "+
                    		"alt='forumlogo'" + "></img>");
                    $spanName = $("<span class=\"forumname\"></span>");
                    $spanDesc = $("<span class='forumdetail'></span>");
                    $spanOwner = $("<span class='forumowner'></span>");

                    
                    $a.append($img.clone());
                    $a.append($spanName.clone().text(boardCustom.boardName));
                    $a.append($spanDesc.clone().text(boardCustom.boardDescribe));
                    $a.append($spanOwner.clone(boardCustom.boardMaster));

                    $li.append($a.clone());
                    $li.appendTo($("#forumlist"));
                })
            }
        },
    })
})