<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>

<link rel="stylesheet" type="text/css" href="#"/>
<script type="text/javascript" src="#"></script>

</head>
<body>
	<div id="div_1">
		<center>欢迎登录</center>
		<center><font color="red">${message }</font></center>
		<form action="/MyProjrct_1_v1/CoreController/login">
			<table>
				<table align="center" border="1" width="300px" cellspacing="0">
					<tr>
						<th>用户名:</th>
						<td>
							<input type="text" id="userName" name="userName" placeholder="请输入用户名">
						</td>
					</tr>
					<tr>
						<th>密码:</th>
						<td>
							<input type="password" id="password" name="password" placeholder="请输入密码">
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="登录">
						</td>
					</tr>
				</table>
			</table>
		</form>
	</div>
</body>
</html>