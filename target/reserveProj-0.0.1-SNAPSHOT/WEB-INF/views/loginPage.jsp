<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请登录</title>
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="//apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>

<style type="text/css">
body{
	background-color: #AEEEEE;
}
.logo{
	font-family: Microsoft Yahei;
	text-align: center;
	height: 140px;
	margin-top: 10px; 
}
.nav-tabs{
	margin-bottom: 10px;
}
.checkbox-custom {
    position: relative;
    padding: 0 15px 0 25px;
    margin-bottom: 7px;
    margin-top: 25px;
    display: inline-block;
}
.checkbox-custom input[type="checkbox"] {
    opacity: 0;
    position: absolute;
    cursor: pointer;
    z-index: 2;
    margin: -6px 0 0 0;
    top: 50%;
    left: 3px;
}
.checkbox-custom label:before {
    content: '';
    position: absolute;
    top: 50%;
    left: 0;
    margin-top: -9px;
    width: 19px;
    height: 18px;
    display: inline-block;
    border-radius: 2px;
    border: 1px solid #bbb;
    background: #fff;
}
.checkbox-custom input[type="checkbox"]:checked +label:after {
    position: absolute;
    display: inline-block;
    font-family: 'Glyphicons Halflings';
    content: "\e013";
    top: 42%;
    left: 3px;
    margin-top: -5px;
    font-size: 14px;
    line-height: 1;
    width: 16px;
    height: 16px;
    color: #48D1CC;
}
.checkbox-custom label {
    cursor: pointer;
    line-height: 1.2;
    font-weight: normal;
    margin-bottom: 0;
    text-align: left;
    font-size: 20px;
    color: gray;
}


.container{
	background-color:white;
	width: 35%;
	height: 40%;
	border: 1px solid rgba(0,0,0,0.2);
	position:relative;
	margin:10px auto;
	padding: 20px 60px 40px 60px;
	
}
.jumbotron{
	background-color: white;
	padding: 0;
	margin: 0 0 20px 0 ;
	text-align: center;
	height: 30%;	
}
.form-control{
	height: 52px;
	padding-left:55px; 
}
.form-group{
	height: 50%;
}
.has-feedback .form-control-feedback {
    top: 25px;
    left: 0;
    margin: 9px 4px 3px 9px;
}
#loginBtn{
	text-align:center;
	font-size:25px;
	font-weight:50px;
	line-height:50px;
	font-family:monospace;
	font-weight:bolder;
	padding-bottom:3px;
	color:white;
	width:100%;
	height: 50px;
	background-color:#EEAEEE;
	margin-top: 25px;
}
#loginBtn:hover{
	color:#EEAEEE;
	background-color: white;
	border: 3px solid #EEAEEE;
}
a,a:visited,a:hover,a:active,a:link{
	text-decoration:none;
}
#msg{
	text-align:center;
	width:200px;
	margin: 0 auto;
	color: red;
	font-size: 20px;
}
.footer {
    position: absolute;
    bottom: 0;
    font-size:16px;
    color:gray;
    height: 50px;
    width: 100%;
    text-align: center;
    line-height: 50px;
  }
#login{
	text-align: center;
	color: #FF3030;
	font-size: 15px;
	margin-top: 5px;
	display: none;
}
label.error{
    float: left;
    height: 18px;
    line-height: 18px;
    font-size: 13px;
    text-align: left;
    margin-left: 0px;
    margin-top:2px;
    padding-left: 15px;
    color: red;
}

</style>

<% 
	pageContext.setAttribute("APP_PATH",request.getContextPath());

	String userName=null;
	String password=null;
	String privilegeMark=null;
	Cookie[] cookies=request.getCookies();
	for(int i=0;cookies!=null &&i<cookies.length;i++){
		if(cookies[i].getName().equals("username")){
			userName=cookies[i].getValue();
		}else if(cookies[i].getName().equals("password")){
			password=cookies[i].getValue();
		}else if(cookies[i].getName().equals("privilegeMark")){
			privilegeMark=cookies[i].getValue();
		}
	if(userName==null){
		userName="";
	}
	if(password==null){
		password="";
	}
	}
	if(privilegeMark=="1"){
		pageContext.setAttribute("privilegeMark",privilegeMark);
		request.setAttribute("privilegeMark", privilegeMark);
	}
	
	
%>

