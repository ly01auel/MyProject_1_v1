<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
#main {
	position: absolute;
	left: 680px;
	top: 200px;
	width: 300px;
}
ul a {
	font-size: 25px;
	font-style: italic;
	font-weight: 700;
	color: pink;
}

h1{
	margin-left:25px;
}
</style>
<body>
	<jsp:include page="/common-jsp/menu_head.jsp"></jsp:include>
	<div id="main">
		<h1>菜单页</h1>
		<ul>
			<li><a href="/MyProjrct_1_v1/CoreController/showPageAll">联系人</a></li>
			<li><a href="/MyProjrct_1_v1/CoreController/SerchByCondition">检索联系人</a></li>
			<li><a href="/MyProjrct_1_v1/CoreController/showOnlineUsers">查看在线人数</a></li>
			<li><a href="/MyProjrct_1_v1/CoreController/addComment">发表评论</a></li>
			<li><a href="/MyProjrct_1_v1/CoreController/fileUploadAndDownload">文件上传与下载</a></li>
			<li><a href="/MyProjrct_1_v1/sendMail.jsp">邮件发送</a></li>
		</ul>
	</div>
</body>
</html>