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
    <title>修改</title>
    
    <link rel="stylesheet" href="easyui/themes/default/easyui.css" />
	<link rel="stylesheet" href="easyui/themes/icon.css"/>
	<script src="easyui/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js" ></script>
	<script src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
    
    </script>
    
  </head>
  
  
	<body>
		<div style="width: 100%; text-align: center; margin: 10 auto;" >
			<div style="width: 30% ;float: left;text-align: center; margin: 0 auto;">
				<p style="font-size:xx-large ;width: 100%;text-align: center;color:maroon;">修改商品</p>
				<form action="ma/updateProTru" method="post">
					<input type="hidden" name="mname" value="${requestScope.mname}" />
					<input type="hidden" name="mpwd" value="${requestScope.pwd}" />
					<input type="hidden" name="pid" value="${requestScope.product.id}" />
					<table border="0" style="width: 100%; text-align: center;">
						<tr>
							<td>商品名</td>
							<td><input type="text" name="pname" value="${requestScope.product.name}" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '${requestScope.product.name}';}" /></td>
						</tr>
						<tr>
							<td>商品单价</td>
							<td><input type="text" name="price" value="${requestScope.product.price}" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '${requestScope.product.price}';}"  />元</td>
						</tr>
						<tr>
							<td>商品现有库存</td>
							<td><input type="number" name="num" value="${requestScope.product.num}" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '${requestScope.product.num}';}"  /></td>
						</tr>
						<tr>
							<td>商品额定库存</td>
							<td><input type="number" name="allnum" value="${requestScope.product.allnum}" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '${requestScope.product.allnum}';}"  /></td>
						</tr>
					</table>
					<button style="font-size: large;width: 100%; text-align: center;color: fuchsia;">
						修改</button>
				</form>
			</div>
		</div>
	</body>
</html>
