<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>增加联系人</title>
<script type="text/javascript">
	function submit(){
		document.forms[0].submit();
	}
</script>
<style type="text/css">
	#main {
		position: absolute;
		left: 610px;
		top: 100px;
	}
</style>
</head>
<body>
	<jsp:include page="/common-jsp/menu_head.jsp"></jsp:include>
	<div id="main">
		<h4 align="center">增加联系人</h4>
		<form action="/MyProjrct_1_v1/CoreController/AddContact" method="post">
			<table align="center" border="1" width="300px">
				<tr>
					<th>姓名:</th>
					<td><input name="con_name" type="text"/></td>
				</tr>
				<tr>
					<th>性别:</th>
					<td><input type="radio" name="con_sex" value="男" checked>男<input type="radio" name="con_sex" value="女">女</td>
				</tr>
				<tr>
					<th>年龄:</th>
					<td><input name="con_age" type="text"/></td>
				</tr>
				<tr>
					<th>电话:</th>
					<td><input name="con_tel" type="text"/></td>
				</tr>
				<tr>
					<th>QQ:</th>
					<td><input name="con_qq" type="text"/></td>
				</tr>
				<tr>
					<th>邮箱:</th>
					<td><input name="con_email" type="text"/></td>
				</tr>
				<tr>
					<td colspan="2" style="font-size:20px;text-align:center"><a href="javascript:submit()">[保存]</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>