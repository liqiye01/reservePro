<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教室预定</title>

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
.container{
	width: 98%;
	height: 480px;
	border: 1px solid rgba(0,0,0,0.4);
	margin-top: 10px;
	padding: 0;
	
}
#returnBtn{
	text-align:center;
	font-size:23px;
	font-weight:35px;
	line-height:35px;
	font-family:monospace;
	font-weight:bolder;
	color:white;
	width:100%;
	height:100%;
	background-color:#8EE5EE;
	cursor:pointer;
	margin: 0;
}
#returnBtn:HOVER{
	background-color:#97FFFF;
}
#reserveBtn{
	text-align:center;
	font-size:23px;
	font-weight:35px;
	line-height:35px;
	font-family:monospace;
	font-weight:bolder;
	color:white;
	width:100%;
	height:100%;
	background-color:#4EEE94;
	cursor:pointer;
	margin: 0;
}
#reserveBtn:HOVER{
	background-color:#54FF9F;
}
.table{
	border-collapse:collapse;
}
.table-bordered{
	width: 100%;
	height: 100%;
	text-align: center;
	font-size:14px;
	font-weight:30px;
	line-height:24px;
	font-family:monospace;
	line-height:20px;
	margin: 0;
	left: 0;
}
.textSize{
	text-align: center;
	font-family:monospace;
	font-weight:bolder;
	font-size:40px;
	margin-top: 30px;
}
.todayDateText{
	position: absolute;
	top: 62px;
	right: 24px;
	color: #A52A2A;
	font-size: 13px;
	font-weight: bold;
}
.today{
	position: absolute;
	top: 62px;
	right: 98px;
	font-size: 14px;
	font-weight: bolder;
}
.dateText{
	color: #A52A2A;
	font-size: 14px;
	font-weight: bolder;
}

</style>	
<script type="text/javascript">
$(document).ready(function(){
	
	$("input[type=checkbox]").click(function(){
		if($("input[type='checkbox']:checked").length>3){
			alert("最多预定三个时间段");
			$(this).attr("checked", false);
		}
	});
	
	$("#reserveBtn").click(function(){
		if($("input[type='checkbox']:checked").length==0){
			alert("请至少选择一个时间段");
			return false;
		}
	});
	
	if(${reserveFlag=='1'}){
	alert("已成功预订");
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
	               	$("span a").attr("data-content",msg);
               },
               error:function(){
               	console.log("失败");
               }
			});
	}

</script>


</head>
<body>
<c:if test="${empty laboratoryFlag}">
	<form action="${APP_PATH}/classroom/submitReserve" >
</c:if>
<c:if test="${laboratoryFlag=='1'}">
	<form action="${APP_PATH}/laboratory/submitReserve" >
