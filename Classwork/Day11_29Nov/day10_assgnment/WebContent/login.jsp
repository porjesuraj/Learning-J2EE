<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%--create JB instance n add it under session scope --%>
<%--session.setAttribute("vendor_bean",new VendorBean())  --%>
<jsp:useBean id="vendor_bean" class="beans.VendorBean" scope="session" />
<jsp:useBean id="acct_bean" class="beans.BankAccountBean"
	scope="session" />
<body>
	<h5 style="color: red">${sessionScope.vendor_bean.message}</h5>
	<c:url var="url" value="validate.jsp" />
	<form action="${url}" method="post">
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td>Enter User Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>

</body>
</html>