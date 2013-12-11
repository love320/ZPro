<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="base" value="${pageContext.request.contextPath}"/>

<!-- Static navbar -->
      <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">冰迪网络</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
              <li><a href="#">首页</a></li>
		      <li class="usernav"><a href="${base}/user/list">用户管理</a></li>
		      <li class="rolenav"><a href="${base}/role/list">角色管理</a></li>
		      <li class="authoritynav"><a href="${base}/authority/list">权限管理</a></li>
		      <li class="upfilenav"><a href="${base}/upfile/list">文件上传</a></li>
		      <li><a href="${base}/user/logout">退出</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li class="active"><a href="#">关于我们</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