<script type="text/javascript">
$(document).ready(function(){
	
	
	$("#loginForm").validate({
		rules:{
			username:{
				required:true,
				minlength:9
			},
			password:{
				required:true,
				minlength:8
			}
		},
		messages:{
			username:{
				required:"用户名不能为空",
				minlength:"用户名长度至少为9"
			},
			password:{
				required:"密码不能为空",
				minlength:"密码长度至少为8"
			}
		}
	});
	
	var flag="${flag}"
	if(flag=='1'){
		$("#msg").html("<span>密码错误！</span>");
		$("#password").val("");
		$("#username").val("${username}");
		$("#password").focus();
	}
	if(flag=='2'){
		$("#msg").html("<span>不存在该管理员用户！</span>");
		$("#username").val("");
		$("#password").val("");
		$("#username").focus();
	}
	if(flag=='3'){
		$("#msg").html("<span>不存在该用户！</span>");
		$("#username").val("");
		$("#password").val("");
		$("#username").focus();
	}
	
	
	/* 如果是登录的管理员，跳转回来还显示选择管理员登录 */
	var a="${change}";
	if(a=='1'){
		$("#btn1").removeClass("active");
		$("#btn2").addClass("active");
		$("#privilegeMark").val("1");
	}
	
	$(document).keyup(function(event){
 		if(event.keyCode ==13){
   		document.loginForm.submit();
  	}
	});
	
	var b="${privilegeMark}";
	if(b=='1'){
		$("#btn1").removeClass("active");
		$("#btn2").addClass("active");
		$("#privilegeMark").val("1");
	}
	
	/* 非法访问登录页面以外的页面返回的提示 */
	var loginFlag="${loginFlag}";
	if(loginFlag=='1'){
		$("#login").css("display","block");
	}
	
});

</script>


</head>
<body style="height: 100%;width: 100%">

<div class="logo">
  	<img alt="" src="${APP_PATH }/image/schoolLogo.png" width="120px" style="margin-top: 20px">
  	<img alt="" src="${APP_PATH }/image/textLogo.png" height="100px" style="margin-top: 40px">
</div>

<div class="container">
<form name="loginForm" id="loginForm" action="${APP_PATH }/view/login" method="post">
	<div class="jumbotron" >
  		<h2>Login</h2>
	</div>
	<ul class="nav nav-tabs" >
	    <li data-toggle='tab' role="presentation" id="btn1" class="active"><a  href="#">一般用户</a></li>
	    <li data-toggle='tab' role="presentation" id="btn2" ><a  href="#">管理员</a></li>
	</ul>
	<input id="privilegeMark" type="hidden" name="privilegeMark" value="0">
	<div class="form-group  has-feedback">
	    <label class="sr-only" for="exampleInputEmail3">用户名</label>
	    <span class="glyphicon glyphicon-user form-control-feedback" aria-hidden="true" style="color:gray;font-size:25px;"></span>
	    <input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"
	     type="text" name="username" class="form-control" id="username" placeholder="用户名 ( 学号 )" value="<%=userName%>">
	</div>
  <div class="form-group has-feedback">
    <label class="sr-only" for="exampleInputPassword3">密码</label>
    <span class="glyphicon glyphicon-lock form-control-feedback" aria-hidden="true" style="color:gray;font-size:25px;"></span>
    <input type="password" name="password" class="form-control" id="password" placeholder="密码" value="<%=password%>">
  </div>
  <a  onclick='$("#tijaio").click()'><div id="loginBtn" >登录</div></a>
  <input type="submit" id="tijaio" style="display: none;"/>
  <span><div class="checkbox-custom">
      <input type="checkbox" id="RememberMe" name="RememberMe" value="yes" checked="checked">
      <label for="RememberMe">记住密码</label>
  </div></span>
  <!-- <span style="font-size: 20px;color: gray;right: 62px;bottom:45px; position:absolute;" >忘记密码？<span style="font-size: 20px;color: #48D1CC;"><a href="#">找回</a></span></span> -->
</form>
</div>
<div id="login">
	您还没登录或者登录已过期，请先登录！
</div>
<div id="msg"></div>
<div class="footer">
	&copy; 2018 教学资源预定系统
</div>

</body>

<script type="text/javascript">

$("#btn1").click(function(){
		$("#privilegeMark").val("0");
	});
$("#btn2").click(function(){
		$("#privilegeMark").val("1");
	});

</script>




</html>