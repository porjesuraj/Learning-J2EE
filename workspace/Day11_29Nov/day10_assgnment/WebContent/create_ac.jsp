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
<c:url var="url" value="create.jsp"/>
	<form action="${url}" method="post">
		<table style="background-color: cyan; margin: auto;" border="1">
			<tr>
				<td>Choose A/C Type</td>
				<td><select name="acType">
						<c:forEach var="acTy" items="${sessionScope.acct_bean.acTypes}">
							<option value="${acTy}">${acTy}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Enter A/C balance</td>
				<td><input type="number" name="balance" /></td>
			</tr>
			<tr>
				<td>Choose Creation Date</td>
				<td><input type="date" name="creationDate" /></td>
			</tr>
			<tr>

				<td><input type="submit" value="Create A/C" /></td>
			</tr>
		</table>
	</form>
</body>
</html>