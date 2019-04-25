<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>实验楼</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="//apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
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
#content{
	margin: 6px 6px 0 6px;
}
.nav-tabs > li > a{
	font-size: 18px;
}
.table-striped{
	text-align: center;
}
a{
	color: #63B8FF;
}
a:HOVER {
	text-decoration:none;
}
.select{
	margin-top: 10px;
	margin-left: 10px;
}
.form-group{
	float: left;
	margin-right: 20px;
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
.pageInfo{
	font-size: 14px;
	color: gray;
	float: left;
	font-weight: bolder;
	position: relative;
	left:60px;
	top:33px;
}
.pagination{
	float: left;
}
.paging{
	position: relative;
	margin: 60px 150px;
}
.goForm{
	position:relative;
	left:30px;
	top:19px;
}


</style>
<script type="text/javascript">
$(document).ready(function(){
	
	if(${area=='1'}){
		$("#area option:eq(2)").attr("selected","selected");
	}
	if(${area=='2'}){
		$("#area option:eq(1)").attr("selected","selected");
	}
	if(${area=='3'}){
		$("#area option:eq(3)").attr("selected","selected");
	}
	if(${buildingNum!=null}){
		$("#buildingNum").val(${buildingNum});
	}
	if(${floor!=null}){
		$("#floor").val(${floor});
	}
	if(${maxPopulation!=null}){
		$("#maxPopulation").val(${maxPopulation});
	}
	if(${airConditioner!=null}){
		$("#airConditioner").val(${airConditioner});
	}
	
	if(${delFlag=='1'}){
		setTimeout(function(){$("#box2").slideToggle("2000");}, 100);
			$("#closeBtn2").click(function() {
				$("#box2").slideToggle();
		});
	}
	
	
	var pageNum = ${pageInfo.pageNum};   //当前页数
	var pages = ${pageInfo.pages};  //总页数
	if(pageNum=='1'){
		$("#previous").addClass("disabled");
	}
	if(pageNum==pages){
		$("#next").addClass("disabled");
	}
	
	
	

});


</script>

</head>
<!-- 删除弹窗 -->
<div id="box2" style="display: none">
	<div id="content">
		<div >
  			<h1 class="text1" >已成功删除</h1>
  			<hr>
  			<p class="text2">资源: ${resourceName}</p>
		</div>
		<span class="colseBtn" style="cursor:pointer;"><a  id="closeBtn2" >
			<span class="glyphicon glyphicon-remove" style="font-size:25px;margin-top: 10px"></span>
		</a></span>
	</div>
</div>

<body>
	<div id="content">
		<ul class="nav nav-tabs">
			<li class="active" ><a  onclick="javascript:window.location.href='${APP_PATH}/manage/laboratoryListPage?pageNum=1'">资源列表</a></li>
			<li  ><a  onclick="javascript:window.location.href='${APP_PATH}/manage/addLaboratoryPage'">新增资源</a></li>
		</ul>
		<div class="select">
			<form action="${APP_PATH}/manage/laboratoryListPage?pageNum=1">
				<select id="area" name="area" class="selectStyle">
					<option value="">请选择区域</option>
					<option value="2">西区</option>
					<option value="1">中区</option>
					<option value="3">东区</option>
				</select>
				<div class="form-group">
				    <input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"
				     id="buildingNum" type="text" class="form-control" name="buildingNum"  placeholder="教学楼号" style="widows: 150px;">
				</div>
				<div class="form-group">
				    <input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"
				     id="floor" type="text" class="form-control" name="floor"  placeholder="层数" style="widows: 150px;">
				</div>
				<div class="form-group">
				    <input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"
				     id="maxPopulation" type="text" class="form-control" name="maxPopulation"  placeholder="最大人数" style="widows: 150px;">
				</div>
				<select id="airConditioner" name="airConditioner" class="selectStyle">
					<option value="">请选择有无空调</option>
					<option value="1">有空调</option>
					<option value="0">无空调</option>
				</select>
				<button class="btn btn-info" type="submit" style="float: left;">查询</button>
			</form>
		</div>
		<table class="table table-striped">
			<thead>
				<tr  class="info" style="font-weight: bolder;">
					<td>区域</td>
					<td>实验楼号</td>
					<td>层数</td>
					<td>房号</td>
					<td>最大人数</td>
					<td>是否有空调</td>
					<td>操作</td>
				</tr>
			</thead>
			<c:forEach items="${pageInfo.list}" var="laboratory">
				<tr>
					<td>
						<c:if test="${laboratory.area=='1'}">中区</c:if>
						<c:if test="${laboratory.area=='2'}">西区</c:if>
						<c:if test="${laboratory.area=='3'}">东区</c:if>
					</td>
					<td>${laboratory.buildingNum}</td>
					<td>${laboratory.floor}</td>
					<td>${laboratory.roomNum}</td>
					<td>${laboratory.maxPopulation}</td>
					<td>
						<c:if test="${laboratory.airConditioner=='1'}">
							是						
						</c:if>
						<c:if test="${laboratory.airConditioner=='0'}">
							无						
						</c:if>
					</td>
					<td>
						<a href="${APP_PATH}/manage/updateLaboratory?id=${laboratory.id}">修改</a>
						<a onclick="return confirm('确认删除资源  【${laboratory.buildingNum}教${laboratory.roomNum}】吗？', this.href)"
							href="${APP_PATH}/manage/delLaboratory?id=${laboratory.id}&timeArrangeId=${laboratory.timeArrangeId}
							&predictPersonId=${clalaboratoryssroom.predictPersonId}&area=${area}&buildingNum=${buildingNum}
							&floor=${floor}&roomNum=${roomNum}&maxPopulation=${maxPopulation}
							&airConditioner=${airConditioner}&pageNum=${pageNum}&resourceName=${laboratory.buildingNum}实${laboratory.roomNum}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div class="paging">
		<nav aria-label="Page navigation">
		  <ul class="pagination">
		    <li id="previous">
		      <a href="${APP_PATH}/manage/laboratoryListPage?pageNum=${pre}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;上一页</span>
		      </a>
		    </li>
		    <li id="next">
		      <a href="${APP_PATH}/manage/laboratoryListPage?pageNum=${nex}" aria-label="Next">
		        <span aria-hidden="true">下一页&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
		<div class="goForm">
			<form action="${APP_PATH}/manage/laboratoryListPage" >
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