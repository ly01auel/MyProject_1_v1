<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>检索联系人</title>
<script type="text/javascript">
	function checkBefore(a){
		if(${pageBean.currentPage}==1){
			a.href = "#";
			alert("已经米没有上一页了哦!");
		}else{
			a.href = "/MyProjrct_1_v1/SerchByCondition?currentPage="+${ pageBean.currentPage -1};	
		}
	}
	
	function checkAfter(a){
		if(${pageBean.currentPage}==${pageBean.totlePage}){
			a.href = "#";
			alert("已经米没有下一页了哦!");
		}else{
			a.href = "/MyProjrct_1_v1/SerchByCondition?currentPage="+${ pageBean.currentPage +1};	
		}
	}
	
	function clearValue(){
		var con_name = document.getElementById("con_name");
		var con_sex = document.getElementsByName("con_sex");
		var con_age = document.getElementById("con_age");
		var con_tel = document.getElementById("con_tel");
		var con_qq = document.getElementById("con_qq");
		var con_email = document.getElementById("con_email");
		
		con_name.value = null;
		var len = con_sex.length;
		for(var i=0;i<len;i++){
			con_sex[i].checked = false;
		}
		con_age.value = null;
		con_tel.value = null;
		con_qq.value = null;
		con_email.value = null;
	}
	
	function goPage(){
		//获取需要的下拉框
		var obj  = document.getElementById("selectPage");
		//获取被选中选项的下标
		var index = obj.selectedIndex;
		//得到被选中的选项元素
		var option = obj.options[index];
		//获取被选中元素的文本值
		var value = option.text;
		location.replace("/MyProjrct_1_v1/SerchByCondition?currentPage="+value);
	}
</script>

<style type="text/css">

#main {
	position: absolute;
	left: 370px;
	top: 100px;
}
</style>

</head>
<body>
	<jsp:include page="/common-jsp/menu_head.jsp"></jsp:include>
	<div id="main">
	<form action="/MyProjrct_1_v1/CoreController/SerchByCondition" method="post">
			按条件搜索联系人：<br/>
			姓名<input class="text" id="con_name" name="con_name" type="text" value="${sessionScope.condition.con_name}"></input>
			<c:choose>
				<c:when test="${sessionScope.condition.con_sex == '男'}">
					<input name="con_sex" type="radio" value="男" checked/>男<input name="con_sex"type="radio" value="女"/>女<br/>
				</c:when>
				<c:when test="${sessionScope.condition.con_sex == '女'}">
					<input name="con_sex" type="radio" value="男"/>男<input name="con_sex"type="radio" value="女" checked/>女<br/>
				</c:when>
				<c:otherwise>
					<input name="con_sex" type="radio" value="男"/>男<input name="con_sex"type="radio" value="女"/>女<br/>
				</c:otherwise>
			</c:choose>
			年龄<input class="text" id="con_age" name="con_age" type="text" value="${sessionScope.condition.con_age}"></input>
			电话<input class="text" id="con_tel" name="con_tel" type="text" value="${sessionScope.condition.con_tel}"></input><br/>
			QQ<input  class="text" id="con_qq" name="con_qq" type="text" value="${sessionScope.condition.con_qq}"></input>
			邮箱<input class="text" id="con_email" name="con_email" type="text" value="${sessionScope.condition.con_email}"></input><br/>
			<input type="submit" value="检索">&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="clearValue()">清空</button>
			<hr/>
			<table align="center" border="1" width="800px">
			<tbody align="center">
				<tr>
					<th>编号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>电话</th>
					<th>QQ</th>
					<th>邮箱</th>
					<th>操作</th>
				</tr>
				<c:choose>
					<c:when test="${not empty pageBean.dataList}">
						<c:forEach items="${pageBean.dataList }" var="contact"
							varStatus="status">
								<tr>
									<td>${( pageBean.currentPage-1 ) * pageBean.pageCount + status.count }</td>
									<td>${ contact.con_name}</td>
									<td>${ contact.con_sex}</td>
									<td>${ contact.con_age}</td>
									<td>${ contact.con_tel}</td>
									<td>${ contact.con_qq}</td>
									<td>${ contact.con_email}</td>
									<td><a href="/MyProjrct_1_v1/CoreController/SetContactData?con_id=${contact.con_id }">修改</a>/<a href="/MyProjrct_1_v1/CoreController/DeleteContact?con_id=${contact.con_id }">删除</a></td>
								</tr>
						</c:forEach>
						<tr>
							<td colspan="8">
								<span>【为您查询到${pageBean.totleCount }条记录】</span>
								<span>${pageBean.currentPage }/${pageBean.totlePage }</span>
								<span><a href="/MyProjrct_1_v1/SerchByCondition?currentPage=1">首页</a></span> 
								<span><a href="/MyProjrct_1_v1/SerchByCondition?currentPage=${ pageBean.currentPage -1}" onclick="checkBefore(this)">上一页</a></span>  
								<span><a href="/MyProjrct_1_v1/SerchByCondition?currentPage=${ pageBean.currentPage +1}" onclick="checkAfter(this)">下一页</a></span> 
								<span><a href="/MyProjrct_1_v1/SerchByCondition?currentPage=${ pageBean.totlePage}">尾页</a></span>
								<select id="selectPage">
									<c:forEach begin="1" end="${pageBean.totlePage }" step="1" var="page">
										<c:choose>
											<c:when test="${ pageBean.currentPage==page}">
												<option selected=selected>${page}</option>
											</c:when>
											<c:otherwise>
												<option>${page}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
								<span><button type="button" onclick="goPage()">跳转</button></span>
								<span><a href="/MyProjrct_1_v1/addContact.jsp">[添加联系人]</a></span>
							</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="8"><span>没有查询到联系人</span> <span><a href="#">[添加联系人]</a></span></td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</form>
	</div>
</body>
</html>