<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请登录</title>
<% 
	pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<script type="text/javascript">
	
	/* window.location.href='${APP_PATH}/views/loginPage'; */

</script>

</head>
<body style="height: 100%;width: 100%">

<c:redirect url="/view/loginPage"/>
<%-- <%@include file="/WEB-INF/views/loginPage.jsp" %> --%>
<%-- <jsp:forward page="/WEB-INF/views/loginPage.jsp"></jsp:forward> --%>
</body>
</html>