<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="utility.DbUtility" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href='http://fonts.googleapis.com/css?family=Marck+Script' rel='stylesheet' type='text/css'>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/inscription.css" />
	
	<title>Luncher - Catalogue</title>
</head>
<body>
	<%
		try {
		Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
		System.out.println(e.getMessage());
			}
		DbUtility.synDB();
	%>
	<%@ include file="pages/barTop.jsp" %>
	<%@ include file="pages/inscription.jsp" %>
	
	<a href="admin/admin.jsp">Admin</a>
	<a href="pages/welcome.jsp">Welcome</a>
</body>
</html>
