<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息页面</title>

<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="//apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>


<style type="text/css">
#box{
	width: 400px;
	height: 300px;
	background-color: #E0FFFF;
	position: absolute;
	bottom: 1px;
	right: 1px;
	z-index: 200;
}
#box2{
	width: 400px;
	height: 300px;
	background-color: #E0FFFF;
	position: absolute;
	bottom: 1px;
	right: 1px;
	z-index: 200;
}
.text2{
	color: #607B8B;
	margin: 0px 100px 0 145px;
	font-size: 20px;
	line-height: 40px;
}
.text3{
	text-align: center;
	margin-top: 30px;
	margin-bottom:30px;
	color: #76EE00;
	font-weight: bold;
}
.colseBtn{
	position:absolute;
	right:10px;
	top: 0;
}
.content{
	margin: 100px auto;
	padding:25px;
	width: 550px;
	height: 500px;
	background-color: #F0FFFF;
}
.logoText{
	color:#8B3A3A;
	text-align: center;
	font-family: Microsoft YaHei;
	font-weight: bold;
	margin-bottom: 30px;
}
.text1{
	color: gray;
	font-size: 18px;
	font-weight:normal;
	margin:10px 100px;
	
}
.form-group>label{
	color: gray;
	font-size: 17px;
	font-weight:normal;
	float: left;
	margin-right: 10px;
}
.msg{
	margin-left: 100px;
}
#introduction{
	width: 280px;
	margin-left: 100px;
	height: 80px;
	margin-top: -10px;
}


</style>

<script type="text/javascript">
$(document).ready(function(){
	if(${updateMsg=='1'}){
		setTimeout(function(){$("#box").slideToggle("2000");}, 100);
		$("#closeBtn").click(function() {
			$("#box").slideToggle();
		});
	}
	
	if(${updatePwd=='1'}){
		setTimeout(function(){$("#box2").slideToggle("2000");}, 100);
		$("#closeBtn2").click(function() {
			$("#box2").slideToggle();
		});
	}
	
	
	//验证
	$("#userForm").validate({
		rules:{    
			 //配置验证规则，key就是被验证的dom对象，value就是调用验证的方法(也是json格式)
			 email:{
                 email:true  
             }
        },
        messages:{
        	//验证回显的信息
        	email:{
                 email:"请输入正确的邮箱格式"  
            }
        }
	});
	

});

</script>

<% 
	pageContext.setAttribute("APP_PATH",request.getContextPath());
%>

</head>
<body>

<!-- 添加成功弹窗 -->
<div id="box" style="display: none">
	<div id="content">
		<div >
  			<h1 class="text3" >已成功</h1>
  			<hr>
  			<p class="text2">修改个人信息</p>
		</div>
		<span class="colseBtn" style="cursor:pointer;"><a  id="closeBtn" >
			<span class="glyphicon glyphicon-remove" style="font-size:25px;margin-top: 10px"></span>
		</a></span>
	</div>
</div>
<!-- 修改密码成功弹窗 -->
<div id="box2" style="display: none">
	<div id="content">
		<div >
  			<h1 class="text3" >已成功</h1>
  			<hr>
  			<p class="text2">修改密码</p>
		</div>
		<span class="colseBtn" style="cursor:pointer;"><a  id="closeBtn2" >
			<span class="glyphicon glyphicon-remove" style="font-size:25px;margin-top: 10px"></span>
		</a></span>
	</div>
</div>

	<div class="content">
		<form:form id="updateForm" action="${APP_PATH}/view/updateUserMsg" modelAttribute="user">
			<form:hidden path="id"/>
			<form:hidden path="username"/>
			<form:hidden path="tureName"/>
			<form:hidden path="password"/>
			<form:hidden path="level"/>
			<form:hidden path="major"/>
			<form:hidden path="classnum"/>
			<form:hidden path="gender"/>
			<h2 class="logoText">个人信息页面</h2>
			<p class="text1"><strong>姓名 :</strong> ${user.tureName} &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<strong>${user.level}届</strong></p>
			<p class="text1"><strong>专业 :</strong> ${user.major}  &nbsp&nbsp&nbsp <strong>班级 :</strong> ${user.classnum}</p>
			<p class="text1"><strong>性别 :</strong> 
				<c:if test="${user.gender=='1'}">男</c:if>
				<c:if test="${user.gender=='2'}">女</c:if>
			</p>
			<div class="msg">
				<div class="form-group">
				    <label><strong>邮箱&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</strong></label>
				    <form:input type="email" path="email" id="email" class="form-control" style="width: 200px;"  placeholder="Email" />
				</div>
				<div class="form-group">
				    <label><strong>联系电话</strong></label>
				    <form:input type="text" path="telephone" id="telephone" class="form-control" style="width: 200px;"  placeholder="手机号" 
				    onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
				</div>
			</div>
			<div class="form-group">
			    <p class="text1"><strong>个人介绍</strong></p>
			    <form:textarea path="introduction"  class="form-control" id="introduction" placeholder="" />
			</div>
			<div style="margin-left: 100px;">
				<button type="submit" class="btn btn-default">修改信息</button> &nbsp&nbsp&nbsp
				<a href="${APP_PATH}/view/updateUserPwdPage"><button type="button" class="btn btn-info">修改密码</button></a>
			</div>
		</form:form>
	</div>
</body>
</html>