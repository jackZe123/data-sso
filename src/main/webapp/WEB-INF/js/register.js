function xuehao(){
    var account=$("#account").val();
    console.log(account);
    $.ajax({
        type:"post",
        url:"../user/checkUserRegisterAccount",
        dataType:"json",
        contentType: "application/x-www-form-urlencoded",
        data:{
            "account":account
        },
        success:function(result){
            console.log(result.msg)
            if(result.status==200){
                $("#xuehao").hide();
                $("#xuehaook").show();
            }else{
                $("#xuehao").show();
                $("#xuehaook").hide();
            }
        }
    })
}
function user_name(){
    var username=$("#username").val();
    console.log(username);
    $.ajax({
        type:"post",
        url:"../user/checkUserName",
        dataType:"json",
        contentType: "application/x-www-form-urlencoded",
        data:{
            "username":username
        },
        success:function(result){
            console.log(result.msg)
            if(result.status==200){
                $("#checkname").hide();
                $("#nameok").show();
            }else{
                $("#checkname").show();
                $("#nameok").hide();
            }

        }
    })
}
function telephone(){
    var phone=$("#phone1").val();
    console.log(phone);
    $.ajax({
        type:"post",
        url:"../user/checkUserPhone",
        dataType:"json",
        contentType: "application/x-www-form-urlencoded",
        data:{
            "phone":phone
        },
        success:function(result){
            if (result.status==200){
                $("#phoneok").show();
                $("#phone").hide();
            }else{
                $("#phone").show();
                $("#phoneok").hide();
            }
        }
    })
}
function useremail(){
    var email=$("#email").val();
    console.log(email);
    $.ajax({
        type:"post",
        url:"../user/checkUserEmail",
        dataType:"json",
        contentType: "application/x-www-form-urlencoded",
        data:{
            "email":email
        },
        success:function(result){
            if (result.status==200){
                $("#emailok").show();
                $("#email2").hide();
            }else{
                $("#emailok").hide();
                $("#email2").show();
            }
        }
    })
}
function userpassword(){
    var password=$("#mima").val();
    console.log(password);
    $.ajax({
        type:"post",
        url:"../user/checkUserPassword",
        dataType:"json",
        contentType: "application/x-www-form-urlencoded",
        data:{
            "password":password
        },
        success:function(result){
            if (result.status==200){
                $("#passwordok").show();
                $("#mima1").hide();
            }else{
                $("#passwordok").hide();
                $("#mima1").show();
            }
        }
    })
}
function register(){
    var account=$("#account").val();
    var username=$("#username").val();
    var phone=$("#phone1").val();
    var email=$("#email").val();
    var password=$("#mima").val();
    var sex = 0;
    console.log(account);
    console.log(username);
    console.log(phone);
    console.log(email);
    console.log(password);
    $.ajax({
        type:"post",
        url:"../user/register",
        dataType:"json",
        contentType: "application/x-www-form-urlencoded",
        data:{
            "account":account,
            "username":username,
            "phone":phone,
            "email":email,
            "sex":sex,
            "password":password
        },
        success:function(result){
            if (result.status==200){
               alert("注册成功");
            }else{
               alert("注册失败");
            }
        }
    })
}