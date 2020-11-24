<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h5> Successfully login ...</h5>

<h4> Your details : ${requestScope.user_details}</h4>
<h4> Request scope :${requestScope}</h4>

<% 
 session.setAttribute("user", request.getAttribute("user_details"));
%>
<h5> <a href="logout.jsp">log me out</a> </h5>

</body>
</html>