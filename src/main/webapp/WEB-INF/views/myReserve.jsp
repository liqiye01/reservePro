<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的预定列表</title>

<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="//apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


<% 
	pageContext.setAttribute("APP_PATH",request.getContextPath());
%>

<style type="text/css">
#content{
	margin: 6px;
}
a{
	color: #63B8FF;
}
.table-hover{
	text-align: center;
}
.nav-tabs > li > a{
	font-size: 18px;
}
.select{
	margin: 10px 10px;
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


</style>
<script type="text/javascript">
$(document).ready(function(){
		if(${predictState=='1'}){
			$("#pState1").attr("selected","selected");
		}
		if(${predictState=='2'}){
			$("#pState2").attr("selected","selected");
		}
		if(${predictState=='3'}){
			$("#pState3").attr("selected","selected");
		}

});

</script>

</head>
<body>
<div id="content">
	<ul class="nav nav-tabs">
	  <li role="presentation" class="active"><a href="${APP_PATH}/view/myReserve">我的预定列表</a></li>
	</ul>
	<div class="select" style="margin-bottom: 10px;">
		<form action="${APP_PATH}/view/myReserve" >
			<select  name="predictState" class="selectStyle" style="margin-bottom: 10px;margin-left: 15px;">
				<option  value="">请选择预定状态</option>
				<option id="pState1" value="1">待批准</option>
				<option id="pState2" value="2">已批准</option>
				<option id="pState3" value="3">已驳回</option>
			</select>
			<button class="btn btn-info" type="submit" style="float: left;margin-bottom: 10px;">查询</button>
		</form> 
	</div>
	<div>
		<table class="table table-hover">
			<thead>
				<tr class="info" style="font-weight: bolder;">
					<td>资源类型</td>
					<td>资源名</td>
					<td>预定时间</td>
					<td>状态</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="predict">
			    <tr>
			    	<td>
			    		<c:if test="${predict.resourceType=='1'}">教学楼</c:if>
			    		<c:if test="${predict.resourceType=='2'}">实验楼</c:if>
			    		<c:if test="${predict.resourceType=='3'}">体育场地</c:if>
			    		<c:if test="${predict.resourceType=='4'}">会议室</c:if>
			    	</td>
			    	<td>${predict.resourceName}</td>
			    	<td>${predict.predictTime}</td>
			    	<td>
			    		<c:if test="${predict.predictState=='1'}">待批准</c:if>
			    		<c:if test="${predict.predictState=='2'}"><span style="color: #90EE90">已批准</span></c:if>
			    		<c:if test="${predict.predictState=='3'}"><span style="color: red">已驳回</span></c:if>
			    	</td>
			    </tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	
</div>
</body>
</html>