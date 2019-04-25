<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>

<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="//apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<% 
	pageContext.setAttribute("APP_PATH",request.getContextPath());
	int currentNum = Integer.parseInt((String)request.getAttribute("pageNum"));
	int pages = Integer.parseInt((String)request.getAttribute("pages"));
	int pre=currentNum-1;
	int nex=currentNum+1;
	if(pre==0){
		request.setAttribute("pre", "1");
	}else{
		request.setAttribute("pre", pre);
	}
	if(nex>pages){
		request.setAttribute("nex", pages);
	}else{
		request.setAttribute("nex", nex);
	}
%>

<style type="text/css">
#box2{
	width: 400px;
	height: 300px;
	background-color: #EEB4B4;
	position: absolute;
	bottom: 1px;
	right: 1px;
	z-index: 100;
}
.text1{
	text-align: center;
	margin-top: 30px;
	margin-bottom:30px;
	color: #76EE00;
	font-weight: bolder;
}
.text2{
	color: #607B8B;
	margin: 0px 100px 0 100px;
	font-size: 18px;
	line-height: 40px;
}
.colseBtn{
	position:absolute;
	right:10px;
	top: 0;
}
.content{
	margin: 4px;
}
table>thead>tr,table>tbody>tr{
	text-align: center;
}
table>thead>tr{
	font-weight: bold;
}
a{
	color: #63B8FF;
}
a:HOVER {
	text-decoration:none;
}
.paging{
	position: relative;
	margin: 60px 150px;
}
.pageInfo{
	font-size: 14px;
	color: gray;
	float: left;
	font-weight: bolder;
	position: relative;
	left:60px;
	top:33px;
}
.goForm{
	position:relative;
	left:30px;
	top:19px;
}
.pagination{
	float: left;
}
.select{
	margin: 7px 15px;
}
.selectStyle{
	float: left;
	margin-right: 20px;
	height: 32px;width: 150px;
	background-color: #F7F7F7;
	border-radius:3px;
	-webkit-border-radius:3px;
	-moz-border-radius :3px;
}
.form-group{
	float: left;
	margin-right: 20px;
}

</style>
<script type="text/javascript">
$(document).ready(function(){
	
	var pageNum = ${pageInfo.pageNum};   //当前页数
	var pages = ${pageInfo.pages};  //总页数
	if(pageNum=='1'){
		$("#previous").addClass("disabled");
	}
	if(pageNum==pages){
		$("#next").addClass("disabled");
	}
	
	if(${delFlag=='1'}){
		setTimeout(function(){$("#box2").slideToggle("2000");}, 100);
			$("#closeBtn2").click(function() {
				$("#box2").slideToggle();
		});
	}
	

});


</script>


</head>
<body>

<!-- 删除弹窗 -->
<div id="box2" style="display: none">
	<div id="content">
		<div >
  			<h1 class="text1" >已成功删除</h1>
  			<hr>
  			<p class="text2">用户: ${resourceName}</p>
		</div>
		<span class="colseBtn" style="cursor:pointer;"><a  id="closeBtn2" >
			<span class="glyphicon glyphicon-remove" style="font-size:25px;margin-top: 10px"></span>
		</a></span>
	</div>
</div>

<div class="content">
	<ul class="nav nav-tabs">
	  <li  class="active"><a href="${APP_PATH}/userManage/userList?pageNum=1">用户列表</a></li>
	  <li ><a href="${APP_PATH}/userManage/addUserPage">新增用户</a></li>
	</ul>
	
	<div class="select">
		<form:form action="${APP_PATH}/userManage/userList?pageNum=1" modelAttribute="user">
		<div class="form-group">
		    <form:input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"
		     id="username" type="text" class="form-control" path="username"  placeholder="用户名" style="widows: 150px;" />
		</div>
		<div class="form-group">
		    <form:input id="tureName" type="text" class="form-control" path="tureName"  placeholder="姓名" style="widows: 150px;" />
		</div>
		<div class="form-group">
		    <form:input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"
		     id="level" type="text" class="form-control" path="level"  placeholder="届数 (届)" style="widows: 150px;" />
		</div>
		<div class="form-group">
		    <form:input id="major" type="text" class="form-control" path="major"  placeholder="专业" style="widows: 150px;" />
		</div>
		<form:select id="permission" path="permission" class="selectStyle">
			<form:option value="">预定权利</form:option>
			<form:option value="1">有</form:option>
			<form:option value="0">无</form:option>
		</form:select>
		<button class="btn btn-info" type="submit" style="float: left;">查询</button>
		</form:form>
	</div>
	
	<table class="table table-hover">
		<thead>
			<tr class="info">
				<td>用户名(学号)</td>
				<td>姓名</td>
				<td>届数</td>
				<td>专业班级</td>
				<td>性别</td>
				<td>预定权利</td>
				<td>操作</td>
			</tr>
		</thead>
		<c:forEach items="${pageInfo.list}" var="user">
			<tr>
				<td>${user.username}</td>
				<td>${user.tureName}</td>
				<td>${user.level}届</td>
				<td>${user.major}&nbsp${user.classnum}</td>
				<td>
					<c:if test="${user.gender=='1'}">男</c:if>
					<c:if test="${user.gender=='2'}">女</c:if>
				</td>
				<td>
					<c:if test="${user.permission=='1'}"><span style="color: #66CD00">有</span></c:if>
					<c:if test="${user.permission=='0'}"><span style="color: red">无</span></c:if>
				</td>
				<td>
					<a href="${APP_PATH}/userManage/updateUser?id=${user.id}">修改信息</a>
					<a onclick="return confirm('确认删除用户  【${user.username}】吗？', this.href)"
							href="${APP_PATH}/userManage/delUser?id=${user.id}&username=${username}
							&tureName=${tureName}&level=${level}&major=${major}
							&permission=${permission}&pageNum=${pageNum}&resourceName=${user.username}">
					删除用户</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div class="paging">
		<nav aria-label="Page navigation">
		  <ul class="pagination">
		    <li id="previous">
		      <a href="${APP_PATH}/userManage/userList?pageNum=${pre}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;上一页</span>
		      </a>
		    </li>
		    <li id="next">
		      <a href="${APP_PATH}/userManage/userList?pageNum=${nex}" aria-label="Next">
		        <span aria-hidden="true">下一页&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
		<div class="goForm">
			<form action="${APP_PATH}/userManage/userList" >
				<input type="text" name="pageNum" value="${pageNum}" class="form-control" placeholder="" style="width: 45px;float: left;margin-right: 10px;">
				<button class="btn btn-info" type="submit" style="float: left;margin-top: 1px;">go</button>
			</form>
		</div>
		<div class="pageInfo">
			当前 ${pageInfo.pageNum} / ${pageInfo.pages} 页  ， 共${pageInfo.total}条
		</div>
	</div>
	
	
</div>
</body>
</html>