<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!//JSP declaration block
	int counter;
	String message = "Hello there!!";

	int testMe() {
		return ++counter;
	}

	//override life cycle method
	public void jspInit() {
		System.out.println("in jsp init");
	}%>
<body>
<h5>Message : <%= message %></h5>
<h5>Page Visit Counter : <%= testMe() %></h5>
</body>
<%!
//another jsp declaration block
 public void jspDestroy()
 {
	System.out.println("in jsp destroy");
 }
%>
</html>

            