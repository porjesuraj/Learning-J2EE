<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%-- import jstl supplied core tag lib --%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<body>
<%-- check voting status  --%>

<c:choose>
<%-- if(!session.getAttribute("voter").getValidatedUser().isStatus()) --%>
<c:when test="${!sessionScope.voter.validatedUser.status}">
<%--not yet voted --%>

<%-- increment candidate vote count  --%>
<jsp:setProperty property="*" name="candidate"/>
<%--invoke B.L method of candidate bean  --%>
 <h5> Voting Message: ${sessionScope.candidate.updateVotes()} </h5> 
 
 <%-- INVOKE B.L method of voter bean --%>
 <h5> Voter status :  ${sessionScope.voter.updateStatus()}  </h5>

</c:when>

<c:otherwise>
<%-- increment the vote  --%>

<h5> you have already voted .... </h5>


</c:otherwise>
</c:choose>


<%-- invoke beans methods to close DB resources --%>

${sessionScope.voter.daoCleanUp()}

${sessionScope.candidate.daoCleanUp()}


<%-- invalidate http session  --%>
<%-- pageContext.getSession().invalidate()-- --%>
${pageContext.session.invalidate()}

<h5> user logout successfully </h5>

</body>
</html>