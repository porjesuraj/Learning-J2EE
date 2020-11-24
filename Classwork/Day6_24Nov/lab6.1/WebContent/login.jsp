<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<%--bean instance created by WC n added under session scope --%>
<jsp:useBean id="voter" class="beans.VoterBean" scope="session"/>
<%--if null : session.getAttribute()  , then sessionAttribute("voter",new VoterBean()) --%>


<jsp:useBean id="candidate" class="beans.CandidateBean" scope="session"/>

<%-- if null : session.setAttribute("candidate", new CandidateBean()) --%>

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