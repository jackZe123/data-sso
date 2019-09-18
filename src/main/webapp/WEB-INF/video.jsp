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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base10.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.css">
    <script src="${pageContext.request.contextPath}/js/base10.js"></script>
    <script src="${pageContext.request.contextPath}/js/login.js"></script>
    <script src="${pageContext.request.contextPath}/js/comment.js"></script>
    <title>Document</title>
</head>
<body>

<!-- 点击图片弹出视频窗口-->
<div class="photo_video" id="photo_video">
    <div class="video_left"><!--视频部分-->
        <video controls id="videosource">
            <source src="${pageContext.request.contextPath}/video/${video_info.video.videoUrl}">
        </video>
    </div>
    <div class="video_right"><!--点赞评论部分-->
        <div class="review_top">
            <img src="${pageContext.request.contextPath}/img/user-logo-004.png">
            <div class="video_intro">
                <span class="font">作者：${video_info.video.userName}</span><br>
                <span class="font">上传时间：${video_info.video.createTime}</span><br>
                <span class="font">浏览数：${video_info.video.browseNum}</span><br>
                <div class="div_zan">
                    <span class="zan">
                        点赞：<a href="javascript:void(0)" class="zan1" id="zan1" onclick="zan1(${video_info.video.id})"><img src="${pageContext.request.contextPath}/img/zan1.png" ></a>
                       <a href="javascript:void(0)" class="zan2" id="zan2" onclick="zan2(${video_info.video.id})"><img src="${pageContext.request.contextPath}/img/zan2.png"></a>
                        <span id="zanlength" class="count_zan">${video_info.video.supportNum}</span>
                    </span>
                </div>

                <div class="div_like">
                    <span class="zan">
                        收藏：<a href="javascript:void(0)" class="like1" id="like1" onclick="like1(${video_info.video.id})"><img src="${pageContext.request.contextPath}/img/like1.png" class="like"></a>
                        <a href="javascript:void(0)" class="like2" id="like2" onclick="like2(${video_info.video.id})"><img src="${pageContext.request.contextPath}/img/like2.png" class="like"></a>
                        <span id="collectlength" class="count_like">${video_info.video.collectNum}</span>
                     </span>
                </div>


            </div>
        </div>
        <div class="review_mid">
            <!--显示别人的评论-->
            <div class="review_mid_top">
                <ul id ="comment_ul" >
                    <c:forEach items="${video_info.getCommentResponseList}" var="commentcontent">
                        <li><p><span>${commentcontent.username}：</span>${commentcontent.comment}</p></li>
                    </c:forEach>
                </ul>
            </div>
            <!--写评论-->
            <div class="review_mid_content">
                <form action="javascript:void(0)" method="post" >
                    <span id="VideoId" style="display: none">${video_info.video.id}</span>
                    <textarea rows="3" cols="35" id="content" placeholder="我也说一句"></textarea><br>
                    <a href="javascript:void(0)" onclick="pushcomment()" >评论</a>
                </form>
            </div>


        </div>
    </div>
</div>


</body>
</html>

