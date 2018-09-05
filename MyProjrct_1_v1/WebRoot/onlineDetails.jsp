<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
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
		<center>在线情况统计</center>
		当前在线人数:<c:out value="${fn:length(requestScope.onlineUserMap) }"></c:out>人
		<table align="center" border="1px" width="600px">
			<tr>
				<th>序号</th>
				<th>用户Id</th>
				<th>用户名</th>
			</tr>
			<c:forEach items="${requestScope.onlineUserMap }"  var="entry"
				varStatus="stat">
				<tr>
					<td>${stat.count}</td>
					<td>${entry.value.id }</td>
					<td>${entry.value.userName}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>