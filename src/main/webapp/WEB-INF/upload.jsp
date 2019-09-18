<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <title>上传界面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/upload.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/upload.js"></script>

</head>
<body >
<div class="upload" id="upload">
    <h1>视频上传</h1>
    <form action="${pageContext.request.contextPath}/video/uploadVideo" method="post" enctype="multipart/form-data" class="form_upload"><!--enctype="multipart/form-data"上传含有非文本内容时，将表单中的数据变成二进制数据进行上传-->
        视频名称：&nbsp;<input type="text" placeholder="请输入视频名称"  name="title"id="video_name" style="height:35px;width:255px"><br>
        视频分类：
        <select id="video_sort" style="height:38px;width:259px" name = "categoryname">
            <c:forEach items="${category_list_sort}" var="category">
            <option value="${category.categoryname}">${category.categoryname}</option>
            </c:forEach>
        </select><br>
        选择封面：
        <input type="file" name="img" class="f_img" id="f_img"
                /><br>
        选择视频：
        <input type="file" name="video" class="f_video" id="f_video"
               /><br>
        <input type="submit"  name="submit" class="btn_upload" onclick="checkUpload()" value="上传" >
    </form>
</div>
</body>
</html>
