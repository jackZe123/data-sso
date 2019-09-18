window.onload = function(){

    /*设置分页页面参数*/
  new myPagination({
    id: 'pagination',
    curPage:1, //初始页码
    pageTotal: 20, //总页数
    pageAmount: 9,  //每页多少条
    dataTotal: document.getElementById("videocount").innerText, //总共多少条数据
    pageSize: 5, //可选,分页个数
    showPageTotalFlag:true, //是否显示数据统计
    showSkipInputFlag:true, //是否支持跳转
  })



  document.getElementById("btn_showlogin").onclick = shogMinLogin;
  document.getElementById("close_minilogin").onclick = closeLogin;
  document.getElementById("firstLine").onmousedown = moveLogin;
  /* 显示登录窗口 */
  function shogMinLogin(){
    var login = document.getElementsByClassName("login")[0];
    var cover = document.getElementsByClassName("cover")[0];
    login.style.display = "block";
    cover.style.display = "block";
    login.style.left = (document.body.scrollWidth - login.scrollWidth) / 2 + "px";
    login.style.top = "100px";
  }


  function closeLogin(){
    var login = document.getElementsByClassName("login")[0];
    var cover = document.getElementsByClassName("cover")[0];
    login.style.display = "none";
    cover.style.display = "none";
  }

  /* 移动登录窗口 */
  function moveLogin(event){
    var moveable = true;

    //获取事件源
    event = event ? event : window.event;
    var clientX = event.clientX;
    var clientY = event.clientY;
    var login = document.getElementById("login");
    console.log(login);
    var top = parseInt(login.style.top);
    var left = parseInt(login.style.left);//鼠标拖动
    document.onmousemove = function(event){
      if(moveable){
        event = event ? event : window.event;
        var y = top + event.clientY - clientY;
        var x = left + event.clientX - clientX;
        if(x>0 && y>0){
          login.style.top = y + "px";
          login.style.left = x + "px";
        }
      }
    }
    //鼠标弹起
    document.onmouseup = function(){
      moveable = false;
    }
  }
};
