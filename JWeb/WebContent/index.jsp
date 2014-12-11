<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// This scriptlet declares and initializes "date"
		System.out.println("Evaluating date now");
		java.util.Date date = new java.util.Date();
	%>
	Hello! The time is now
	<%
		out.println(date);
		out.println("<BR>Your machine's address is ");
		//out.println(request.getRemoteHost());
	%>
</body>
</html>