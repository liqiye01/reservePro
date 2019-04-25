<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教学资源预定系统</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="//apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<% 
	pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<!-- 引入样式 -->
<link type="text/css" href="${APP_PATH}/static/css/view.css" rel="stylesheet">
<script type="text/javascript" src="${APP_PATH}/static/js/view.js"></script>

<style type="text/css">
#box{
	width: 400px;
	height: 300px;
	background-color: #E0FFFF;
	position: absolute;
	bottom: 40px;
	right: 28px;
	z-index: 200;
}
#box2{
	width: 400px;
	height: 300px;
	background-color: #EEB4B4;
	position: absolute;
	bottom: 30px;
	right: 18px;
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
.resourceText{
	color: gray;
	margin: 5px 100px 0 100px;
	font-size: 14px;
	line-height: 20px;
}
.colseBtn{
	position:absolute;
	right:10px;
	top: 0;
}

</style>
<script type="text/javascript">
$(document).ready(function(){
	
	var successIds = '${successIds}';
	var rejectIds = '${rejectIds}';
	if(${reserveSuccess=='1'}){
		setTimeout(function(){$("#box").slideToggle("2000");}, 1300);
			$("#closeBtn").click(function() {
				$("#box").slideToggle();
				//点击关闭 将字段改为已读
				$.ajax({
					type: "post",
            		url: "${APP_PATH}/view/checkSuccess",
            		dataType:"json",
                    data:{"successIds":successIds},
                    success:function(data){
                    } 
				});
		});
	}
	if(${reserveReject=='1'}){
		setTimeout(function(){$("#box2").slideToggle("2000");}, 800);
			$("#closeBtn2").click(function() {
				$("#box2").slideToggle();
				$.ajax({
					type: "post",
            		url: "${APP_PATH}/view/checkReject",
            		dataType:"json",
                    data:{"rejectIds":rejectIds},
                    success:function(data){
                    } 
				});
		});
	}
	
	

});


</script>


</head>
<body>
<!-- 预定成功弹窗 -->
<div id="box" style="display: none">
	<div id="content">
		<div >
  			<h1 class="text1" >恭喜！</h1>
  			<hr>
  			<p class="text2">您预定的:</p>
  			<div class="resourceText"><strong>${successName}</strong></div> 
  			<p class="text2">已通过管理员的审核</p>
		</div>
		<span class="colseBtn" style="cursor:pointer;"><a  id="closeBtn" >
			<span class="glyphicon glyphicon-remove" style="font-size:25px;margin-top: 10px"></span>
		</a></span>
	</div>
</div>
<!-- 预定被驳回弹窗 -->
<div id="box2" style="display: none">
	<div id="content">
		<div >
  			<h1 class="text1" >很抱歉！</h1>
  			<hr>
  			<p class="text2">您预定的:</p>
  			<div class="resourceText"><strong>${rejectName}</strong></div> 
  			<p class="text2">已被管理员驳回</p>
		</div>
		<span class="colseBtn" style="cursor:pointer;"><a  id="closeBtn2" >
			<span class="glyphicon glyphicon-remove" style="font-size:25px;margin-top: 10px"></span>
		</a></span>
	</div>
</div>

<!--顶部导航栏部分-->
<nav class="navbar navbar-default ">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" title="教学资源预定系统" href="#">
            	<span class="logoForm">教学资源预定系统</span>
            </a>
       </div>
       <div class="collapse navbar-collapse">
           <ul class="nav navbar-nav navbar-right">
                <li>
                   <a title="个人信息" href="${APP_PATH}/view/personalMsgPage" target="mainFrame">当前用户：<span class="badge">${user.tureName }</span></a>
                </li>
				<li>
					<a href="${APP_PATH}/view/quitLogin"> 
						<span class="glyphicon glyphicon-lock"></span>退出登录
					</a>
				</li>
			</ul>
       </div>
    </div>      
</nav>

