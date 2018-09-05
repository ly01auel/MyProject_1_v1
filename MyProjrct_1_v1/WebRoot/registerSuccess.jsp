<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册成功页面</title>
<link rel="stylesheet" type="text/css" href="#"/>
<script type="text/javascript" src="#"></script>
<script type="text/javascript">
	var time = 3;
	
	function refer(){
		if(time == 0){
			location = "/MyProjrct_1_v1/topPage.jsp";
		}
		document.getElementById("timer").innerHTML = time+"秒后自动为您返回......";
		time--;
	}
	
	setInterval("refer()",1000);
</script>
</head>


<body>
	<center><c:out value="${message }" default="<h1>恭喜您完成注册</h1>" escapeXml="false"></c:out></center>
	<center id="timer"></center>
</body>
</html>