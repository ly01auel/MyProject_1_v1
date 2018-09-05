<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆成功页面</title>

<link rel="stylesheet" type="text/css" href="#" />
<script type="text/javascript" src="#"></script>
<script type="text/javascript">
	var t = 1;//设定跳转的时间
	
	
	function refer(){
		if(t == 0){
			location = "/MyProjrct_1_v1/menu.jsp";
		}
		document.getElementById("timer").innerHTML = t + "秒后为您跳转到主页面......";
		t--;
	}
	
	
	setInterval("refer()", 1000);//启动1秒定时
</script>
</head>
<body>
	<span>${timeNow }</span>
	<center>
		<c:out value="${message }" default="<h1>WELCOME TO　MY SYSTEM!</h1>"
			escapeXml="false"></c:out>
	</center>
	<center id="timer"></center>
</body>
</html>