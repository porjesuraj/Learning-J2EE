<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>From Test1 page....</h5>
	<%--name=abc&age=25 --%>
	<%--Display User's name n age using EL syntax --%>
	<h5>Hello , ${param.name}</h5>
	<h5>Age : ${param.age}</h5>
	<%--Add these user details under session scope --%>
	<%
		//adding session scope attr
	//session.setAttribute("user_details", request.getParameter("name") + ":" + request.getParameter("age"));
	//create page , req , appln scoped attrs
	
	session.setAttribute("attr2", 2345); 
	pageContext.setAttribute("attr1", 1234);
	request.setAttribute("user_details", request.getParameter("name") + ":" + request.getParameter("age"));
	application.setAttribute("attr3", 4567);
	//clnt pull II : send redirect
//	response.sendRedirect("test2.jsp");
	//server pull : forward scenario
	//1 : RD
	RequestDispatcher rd=request.getRequestDispatcher("test2.jsp");
	// forward 
	//rd.forward(request, response);
	// include 
	rd.include(request, response); 
	%>
</body>
</html>

            
