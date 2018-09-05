<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看全部联系人</title>
<style type="text/css">

#main {
	position: absolute;
	left: 370px;
	top: 100px;
}

.text{
	width:10%;
	margin:0px 10px;
}

</style>

<script type="text/javascript">
	function checkBefore(a){
		if(${pageBean.currentPage}==1){
			a.href = "#";
			alert("已经米没有上一页了哦!");
		}else{
			a.href = "/MyProjrct_1_v1/ContactShowPage?currentPage="+${ pageBean.currentPage -1};	
		}
	}
	
	function checkAfter(a){
		if(${pageBean.currentPage}==${pageBean.totlePage}){
			a.href = "#";
			alert("已经米没有下一页了哦!");
		}else{
			a.href = "/MyProjrct_1_v1/ContactShowPage?currentPage="+${ pageBean.currentPage +1};	
		}
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
		location.replace("/MyProjrct_1_v1/ContactShowPage?currentPage="+value);
	}
</script>
</head>
<body>
	<jsp:include page="/common-jsp/menu_head.jsp"></jsp:include>
	<div id="main">
		<!-- 
		<form action="/MyProjrct_1_v1/SerchByCondition" method="post">
			按条件搜索联系人：<br/>
			姓名<input class="text" name="con_name" type="text" value=""></input>
			<c:choose>
				<c:when test="">
					<input name="con_sex" type="radio" value="男" checked/>男<input name="con_sex"type="radio" value="女"/>女<br/>
				</c:when>
				<c:when test="">
					<input name="con_sex" type="radio" value="男"/>男<input name="con_sex"type="radio" value="女" checked/>女<br/>
				</c:when>
				<c:otherwise>
					<input name="con_sex" type="radio" value="男"/>男<input name="con_sex"type="radio" value="女"/>女<br/>
				</c:otherwise>
			</c:choose>
			年龄<input class="text" name="con_age" type="text" value=""></input>
			电话<input class="text" name="con_tel" type="text" value=""></input><br/>
			QQ<input  class="text" name="con_qq" type="text" value=""></input>
			邮箱<input class="text" name="con_email" type="text" value=""></input><br/>
			<input type="submit" value="检索">&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="#">清空</button>
		</form>
		-->
		<h4 align="center">我的联系人</h4>
		
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
								<span><a href="/MyProjrct_1_v1/ContactShowPage?currentPage=1">首页</a></span> 
								<span><a href="/MyProjrct_1_v1/ContactShowPage?currentPage=${ pageBean.currentPage -1}"	onclick="checkBefore(this)">上一页</a></span> 
								<span> 
									<select id="selectPage">
										<c:forEach  var="i" begin="1" end="${ pageBean.totlePage}" step="1">
											<c:choose>
												<c:when test="${i==pageBean.currentPage }">
													<option selected="selected">${i }</option>
												</c:when>
												<c:otherwise>
													<option>${i }</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</span> 
								<span><button onclick="goPage()">go</button></span>
								<span><a href="/MyProjrct_1_v1/ContactShowPage?currentPage=${ pageBean.currentPage +1}" onclick="checkAfter(this)">下一页</a></span> 
								<span><a href="/MyProjrct_1_v1/ContactShowPage?currentPage=${ pageBean.totlePage}">尾页</a></span>
								<span><a href="/MyProjrct_1_v1/addContact.jsp">[添加联系人]</a></span>
							</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="8"><span>没有查询到联系人</span> <span><a
									href="/MyProjrct_1_v1/addContact.jsp">[添加联系人]</a></span></td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</body>
</html>