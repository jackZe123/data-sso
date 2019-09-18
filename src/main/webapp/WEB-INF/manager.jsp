<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/rank.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/manager.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/table.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize.css">
    <script src="${pageContext.request.contextPath}/js/video.js"></script>
    <script src="${pageContext.request.contextPath}/js/tableshow.js"></script>
    <script src="${pageContext.request.contextPath}/js/add_category.js"></script>
</head>
<body>
<div class="top">
    <div class="top_left">一拍短视频后台管理系统</div>
    <ul>
        <li>欢迎您！</li>
        <li class="l">|</li>
        <li>${admin}</li>
        <li class="l">|</li>
        <li><a href="#">修改密码</a></li>
        <li class="l">|</li>
        <li><a href="#">设置</a></li>
        <li>|</li>
        <li><a href="${pageContext.request.contextPath}/admin/loginOut">退出</a></li>
    </ul>
</div>

<div class="mid">
    <div class="left">

        <ul class="menu">
            <!--分类管理-->
            <li>
                <a href="javascript:void(0)" onclick="show01()"><img src="${pageContext.request.contextPath}/img/sort.png">分类管理</a>
            </li>
            <!--视频审核-->
            <li>
                <a href="javascript:void(0)" onclick="show02()"><img src="${pageContext.request.contextPath}/img/video.png">视频审核</a>
            </li>
            <!--评论管理-->
            <li>
                <a href="javascript:void(0)" onclick="show03()"><img src="${pageContext.request.contextPath}/img/coment.png">评论管理</a>
            </li>
            <!--用户管理-->
            <li>
                <a href="javascript:void(0)" onclick="show04()"><img src="${pageContext.request.contextPath}/img/user.png">用户管理</a>
            </li>
            <!--流量统计-->
            <li>
                <a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/img/count.png">流量统计</a>
            </li>
            <!--系统设置-->
            <li>
                <a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/img/config.png">系统设置</a>
            </li>
        </ul>

    </div>

    <div class="right">

        <div class="video_table head01" id="h_1">

            <div class="head_table">
                <ul>
                    <li class="caro_id">分类ID</li>
                    <li>分类名称</li>
                    <li>分类简介</li>
                    <li>创建时间</li>
                    <li>更新时间</li>
                    <li class="make head_make">操作</li>
                    <li><a href="javascript:void(0)" id="add_category" onclick="show_add_category()">添加</a></li>
                </ul>
            </div>
            <div id="add_">
                <c:forEach items="${categories}" var="category">
                    <div class="info_table" id="div${category.id}">
                        <ul>
                            <li>${category.id}</li>
                            <li>${category.categoryName}</li>
                            <li>${category.categorySynopsis}</li>
                            <li>${category.createTime}</li>
                            <li>${category.updateTime}</li>
                            <li><a href="javascript:void(0)" onclick="deleteCategory(${category.id})" >删除</a></li>
                        </ul>
                    </div>
                </c:forEach>
            </div>
        </div>

        <div class="video_table head02"  id="h_2">

            <div class="head_table">
                <ul>
                    <li>视频ID</li>
                    <li>视频标题</li>
                    <li>上传用户名</li>
                    <li>上传时间</li>
                    <li>视频类别</li>
                    <li class="make">操作</li>
                </ul>
            </div>
            <c:forEach items="${videoCategories}" var="videoCategory">
                <div class="info_table" id="div${videoCategory.videoid }">
                    <ul>
                        <li>${videoCategory.videoid}</li>
                        <li>${videoCategory.title}</li>
                        <li>${videoCategory.username}</li>
                        <li>${videoCategory.createtime}</li>
                        <li>${videoCategory.categoryname}</li>
                        <li><a href="${pageContext.request.contextPath}/video/getVideoMessageByVideoId?videoid=${videoCategory.videoid }" target="_Blank">预览</a></li>
                        <li><a href="javascript:void(0)" onclick="pass(${videoCategory.videoid} )" >审核通过</a></li>
                        <li><a href="javascript:void(0)" onclick="unpass(${videoCategory.videoid})">审核不通过</a></li>
                    </ul>
                </div>
            </c:forEach>


        </div>


        <div class="video_table head03"  id="h_3">

            <div class="head_table">
                <ul>
                    <li>评论ID</li>
                    <li>评论内容</li>
                    <li>评论用户</li>
                    <li>关联视屏ID</li>
                    <li>评论时间</li>
                    <li class="make">操作</li>
                </ul>
            </div>
                <c:forEach items="${commentCategories}" var="commentCategory">
                    <div class="info_table" id="div${commentCategory.commentid }">
                        <ul>
                            <li>${commentCategory.commentid}</li>
                            <li>${commentCategory.comment}</li>
                            <li>${commentCategory.username}</li>
                            <li>${commentCategory.videoid}</li>
                            <li>${commentCategory.createtime}</li>
                            <li><a href="javascript:void(0)" onclick="deleteComment(${commentCategory.commentid})" >删除</a></li>
                        </ul>
                    </div>
                </c:forEach>
        </div>

        <div class="video_table head04"  id="h_4">
            <div class="head_table">
                <ul>
                    <li class="user_id"> 用户ID</li>
                    <li>用户名</li>
                    <li>手机号</li>
                    <li>邮箱</li>
                    <li>创建时间</li>
                    <li class="make heab_make">操作</li>
                </ul>
            </div>
                <c:forEach items="${userCategories}" var="userCategory">
                    <div class="info_table" id="div${userCategory.userid}">
                        <ul>
                            <li>${userCategory.userid}</li>
                            <li>${userCategory.username}</li>
                            <li>${userCategory.phone}</li>
                            <li>${userCategory.email}</li>
                            <li>${userCategory.createtime}</li>
                            <li><a href="javascript:void(0)" onclick="deleteUser(${userCategory.userid})">删除</a></li>
                        </ul>
                    </div>
                </c:forEach>
        </div>


