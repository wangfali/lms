<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更改用户信息</title>
</head>
<body>
	<form action="UpdateUserServlet" method="post">
		<table>
			<tr>
				<td>姓名</td>
				<td><input type="text" value="${user.nameString}" name="name">
				<input type="hidden" value="${user.idString}" name="id"></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" value="${user.phoneString}" name="phone"></td>
			</tr>
			<tr>
				<td>qq</td>
				<td><input type="text" value="${user.qqString}" name="qq"></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td><input type="text" value="${user.emailString}" name="email"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="radio" name="sex" value="man">男
				<input type="radio" name="sex" value="woman">女</td>
			</tr>
			<tr>
				<td><input type="submit" value="确认">
				</td>
				<td><input type="button" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>