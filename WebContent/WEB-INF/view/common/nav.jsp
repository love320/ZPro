<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="base" value="${pageContext.request.contextPath}"/>
	<div class="navbar">
  <div class="navbar-inner">
    <a class="brand" href="#">冰迪网络</a>
    <ul class="nav">
      <li class="active"><a href="#">首页</a></li>
      <li><a href="${base}/user/list.do">用户管理</a></li>
      <li><a href="${base}/role/list.do">角色管理</a></li>
      <li><a href="${base}/authority/list.do">权限管理</a></li>
      <li><a href="${base}/user/logout.do">退出</a></li>
    </ul>
  </div>
</div>
