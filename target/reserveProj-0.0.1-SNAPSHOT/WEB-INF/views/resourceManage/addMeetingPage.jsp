<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增会议室</title>

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

#content{
	margin: 6px 6px 0 6px;
}
.nav-tabs > li > a{
	font-size: 18px;
}
.addForm{
	margin: 50px 10px 50px 50px;
	float: left;
}

.sel_mask{                  
            position:relative;
            width:280px;
            height:35px;
            background:#87CEFF;
            border-radius: 5px;
            box-shadow:1px 1px 5px #169BD5;
            display:inline-block;
            text-decoration: none;
 }
 .sel_mask:hover{         /*添加hover效果*/
     background:#5CACEE;
 }
 .sel_mask select{        /*以相同大小将<select></select>绝对定位*/
     top:0px;
     left:0px;
     position:absolute;
     width:280px;
     height:35px;
     opacity:0;
 }
 .sel_mask select option[selected]{
     font-weight:bold
 }
 .sel_mask select option:nth-child(even) {
     background-color:#EEE5DE;
 }
 .sel_mask select option{
     color:#8B5F65;
     font-size: 17px;
 }
 .sel_mask span{     /*显示内容*/
     position: absolute;
     top:5px;
     left:5px;
     right: 20px;
     display: inline-block;
     color:#fff;
     font-size:19px;
     overflow:hidden;
     text-overflow: ellipsis;
     white-space:nowrap;
     margin-left: 15px;
 }
.text1{
	font-size: 20px;
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

.table-bordered{
	width: 500px;
	height: 350px;
}
.arrangeForm{
	float: left;
	margin: 50px 10px;
	overflow: auto;
}
.arrangeText{
	margin:0 0 20px 5px;
	font-family: Microsoft YaHei;
	color: 
}
.timeText{
	font-size: 17px;
	color: gray;
}
#timeSelect{
	height: 30px;
	background-color: #F7F7F7;
	border-radius:3px;
	-webkit-border-radius:3px;
	-moz-border-radius :3px;
}


