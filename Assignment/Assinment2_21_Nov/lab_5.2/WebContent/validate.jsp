
<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@page import="pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!// hard code valid user credentials

	String name = "abc", password = "1234";%>

<body>
	<h5>from validate page</h5>
	<%
		// add a scriplet for validation 

		String nm1 = request.getParameter("nm");
		String pwd = request.getParameter("pass");

		if (nm1.equals(name) && pwd.equals(password)) {
			// valid login 

			// valid login : store validated user details in User pojo n save  it under session scope
			//session.setAttribute("user_details", new User(nm1, pwd));
		
		request.setAttribute("user_details", new User(nm1, pwd));
		
			// clnt pull: redirect 
			//response.sendRedirect("details.jsp");

		// USING SERVER PULL 
		// 1. RD
RequestDispatcher rd = request.getRequestDispatcher("details.jsp"); 
		// 2. Forward
		rd.forward(request, response); // WC : clears buffer of jsp writer n then invokes : details_jsp ,_jspService method 
		
		} else {
	%>

	<h5 style="color: red">Invalid login...</h5>
	<h5>
		Please <a href="login.jsp">Retry</a>
	</h5>

	<%
		}
	%>

</body>
</html>