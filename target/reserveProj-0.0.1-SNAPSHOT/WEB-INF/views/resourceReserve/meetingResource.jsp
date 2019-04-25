<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会议室资源</title>


<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="//apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<% 
	pageContext.setAttribute("APP_PATH",request.getContextPath());
%>


<style type="text/css">
#box{
	width: 400px;
	height: 300px;
	background-color: #EEE9E9;
	position: absolute;
	top: 50%;
	right: 50%;
	margin-top: -150px;
	margin-right: -100px;
}
#box2{
	width: 400px;
	height: 300px;
	background-color: #FFC0CB;
	position: absolute;
	top: 50%;
	right: 50%;
	margin-top: -150px;
	margin-right: -100px;
}
#box3{
	width: 400px;
	height: 300px;
	background-color: #FFC0CB;
	position: absolute;
	top: 50%;
	right: 50%;
	margin-top: -150px;
	margin-right: -100px;
}
.colseBtn{
	position:absolute;
	right:10px;
	top: 0;
}
.text1{
	text-align: center;
	margin-top: 60px;
	color: #66CD00;
	font-weight: bolder;
}
.text2{
	color: #607B8B;
	margin: 35px 10px 0 100px;
	font-size: 18px;
	line-height: 40px;
}

table>thead>tr,table>tbody>tr{
	text-align: center;
	line-height:35px;
	height: 35px;
}

a,a:visited,a:hover,a:active,a:link{
	text-decoration:none;
}

a:HOVER{
	color: #0000EE;
}

.nav-tabs > li > a{
	font-size: 18px;
}
table>thead>tr,table>tbody>tr{
	text-align: center;
}
table>thead>tr{
	font-weight: bold;
}
#content{
	margin: 6px 6px 0 6px;
}
a{
	color: #63B8FF;
}

</style>
<script type="text/javascript">

	$(document).ready(function(){
		
		if(${areaNum=='1'}){
			$("#west").removeClass("active");
			$("#east").removeClass("active");
			$("#center").addClass("active");
		}
		if(${areaNum=='2'}){
			$("#east").removeClass("active");
			$("#center").removeClass("active");
			$("#west").addClass("active");
		}
		if(${areaNum=='3'}){
			$("#west").removeClass("active");
			$("#center").removeClass("active");
			$("#east").addClass("active");
		}
		
		$("table").css("margin","0");
		
		if(${reserveFlag=='1'}){
			setTimeout(function(){$("#box").fadeToggle("slow");}, 0);
				$("#closeBtn").click(function() {
					$("#box").fadeToggle();
			});
		}
		
		if(${alreadyReserveFlag=='1'}){
			setTimeout(function(){$("#box2").fadeToggle("slow");}, 0);
				$("#closeBtn2").click(function() {
					$("#box2").fadeToggle();
			});
		}
		
		if(${banFlag=='1'}){
			setTimeout(function(){$("#box3").fadeToggle("slow");}, 0);
				$("#closeBtn3").click(function() {
					$("#box3").fadeToggle();
			});
		}
		
		setTimeout(function(){ $("#box").fadeOut(); }, 5000);
		
		setTimeout(function(){ $("#box2").fadeOut(); }, 5000);
		
		});
	
	
	
</script>

</head>
<body>
<!-- 预定权利被禁止弹窗 -->
<div id="box3" style="display: none">
	<div id="content">
		
		<div >
  			<h1 class="text1" >很抱歉！</h1>
  			<p class="text2">您的预定权利已被禁用！</br>请及时联系管理员</p>
		</div>
		
		<span class="colseBtn" style="cursor:pointer;"><a  id="closeBtn3" >
			<span class="glyphicon glyphicon-remove" style="font-size:25px;margin-top: 10px"></span>
		</a></span>
	</div>
</div>

<!-- 预定提交成功弹窗 -->
<div id="box" style="display: none">
	<div id="content">
		
		<div >
  			<h1 class="text1" >提交成功！</h1>
  			<p class="text2">资源预定:<strong>${resourceName}</strong></br>请耐心等待管理通过...</p>
		</div>
		
		<span class="colseBtn" style="cursor:pointer;"><a  id="closeBtn" >
			<span class="glyphicon glyphicon-remove" style="font-size:25px;margin-top: 10px"></span>
		</a></span>
	</div>
</div>

<!-- 已预定弹窗 -->
<div id="box2" style="display: none">
	<div id="content">
		
		<div >
  			<h1 class="text1" >请不要重复预定！</h1>
  			<p class="text2">资源:<strong>${resourceName} ${predictTime}</strong></br>请耐心等待管理通过...</p>
		</div>
		
		<span class="colseBtn" style="cursor:pointer;"><a  id="closeBtn2" >
			<span class="glyphicon glyphicon-remove" style="font-size:25px;margin-top: 10px"></span>
		</a></span>
	</div>
</div>

	<div id="content" class="">
		<ul class="nav nav-tabs">
			<li class="active" data-toggle="tab" id="east"><a  onclick="javascript:window.location.href='${APP_PATH}/meeting/resource?areaNum=3'">东区</a></li>
			<li data-toggle="tab" id="west"><a  onclick="javascript:window.location.href='${APP_PATH}/meeting/resource?areaNum=2'">西区</a></li>
			<li data-toggle="tab" id="center"><a  onclick="javascript:window.location.href='${APP_PATH}/meeting/resource?areaNum=1'">中区</a></li>
		</ul>

		<table class="table table-hover table-condensed">
			<thead style="width: 100%">
				<tr class="info">
					<td >楼号</td>
					<td >房号</td>
					<td >最大人数</td>
					<td >操作</td>
				</tr>
			</thead>
			<tbody style="width: 100%">
				<c:forEach items="${list}" var="meeting">
					<tr>
						<td>${meeting.buildingNum }教</td>
						<td>${meeting.roomNum }</td>
						<td>${meeting.maxPopulation }人</td>
						<td>
							<a><a href="reserve?id=${meeting.id}&areaNum=${areaNum}">预定详情 <span class="glyphicon glyphicon-hand-up"></span></a></a>
						</td>
					</tr>
				</c:forEach>			
			</tbody>
			
			
		</table>
	</div>
</body>
</html>