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
    <title>卖家登录</title>
    
    <link rel="stylesheet" href="easyui/themes/default/easyui.css" />
	<link rel="stylesheet" href="easyui/themes/icon.css"/>
	<script src="easyui/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js" ></script>
	<script src="easyui/locale/easyui-lang-zh_CN.js"></script>
    
  </head>
  
  
  <body>
	<div>
		<p>卖家登录</p>
		<form action="spa/mlogin" method="post">
			店名:<input type="text" name="name" /><br>
			密码:<input type="password" name="pwd" /><br>
			<button>登录</button>
		</form>
		<br>
		<a href="index.jsp">切换到买家登录页面</a>
	</div>
  </body>
</html>
