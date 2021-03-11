<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4> session id  :<%= session.getId() %></h4>
	<h5>
		Email :
		<%
		out.print(request.getParameter("em"));
	%>
	</h5>
	<h5>
		Password :
		<%
		out.print(request.getParameter("pass"));
	%>
	</h5>
	<hr> 
	
	<h5> Email via Expression : <%= request.getParameter("em") %></h5>
	<h5> Password via Expression : <%= request.getParameter("pass") %></h5>
</body>
</html>

            