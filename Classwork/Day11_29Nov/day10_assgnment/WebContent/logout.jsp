<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>Hello, ${sessionScope.vendor_bean.validatedDetails.name}</h5>
	${pageContext.session.invalidate()}
	<h6>You have logged out...</h6>
	<h5>
		<a href="login.jsp">Visit Again</a>
	</h5>
</body>
</html>