<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- save product details under session scope w/o using scriplet --%>

<c:set var="product_dtls" value ="${param.pid} : ${param.price} : ${param.category}" scope="session" />


<%-- <c:url value="next page location (test2.jsp)" />  --%>

<h4> <a href="<c:url value='test2.jsp'/>"> Next</a></h4>


</body>
</html>