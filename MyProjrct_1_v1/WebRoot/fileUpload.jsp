<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件上传</title>

<style type="text/css">
	#main {
		position: absolute;
		left: 530px;
		top: 100px;
	}
</style>

</head>
<body>
	<jsp:include page="/common-jsp/menu_head.jsp"></jsp:include>
	<div id="main">
		<h4 align="center">文件上传与下载</h4>
		<form name="uploadForm" action="${pageContext.request.contextPath}/CoreController/fileUploadAndDownload" method="post" enctype="multipart/form-data">
			自定义文件名:<input type="text" name="fileName" />(此项不填则使用默认文件名)<br/>
			<c:if test="${requestScope.msg != null }">
				<font color="red">${requestScope.msg }</font>
			</c:if>
			<br /> 选择文件:<input type="file" name="fileContent" /><br /><br />
			 <input type="submit" value="上传文件" />
		</form>
		<br />
		<c:if test="${requestScope.downloadList != null && fn:length(requestScope.downloadList)!=0}">
			<hr color="pink"/><br />
			<table border="1" width="600px">
				<tr>
					<th>序号</th>
					<th>文件名</th>
					<th>操作</th>
				</tr>
				<c:forEach varStatus="sta" items="${requestScope.downloadList }"
					var="downloadFile">
					<tr>
						<td>${sta.count }</td>
						<td>${downloadFile.key }</td>
						<td><a href="${pageContext.request.contextPath}/FileDownloadServlet?fileName=${downloadFile.value}">下载</a>/
							<a href="${pageContext.request.contextPath}/FileDleteServlet?fileName=${downloadFile.value}">删除</a></td>
					</tr>
				</c:forEach>
	
			</table>
		</c:if>
	</div>
</body>
</html>