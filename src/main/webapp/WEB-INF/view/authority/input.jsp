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
		<form class="form-horizontal" action="${base}/authority/save" method="post">
		<input type="hidden" name="id" value="${entity.id}" />
			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputEmail">权限名</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="inputEmail" name="name" value="${entity.name}" placeholder="...">
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
