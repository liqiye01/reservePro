	$(document).ready(function() {
		
		/* 页面加载默认打开菜单栏的第一栏 */
		$("#panel1").slideDown("slow");
		$("#option").addClass("active");
		$("#option a span").removeClass("glyphicon-triangle-right").addClass("glyphicon-triangle-bottom");
		
		$(".nav li").click(function() {
			$(".active").removeClass('active');
			$(this).addClass("active"); 
		});
		
		$(".dropdown-menu li").click(function() {
			$(".flag").css("background-color","");
			$(this).css("background-color","#F7F7F7").addClass("flag");
		});
		
		/* 菜单栏的箭头转换 */
		$("#flip1").click(function(){
			if($("#flip1  span").hasClass("glyphicon-triangle-right")){
				$("#flip1  span").removeClass("glyphicon-triangle-right");
				$("#flip1  span").addClass("glyphicon-triangle-bottom");
			}else {
				$("#flip1  span").removeClass("glyphicon-triangle-bottom");
				$("#flip1  span").addClass("glyphicon-triangle-right");
			}
			$("#flip2  span").removeClass("glyphicon-triangle-bottom");
			$("#flip2  span").addClass("glyphicon-triangle-right");
			$("#panel1").slideToggle("slow");
			$("#panel2").slideUp("slow");
		})
		$("#flip2").click(function(){
			if($("#flip2  span").hasClass("glyphicon-triangle-right")){
				$("#flip2  span").removeClass("glyphicon-triangle-right");
				$("#flip2  span").addClass("glyphicon-triangle-bottom");
			}else {
				$("#flip2  span").removeClass("glyphicon-triangle-bottom");
				$("#flip2  span").addClass("glyphicon-triangle-right");
			}
			$("#flip1  span").removeClass("glyphicon-triangle-bottom");
			$("#flip1  span").addClass("glyphicon-triangle-right");
			$("#panel2").slideToggle("slow");
			$("#panel1").slideUp("slow");
		})
		$("#flip3").click(function(){
			if($("#flip2  span").hasClass("glyphicon-triangle-bottom")){
				$("#flip2  span").removeClass("glyphicon-triangle-bottom");
				$("#flip2  span").addClass("glyphicon-triangle-right");
			}
			if($("#flip1  span").hasClass("glyphicon-triangle-bottom")){
				$("#flip1  span").removeClass("glyphicon-triangle-bottom");
				$("#flip1  span").addClass("glyphicon-triangle-right");
			}
			$("#panel2").slideUp("slow");
			$("#panel1").slideUp("slow");
		})
		$("#flip4").click(function(){
			if($("#flip2  span").hasClass("glyphicon-triangle-bottom")){
				$("#flip2  span").removeClass("glyphicon-triangle-bottom");
				$("#flip2  span").addClass("glyphicon-triangle-right");
			}
			if($("#flip1  span").hasClass("glyphicon-triangle-bottom")){
				$("#flip1  span").removeClass("glyphicon-triangle-bottom");
				$("#flip1  span").addClass("glyphicon-triangle-right");
			}
			$("#panel2").slideUp("slow");
			$("#panel1").slideUp("slow");
		})
		
		$("#menu li:last").css("border-bottom","0");
		

	});