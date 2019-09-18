<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/rank.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base1.0.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/myPagination.css">
    <script src="${pageContext.request.contextPath}/js/base1.0.js"></script>
    <script src="${pageContext.request.contextPath}/js/login.js"></script>
    <script src="${pageContext.request.contextPath}/js/myPagination.js"></script>
    <title>Document</title>
</head>
<body>
<div class="top">
    <input type="serch" placeholder="请输入搜索关键字" >
    <a href="#" class="search">搜索</a>
    <span id="videocount" class="videocount" style="display: none">${video_count}</span>
    <div class="Login_info">

    <a href="javascript:void(0)" class="btn_login" id="btn_showlogin" >
        <c:choose>
            <c:when test="${currentUser!=null}">
                登录成功,${currentUser.userName }
            </c:when>
            <c:otherwise>
                请登录
            </c:otherwise>
        </c:choose>
    </a>
<%--    <span id ="pleaselogin" class="pleaselogin"></span>--%>
    <img src="${pageContext.request.contextPath}/img/head.png">
        <c:choose>
            <c:when test="${currentUser!=null}">
                <a href="${pageContext.request.contextPath}/video/upload" target="_Blank" class="btn_uplond" id="btn_uplond" >上传</a>
                <a href="${pageContext.request.contextPath}/user/loginOut" class="btn_logout" id="btn_logout"   >退出</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/regist/toRegist" class="btn_register" id="btn_register" >注册</a>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<div class="mid">
    <ul>
        <c:forEach items="${category_list}" var="category">
            <li class="category_l" id="category_1"><a href="javascript:void(0)" data-id="${category.categoryid}" onclick="getImgurl(${category.categoryid});">${category.categoryname}</a></li>
        </c:forEach>
    </ul>
</div>
<div class="content">
    <h2>热门<span style="color: #9092ff">></span></h2>
    <div class="middle">
    <div class="video_new">
        <div class="left_img_url">
        <c:forEach items="${img_list}" var="img">
        <div class="video_item" id="video_show">
            <a href="${pageContext.request.contextPath}/video/getVideoMessageByVideoId?videoid=${img.videoid }" target="_Blank">
                <img  src="${pageContext.request.contextPath}/img/${img.imgurl}" >
            </a>
        </div>
        </c:forEach>
        </div>
        <div id="pagination" class="pagination"></div>
    </div>
    <div class="rank_new">
        <div class="top_rank" >
            <p>视频排行榜</p>
        </div>
        <c:forEach items="${paih_list}" var="paih_list">
            <div class="video_paih_item">
                <a href="${pageContext.request.contextPath}/video/getVideoMessageByVideoId?videoid=${paih_list.videoid}" target="_Blank">
                <img src="${pageContext.request.contextPath}/img/user-logo-004.png">
                <div class="video_paih_info">
                    <p class="p1">作者</p>
                    <p class="p2" style="width: 150px">${paih_list.username}</p>
                    <p class="p3">视频名称</p>
                    <p class="p4" style="width: 150px">${paih_list.title}</p>
                    <p class="p5">点赞数</p>
                    <p class="p6" style="width: 150px">${paih_list.supportnum}</p>
                </div>
                </a>
            </div>
        </c:forEach>
    </div>
    </div>

</div>
<!-- 点击登录弹出登录框-->
<div class="login" >
    <div class="item firstLine" id="firstLine">
        <span class="login_title">登录窗口</span>
        <span class="login_close" id="close_minilogin">X</span>
    </div>
    <form action="${pageContext.request.contextPath}/user/checkLogin"  method="post" >
    <lable>账号：<input type="text" name="useraccount" placeholder="请输入账号（小于10位数字）" id="account" onblur="checkAccount()" ></lable>
    <span class="span_account"></span><br>
    <lable>密码：<input type="password" name="pwd" placeholder="请输入密码（6-12位数字+密码）" id="password" onblur="checkPass()" style="height:35px;width:255px"></lable>
    <span class="span_password"></span><br>
    <input type="submit" value="登录" class="login_button">
    </form>
</div>


<!-- 登录遮罩层 -->
<div class="cover"></div>

<%--<!-- 视频遮罩层 -->--%>
<%--<div class="video_cover" id="video_co"></div>--%>


</body>
</html>

