<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="base" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ZPro 基础架构 -冰迪网络(出品)</title>
<link href="${base}/css/bootstrap.css" rel="stylesheet">
<link href="${base}/css/bootstrap-theme.css" rel="stylesheet">
</head>
<body>
<div class="container">
<jsp:include page="../common/nav.jsp" />
		<form class="form-horizontal" action="${base}/user/saveids" method="post">
		<input type="hidden" name="id" value="${entity.id}" />
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">账号</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="inputEmail" name="name" value="${entity.name}" placeholder="...">
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputPassword">密码</label>
				<div class="col-sm-8">
					<input type="password" class="form-control" id="inputPassword" name="password" value="${entity.password}"  placeholder="Password">
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputPassword">邮箱</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="inputPassword"  name="email" value="${entity.email}"  placeholder="Email">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputPassword">角色</label>
				<div class="col-sm-8">
					<c:forEach items="${allrolelist}" var="xx">
						<label class="checkbox"><input type="checkbox" name="ids" value="${xx.id}" 
						<c:forEach items="${rolelist}" var="xxx"><c:if test="${xx.id == xxx.id}">checked</c:if></c:forEach>
						>${xx.name}</label>
					</c:forEach>
				</div>
			</div>
			<button type="submit" class="btn btn-default col-md-offset-2">提交</button>
		</form>
</div>

	<!-- javascript -->
	<script src="${base}/js/jquery.js"></script>
	<script src="${base}/js/bootstrap.js"></script>
</body>
</html>
