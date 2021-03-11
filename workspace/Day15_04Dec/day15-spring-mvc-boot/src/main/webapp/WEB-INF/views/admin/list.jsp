<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
 
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin list</title>
</head>
<body>

<h5> ${requestScope.message }</h5>
<h4> Admin details : ${sessionScope.user_details} </h4>
<h4> Vendor List</h4>
<h4> <a href=" <spring:url value='/admin/register'/> ">Add new Vendor </a> </h4>

<table style="background-color: cyan; margin: auto;" border="1">
		<caption>Vendor List</caption>
		
		<tr> 
		<th>Name </th>
		<th>Email </th>
		<th>Reg Amount</th>
		<th>reg date </th>
		<th> Update </th>
		<th> Delete </th>
		</tr> 
		<c:forEach var="v" items="${requestScope.vendor_list}">
			<tr>
				<td>${v.name}</td>
				<td>${v.email}</td>
				<td>${v.regAmount}</td>
				<td>${v.regDate}</td>
				<td> <a href=" <spring:url value='/admin/update?vid=${v.vendorId}'/>  "> Update</a>  </td>
				<td> <a href=" <spring:url value='/admin/delete?vid=${v.vendorId}'/>  ">Delete</a>  </td>
			</tr>
		</c:forEach>
	</table>
	
	
	<h4> <a href=" <spring:url value='/user/logout'/> ">LogOut</a> </h4>
</body>
</html>