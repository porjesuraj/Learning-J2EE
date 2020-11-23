<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- pageContext.getSession().getId --%>
<h5> Session Id from log out  page :${pageContext.session.id} </h5>

<%-- session.getAttribute("usr_details").getName() --%>
<h5> Hello ${sessionScope.user.name} </h5>
<%--invalidate session
<%
session.invalidate();
%>
 --%>
 <%-- pageContext.getSession() --%>
 
${pageContext.session.invalidate() }
 
 <h5> you have logged out ...</h5>
 <h5> <a href="index.jsp"> Visit again</a> </h5>


</body>
</html>