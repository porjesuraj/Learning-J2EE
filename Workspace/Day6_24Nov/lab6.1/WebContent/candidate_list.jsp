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

	<%-- display list of candidates : by calling B.L method of candidate bean : EL syntax --%>

	<%-- session.getAttribute("candidate") --%>

	<h5 align="center">Candidate List</h5>
	<%-- for(Candidate c : session.getAtribute("candidate").getCandidates()) --%>


	<form action="voter_status.jsp" method="get">
		<table style="background-color: cyan; margin: auto;" border="1">
            <c:forEach var="c" items="${sessionScope.candidate.candidates}">
				<%-- out.print(c.getCandidateId + " " + c.getName() + " " + c.getParty() --%>
				<tr>
					<td><input type="radio" name="cid" value="${c.candidateId}">
					</td>
					<td>${c.candidateId} ${c.name} ${c.party}</td>
				</tr>
			</c:forEach>

			<tr>
				<td><input type="submit" value="cast a vote" /></td>
			</tr>
		</table>
	</form>





</body>
</html>

