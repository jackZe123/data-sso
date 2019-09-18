<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/regist1.2.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/qipao.css">
	<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico">
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/register.js"></script>

</head>
<body>


<div class="w">
	<div class="left_img">
		<img src="${pageContext.request.contextPath}/img/regist.jpg">
	</div>
	<div class="pay_xiangqing">
		<form action="${pageContext.request.contextPath}/user/main" method="post" id="myform" class="regist_form">
			<div class="xiangqing">
				用户注册
			</div>
			<a href="${pageContext.request.contextPath}/user/main" class="return">[返回首页]</a>
			<div class="title hei">
				<ul>
					<li class="wid">账号</li>
					<li>
						<div class="adjust">
							<input type="text"  placeholder="请输入账号小于10位"
								   name="account"
								   id="account"
								   onblur="xuehao()">
							<img id="xuehaook" class="img" src="${pageContext.request.contextPath}/img/true.png">
							<p class="red" id="xuehao">账号不符合规范</p>
						</div>
					</li>
				</ul>
			</div>
			<div class="title hei" >
				<ul>
					<li class="wid">昵称</li>
					<li>
						<div class="adjust">
							<input type="text" placeholder="请输入用户名" id="username"
								   name="username"
								   onblur="user_name()"
							>
							<img id="nameok"  src="${pageContext.request.contextPath}/img/true.png">
							<p class="red" id="checkname">用户名不能为空</p>
						</div>
					</li>
				</ul>
			</div>
			<div class="title hei">
				<ul>
					<li class="wid0">联系方式</li>
					<li>
						<div class="adjust">
							<input type="text" placeholder="请输入手机号" id="phone1"
								   name="phone"
								   onblur="telephone()"
							>
							<img id="phoneok" src="${pageContext.request.contextPath}/img/true.png">
							<p class="red" id="phone">手机号不符合规范</p>

						</div>
					</li>
				</ul>
			</div>
			<div class="title hei">
				<ul>
					<li class="wid">邮箱</li>
					<li>
						<div class="adjust">
							<input type="text" placeholder="请输入邮箱地址"    id="email"
								   name="email1"
								   onblur="useremail()"
							>
							<img id="emailok" src="${pageContext.request.contextPath}/img/true.png">
							<p class="red" id="email2">邮箱地址不符合规范</p>

						</div>
					</li>
				</ul>
			</div>
			<div class="title">
				<ul>
					<li class="wid">性别</li>
					<li>
						<div class="adjust">
							<input type="radio"  value="1" name="sex"  id="sex1">男
							<input type="radio"  value="2" name="sex"  id="sex2">女<br>
						</div>
					</li>
				</ul>
			</div>
			<div class="title hei">
				<ul>
					<li class="wid">密码</li>
					<li>
						<div class="adjust">
							<input type="password" name="password" id="mima" onblur="userpassword()"   placeholder="请输入6~12位数字+字母">
							<img id="passwordok"  src="${pageContext.request.contextPath}/img/true.png">
							<p class="red" id="mima1">密码格式不规范</p>
						</div>
					</li>
				</ul>
			</div>
		</form>

		<div class="ok">
				<div class="span1 btn-bubble getregist1" id="aRegist" onclick="register()" >注册</div>
		</div>
		<div class="logo">
			<img src="${pageContext.request.contextPath}/img/logo.jpg">
		</div>
	</div>
</div>
</div>

</body>

</html>