</style>
<script type="text/javascript">
$(document).ready(function(){
	$('.sel').change(function () {    
        $('span').html($('.sel').find('option:selected').html());
    })
    $('.sel').blur(function () {      
    })
    $('.sel').click(function(){     
    })
	
	if(${addSuccess=='1'}){
		setTimeout(function(){$("#box").slideToggle("2000");}, 100);
		setTimeout(function(){$("#box").slideToggle("2000");}, 3100);
		/*$("#closeBtn").click(function() {
			$("#box").slideToggle();
		});*/
	}
	
	if(${existFlag=='1'}){
		setTimeout(function(){$("#box2").slideToggle("2000");}, 100);
		setTimeout(function(){$("#box2").slideToggle("2000");}, 3100);
		/*$("#closeBtn2").click(function() {
			$("#box2").slideToggle();
		});*/
	}
	
	if(${meetingRoom.area=='1'}){
		$("#areaText").html("中区");
	}
	if(${meetingRoom.area=='2'}){
		$("#areaText").html("西区");
	}
	if(${meetingRoom.area=='3'}){
		$("#areaText").html("东区");
	}
	
	

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
  				<p class="text2">添加会议室: <strong>${resourceName}</strong></p>
  			</c:if>
  			<c:if test="${updateSuccess=='1'}">
  				<p class="text2">修改资源: <strong>${resourceName}</strong></p>
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
  			<h1 class="text3" >已存在该资源</h1>
  			<hr>
  			<p class="text2">资源: ${resourceName}</p>
		</div>
		<span class="colseBtn" style="cursor:pointer;"><a  id="closeBtn2" >
			<span class="glyphicon glyphicon-remove" style="font-size:25px;margin-top: 10px"></span>
		</a></span>
	</div>
</div>

<div id="content" >
	<ul class="nav nav-tabs">
		<li  data-toggle="tab" ><a  onclick="javascript:window.location.href='${APP_PATH}/manage/meetingListPage?pageNum=1'">资源列表</a></li>
		<c:if test="${meetingRoom.id==null}">
			<li class="active" data-toggle="tab" ><a  onclick="javascript:window.location.href='${APP_PATH}/manage/addMeetingPage'">新增资源</a></li>
		</c:if>
		<c:if test="${meetingRoom.id!=null}">
			<li class="active" data-toggle="tab" ><a  onclick="javascript:window.location.href='${APP_PATH}/manage/addMeetingPage'">资源修改</a></li>
		</c:if>
	</ul>
	<div class="addForm">
		<form:form modelAttribute="meetingRoom"  action="${APP_PATH}/manage/addMeeting" method="post">
			<form:hidden path="id"/>
			<div class="form-group">
		    	<label for="exampleInputEmail1" class="text1"> 区域</label></br>
				<a href="javascript:void(0)"  class="sel_mask"><span id="areaText">请选择</span>
				   <form:select id="areaSelect" path="area" class="sel">
				       <form:option value="" >请选择</form:option>
				       <form:option value="2">西区</form:option>
				       <form:option value="1">中区</form:option>
				       <form:option value="3">东区</form:option>
				   </form:select>
				</a>
		   </div>
		   <div class="form-group">
		    	<label for="exampleInputEmail1" class="text1"> 教学楼号</label></br>
				<form:input path="buildingNum" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"
				 type="text" class="form-control"  placeholder="如1教请输入:1" style="width: 280px" />
		   </div>
		   <div class="form-group">
		    	<label for="exampleInputEmail1" class="text1"> 层数</label></br>
				<form:input path="floor" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"
				 type="text" class="form-control"  placeholder="如一层楼请输入:1" style="width: 280px" />
		   </div>
		   <div class="form-group">
		    	<label for="exampleInputEmail1" class="text1"> 房号</label></br>
				<form:input path="roomNum" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"
				 type="text" class="form-control"  placeholder="如101教室请输入:101" style="width: 280px" />
		   </div>
		   <div class="form-group">
		    	<label for="exampleInputEmail1" class="text1"> 最大容纳人数 (人)</label></br>
				<form:input path="maxPopulation" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"
				 type="text" class="form-control"  placeholder="请输入数字" style="width: 280px" />
		   </div>
		   <c:if test="${meetingRoom.id==null}">
		   		<button style="margin-left: 5px;" class="btn btn-info btn-lg" type="submit">添加资源信息</button>
		   </c:if>
		   <c:if test="${meetingRoom.id!=null}">
		   		<button style="margin-left: 5px;" class="btn btn-info btn-lg" type="submit">修改资源信息</button>
		   </c:if>
	</div>
	
	<div class="arrangeForm">
		<h1 class="arrangeText">一周安排表</h1>
		<table class="table table-bordered">
			<form:hidden path="timeArrange.id" />
  			<tr>
  				<td>
  					<label class="timeText">星期一早上</label>
					<form:select path="timeArrange.monMorning" id="timeSelect" >
						<form:option label="已有课程安排" value="1"></form:option>
						<form:option label="待预定" value="2"></form:option>
						<form:option label="已预订" value="4"></form:option>
					</form:select>
  				</td>
  				<td>
  					<label class="timeText">星期二早上</label>
					<form:select path="timeArrange.tueMorning" id="timeSelect">
						<form:option label="已有课程安排" value="1"></form:option>
						<form:option label="待预定" value="2"></form:option>
						<form:option label="已预订" value="4"></form:option>
					</form:select>
  				</td>
  				<td>
  					<label class="timeText">星期三早上</label>
					<form:select path="timeArrange.wedMorning" id="timeSelect">
						<form:option label="已有课程安排" value="1"></form:option>
						<form:option label="待预定" value="2"></form:option>
						<form:option label="已预订" value="4"></form:option>
					</form:select>
  				</td>
  				<td>
  					<label class="timeText">星期四早上</label>
					<form:select path="timeArrange.thuMorning" id="timeSelect">
						<form:option label="已有课程安排" value="1"></form:option>
						<form:option label="待预定" value="2"></form:option>
						<form:option label="已预订" value="4"></form:option>
					</form:select>
  				</td>
  				<td>
  					<label class="timeText">星期五早上</label>
					<form:select path="timeArrange.friMorning" id="timeSelect">
						<form:option label="已有课程安排" value="1"></form:option>
						<form:option label="待预定" value="2"></form:option>
						<form:option label="已预订" value="4"></form:option>
					</form:select>
  				</td>
  				<td>
  					<label class="timeText">星期六早上</label>
					<form:select path="timeArrange.satMorning" id="timeSelect">
						<form:option label="已有课程安排" value="1"></form:option>
						<form:option label="待预定" value="2"></form:option>
						<form:option label="已预订" value="4"></form:option>
					</form:select>
  				</td>
  				<td>
  					<label class="timeText">星期天早上</label>
					<form:select path="timeArrange.sunMorning" id="timeSelect">
						<form:option label="已有课程安排" value="1"></form:option>
						<form:option label="待预定" value="2"></form:option>
						<form:option label="已预订" value="4"></form:option>
					</form:select>
  				</td>
  			</tr>
  			<tr>
  				<td>
  					<label class="timeText">星期一下午</label>
					<form:select path="timeArrange.monAfternoon" id="timeSelect">
						<form:option label="已有课程安排" value="1"></form:option>
						<form:option label="待预定" value="2"></form:option>
						<form:option label="已预订" value="4"></form:option>
					</form:select>
  				</td>
  				<td>
  					<label class="timeText">星期二下午</label>
					<form:select path="timeArrange.tueAfternoon" id="timeSelect">
						<form:option label="已有课程安排" value="1"></form:option>
						<form:option label="待预定" value="2"></form:option>
						<form:option label="已预订" value="4"></form:option>
					</form:select>
  				</td>
  				<td>
  					<label class="timeText">星期三下午</label>
					<form:select path="timeArrange.wedAfternoon" id="timeSelect">
						<form:option label="已有课程安排" value="1"></form:option>
						<form:option label="待预定" value="2"></form:option>
						<form:option label="已预订" value="4"></form:option>
					</form:select>
  				</td>
  				<td>
  					<label class="timeText">星期四下午</label>
					<form:select path="timeArrange.thuAfternoon" id="timeSelect">
						<form:option label="已有课程安排" value="1"></form:option>
						<form:option label="待预定" value="2"></form:option>
						<form:option label="已预订" value="4"></form:option>
					</form:select>
  				</td>
  				<td>
  					<label class="timeText">星期五下午</label>
					<form:select path="timeArrange.friAfternoon" id="timeSelect">
						<form:option label="已有课程安排" value="1"></form:option>
						<form:option label="待预定" value="2"></form:option>
						<form:option label="已预订" value="4"></form:option>
					</form:select>
  				</td>
  				<td>
  					<label class="timeText">星期六下午</label>
					<form:select path="timeArrange.satAfternoon" id="timeSelect">
						<form:option label="已有课程安排" value="1"></form:option>
						<form:option label="待预定" value="2"></form:option>
						<form:option label="已预订" value="4"></form:option>
					</form:select>
  				</td>
  				<td>
  					<label class="timeText">星期天下午</label>
					<form:select path="timeArrange.sunAfternoon" id="timeSelect">
						<form:option label="已有课程安排" value="1"></form:option>
						<form:option label="待预定" value="2"></form:option>
						<form:option label="已预订" value="4"></form:option>
					</form:select>
  				</td>
  			</tr>
  			<tr>
  				<td>
  					<label class="timeText">星期一晚上</label>
					<form:select path="timeArrange.monEvening" id="timeSelect">
						<form:option label="已有课程安排" value="1"></form:option>
						<form:option label="待预定" value="2"></form:option>
						<form:option label="已预订" value="4"></form:option>
					</form:select>
  				</td>
  				<td>
  					<label class="timeText">星期二晚上</label>
					<form:select path="timeArrange.tueEvening" id="timeSelect">
						<form:option label="已有课程安排" value="1"></form:option>
						<form:option label="待预定" value="2"></form:option>
						<form:option label="已预订" value="4"></form:option>
					</form:select>
  				</td>
  				<td>
  					<label class="timeText">星期三晚上</label>
					<form:select path="timeArrange.wedEvening" id="timeSelect">
						<form:option label="已有课程安排" value="1"></form:option>
						<form:option label="待预定" value="2"></form:option>
						<form:option label="已预订" value="4"></form:option>
					</form:select>
  				</td>
  				<td>
  					<label class="timeText">星期四晚上</label>
					<form:select path="timeArrange.thuEvening" id="timeSelect">
						<form:option label="已有课程安排" value="1"></form:option>
						<form:option label="待预定" value="2"></form:option>
						<form:option label="已预订" value="4"></form:option>
					</form:select>
  				</td>
  				<td>
  					<label class="timeText">星期五晚上</label>
					<form:select path="timeArrange.friEvening" id="timeSelect">
						<form:option label="已有课程安排" value="1"></form:option>
						<form:option label="待预定" value="2"></form:option>
						<form:option label="已预订" value="4"></form:option>
					</form:select>
  				</td>
  				<td>
  					<label class="timeText">星期六晚上</label>
					<form:select path="timeArrange.satEvening" id="timeSelect">
						<form:option label="已有课程安排" value="1"></form:option>
						<form:option label="待预定" value="2"></form:option>
						<form:option label="已预订" value="4"></form:option>
					</form:select>
  				</td>
  				<td>
  					<label class="timeText">星期天晚上</label>
					<form:select path="timeArrange.sunEvening" id="timeSelect" >
						<form:option label="已有课程安排" value="1"></form:option>
						<form:option label="待预定" value="2"></form:option>
						<form:option label="已预订" value="4"></form:option>
					</form:select>
  				</td>
  			</tr>
		</table>
	</div>
	
	
</form:form>

</div>
</body>
</html>