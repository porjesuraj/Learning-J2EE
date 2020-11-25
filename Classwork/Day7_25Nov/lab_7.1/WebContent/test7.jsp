<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%! String message="hello..."; // what is it? : instance var available : private %> 
<body>

<%
int data = 1234; // what is it? : method local variable : within _jspService of test7.jsp
%>
<%-- page scoped attribute available to current page only  --%>
<c:set var="server_date" value="<%= LocalDateTime.now() %>" />

<%-- use include directive  --%>

<%@ include file="test8.jsp" %>

</body>
</html>