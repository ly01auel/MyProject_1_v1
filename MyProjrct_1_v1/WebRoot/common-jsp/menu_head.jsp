<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>菜单页</title>
</head>

<script type="text/javascript">
	function showTime(){
		var date = new Date();
		
		with(date){
			var year = getFullYear();
			var month = getMonth()+1;
			var date = getDate();
			var day = getDay();
			var hours = getHours();
			var minutes = getMinutes();
			var scconds = getSeconds();
		}
		
		var arr = ["日","一","二","三","四","五","六"];
		
		var timeNow = year+"年"+month+"月"+date+"日  星期"+arr[day]+"  "+hours+"时"+minutes+"分"+scconds+"秒";
		
		var item = document.getElementById("nowTime");
		
		item.innerHTML = timeNow;
	}
	
	setInterval("showTime()",1000);
</script>

<style type="text/css">
	#com_name{float:left;}
	#com_name span{margin-left:20px;}
	#com_title{float:left;margin:0px 250px 0px 450px;font-size:40px;}
	#com_time{float:right;}
	a{margin-right:20px;}
</style>
<body>
	<div  id="com_name">
		当前用户:<span>${user.userName }</span>
		<br/><a href="/MyProjrct_1_v1/CoreController/returnToMenu">菜单画面</a><a href="/MyProjrct_1_v1/CoreController/logout">退出登录</a>
	</div>
	<div id="com_title">
		<span>MyProjrct_1_v1</span>
	</div>
	<div id="com_time">
		<span id="nowTime"></span>
	</div>
</body>
</html>