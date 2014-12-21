<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.*"%>

<jsp:useBean id="user" class="controller.LoadController" scope="session"/>
<jsp:setProperty name="user" property="*"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='http://fonts.googleapis.com/css?family=Marck+Script' rel='stylesheet' type='text/css'>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/pages.css" />
<title>Bienvenue</title>
</head>
<body class="bg">
	<%@ include file="barTop.jsp"%>

	<center>
		<div class="page-body">
			<div class="page-header">
				<h1>Catalogue 2015</h1>
			</div>
			<marquee id="newsContainer" class="defileParent" onmouseover="this.stop()" onmouseout="this.start()" direction="left" scrollamount="5">
			<%
				ArrayList<News> listNews = user.getNews();//(ArrayList<News>) request.getAttribute("listNews");
				if (listNews != null)
					for (News news : listNews)
					{
						%>
							<span class="defile"><%= news.getDate()%> <%= news.getTitle()%> <%= news.getDescription()%></span>
						<%
					}
			%>
			</marquee>

			<div class="page-container">
				<div class="table">
				<%
				ArrayList<Product> listProduct = user.getListProduct();//(ArrayList<Product>) request.getAttribute("listProduct");
				if (listProduct != null)
					for (Product product : listProduct) {
					%>
					<div class="li">
						<div class="top purple white">
							<h1><%= product.getName() %></h1>
							<div class="circle pink"><%= product.getPrice() %>€</div>
						</div>
						<div class="bottom">
							<img width="199px" alt=""
								src="http://g-ecx.images-amazon.com/images/G/02/uk/pcs/aplus/kitchen/JamieOliverAnniversaryFrypan._V355316657_.jpg">
							<p>
								<span>Description</span>
							</p>
							<p><%= product.getDescription() %></p>
							<div class="sign">
								<form method="POST" action="getProduct.do">
									<input type="Submit" value="Voir">
									<input type="hidden" name="id" value="<%= product.getId()%>">
								</form>
								<form method="POST" action="panier.do">
									<input type="Submit" value="Ajouter au Panier">
									<input type="hidden" name="idProduct" value="<%= product.getId()%>">
								</form>
							</div>
						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>
		</div>
	</center>
</body>
</html>