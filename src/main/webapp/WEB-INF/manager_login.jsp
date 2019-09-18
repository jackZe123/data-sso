<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>后台管理登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/manager_login.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/manager_login.js"></script>

</head>
<body>
<div class="manager_login" id="manager_login">
    <h1>一拍短视频后台管理</h1>
    <form action="${pageContext.request.contextPath}/admin/checkLogin" method="post" class="manager_form">
        <lable>账号：<input type="text"name="adminaccount"id="manager_account" style="height:35px;width:255px"></lable>
        <span class="span_manager_account"></span><br>
        <lable>密码：<input type="password" name="adminpassword"  id="manager_password" style="height:35px;width:255px"></lable>
        <span class="span_manager_password"></span><br>
        <input type="submit"  value="登录" class="submit" ><br>
    </form>
</div>
</body>
</html>
