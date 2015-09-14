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
    <title>商品列表</title>
    
    <link rel="stylesheet" href="easyui/themes/default/easyui.css" />
	<link rel="stylesheet" href="easyui/themes/icon.css"/>
	<script src="easyui/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js" ></script>
	<script src="easyui/locale/easyui-lang-zh_CN.js"></script>
    
    <script type="text/javascript">
		function addPN(i,pid,uname,pwd) {
			var list = document.getElementsByName("pNum");
			var num = list[i].value;
			var headerurl = "http://localhost:8080/shopping/";
			var footer = "&uname="+uname+"&pwd="+pwd;
			var uri = headerurl+"spa/addSC?pid="+pid+"&num="+num+footer;
			window.location.href = uri;
		}
		function addOrder(uname,pwd) {
			var headerurl = "http://localhost:8080/shopping/";
			var footer = "?uname="+uname+"&pwd="+pwd;
			var uri = headerurl+ "spa/addOrder" +footer;
			window.location.href = uri;
		}
		function deleteSC(scid,uname,pwd) {
			var headerurl = "http://localhost:8080/shopping/";
			var footer = "&uname="+uname+"&pwd="+pwd;
			var uri = headerurl+"spa/deleteSC?scid="+scid+footer;
			window.location.href = uri;
		}
	</script>
    
  </head>
  
  
  <body>
	<div style="width: 100%; text-align: center; margin: 10 auto;" >
		<div style="background-color:yellow;width: 60% ;float: left;text-align: center; margin: 0 auto;">
			<table border="1" style="width: 100% ;text-align: center; margin: 0 auto;">
				<tr><th>所有商品</th></tr>
				<tr>
					<td>商品编号</td>
					<td>商品名</td>
					<td>商品单价</td>
					<td>商品库存</td>
					<td>购入数量</td>
					<td>添加到购物车</td>
				</tr>
				<%int i = -1; %>
				<c:forEach items="${requestScope.products}" var="list">
					<tr>
						<td>${list.id }</td>
						<td>${list.name }</td>
						<td>${list.price }</td>
						<td>${list.num }</td>
						<%i=i+1; %>
	<c:if test="${list.num>0 }">
						<td>
							<input type="number" name="pNum" value="0" />
						</td>
						<td>
							<button onclick="addPN(<%=i %>,'${list.id }',
											'${requestScope.uname}',
											'${requestScope.pwd}')">添加到购物车</button>
						</td>
						
	</c:if>					
						
						
					</tr>
				</c:forEach>
			</table>
		</div>
		<div style="width: 30% ;float: left;text-align: center; margin: 0 auto;">
			
		</div>
		
	</div>
	<c:if test="${!empty requestScope.shoppingcars}">
		<div style="width: 100%; text-align: center; margin: 10 auto;" >
			<div style="background-color:lime; width: 60% ;float: left;text-align: center; margin: 0 auto;">
				<table border="1" style="width: 100% ;text-align: center; margin: 0 auto;">
					<tr><th>订单</th></tr>
					<tr>
						<td>订单编号</td>
						<td>商品名</td>
						<td>商品单价</td>
						<td>购入数量</td>
						<td>单商品总价</td>
						<td>删除订单</td>
					</tr>
					<c:forEach items="${requestScope.shoppingcars}" var="list">
						<tr>
							<td>${list.id }</td>
							<td>${list.pname }</td>
							<td>${list.price }</td>
							<td>${list.num }</td>
							<td>${list.pprice}</td>
							<td>
								<button style="background-color: fuchsia;" 
				  				        onclick="deleteSC('${list.id }',
				  				        					'${requestScope.uname}',
												          '${requestScope.pwd}')">删除订单</button>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td>购物车总价：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							${requestScope.allprice }&nbsp;&nbsp;元</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button style="background-color: fuchsia;" 
									onclick="addOrder('${requestScope.uname}',
					   						          '${requestScope.pwd}')">提交订单</button>
						</td>
					</tr>
				</table>
			</div>	
		</div>
	</c:if>
	
	
  </body>
</html>
