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
    <title>我的店铺</title>
    
    <link rel="stylesheet" href="easyui/themes/default/easyui.css" />
	<link rel="stylesheet" href="easyui/themes/icon.css"/>
	<script src="easyui/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js" ></script>
	<script src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
    	function updatePro(pid,mname,pwd) {
    		var headerurl = "http://localhost:8080/shopping/";
			var footer = "&mname="+mname+"&pwd="+pwd;
			var uri = headerurl+"ma/updatePro?pid="+pid+footer;
			window.location.href = uri;
		}
    	function deletePro(pid,mname,pwd) {
    		var headerurl = "http://localhost:8080/shopping/";
			var footer = "&mname="+mname+"&pwd="+pwd;
			var uri = headerurl+"ma/deleteP?pid="+pid+footer;
			window.location.href = uri;
		}
    </script>
    
  </head>
  
  
  <body>
	<div style="width: 100%; text-align: center; margin: 10 auto;" >
		<div style="background-color:fuchsia; ;width: 60% ;float: left;text-align: center; margin: 0 auto;">
			<table border="1" style="width: 100% ;text-align: center; margin: 0 auto;">
				<tr><th>所有商品</th></tr>
				<tr>
					<td>商品编号</td>
					<td>商品名</td>
					<td>商品单价</td>
					<td>商品库存</td>
					<td>原库存</td>
					<td>修改</td>
					<td>删除</td>
				</tr>
				<c:forEach items="${requestScope.myProducts}" var="list">
					<tr>
						<td>${list.id }</td>
						<td>${list.name }</td>
						<td>${list.price }</td>
						<td>${list.num }</td>
						<td>${list.allnum }</td>
						<td>
							<button onclick="updatePro('${list.id }',
											'${requestScope.mname}',
											'${requestScope.pwd}')">修改</button>
						</td>
						<td>
							<button onclick="deletePro('${list.id }',
											'${requestScope.mname}',
											'${requestScope.pwd}')">删除</button>
						</td>
						
					</tr>
				</c:forEach>
			</table>
		</div>
		<div style="width: 30% ;float: left;text-align: center; margin: 0 auto;">
			<p style="font-size:xx-large ;width: 100%;text-align: center;color:maroon;">添加商品</p>
			<form action="ma/addPro" method="post">
				<input type="hidden" name="mname" value="${requestScope.mname}" />
				<input type="hidden" name="mpwd" value="${requestScope.pwd}" />
				<table border="0" style="width: 100%; text-align: center;">
					<tr>
						<td>商品名</td>
						<td><input type="text" name="pname" /></td>
					</tr>
					<tr>
						<td>商品单价</td>
						<td><input type="text" name="price" value="0.00" />元</td>
					</tr>
					<tr>
						<td>商品现有库存</td>
						<td><input type="number" name="num" /></td>
					</tr>
					<tr>
						<td>商品额定库存</td>
						<td><input type="number" name="allnum" /></td>
					</tr>
				</table>
				<button style="font-size: large;width: 100%; text-align: center;color: fuchsia;">添加</button>
			</form>
		</div>
		
	</div>
  </body>
</html>
