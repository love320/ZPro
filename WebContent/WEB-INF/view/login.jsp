<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%    
String path = request.getContextPath();    
String base = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;    
%> 
<!DOCTYPE html>
<html lang="zh_CN">
<head>
<meta charset="utf-8">
<title>ZPro 基础架构-冰迪网络(出品)</title>
<link href="<%=base%>/css/bootstrap.css" rel="stylesheet">
<link href="<%=base%>/css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form action="<%=base%>/user/login.do" method="post" class="form-inline">
			<legend>登录 ${msg}</legend>
			 <input type="text" name="name" value="" placeholder="账号">
			 <input type="text" name="pwd" value="" placeholder="姓名">
			 <input type="text" name="code" value="" placeholder="验证码">
			 <button type="submit" class="btn">登录</button>
		</form>
	</div>

	<!-- javascript -->
	<script src="<%=base%>/js/jquery.js"></script>
	<script src="<%=base%>/js/bootstrap.js"></script>
</body>
</html>
