<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教室资源</title>


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

.main
{
	padding:7px 0 3px 0;
	background-color:while;
	border:solid 1px #c3c3c3;
	margin: 0 auto;
}

.next
{
	display:none;
	padding:0 10px;
}
.main:HOVER{
	background-color:#F8F8FF
}

</style>
<script type="text/javascript">

	$(document).ready(function(){
		
		if(${areaNum}=='3'){
			$("#east").addClass("active");
			$("#center").removeClass("active");
			$("#west").removeClass("active");
		}
		if(${areaNum}=='2'){
			$("#west").addClass("active");
			$("#center").removeClass("active");
			$("#east").removeClass("active");
		}
		if(${areaNum}=='1'){
			$("#center").addClass("active");
			$("#east").removeClass("active");
			$("#west").removeClass("active");
		}
		
		
		$(".main").click(function() {
			$(this).next().slideToggle("slow");
			$(this).next().siblings(".next").slideUp("slow");
			if($(this).children("table").children("thead").children("tr").children("td").eq(2).children("span").hasClass("glyphicon-chevron-right")){
				$(".glyphicon-chevron-down").addClass("glyphicon-chevron-right");
				$(".glyphicon-chevron-down").removeClass("glyphicon-chevron-down");
				$(this).children("table").children("thead").children("tr").children("td").eq(2).children("span").removeClass("glyphicon-chevron-right");
				$(this).children("table").children("thead").children("tr").children("td").eq(2).children("span").addClass("glyphicon-chevron-down");
			}else{
				$(this).children("table").children("thead").children("tr").children("td").eq(2).children("span").removeClass("glyphicon-chevron-down");
				$(this).children("table").children("thead").children("tr").children("td").eq(2).children("span").addClass("glyphicon-chevron-right");
			}
		});
		$("table").css("margin","0");
		
		$(".main").hover(function() {
			$(this).children("table").children("thead").children("tr").children("td").eq(1).html("<span style='color:gray'>点击展开 / 收起</span>");
			}, function() {
				$(this).children("table").children("thead").children("tr").children("td").eq(1).html("");
			});

	});
	
	
	
</script>

</head>
<body>
	<div id="content" class="">
		<ul class="nav nav-tabs">
			<li class="active" data-toggle="tab" id="east"><a  onclick="javascript:window.location.href='${APP_PATH}/classroom/resource?areaNum=3'">东区</a></li>
			<li data-toggle="tab" id="west"><a  onclick="javascript:window.location.href='${APP_PATH}/classroom/resource?areaNum=2'">西区</a></li>
			<li data-toggle="tab" id="center"><a  onclick="javascript:window.location.href='${APP_PATH}/classroom/resource?areaNum=1'">中区</a></li>
		</ul>

		<table class="table">
			<thead>
				<tr class="info row" >
					<td class="col-lg-2">楼号</td>
					<td class="col-lg-2">层数</td>
					<td class="col-lg-2">房号</td>
					<td class="col-lg-2">最大人数</td>
					<td class="col-lg-2">空调</td>
					<td class="col-lg-2">操作</td>
				</tr>
			</thead>
		</table>
		
		<c:forEach items="${BudNumList}" var="BudNum">
			<div class="main" >
				<table class="table">
					<thead>
						<tr class="row" >
							<td class="col-lg-2">${BudNum}号教学楼</td>
							<td class="col-lg-8"></td>
							<td class="col-lg-2"><span class="glyphicon glyphicon-chevron-right"></span></td>
						</tr>
					</thead>
				</table>
			</div>
			<div class="next">
       			<iframe src="${APP_PATH}/classroom/details?buildingNum=${BudNum}" id="mainFrame" name="mainFrame" frameborder="0" width="100%"  height="500px" ></iframe> 
    		</div>
		</c:forEach>
		
		
	</div>
</body>
</html>