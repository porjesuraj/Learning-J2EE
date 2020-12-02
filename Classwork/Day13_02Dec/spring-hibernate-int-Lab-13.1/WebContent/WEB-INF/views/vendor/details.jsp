<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5> Vendor Login Successful </h5>

<h4> Vendor details :${sessionScope.user_details}  </h4>

<h5> <a href="/vendor/list"> Vendor list</a> </h5>
</body>
</html>