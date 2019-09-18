function pass(videoid){
    $.ajax({
        type: "post",
        url: "../video/checkVideoByVideoIdPass",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded",
        data: {
            "videoid":videoid
        },
        success: function (datas) {
            if (datas.status==200) {
                $("#div"+videoid).remove();
            }
        }
    })
}
function unpass(videoid){
    $.ajax({
        type: "post",
        url: "../video/checkVideoByVideoIdUnPass",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded",
        data: {
            "videoid":videoid
        },
        success: function (datas) {
            if (datas.status==200) {
                $("#div"+videoid).remove();
            }
        }
    })
}
function deleteCategory(categoryid) {
    $.ajax({
        type: "post",
        url: "../category/deleteCategory",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded",
        data: {
            "categoryid":categoryid
        },
        success: function (datas) {
            if (datas.status==200) {
                $("#div"+categoryid).remove();
            }
        }
    })
}
function deleteComment(commentid) {
    $.ajax({
        type: "post",
        url: "../comment/deleteComment",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded",
        data: {
            "commentid":commentid
        },
        success: function (datas) {
            if (datas.status==200) {
                $("#div"+commentid).remove();
            }
        }
    })
}
function deleteUser(userid) {
    $.ajax({
        type: "post",
        url: "../admin/deleteUser",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded",
        data: {
            "userid":userid
        },
        success: function (datas) {
            if (datas.status==200) {
                $("#div"+userid).remove();
            }
        }
    })
}