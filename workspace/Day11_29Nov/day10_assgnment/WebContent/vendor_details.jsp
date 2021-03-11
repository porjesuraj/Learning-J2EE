<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<%--display login successful message using EL syntax --%>
	<h5>${sessionScope.vendor_bean.message}</h5>
	<h5>${sessionScope.acct_bean.message}</h5>
	<h5>Hello, ${sessionScope.vendor_bean.validatedDetails.name}</h5>
	<h6></h6>
	<h5 align="center">Your A/C Summary</h5>
	<c:url var="url" value="close_ac.jsp"/>
	<form action="${url}">
		<table style="background-color: cyan; margin: auto;" border="1">
			<caption></caption>
			<tr>
				<th>Type</th>
				<th>Balance</th>
				<th>Created On</th>
				<th></th>
			</tr>
			<c:forEach var="acct"
				items="${sessionScope.acct_bean.fetchAccounts(sessionScope.vendor_bean.validatedDetails.vendorId)}">
				<tr>
					<td><input type="radio" name="acctId" value="${acct.acctNo}"></td>
					<td>${acct.acType}</td>
					<td>${acct.balance}</td>
					<td>${acct.creationDate}</td>
				</tr>
			</c:forEach>
			<tr>
			<td><input type="submit" value="Close A/C"></td>
			</tr>
		</table>
	</form>

	<h5>
		<a href="<c:url value='create_ac.jsp'/>">Create New Account</a>
	</h5>
	<h5>
		<a href="<c:url value='logout.jsp'/>">Log Me Out</a>
	</h5>
</body>
</html>