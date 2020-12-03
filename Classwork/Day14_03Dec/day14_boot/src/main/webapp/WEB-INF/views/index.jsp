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

<h4> <a href="product/add?name=pen&category=stationary&price=50.5&qty=3&creation_date=12/23/2019"> Handling Request </a> </h4>


<h4> <a href="product/add2?name=pen&category=stationary&price=50.5
&qty=3&creation_date=2020-5-25"> Handling Request Paramter and date time Formatting </a> </h4>

<%--URL rewriting if needed and makes all URL relative to root of current web application  --%>
<h5> <a href="<spring:url value='/user/login'/>">User Login </a> </h5>


</body>
</html>