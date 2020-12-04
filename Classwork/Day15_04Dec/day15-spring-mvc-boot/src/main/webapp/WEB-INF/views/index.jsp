<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%--  importing spring supplied JSP tag library  --%>  
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h5>Welcome to Spring MVC : page served via Spring framework@
${requestScope.time}</h5>

<%--URL rewriting if needed and makes all URL relative to root of current web application  --%>
<h5> <a href="<spring:url value='/user/login'/>">User Login </a> </h5>


<h5> <a href="<spring:url value='/product/show/123/bread/50/2020-12-10'/>"> Show Product Details </a> </h5>

</body>
</html>