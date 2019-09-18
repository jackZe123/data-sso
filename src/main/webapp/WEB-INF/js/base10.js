function zan1(videoid) {
    console.log(videoid);
    var zan1 = document.getElementById("zan1");
    var zan2 = document.getElementById("zan2");
    $.ajax({
        type:"post",
        url:"../video/commitZan",
        dataType:"json",
        contentType: "application/x-www-form-urlencoded",
        data:{
            "videoid":videoid
        },
        success:function(datas){
            if(datas.status==200){
                //响应成功
                zan1.style.display="none";
                zan2.style.display="inline";
                $("#zanlength").html(datas.data);

            }else{
                //响应失败
                alert("请先登录");
                zan1.style.display="inline";
                zan2.style.display="none";
            }
        }
    })
}
function like1(videoid) {
    console.log(videoid);
    var like1 = document.getElementById("like1");
    var like2 = document.getElementById("like2");
    $.ajax({
        type:"post",
        url:"../video/commitLike",
        dataType:"json",
        contentType: "application/x-www-form-urlencoded",
        data:{
            "videoid":videoid
        },
        success:function(datas){
            if(datas.status==200){
                //响应成功
                like1.style.display="none";
                like2.style.display="inline";
                $("#collectlength").html(datas.data);

            }else{
                //响应失败
                alert("请先登录");
                like1.style.display="inline";
                like2.style.display="none";
            }
        }
    })
}
/*取消赞，取消收藏*/
function zan2(videoid) {
    console.log(videoid);
    var zan1 = document.getElementById("zan1");
    var zan2 = document.getElementById("zan2");
    $.ajax({
        type:"post",
        url:"../video/cancelZan",
        dataType:"json",
        contentType: "application/x-www-form-urlencoded",
        data:{
            "videoid":videoid
        },
        success:function(datas){
            if(datas.status==200){
                //响应成功
                zan1.style.display="inline";
                zan2.style.display="none";
                $("#zanlength").html(datas.data);

            }else{
                //响应失败
                alert("请先登录");
                zan1.style.display="none";
                zan2.style.display="inline";
            }
        }
    })
}
function like2(videoid) {
    console.log(videoid);
    var like1 = document.getElementById("like1");
    var like2 = document.getElementById("like2");
    $.ajax({
        type:"post",
        url:"../video/cancelLike",
        dataType:"json",
        contentType: "application/x-www-form-urlencoded",
        data:{
            "videoid":videoid
        },
        success:function(datas){
            if(datas.status==200){
                //响应成功
                like1.style.display="inline";
                like2.style.display="none";
                $("#collectlength").html(datas.data);

            }else{
                //响应失败
                alert("请先登录");
                like1.style.display="none";
                like2.style.display="inline";
            }
        }
    })
}