</c:if>
<div class="container">
	<table class="table-bordered">
		<input type="hidden" name="id" value="${timeArrange.id}"/>
		<input type="hidden" name="classroomId" value="${classroom.id}"/>
		<input type="hidden" name="resourceType" value="1"/>
		<input type="hidden" name="buildingNum" value="${classroom.buildingNum }"/>
		<input type="hidden" name="roomNum" value="${classroom.roomNum }"/>
		<tr class="info" height="13%">
			<td ><a href="javascript:history.go(-1)"><button id="returnBtn" type="button"><span class="glyphicon glyphicon-share-alt"></span> 返回</br>&nbsp 列表</button></a></td>
			<td ><a href="#" onClick="return confirm('确定提交预定选中的时间段吗?');"><button id="reserveBtn" type="submit"><span class="glyphicon glyphicon-tag"></span> 提交</br>&nbsp 预定</button></a></td>
			<td colspan="6" >
				<c:if test="${empty laboratoryFlag}">
					<span class="textSize">${classroom.buildingNum }教${classroom.roomNum }</span>
				</c:if>
				<c:if test="${laboratoryFlag=='1'}">
					<span class="textSize">${classroom.buildingNum }实${classroom.roomNum }</span>
				</c:if>
				<span class="today">今天:</span><span class="todayDateText">${todayDate}</span>
			</td>
		</tr>
		<tr height="13%">
			<td width="12.5%">日期</td>
			<td width="12.5%" class="dateText">
				<input type="hidden" name="MonDate" value="${MonDate}"/>${MonDate}
			</td>
			<td width="12.5%" class="dateText">
				<input type="hidden" name="TueDate" value="${TueDate}"/>${TueDate}
			</td>
			<td width="12.5%" class="dateText">
				<input type="hidden" name="WenDate" value="${WenDate}"/>${WenDate}
			</td>
			<td width="12.5%" class="dateText">
				<input type="hidden" name="ThuDate" value="${ThuDate}"/>${ThuDate}
			</td>
			<td width="12.5%" class="dateText">
				<input type="hidden" name="FriDate" value="${FriDate}"/>${FriDate}
			</td>
			<td width="12.5%" class="dateText">
				<input type="hidden" name="SatDate" value="${SatDate}"/>${SatDate}
			</td>
			<td width="12.5%" class="dateText">
				<input type="hidden" name="SunDate" value="${SunDate}"/>${SunDate}
			</td>
		</tr>
		<tr height="13%">
			<td width="12.5%">星期</td>
			<td width="12.5%">星期一</td>
			<td width="12.5%">星期二</td>
			<td width="12.5%">星期三</td>
			<td width="12.5%">星期四</td>
			<td width="12.5%">星期五</td>
			<td width="12.5%">星期六</td>
			<td width="12.5%">星期日</td>
		</tr>
		<tr height="13%">
			<td >早上</td>
			<td onmouseover="getUserMsg(${predictPerson.monMorning});">
				<c:if test="${timeArrange.monMorning =='1'}">
					已有课程安排
				</c:if>
				<c:if test="${timeArrange.monMorning =='2'}">
					<input type="checkbox" id="monMorning" name="monMorning" value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.monMorning =='3'}">
					<input type="checkbox" id="monMorning" name="monMorning"  value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.monMorning =='4'}">
					<span style="color: #FF34B3">已被预订</span></br>	
					预订者：
					<span><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="right" title="预定者信息" data-content="">${predictPerson.monMorning}</a></sapn>
				</c:if>
			</td>
			<td onmouseover="getUserMsg(${predictPerson.tueMorning });">
				<c:if test="${timeArrange.tueMorning =='1'}">
					已有课程安排
				</c:if>
				<c:if test="${timeArrange.tueMorning =='2'}">
					<input type="checkbox" id="tueMorning" name="tueMorning" value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.tueMorning =='3'}">
					<input type="checkbox" id="tueMorning" name="tueMorning"  value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.tueMorning =='4'}">
					<span style="color: #FF34B3">已被预订</span></br>	
					预订者：
					<span><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="right" title="预定者信息" data-content="">${predictPerson.tueMorning }</a></span>
				</c:if>
			</td>
			<td onmouseover="getUserMsg(${predictPerson.wedMorning });">
				<c:if test="${timeArrange.wedMorning =='1'}">
					已有课程安排
				</c:if>
				<c:if test="${timeArrange.wedMorning =='2'}">
					<input type="checkbox" id="wedMorning" name="wedMorning" value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.wedMorning =='3'}">
					<input type="checkbox" id="wedMorning" name="wedMorning"  value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.wedMorning =='4'}">
					<span style="color: #FF34B3">已被预订</span></br>	
					预订者：
					<span><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="right" title="预定者信息" data-content="">${predictPerson.wedMorning }</a></span>
				</c:if>
			</td>
			<td onmouseover="getUserMsg(${predictPerson.thuMorning});">
				<c:if test="${timeArrange.thuMorning =='1'}">
					已有课程安排
				</c:if>
				<c:if test="${timeArrange.thuMorning =='2'}">
					<input type="checkbox" id="thuMorning" name="thuMorning" value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.thuMorning =='3'}">
					<input type="checkbox" id="thuMorning" name="thuMorning"  value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.thuMorning =='4'}">
					<span style="color: #FF34B3">已被预订</span></br>	
					预订者：
					<span><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="right" title="预定者信息" data-content="">${predictPerson.thuMorning }</a></span>
				</c:if>
			</td>
			<td onmouseover="getUserMsg(${predictPerson.friMorning });">
				<c:if test="${timeArrange.friMorning =='1'}">
					已有课程安排
				</c:if>
				<c:if test="${timeArrange.friMorning =='2'}">
					<input type="checkbox" id="friMorning" name="friMorning" value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.friMorning =='3'}">
					<input type="checkbox" id="friMorning" name="friMorning"  value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.friMorning =='4'}">
					<span style="color: #FF34B3">已被预订</span></br>	
					预订者：
					<span><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="right" title="预定者信息" data-content="">${predictPerson.friMorning }</a></span>
				</c:if>
			</td>
			<td onmouseover="getUserMsg(${predictPerson.satMorning });">
				<c:if test="${timeArrange.satMorning =='1'}">
					已有课程安排
				</c:if>
				<c:if test="${timeArrange.satMorning =='2'}">
					<input type="checkbox" id="satMorning" name="satMorning" value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.satMorning =='3'}">
					<input type="checkbox" id="satMorning" name="satMorning"  value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.satMorning =='4'}">
					<span style="color: #FF34B3">已被预订</span></br>	
					预订者：
					<span><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="right" title="预定者信息" data-content="">${predictPerson.satMorning }</a></span>
				</c:if>
			</td>
			<td onmouseover="getUserMsg(${predictPerson.sunMorning });">
				<c:if test="${timeArrange.sunMorning =='1'}">
					已有课程安排
				</c:if>
				<c:if test="${timeArrange.sunMorning =='2'}">
					<input type="checkbox" id="sunMorning" name="sunMorning" value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.sunMorning =='3'}">
					<input type="checkbox" id="sunMorning" name="sunMorning"  value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.sunMorning =='4'}">
					<span style="color: #FF34B3">已被预订</span></br>	
					预订者：
					<span><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="left" title="预定者信息" data-content="">${predictPerson.sunMorning }</a></span>
				</c:if>
			</td>
		</tr>
		<tr height="13%">
			<td >下午</td>
			<td onmouseover="getUserMsg(${predictPerson.monAfternoon });">	
				<c:if test="${timeArrange.monAfternoon =='1'}">
					已有课程安排
				</c:if>
				<c:if test="${timeArrange.monAfternoon =='2'}">
					<input type="checkbox" id="monAfternoon" name="monAfternoon" value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.monAfternoon =='3'}">
					<input type="checkbox" id="monAfternoon" name="monAfternoon"  value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.monAfternoon =='4'}">
					<span style="color: #FF34B3">已被预订</span></br>	
					预订者：
					<span><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="right" title="预定者信息" data-content="">${predictPerson.monAfternoon }</a></span>
				</c:if>
			</td>
			<td onmouseover="getUserMsg(${predictPerson.tueAfternoon });">
				<c:if test="${timeArrange.tueAfternoon =='1'}">
					已有课程安排
				</c:if>
				<c:if test="${timeArrange.tueAfternoon =='2'}">
					<input type="checkbox" id="tueAfternoon" name="tueAfternoon" value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.tueAfternoon =='3'}">
					<input type="checkbox" id="tueAfternoon" name="tueAfternoon"  value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.tueAfternoon =='4'}">
					<span style="color: #FF34B3">已被预订</span></br>	
					预订者：
					<span><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="right" title="预定者信息" data-content="">${predictPerson.tueAfternoon }</a></span>
				</c:if>
			</td>
			<td onmouseover="getUserMsg(${predictPerson.wedAfternoon });">
				<c:if test="${timeArrange.wedAfternoon =='1'}">
					已有课程安排
				</c:if>
				<c:if test="${timeArrange.wedAfternoon =='2'}">
					<input type="checkbox" id="wedAfternoon" name="wedAfternoon" value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.wedAfternoon =='3'}">
					<input type="checkbox" id="wedAfternoon" name="wedAfternoon"  value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.wedAfternoon =='4'}">
					<span style="color: #FF34B3">已被预订</span></br>	
					预订者：
					<span><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="right" title="预定者信息" data-content="">${predictPerson.wedAfternoon }</a></span>
				</c:if>
			</td>
			<td onmouseover="getUserMsg(${predictPerson.thuAfternoon });">
				<c:if test="${timeArrange.thuAfternoon =='1'}">
					已有课程安排
				</c:if>
				<c:if test="${timeArrange.thuAfternoon =='2'}">
					<input type="checkbox" id="thuAfternoon" name="thuAfternoon" value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.thuAfternoon =='3'}">
					<input type="checkbox" id="thuAfternoon" name="thuAfternoon"  value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.thuAfternoon =='4'}">
					<span style="color: #FF34B3">已被预订</span></br>	
					预订者：
					<span><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="right" title="预定者信息" data-content="">${predictPerson.thuAfternoon }</a></span>
				</c:if>
			</td>
			<td onmouseover="getUserMsg(${predictPerson.friAfternoon });">
				<c:if test="${timeArrange.friAfternoon =='1'}">
					已有课程安排
				</c:if>
				<c:if test="${timeArrange.friAfternoon =='2'}">
					<input type="checkbox" id="friAfternoon" name="friAfternoon" value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.friAfternoon =='3'}">
					<input type="checkbox" id="friAfternoon" name="friAfternoon"  value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.friAfternoon =='4'}">
					<span style="color: #FF34B3">已被预订</span></br>	
					预订者：
					<span><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="right" title="预定者信息" data-content="">${predictPerson.friAfternoon }</a></span>
				</c:if>
			</td>
			<td onmouseover="getUserMsg(${predictPerson.satAfternoon });">
				<c:if test="${timeArrange.satAfternoon =='1'}">
					已有课程安排
				</c:if>
				<c:if test="${timeArrange.satAfternoon =='2'}">
					<input type="checkbox" id="satAfternoon" name="satAfternoon" value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.satAfternoon =='3'}">
					<input type="checkbox" id="satAfternoon" name="satAfternoon"  value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.satAfternoon =='4'}">
					<span style="color: #FF34B3">已被预订</span></br>	
					预订者：
					<span><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="right" title="预定者信息" data-content="">${predictPerson.satAfternoon }</a></span>
				</c:if>
			</td>
			<td onmouseover="getUserMsg(${predictPerson.sunAfternoon });">
				<c:if test="${timeArrange.sunAfternoon =='1'}">
					已有课程安排
				</c:if>
				<c:if test="${timeArrange.sunAfternoon =='2'}">
					<input type="checkbox" id="sunAfternoon" name="sunAfternoon" value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.sunAfternoon =='3'}">
					<input type="checkbox" id="sunAfternoon" name="sunAfternoon"  value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.sunAfternoon =='4'}">
					<span style="color: #FF34B3">已被预订</span></br>	
					预订者：
					<span><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="left" title="预定者信息" data-content="">${predictPerson.sunAfternoon }</a></span>
				</c:if>
			</td>
		</tr>
		<tr height="13%">
			<td >晚上</td>
			<td onmouseover="getUserMsg(${predictPerson.monEvening });">
				<c:if test="${timeArrange.monEvening =='1'}">
					已有课程安排
				</c:if>
				<c:if test="${timeArrange.monEvening =='2'}">
					<input type="checkbox" id="monEvening" name="monEvening" value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.monEvening =='3'}">
					<input type="checkbox" id="monEvening" name="monEvening"  value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.monEvening =='4'}">
					<span style="color: #FF34B3">已被预订</span></br>	
					预订者：
					<span><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="right" title="预定者信息" data-content="">${predictPerson.monEvening }</a></span>
				</c:if>
			</td>
			<td onmouseover="getUserMsg(${predictPerson.tueEvening });">
				<c:if test="${timeArrange.tueEvening =='1'}">
					已有课程安排
				</c:if>
				<c:if test="${timeArrange.tueEvening =='2'}">
					<input type="checkbox" id="tueEvening" name="tueEvening" value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.tueEvening =='3'}">
					<input type="checkbox" id="tueEvening" name="tueEvening"  value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.tueEvening =='4'}">
					<span style="color: #FF34B3">已被预订</span></br>	
					预订者：
					<span><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="right" title="预定者信息" data-content="">${predictPerson.tueEvening }</a></span>
				</c:if>
			</td>
			<td onmouseover="getUserMsg(${predictPerson.wedEvening });">
				<c:if test="${timeArrange.wedEvening =='1'}">
					已有课程安排
				</c:if>
				<c:if test="${timeArrange.wedEvening =='2'}">
					<input type="checkbox" id="wedEvening" name="wedEvening" value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.wedEvening =='3'}">
					<input type="checkbox" id="wedEvening" name="wedEvening"  value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.wedEvening =='4'}">
					<span style="color: #FF34B3">已被预订</span></br>	
					预订者：
					<span><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="right" title="预定者信息" data-content="">${predictPerson.wedEvening }</a></span>
				</c:if>
			</td>
			<td onmouseover="getUserMsg(${predictPerson.thuEvening });">
				<c:if test="${timeArrange.thuEvening =='1'}">
					已有课程安排
				</c:if>
				<c:if test="${timeArrange.thuEvening =='2'}">
					<input type="checkbox" id="thuEvening" name="thuEvening" value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.thuEvening =='3'}">
					<input type="checkbox" id="thuEvening" name="thuEvening"  value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.thuEvening =='4'}">
					<span style="color: #FF34B3">已被预订</span></br>	
					预订者：
					<span><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="right" title="预定者信息" data-content="">${predictPerson.thuEvening }</a></span>
				</c:if>
			</td>
			<td onmouseover="getUserMsg(${predictPerson.friEvening });">
				<c:if test="${timeArrange.friEvening =='1'}">
					已有课程安排
				</c:if>
				<c:if test="${timeArrange.friEvening =='2'}">
					<input type="checkbox" id="friEvening" name="friEvening" value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.friEvening =='3'}">
					<input type="checkbox" id="friEvening" name="friEvening"  value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.friEvening =='4'}">
					<span style="color: #FF34B3">已被预订</span></br>	
					预订者：
					<span><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="right" title="预定者信息" data-content="">${predictPerson.friEvening }</a></span>
				</c:if>
			</td>
			<td onmouseover="getUserMsg(${predictPerson.satEvening });">
				<c:if test="${timeArrange.satEvening =='1'}">
					已有课程安排
				</c:if>
				<c:if test="${timeArrange.satEvening =='2'}">
					<input type="checkbox" id="satEvening" name="satEvening" value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.satEvening =='3'}">
					<input type="checkbox" id="satEvening" name="satEvening"  value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.satEvening =='4'}">
					<span style="color: #FF34B3">已被预订</span></br>	
					预订者：
					<span><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="right" title="预定者信息" data-content="">${predictPerson.satEvening }</a></span>
				</c:if>
			</td>
			<td onmouseover="getUserMsg(${predictPerson.sunEvening });">
				<c:if test="${timeArrange.sunEvening =='1'}">
					已有课程安排
				</c:if>
				<c:if test="${timeArrange.sunEvening =='2'}">
					<input type="checkbox" id="sunEvening" name="sunEvening" value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.sunEvening =='3'}">
					<input type="checkbox" id="sunEvening" name=sunEvening  value="yes" style="width:40px;height:40px;">
				</c:if>
				<c:if test="${timeArrange.sunEvening =='4'}">
					<span style="color: #FF34B3">已被预订</span></br>	
					预订者：
					<span><a style="cursor: pointer;"    title="预定者信息"     data-toggle="popover" data-trigger="hover" 
	 					data-placement="left" title="预定者信息" data-content="">${predictPerson.sunEvening }</a></span>
				</c:if>
			</td>
		</tr>
		<tr >
			<td>预定理由</td>
			<td colspan="7"><textarea name="predictReason" style="width: 99%;height: 90%;margin: 5px;"></textarea></td>
		</tr>
	</table>
</div>
</form>
</body>
</html>