<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增修改用户</title>

<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="//apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<!-- jq的validate验证插件 -->
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>

<% 
	pageContext.setAttribute("APP_PATH",request.getContextPath());
%>	
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
	background-color: #EEB4B4;
	position: absolute;
	bottom: 1px;
	right: 1px;
	z-index: 100;
}
.text3{
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
a{
	color: #63B8FF;
}
.logoText{
	color: #48D1CC;
	font-size: 30px;
	margin: 10px 55px;
}
.text1{
	font-size: 19px;
	margin-left: 10px;
}

input[type="radio"] + label::before {
    content: "\a0"; /*不换行空格*/
    display: inline-block;
    vertical-align: middle;
    font-size: 19px;
    width: 1em;
    height: 1em;
    margin-right: .4em;
    border-radius: 50%;
    border: 1px solid #63B8FF;
    text-indent: .15em;
    line-height: 1; 
}
input[type="radio"]:checked + label::before {
    background-color: #63B8FF;
    background-clip: content-box;
    padding: .2em;
}
input[type="radio"] {
    position: absolute;
    clip: rect(0, 0, 0, 0);
}
input[type="text"],input[type="password"] {
    width: 300px;
}
.addForm{
 	margin: 10px 40px;
 	float: left;
}
.selectStyle{
	margin-left: 20px;
	height: 32px;width: 150px;
	background-color: #F7F7F7;
	border-radius:3px;
	-webkit-border-radius:3px;
	-moz-border-radius :3px;
}


fieldset{    width: 650px;    }
legend{    
    text-align: center;
    font-size: 20px;
}
.item{
    height: 56px;
    line-height: 30px;
    margin: 10px;
}
.item .item-label{
    float: left;
    width: 80px;
    text-align: right;
}
.item-text{
    float: left;
    width: 240px;
    height: 30px;
    padding: 9px 25px 9px 5px;
    margin-left: 10px;
    border: 1px solid #ccc;
    overflow: hidden;
}
.item-select{
    float: left;
    height: 30px;
    border: 1px solid #ccc;
    margin-left: 10px;
    font-size: 14px;
    padding: 6px 0px;
}
.item-file{
    float: left;
    height: 30px;
    margin-left: 10px;
    font-size: 14px;
    padding: 6px 0px;
}
.item-submit{
    float: left;
    height: 30px;
    width: 50px;
    margin-left: 90px;
    font-size: 14px;
}
input.error{
    border: 1px solid #E6594E;
}
input.highlight{
    border: 1px solid #7abd54;
}
label.error{
    float: left;
    height: 30px;
    line-height: 30px;
    font-size: 12px;
    text-align: left;
    margin-left: 0px;
    padding-left: 15px;
    color: red;
}


</style>
<script type="text/javascript">
$(document).ready(function(){
	if(${addSuccess=='1'}){
		setTimeout(function(){$("#box").slideToggle("2000");}, 100);
		$("#closeBtn").click(function() {
			$("#box").slideToggle();
		});
	}
	
	if(${existFlag=='1'}){
		setTimeout(function(){$("#box2").slideToggle("2000");}, 100);
			$("#closeBtn2").click(function() {
				$("#box2").slideToggle();
		});
	}
	
	//验证
	$("#userForm").validate({
		rules:{    
			 //配置验证规则，key就是被验证的dom对象，value就是调用验证的方法(也是json格式)
			 username:{
                 required:true  //必填。如果验证方法不需要参数，则配置为true
             },
             password:{
                 required:true,
                 minlength:8  
             },
             password2:{
	             required:true,
	             equalTo:'#password'
	         },
	         level:{
	         	required:true
	         },
	         major:{
	         	required:true
	         },
	         classnum:{
	         	required:true
	         },
             email:{
                 email:true
             },
             tureName:{
                 required:true
             }
        },
        messages:{
        	//验证回显的信息
        	username:{
                 required:"用户名(学号)不能未空"  
            },
            password:{
                 required:"密码不能为空",
                 minlength:"密码长度至少为8" 
            },
	        password2:{
	             required:"不能为空" ,
	             equalTo:"两次密码必须一致"
	        },
	        level:{
	         	required:"届数不能为空"
	        },
	        major:{
	         	required:"专业不能为空"
	        },
	        classnum:{
	         	required:"班级不能为空"
	        },
            email:{
                 email:"请输入正确的邮箱格式"
            },
            tureName:{
                 required:"真实姓名不能未空"
             }
        }
	});


});

</script>



</head>
<body>

<!-- 添加成功弹窗 -->
<div id="box" style="display: none">
	<div id="content">
		<div >
  			<h1 class="text3" >已成功</h1>
  			<hr>	
  			<c:if test="${updateSuccess==null}">
  				<p class="text2">添加用户: <strong>${resourceName}</strong></p>
  			</c:if>
  			<c:if test="${updateSuccess=='1'}">
  				<p class="text2">修改用户: <strong>${resourceName}</strong></p>
  			</c:if>
		</div>
		<span class="colseBtn" style="cursor:pointer;"><a  id="closeBtn" >
			<span class="glyphicon glyphicon-remove" style="font-size:25px;margin-top: 10px"></span>
		</a></span>
	</div>
</div>
<!-- 数据已存在弹窗 -->
<div id="box2" style="display: none">
	<div id="content">
		<div >
  			<h1 class="text3" >已存在该用户</h1>
  			<hr>
  			<p class="text2">用户名: ${resourceName}</p>
		</div>
		<span class="colseBtn" style="cursor:pointer;"><a  id="closeBtn2" >
			<span class="glyphicon glyphicon-remove" style="font-size:25px;margin-top: 10px"></span>
		</a></span>
	</div>
</div>

<div class="content">
	<ul class="nav nav-tabs">
	  <li ><a href="${APP_PATH}/userManage/userList?pageNum=1">用户列表</a></li>
	  <li class="active"><a href="${APP_PATH}/userManage/addUserPage">
	  	<c:if test="${user.id==null }">
	  		新增用户
	  	</c:if>
	  	<c:if test="${user.id!=null }">
	  		修改用户
	  	</c:if>
	  </a></li>
	</ul>
	<c:if test="${user.id==null}">
		<p class="logoText">新增一般用户信息</p>
	</c:if>
	<c:if test="${user.id!=null}">
		<p class="logoText">修改一般用户信息</p>
	</c:if>
	<form:form id="userForm" action="${APP_PATH}/userManage/addUser" modelAttribute="user">
		<div class="addForm">
		  <form:hidden path="id"/>
		  <div class="form-group">
		    <label class="text1">用户名(学号)</label>
		    <form:input type="text" path="username" class="form-control" id="username" placeholder="学号" 
		    onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
		  </div>
		  <c:if test="${user.id==null }">
		  	  <div class="form-group">
			    <label for="exampleInputPassword1" class="text1">密码</label>
			    <form:input type="password" path="password" class="form-control" id="password" placeholder="请输入密码" />
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1" class="text1">确认密码</label>
			    <input type="password" name="password2" class="form-control" id="password2" placeholder="再次输入密码">
			  </div>
		  </c:if>
		  <div class="form-group">
		    <label for="exampleInputPassword1" class="text1">届数</label>
		    <form:input type="text" path="level" class="form-control" id="level" placeholder="如：15 (届)" 
		    onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1" class="text1">专业</label>
		    <form:input type="text" path="major" class="form-control" id="major" placeholder="专业名称" />
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1" class="text1">班级</label>
		    <form:input type="text" path="classnum" class="form-control" id="classnum" placeholder="如：1班" />
		  </div>
		  <div class="form-group">
		    	<label for="exampleInputEmail1" class="text1"> 预定权利</label></br>
		    	<div style="margin:5px 10px;">
					<form:radiobutton   id="yes" path="permission" value="1" checked="checked" />
	      			<label for="yes">有</label>
	      			<form:radiobutton   id="no" path="permission" value="0" /> 
	      			<label for="no">否</label>
      			</div>
		   </div>
		  <button type="submit" class="btn btn-info">
		 	  <c:if test="${user.id==null }">
		 		 新增
		 	  </c:if>
		 	  <c:if test="${user.id!=null }">
		 		 修改
		 	  </c:if>
		  </button>
		</div>
		<div style="float: left;margin: 0 30px;">
			<div class="form-group">
			    <label for="exampleInputPassword1" class="text1">真实姓名</label>
			    <form:input type="text" path="tureName" class="form-control" id="tureName" placeholder="姓名" />
			</div>
			<div class="form-group">
				<label  class="text1">性别</label>
				<form:select id="permission" path="gender" class="selectStyle">
					<form:option value="">请选择</form:option>
					<form:option value="1">男</form:option>
					<form:option value="2">女</form:option>
				</form:select>
			</div>
			<div class="form-group">
			    <label  class="text1">手机号</label>
			    <form:input type="text" path="telephone" class="form-control" id="telephone" placeholder="请输入手机号" 
			    onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
			</div>
			<div class="form-group" style="margin-bottom: 35px">
			    <label  class="text1">邮箱</label>
			    <form:input type="email" path="email" class="form-control" id="email" placeholder="请输入邮箱地址" />
			</div>
			<div class="form-group">
			    <label  class="text1">个人介绍</label>
			    <form:textarea path="introduction" class="form-control" id="introduction" placeholder="" />
			</div>
		</div>
	</form:form>

</div>
</body>
</html>