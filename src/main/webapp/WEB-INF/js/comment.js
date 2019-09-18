function pushcomment() {
    var videoid = document.getElementById("VideoId").innerText;
    var comment =$("#content").val();
    $.ajax({
        type:"post",
        url:"../comment/pushComment",
        dataType:"json",
        contentType: "application/x-www-form-urlencoded",
        data:{
            "videoid":videoid,
            "comment":comment
        },
        success:function(datas){
            if(datas.status==200){
                //响应成功
                document.getElementById("content").value = "";
                var innerLi="";
                innerLi=innerLi+"<Li><p><span>"+datas.data.username+":</span>"+datas.data.comment+"</p></Li>";
                $("#comment_ul").append(innerLi);
            }else{
                //响应失败
                alert("评论失败");
            }
        }
    })
}
