<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3> welcome to jsp  <%= LocalDateTime.now() %> </h3>

<h4> session id  :<%= session.getId() %></h4>
<h4 >session timeout  : <%= session.getMaxInactiveInterval()  %></h4>

<%-- server side comment  --%>

<!-- client side comment  -->

<%-- <h4> Page Context : <%= pageContext %></h4>
<h4> Page :  <%= page %></h4> --%>

<h5> <a href="login.jsp"> Test Scriplets</a></h5>

<h5> <a href="test1.jsp?name=abc&age=26"> Testing EL syntax n attributes</a> </h5>
<h5>
		<a href="test3.jsp">Testing JSP Declarations</a>
	</h5>
	<%-- <h4>
		PageContext :
		<%=pageContext%></h4>
	<h4>
		Page :
		<%=page%></h4> --%>
</body>
</html>