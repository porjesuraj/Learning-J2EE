<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- create JB instance and add it under sssion scope --%>
<%-- session.addAttribute("vendor_bean", new VendorBean()) --%>

<jsp:useBean id="vendor_bean" class="beans.VendorBean" scope = "session" />

<jsp:useBean id="acct_bean" class="beans.BankAccountBean" scope="session"/>

<body>

	<form action="validate.jsp" method="post">
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

            