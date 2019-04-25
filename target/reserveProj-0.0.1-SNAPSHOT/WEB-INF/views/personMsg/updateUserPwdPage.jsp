<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>

<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="//apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>

<% 
	pageContext.setAttribute("APP_PATH",request.getContextPath());
%>

<style type="text/css">
#box{
	width: 400px;
	height: 300px;
	background-color: #EEB4B4;
	position: absolute;
	bottom: 1px;
	right: 1px;
	z-index: 100;
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
.text2{
	color: #607B8B;
	margin: 0px 100px 0 100px;
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
.form-group>label{
	color: gray;
	font-size: 17px;
	font-weight:normal;
	float: left;
	margin-right: 10px;
}
.form-group>input{
	margin-top: 40px;
}
label.error{
    float: left;
    height: 30px;
    line-height: 30px;
    font-size: 12px;
    text-align: left;
    margin-left: 100px;
    padding-left: 15px;
    color: red;
}

</style>

<script type="text/javascript">
$(document).ready(function(){
	
	if(${oldPwdError=='1'}){
		setTimeout(function(){$("#box").slideToggle("2000");}, 100);
		$("#closeBtn").click(function() {
			$("#box").slideToggle();
		});
	}
	
	if(${samePwd=='1'}){
		setTimeout(function(){$("#box2").slideToggle("2000");}, 100);
		$("#closeBtn2").click(function() {
			$("#box2").slideToggle();
		});
	}
	
	//验证
	$("#updateForm").validate({
		rules:{    
			 //配置验证规则，key就是被验证的dom对象，value就是调用验证的方法(也是json格式)
			 oldPassword:{
             	required:true,
             	minlength:8 
             },
			 password:{
                 required:true,
                 minlength:8   
             },
             password2:{
                 required:true,
                 minlength:8, 
                 equalTo:'#password' 
             }
        },
        messages:{
        	//验证回显的信息
        	oldPassword:{
             	 required:"旧密码不能为空",
             	 minlength:"密码长度至少为8" 
             },
        	password:{
                 required:"新密码不能为空",
                 minlength:"密码长度至少为8" 
            },
	        password2:{
	             required:"不能为空" ,
	             minlength:"密码长度至少为8",
	             equalTo:"两次密码必须一致"
	        }
        }
	});

});

</script>

</head>
<body>
<!-- 旧密码错误弹窗 -->
<div id="box" style="display: none">
	<div id="content">
		<div >
  			<h1 class="text3" >很抱歉</h1>
  			<hr>
  			<p class="text2">你输入的旧密码有误！</p>
		</div>
		<span class="colseBtn" style="cursor:pointer;"><a  id="closeBtn" >
			<span class="glyphicon glyphicon-remove" style="font-size:25px;margin-top: 10px"></span>
		</a></span>
	</div>
</div>

<!-- 新旧密码相同弹窗 -->
<div id="box2" style="display: none">
	<div id="content">
		<div >
  			<h1 class="text3" >很抱歉</h1>
  			<hr>
  			<p class="text2">新密码与旧密码相同！</p>
		</div>
		<span class="colseBtn" style="cursor:pointer;"><a  id="closeBtn2" >
			<span class="glyphicon glyphicon-remove" style="font-size:25px;margin-top: 10px"></span>
		</a></span>
	</div>
</div>

<div class="content">
	<h2 class="logoText">修改密码</h2>
	<div style="margin: 100px 45px;">
		<form id="updateForm" action="${APP_PATH}/view/updateUserPwd">
			<div class="form-group">
			   <label><strong>输入旧密码 </strong></label>
			   <input type="password" name="oldPassword" id="newPassword" class="form-control" style="width: 200px;"  placeholder="请输入密码" />
			</div>
			<div class="form-group">
			   <label><strong>输入新密码 </strong></label>
			   <input type="password" name="password" id="password" class="form-control" style="width: 200px;"  placeholder="请输入密码" />
			</div>
			<div class="form-group">
			   <label><strong>再输入密码</strong></label>
			   <input type="password" name="password2" id="password2" class="form-control" style="width: 200px;"  placeholder="再次输入密码" />
			</div>
			<div style="margin-top: 40px;">
				<button type="submit" class="btn btn-info">修改密码</button>
			</div>
		</form>
	</div>
</div>

</body>
</html>