<!-- 中间主体内容部分 -->
<div class="pageContainer">
     <!-- 左侧导航栏 -->
     <div class="pageSidebar">
         <ul id="menu" class="nav nav-stacked nav-pills boder" >
             <li id="option" role="presentation" >
                <a id="flip1" class="dropdown-toggle">
                 	<i class="glyphicon glyphicon-pencil"></i> 资源预定 <span  class="glyphicon glyphicon-triangle-right"></span>   
                </a>
                <ul id="panel1" class="dropdown-menu" role="menu">
                     <li >
                         <a href="${APP_PATH}/classroom/resource?areaNum=3" role="menuitem" target="mainFrame">
                         	<i class="glyphicon glyphicon-hand-right"></i> 教室预定
                         </a>
                     </li>
                     <li>
                         <a href="${APP_PATH}/laboratory/resource" role="menuitem" target="mainFrame">
                         	<i class="glyphicon glyphicon-hand-right"></i> 实验室预定		
                         </a>
                     </li>
                     <li>
                         <a href="${APP_PATH}/sport/resource?areaNum=3" role="menuitem" target="mainFrame">
                        	 <i class="glyphicon glyphicon-hand-right"></i> 体育场地预定	
                         </a>
                     </li>
                     <li>
                         <a href="${APP_PATH}/meeting/resource?areaNum=3" role="menuitem" target="mainFrame">
                        	<i class="glyphicon glyphicon-hand-right"></i>  会议室	
                         </a>
                     </li>
                 </ul>
             </li>
             <li  role="presentation">
                 <a id="flip2">
                 	<i class="glyphicon glyphicon-asterisk"></i> 资源管理 <span  class="glyphicon glyphicon-triangle-right"></span>
                 </a>
                 <ul id="panel2" class="dropdown-menu" role="menu">
                     <li>
                         <a href="${APP_PATH}/manage/classroomListPage?pageNum=1" role="menuitem" target="mainFrame">
                         	<i class="glyphicon glyphicon-hand-right"></i> 教学楼
                         </a>
                     </li>
                     <li>
                         <a href="${APP_PATH}/manage/laboratoryListPage?pageNum=1" role="menuitem" target="mainFrame">
                         	<i class="glyphicon glyphicon-hand-right"></i> 实验室		
                         </a>
                     </li>
                     <li>
                         <a href="${APP_PATH}/manage/sportListPage?pageNum=1" role="menuitem" target="mainFrame">
                        	 <i class="glyphicon glyphicon-hand-right"></i> 体育场地	
                         </a>
                     </li>
                     <li>
                         <a href="${APP_PATH}/manage/meetingListPage?pageNum=1" role="menuitem" target="mainFrame">
                        	 <i class="glyphicon glyphicon-hand-right"></i> 会议室	
                         </a>
                     </li>
                 </ul>
             </li>
             <li  class="dropdown" role="presentation">
                 <a id="flip3" href="${APP_PATH}/distribution/resource?type=1&state=1" target="mainFrame">
                 	<i class="glyphicon glyphicon-indent-right"></i> 资源分配 
                 </a>
             </li>
             <li  class="dropdown" role="presentation">
                 <a id="flip4" href="${APP_PATH}/userManage/userList?pageNum=1" target="mainFrame">
                 	<i class="glyphicon glyphicon-user"></i> 用户管理 
                 </a>
             </li>
             <li  class="dropdown" role="presentation">
                 <a id="flip5" href="${APP_PATH}/view/myReserve" target="mainFrame">
                 	<i class="glyphicon glyphicon-signal"></i> 我的预定 
                 </a>
             </li>
         </ul>
     </div>

      <!-- 左侧导航和正文内容的分隔线 -->
     <div class="splitter"></div>
     <!-- 正文内容部分 -->
     <div class="pageContent">
       <iframe  id="mainFrame" src="welcomeUse" name="mainFrame" frameborder="0" width="100%"  height="100%" frameBorder="0"></iframe> 
     </div>

 </div>
  <!-- 底部页脚部分 -->
 <div class="footer">
     <p class="text-center">
         &copy; 2018 教学资源预定系统
     </p>
 </div>

</body>
</html>

