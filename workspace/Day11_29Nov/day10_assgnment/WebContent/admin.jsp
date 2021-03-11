<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--display login successful message using EL syntax --%>
<h5>${sessionScope.vendor_bean.message}</h5>
<h5>Admin  Details : ${sessionScope.vendor_bean.validatedDetails}</h5>
</body>
</html>