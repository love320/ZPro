<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="base" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
<meta charset="utf-8">
<title>ZPro 基础架构 -冰迪网络(出品)</title>
<link href="${base}/css/bootstrap.css" rel="stylesheet">
<link href="${base}/css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>
<div class="container">
<jsp:include page="../common/nav.jsp" />
		<form class="form-horizontal" action="${base}/user/saveids.do" method="post">
		<input type="hidden" name="id" value="${entity.id}" />
			<div class="control-group">
				<label class="control-label" for="inputEmail">账号</label>
				<div class="controls">
					<input type="text" id="inputEmail" name="name" value="${entity.name}" placeholder="...">
				</div>
			</div>
			
			<div class="control-group">
				<label class="control-label" for="inputPassword">密码</label>
				<div class="controls">
					<input type="password" id="inputPassword" name="password" value="${entity.password}"  placeholder="Password">
				</div>
			</div>
			
			<div class="control-group">
				<label class="control-label" for="inputPassword">邮箱</label>
				<div class="controls">
					<input type="text" id="inputPassword"  name="email" value="${entity.email}"  placeholder="Email">
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<c:forEach items="${allrolelist}" var="xx">
						<label class="checkbox"><input type="checkbox" name="ids" value="${xx.id}" 
						<c:forEach items="${rolelist}" var="xxx"><c:if test="${xx.id == xxx.id}">checked</c:if></c:forEach>
						>${xx.name}</label>
					</c:forEach>
					<button type="submit" class="btn">提交</button>
				</div>
			</div>
			
		</form>
</div>

	<!-- javascript -->
	<script src="${base}/js/jquery.js"></script>
	<script src="${base}/js/bootstrap.js"></script>
</body>
</html>
