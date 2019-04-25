<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资源分配</title>

<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="//apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<% 
	pageContext.setAttribute("APP_PATH",request.getContextPath());
%>

<style type="text/css">
a{
	color: #63B8FF;
}
#content{	
	margin: 5px;
}
.navbar-nav > li > a {
    font-size: 18px;
    text-align:  center;
}
.navbar-nav > li{
	width: 130px;
}
.nav-tabs > li > a{
	font-size: 18px;
}
.table-bordered{
	margin-top: 0;
}
.navbar{
	margin-top: 1px;
	margin-bottom: 1px;
}
.table > thead >tr{
	height: 47px;
	font-size: 17px;
	font-weight: 500;
	background-color: #EBEBEB;
}
.table > tbody >tr{
	color: #454545;
}
.nav-tabs>li>a:HOVER {
	cursor: pointer;
}
.navbar-nav>li>a:HOVER {
	cursor: pointer;
}




</style>
<script type="text/javascript">


	$(document).ready(function(){
		if(${type}=='1'){
			$("#laboratory").removeClass("active");
			$("#sport").removeClass("active");
			$("#meeting").removeClass("active");
			$("#classroom").addClass("active");
		}
		if(${type}=='2'){
			$("#classroom").removeClass("active");
			$("#sport").removeClass("active");
			$("#meeting").removeClass("active");
			$("#laboratory").addClass("active");
		}
		if(${type}=='3'){
			$("#laboratory").removeClass("active");
			$("#classroom").removeClass("active");
			$("#meeting").removeClass("active");
			$("#sport").addClass("active");
		}
		if(${type}=='4'){
			$("#laboratory").removeClass("active");
			$("#classroom").removeClass("active");
			$("#sport").removeClass("active");
			$("#meeting").addClass("active");
		}
		if(${state}=='1'){
			$("#wait").addClass("active");
			$("#reject").removeClass("active");
			$("#already").removeClass("active");
		}
		if(${state}=='2'){
			$("#already").addClass("active");
			$("#reject").removeClass("active");
			$("#wait").removeClass("active");
		}
		if(${state}=='3'){
			$("#reject").addClass("active");
			$("#wait").removeClass("active");
			$("#already").removeClass("active");
		}
		
		$('[data-toggle="popover"]').popover({html : true});
		
	
	
});

function getUserMsg(username){
		$.ajax({
				type: "get",
           		url: "${APP_PATH}/distribution/getUserMsg",
           		/* dataType:"json", */
                data:{"username":username},
                success:function(data){
                	var jsonData = JSON.parse(data);   //转成对象 ，记得json的key和value都要是"",不能是''
                	//alert("成功"+jsonData.username);
                	var gender = jsonData.gender==1?'男':'女';
                	var msg=jsonData.level+'届</br>姓名: '+jsonData.tureName+'</br>学号: '+jsonData.username+'</br>专业: '
                		+jsonData.major+'</br>班级: '+jsonData.classnum+'</br>性别: '+gender ;
                	$("p a").attr("data-content",msg);
                },
                error:function(){
                	console.log("失败");
                }
			});
}


</script>

