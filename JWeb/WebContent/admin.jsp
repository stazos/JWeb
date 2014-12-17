<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Product" %>
<%@ page import="model.User" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='http://fonts.googleapis.com/css?family=Marck+Script' rel='stylesheet' type='text/css'>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/admin.css" />

<title>Insert title here</title>
</head>
<body>

	<%@ include file="pages/barTop.jsp"%>


	<%@ include file="admin/catalogue.jsp"%>
	<%@ include file="admin/news.jsp"%>
	<%@ include file="admin/products.jsp"%>
	<%@ include file="admin/users.jsp"%>

</body>
</html>