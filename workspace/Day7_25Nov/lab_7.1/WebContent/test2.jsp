<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h5 >Prodct details : ${sessionScope.product_dtls} </h5>

<c:if test="${param.btn eq 'Withdraw'}">
  In withdraw 
 </c:if>

<h5> test</h5>

</body>
</html>