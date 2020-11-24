<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%--ALL MATCHING setters of bean called by WC--%>
<jsp:setProperty property="*" name="voter"/>
<body>
<%--invoke B.L method of bean --%>
<%-- below content will not be sent to  client  --%>
<%-- <h5> Status : ${sessionScope.voter.validateUser()}</h5> --%>

<%-- <h5> Validated user details : ${sessionScope.voter.validatedUser}</h5> --%>


<%-- forward the client in the same req to next page -  --%>
<%-- RD rd = request.getrd(session.getAttributer("voter").validateUser().concat(".jsp"); rd.forward(...); --%>

<%-- 
<jsp:forward page="${sessionScope.voter.validateUser()}.jsp"/> --%>

<%-- redirecting clnt in the NEXT req to next page --%>
<%--response.sendRedirect() + url rewriting  --%>
<c:redirect url="${sessionScope.voter.validateUser()}.jsp"/>

<%-- prg - post redirect g --%>
</body>
</html>

            