<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Boolean admin = (Boolean)session.getAttribute("admin");
	if (admin != true)
	{
		%><jsp:forward page="index.jsp"/><%
	}
%>
<%@ page import="model.Product" %>
<%@ page import="model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='http://fonts.googleapis.com/css?family=Marck+Script' rel='stylesheet' type='text/css'>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/admin.css" />
<link type="text/css" rel="stylesheet" href="css/table.css" />

<title>Panneau de contrôle</title>
</head>
<body>
	<%@ include file="pages/barTop.jsp"%>

	<jsp:include page="admin/news.jsp" />
	<jsp:include page="admin/products.jsp" />
	<jsp:include page="admin/listNews.jsp" />
	<jsp:include page="admin/catalogue.jsp" />
	<jsp:include page="admin/users.jsp" />

</body>
</html>