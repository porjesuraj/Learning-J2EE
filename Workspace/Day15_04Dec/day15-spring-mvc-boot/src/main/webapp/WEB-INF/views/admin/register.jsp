<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%--to enable form binding : import spring supplied form tag lib --%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form:form method="post" modelAttribute="vendor">
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td>Enter Vendor Email</td>
				<td><form:input type="email" path="email" /></td>
				<td> <form:errors path="email"/>  </td>
			</tr>
			<tr>
				<td>Enter Vendor Name</td>
				<td><form:input  path="name" /></td>
				<td> <form:errors path="name"/>  </td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><form:password  path="password" /></td>
				<td> <form:errors path="password"/>  </td>
			</tr>
			<tr>
				<td>Enter Reg Amount</td>
				<td><form:input type="number" path="regAmount" /></td>
				<td> <form:errors path="regAmount"/>  </td>
			</tr>
			<tr>
				<td>Choose Reg Date</td>
				<td><form:input type="date" path="regDate" /></td>
				<td> <form:errors path="regDate"/>  </td>
			</tr>
<
			<tr>
				<td><input type="submit" value="Register New Vendor" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>