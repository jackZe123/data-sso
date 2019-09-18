/*检查账号是否正确*/
function manager_login(){
    var manager_account =$("#manager_account").val();
    var manager_password =$("#manager_password").val();
    console.log(manager_account);
    console.log(manager_password);
    $.ajax({
        type:"post",
        url:"${pageContext.request.contextPath}/user/checkUserAccount",
        dataType:"json",
        contentType: "application/x-www-form-urlencoded",
        data:{
            "manager_account":manager_account,
            "manager_password":manager_password
        },
        success:function(datas){
            if(datas.status==200){
                //响应成功
            }else{
                //响应失败
                $("#span_manager_account").html(datas.msg);
                $("#span_manager_account").show();
                $("#span_manager_password").html(datas.msg);
                $("#span_manager_password").show();
            }
        }
    })
}