</head>
<body>
<div id="content">
	<ul class="nav nav-tabs">
		<li class="active" data-toggle="tab" id="classroom"><a  onclick="javascript:window.location.href='${APP_PATH}/distribution/resource?type=1&state=1'">教室</a></li>
		<li data-toggle="tab" id="laboratory"><a  onclick="javascript:window.location.href='${APP_PATH}/distribution/resource?type=2&state=1'">实验室</a></li>
		<li data-toggle="tab" id="sport"><a  onclick="javascript:window.location.href='${APP_PATH}/distribution/resource?type=3&state=1'">体育场地</a></li>
		<li data-toggle="tab" id="meeting"><a  onclick="javascript:window.location.href='${APP_PATH}/distribution/resource?type=4&state=1'">会议室</a></li>
	</ul>
	<nav class="navbar navbar-default navbar-static-top">
	  	<ul class="nav navbar-nav">
		    <li class="active" data-toggle="tab" id="wait"><a onclick="javascript:window.location.href='${APP_PATH}/distribution/resource?type=${type}&state=1'">待批准</a></li>
		    <li data-toggle="tab" id="reject"><a onclick="javascript:window.location.href='${APP_PATH}/distribution/resource?type=${type}&state=3'">已驳回</a></li>
		    <li data-toggle="tab" id="already"><a onclick="javascript:window.location.href='${APP_PATH}/distribution/resource?type=${type}&state=2'">已批准</a></li>
	    </ul>
	</nav>
	<div>
		<table class="table table-bordered">
			<thead>
	 			<tr>
	 				<td>资源名称</td>
	 				<td>预订者</td>
	 				<td>时间段</td>
	 				<td>开始时间</td>
	 				<td>结束时间</td>
	 				<td>预定理由</td>
	 				<td>状态</td>
	 				<td>操作 <span class="glyphicon glyphicon-hand-up" ></span></td>
	 			</tr>
 			</thead>
 			<tbody>
 			<c:forEach items="${list}" var="predict">
 				<tr onmouseover="getUserMsg(${predict.predictPerson});">
	 				<td width="8%">${predict.resourceName}</td>
	 				<td width="8%"><p><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="right" title="预定者信息" data-content="">${predict.predictPerson}</a></p>
	 				</td>	
	 				<td width="8%">
	 					<c:if test="${predict.predictTime=='monMorning'}">
	 						星期一早上
	 					</c:if>
	 					<c:if test="${predict.predictTime=='monAfternoon'}">
	 						星期一下午
	 					</c:if>
	 					<c:if test="${predict.predictTime=='monEvening'}">
	 						星期一晚上
	 					</c:if>
	 					<c:if test="${predict.predictTime=='tueMorning'}">
	 						星期二早上
	 					</c:if>
	 					<c:if test="${predict.predictTime=='tueAfternoon'}">
	 						星期二下午
	 					</c:if>
	 					<c:if test="${predict.predictTime=='tueEvening'}">
	 						星期二晚上
	 					</c:if>
	 					<c:if test="${predict.predictTime=='wedMorning'}">
	 						星期三早上
	 					</c:if>
	 					<c:if test="${predict.predictTime=='wedAfternoon'}">
	 						星期三下午
	 					</c:if>
	 					<c:if test="${predict.predictTime=='wedEvening'}">
	 						星期三晚上
	 					</c:if>
	 					<c:if test="${predict.predictTime=='thuMorning'}">
	 						星期四早上
	 					</c:if>
	 					<c:if test="${predict.predictTime=='thuAfternoon'}">
	 						星期四下午
	 					</c:if>
	 					<c:if test="${predict.predictTime=='thuEvening'}">
	 						星期四晚上
	 					</c:if>
	 					<c:if test="${predict.predictTime=='friMorning'}">
	 						星期五早上
	 					</c:if>
	 					<c:if test="${predict.predictTime=='friAfternoon'}">
	 						星期五下午
	 					</c:if>
	 					<c:if test="${predict.predictTime=='friEvening'}">
	 						星期五晚上
	 					</c:if>
	 					<c:if test="${predict.predictTime=='satMorning'}">
	 						星期六早上
	 					</c:if>
	 					<c:if test="${predict.predictTime=='satAfternoon'}">
	 						星期六下午
	 					</c:if>
	 					<c:if test="${predict.predictTime=='satEvening'}">
	 						星期六晚上
	 					</c:if>
	 					<c:if test="${predict.predictTime=='sunMorning'}">
	 						星期日早上
	 					</c:if>
	 					<c:if test="${predict.predictTime=='sunAfternoon'}">
	 						星期日下午
	 					</c:if>
	 					<c:if test="${predict.predictTime=='sunEvening'}">
	 						星期日晚上
	 					</c:if>
	 				</td>
	 				<td width="12%"><fmt:formatDate value="${predict.beginTime}" pattern="yyyy-MM-dd HH:mm" /></td>
	 				<td width="12%"><fmt:formatDate value="${predict.endTime}" pattern="yyyy-MM-dd HH:mm" /></td>
	 				<td>${predict.predictReason}</td>
	 				<td width="10%">
	 					<c:if test="${predict.predictState=='1'}">
	 						待批准
	 					</c:if>
	 					<c:if test="${predict.predictState=='2'}">
	 						已批准
	 					</c:if>
	 					<c:if test="${predict.predictState=='3'}">
	 						被驳回
	 					</c:if>
	 				</td>
	 				<td width="10%">
	 					<c:if test="${state=='1'}">
		 					<a href="${APP_PATH}/distribution/approval?type=${type}&id=${predict.id}"><span style="color: green;">批准</span></a>&nbsp
		 					<a href="${APP_PATH}/distribution/reject?type=${type}&id=${predict.id}"><span style="color: #A52A2A;">驳回</span></a>
		 				</c:if>
		 				<c:if test="${state=='2'}">
		 					<a href="${APP_PATH}/distribution/revokeApproval?type=${type}&id=${predict.id}"><span style="color: #5CACEE;">撤销</span></a>&nbsp
		 				</c:if>
		 				<c:if test="${state=='3'}">
		 					<a href="${APP_PATH}/distribution/revokeReject?type=${type}&id=${predict.id}"><span style="color: #5CACEE;">撤销</span></a>&nbsp
		 				</c:if>
	 				</td>
	 			</tr>
 			</c:forEach>
 			</tbody>
		</table>
	
	</div>
	

</div>



</body>
</html>