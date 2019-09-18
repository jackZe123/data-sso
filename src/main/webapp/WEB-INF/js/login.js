/*检查账号是否正确*/
function checkAccount(){
  var account =$("#account").val();
  console.log(account);
  $.ajax({
    type: "post",
    url: "../user/checkUserAccount",
    dataType: "json",
    contentType: "application/x-www-form-urlencoded",
    data: {
      "account": account
    },
    success:function(datas){
      if(datas.status==200){
        //响应成功
        $(".span_account").hide();
      }else{
        //响应失败
        $(".span_account").html(datas.msg);
        $(".span_account").show();
      }
    }
  })
}

/*检查密码是否输入正确*/
function checkPass(){
  var password =$("#password").val();
  console.log(password);
  $.ajax({
    type:"post",
    url:"../user/checkUserPassword",
    dataType:"json",
    contentType: "application/x-www-form-urlencoded",
    data:{
      "password":password
    },
    success:function(datas){
      if(datas.status==200){
        //响应成功
        $(".span_password").hide();
      }else{
        //响应失败
        $(".span_password").html(datas.msg);
        $(".span_password").show();
      }
    }
  })
}
function login() {
  var account =$("#account").val();
  var password =$("#password").val();
  console.log(account);
  console.log(password);
  $.ajax({
    type: "post",
    url: "../user/checkLogin",
    dataType: "json",
    contentType: "application/x-www-form-urlencoded",
    data: {
      "account": account,
      "password":password
    },
    success:function(datas){
      console.log(datas.status);
      if(datas.status==200){
        //响应成功
        $(".login").hide();
        $(".cover").hide();
        $(".btn_register").hide();

        document.getElementById("btn_uplond").style.display = "inline";
        document.getElementById("btn_logout").style.display = "inline";

        // $("#pleaselogin").html("欢迎登录！"+datas.data.userName);
        // $("#pleaselogin").css("margin-left","22%");
        alert("登录成功！");
      }else{
        //响应失败
        alert("登录失败！");
      }
    }
  })
}