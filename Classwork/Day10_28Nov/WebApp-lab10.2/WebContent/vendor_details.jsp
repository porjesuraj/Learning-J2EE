<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%-- acct_bean.setVenorId(session.getAttribute("vendor_bean").getValidatedDetails().setVendorId()) --%>
<jsp:setProperty property="vendorId" value="${sessionScope.vendor_bean.validatedDetails.vendorId}" name="acct_bean"/>

<body>

<%-- display login successful message --%>

<h5> ${sessionScope.vendor_bean.message} </h5>

<h4>Vendor details :  ${sessionScope.vendor_bean.validatedDetails}  </h4>


<h5  align="center"> A/C Summary  </h5>
<%-- <h5> ${sessionScope.vendor_bean.validatedDetails.bankAccounts } </h5> --%>

<h3>${sessionScope.acct_bean.fetchAccounts()} </h3>

</body>
</html>