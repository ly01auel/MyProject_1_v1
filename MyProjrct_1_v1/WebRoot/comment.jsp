<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>评论区页面</title>
	<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/ckeditor/samples/sample.css"></link>
</head>
<body>
	<div id="main">
		<hr/>
		<c:forEach var="comm" items="${requestScope.commentList}">
			用户名:${comm.uname }	&nbsp;	&nbsp;	&nbsp;	&nbsp;${comm.uid}<span id="time">&nbsp;	&nbsp;	&nbsp;	&nbsp;发表时间:${comm.comm_time }</span><br/><br/>
			评论内容:<span>${comm.comm_content }</span>
			<hr/>
		</c:forEach>
		<div style="border:solid">
			<font color="red">注意本站自动屏蔽敏感词汇，如：SB，NND,MDZZ等</font>
			<br/><a href="/MyProjrct_1_v1/CoreController/returnToMenu">菜单画面</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/MyProjrct_1_v1/CoreController/logout">退出登录</a>
			<form action="/MyProjrct_1_v1/CoreController/addComment" method="post">
				<textarea class="ckeditor" rows="6" cols="20" name="comment"></textarea>
				<br /> <input type="submit" value="发表评论">
			</form>
		</div>
		
	</div>

</body>
</html>