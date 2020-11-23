<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- display attributes from different scopes : using EL syntax --%>
<h3> JSESSIon ID :${sessionScope.id} </h3>
<h5> Page Scoped attr: ${pageScope.attr1} </h5> 
<h5> Request Scoped attr: ${requestScope.user_details} </h5>
<h5> Session Scoped attr: ${sessionScope.attr2} </h5>
<h5> Application Scoped attr: ${applicationScope.attr3} </h5>
<h5> Request param : ${param.name} </h5>
</body>
</html>