<%--        <div class="category_table">--%>
<%--        <table  align="center" width="60%" border=1>--%>
<%--            <tr>--%>
<%--                <td >编号</td>--%>
<%--                <td >分类名称</td>--%>
<%--                <td >分类描述</td>--%>
<%--                <td >创建时间</td>--%>
<%--                <td >更新时间</td>--%>
<%--            </tr>--%>
<%--            <c:forEach items="${categories }" var="category" >--%>
<%--                <tr>--%>
<%--                    <td><input type="text" name="id" value="${category.id}"></td>--%>
<%--                    <td><input type="text" name="name" value="${category.categoryName }"></td>--%>
<%--                    <td><input type="text" name="categorySynopsis" value="${category.categorySynopsis }"></td>--%>
<%--                    <td><input type="text" name="createTime" value="${category.createTime }"></td>--%>
<%--                    <td><input type="text" name="updateTime" value="${category.updateTime}"></td>--%>
<%--                    <form action="${pageContext.request.contextPath}/category/deleteCategory?categoryid=${category.id}" method="post">--%>
<%--                        <td><input type="submit" name="yichu" value="移除分类"></td>--%>
<%--                    </form>--%>

<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--        </table>--%>
<%--        </div>--%>
    </div>

</div>

<div class="bottom">
    <p>ynChen_panpan@163.com</p>
</div>

<%--添加视频分类--%>
<div class="add_sort">
    <div class="item firstLine" id="firstLine">
        <span class="add_title">添加视频分类</span>
        <span class="add_close" id="close_add" onclick="close_add()">X</span>
    </div>
    <div class="form">
        <lable>分类名称：<input type="text" name="add_category_name" placeholder="请输入分类名称" id="add_category_name"></lable><br>
        <lable>分类简介：<input type="text" name="add_category_intro" placeholder="请输入视频简介" id="add_category_intro"></lable><br>
        <input type="button" value="提交" class="add_button" onclick="add_category()">
    </div>
</div>

<%--添加视频分类遮罩层--%>
<div class="cover"></div>




</body>
</html>
