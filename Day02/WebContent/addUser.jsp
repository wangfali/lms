<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加联系人</title>
</head>
<body>
	<form action="AddUserServlet" method="post">
	<table style="text-align: center;">
		<tr>
			<td>姓名:</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>电话:</td>
			<td><input type="text" name="phone"></td>
		</tr>
		<tr>
			<td>邮箱:</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td>qq:</td>
			<td><input type="text" name="qq"></td>
		</tr>
		<tr>
			<td>性别:</td>
			<td><input type="radio" name="sex" value="man">男&nbsp;&nbsp;
			<input type="radio" name="sex" value="woman">女</td>
		</tr>
		<tr>
			<td><input type="submit" value="确认"></td>
			<td><input type="button" value="重置" onclick="clearTest1()"></td>
		</tr>
	</table>
	<script type="text/javascript">
		function clearTest1(){
			Element node=(Element)document.getElementsByName("name");
			node.value="";
		}
	</script>
	</form>
</body>
</html>