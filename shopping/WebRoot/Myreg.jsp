<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>买家注册</title>
  </head>
  
  
  <body>
	<div>
		<p>买家注册</p>
		<form action="spa/ureg" method="post">
			昵称:<input type="text" name="name" /><br>
			密码:<input type="password" name="pwd" /><br>
			<button>注册</button>
		</form>
		<br>
		<a href="index.jsp">切换到买家登录页面</a>
	</div>
  </body>
</html>
