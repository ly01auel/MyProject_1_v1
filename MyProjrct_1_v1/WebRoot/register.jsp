<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页面</title>

<link rel="stylesheet" type="text/css" href="#" />
<script type="text/javascript" src="#"></script>
<script type="text/javascript">
	var checkNameFlag = false;
	function checkName() {
		var userName = document.getElementById("userName").value.replace(
				/^\s+|\s+$/g, "");
		if (userName == "") {
			document.getElementById("userName").value = userName;
			document.getElementById("userName_span").innerHTML = "o(╥﹏╥)o   您没有输入内容啊!??"
					.fontcolor("red").bold();
			checkNameFlag = false;
		} else {
			document.getElementById("userName").value = userName;
			document.getElementById("userName_span").innerHTML = "\\(0^◇^0)/   OK"
					.fontcolor("green").bold();
			checkNameFlag = true;
		}
	}

	var checkRePasswordFlag = false;
	function checkRePassword() {
		var password = document.getElementById("password").value;
		var rePassword = document.getElementById("rePassword").value;

		//确认有值密码没治,提示先输入密码,并把焦点给密码
		if (rePassword != "" && password == "") {
			document.getElementById("userName_password").innerHTML = "↖(^ω^)  密码应该先输入哦! "
					.fontcolor("orange").bold();
			document.getElementById("password").focus();
			checkRePasswordFlag = false;
		}

		//确认无值密码有值,提示输入确认值
		if (rePassword == "" && password != "") {
			document.getElementById("userName_rePassword").innerHTML = "^_^“  确认密码也要输的哦! "
					.fontcolor("red").bold();
			checkRePasswordFlag = false;
		}

		//确认和密码都有值,比较两个值是否相等,不等提示不一致
		if (rePassword != "" && password != "") {
			if (password == rePassword) {
				document.getElementById("userName_password").innerHTML = "~^o^~  OK "
						.fontcolor("green").bold();
				document.getElementById("userName_rePassword").innerHTML = "↖(^ω^)↗  完美 "
						.fontcolor("green").bold();
				checkRePasswordFlag = true;
			} else {
				document.getElementById("userName_password").innerHTML = "(⊙_⊙…   额?好像有问题 "
						.fontcolor("orange").bold();
				document.getElementById("userName_rePassword").innerHTML = "囧rz  两次不一样啊... "
						.fontcolor("red").bold();
				checkRePasswordFlag = false;
			}
		}
	}

	var checkPasswordFlag = false;
	function checkPassword() {
		var password = document.getElementById("password").value;
		var rePassword = document.getElementById("rePassword").value;

		if (password == "") {
			document.getElementById("userName_password").innerHTML = "⊙﹏⊙∥   还什么都没输啊!"
					.fontcolor("red").bold();
			checkPasswordFlag = false;
		}

		if (password != "" && rePassword == "") {
			document.getElementById("userName_password").innerHTML = "◕‿-｡  OK"
					.fontcolor("green").bold();
			checkPasswordFlag = true;
		}

		if (password != "" && rePassword != "") {
			if (password == rePassword) {
				document.getElementById("userName_password").innerHTML = "~^o^~  OK "
						.fontcolor("green").bold();
				document.getElementById("userName_rePassword").innerHTML = "↖(^ω^)↗  完美 "
						.fontcolor("green").bold();
				checkPasswordFlag = true;
			} else {
				document.getElementById("userName_password").innerHTML = "(⊙_⊙…   额?好像有问题 "
						.fontcolor("orange").bold();
				document.getElementById("userName_rePassword").innerHTML = "囧rz  两次不一样啊... "
						.fontcolor("red").bold();
				checkPasswordFlag = false;
			}
		}
	}
	
	
	function checkAll(){
		checkName();
		checkPassword();
		checkRePassword();
		if (checkNameFlag && checkRePasswordFlag && checkPasswordFlag) {
			return true;
		}
		document.getElementById("message").innerHTML = "凸(⊙▂⊙✖ )....就你猴急,自己看看该输的输完了吗!?";
		return false;
	}
</script>
</head>
<body>
	<div id="div_1">
		<center>欢迎注册</center>
		<center>
			<font id="message" color="red">${message }</font>
		</center>
		<form action="/MyProjrct_1_v1/CoreController/register" method="post" onsubmit="return checkAll()">
			<table align="center" border="1" width="500px" cellspacing="0">
				<tr>
					<th>用户名:</th>
					<td><input type="text" id="userName" name="userName"
						value="${user.userName }" onblur="checkName()"
						placeholder="请输入用户名"> <span id="userName_span"></span></td>
				</tr>
				<tr>
					<th>密码:</th>
					<td><input type="password" id="password" name="password"
						value="${user.password }" onblur="checkPassword()"
						placeholder="请输入密码"> <span id="userName_password"></span></td>
				</tr>
				<tr>
					<th>确认密码:</th>
					<td><input type="password" id="rePassword" name="rePassword"
						value="${user.password }" onblur="checkRePassword()"
						placeholder="请确认密码"> <span id="userName_rePassword"></span></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="提交">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>