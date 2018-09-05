<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>发送邮件</title>
<style type="text/css">
	.input_1{
		width:400px;
		height:30px;
		font-size:16px;
	}
	
	.input_2{
		font-size:20px;
	}
	
	.submit{
		white-space: nowrap;
		text-align:center;
		
	}
	
	.submit_1{
		font-size:30px;
		margin-top:20px;
	}
	
	th{
		font-size:20px;
	}
	
	#main {
		position: absolute;
		left: 470px;
		top: 100px;
	}
</style>
</head>
<body>
<jsp:include page="/common-jsp/menu_head.jsp"></jsp:include>
<div id="main">
	<h2 align="center">我的邮件发送器</h2>
	<form action="/MyProjrct_1_v1/CoreController/sendMail" method="post">
		<c:if test="${flag==true}">
			<font color="green">${msg}</font>
		</c:if>
		<c:if test="${flag==false}">
			<font color="red">${msg}</font>
		</c:if>
		<table>
			<tr>
				<th colspan="2">发件人:106714747@qq.com&nbsp;&nbsp;(默认我的邮箱)</th>
			</tr>
			<tr>
				<th>收件人</th>
				<td><input type="text" name="reciver" class="input_1" placeholder="ly01auel@126.com"/></td>
			</tr>
			<tr>
				<th>标题</th>
				<td><input type="text" name="title" class="input_1" placeholder="TestMail"/></td>
			</tr>
			<tr>
				<th>内容</th>
				<td><textarea name="content" rows="15" cols="60" class="input_2" placeholder="好好学习,天天加上"></textarea></td>
			</tr>
			<tr>
				<td class="submit" colspan="2"><input type="submit" value="发送" class="submit_1"/></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>