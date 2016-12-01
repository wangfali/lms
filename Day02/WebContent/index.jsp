<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通讯录管理系统</title>
</head>
<body>
	<h2>欢迎使用通讯录管理系统</h2>
	<table>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>电话</th>
			<th>qq</th>
			<th>邮箱 </th>
			<th>操作</th>
		</tr>
	<c:forEach var="user" items="${list}" varStatus="userSta">
		<tr>
			<td>${userSta.count}</td>
			<td>${user.nameString}</td>
			<td>${user.sex}</td>
			<td>${user.phoneString}</td>
			<td>${user.qqString}</td>
			<td>${user.emailString}</td>
			<td><a href="${pageContext.request.contextPath}/DeleteUserServlet?id=${user.idString}">删除</a>
			<a href="${pageContext.request.contextPath}/FindByIdServlet?id=${user.idString}">更改</a></td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="7" style="text-align:center;">
			[<a href="${pageContext.request.contextPath}/addUser.jsp">添加联系人</a>]
		</td>
	</tr>
	</table>
</body>
</html>