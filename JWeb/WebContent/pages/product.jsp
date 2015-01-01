<%@page import="model.Reviews"%>
<%@page import="model.Product"%>
<%@page import="model.News"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='http://fonts.googleapis.com/css?family=Marck+Script' rel='stylesheet' type='text/css'>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/pages.css" />
<link type="text/css" rel="stylesheet" href="css/table.css" />
<title>Fiche produit</title>
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
				ArrayList<News> listNews = (ArrayList<News>) request.getAttribute("listNews");
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
				<%
				Product product = (Product) request.getAttribute("Product");
				if (product != null)
				{
					%>
					<table>
						<thead>
							<tr>
								<td><b><h1><%= product.getName() %></h1></b></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><img width="500px" alt="" src="<%= product.getPhoto() %>"></td>
							</tr>
							<tr>
								<td><%= product.getDescription() %></td>
							</tr>
							<tr><td><%= product.getPrice() %>€</td></tr>
						</tbody>
					</table>
					<%
				}
				%>
			</div>
		</div>
	</center>
	<center>
		<div class="module">
			<form method="POST" action="reviews.do">
				<h1>Ecrire un avis sur ce produit</h1>
				<textarea name="review" rows="5" cols="100"></textarea>
				<input type="hidden" name="idProduct" value="<%= product.getId()%>">
				<input type="submit" value="Envoyer">
			</form>
		</div>
		<div class="module">
			<h1>Les avis des utilisateurs</h1>
			<%
			ArrayList<Reviews> listReviews = (ArrayList<Reviews>) request.getAttribute("ListReviews");
			if (listReviews != null)
				for (Reviews review : listReviews)
				{
					%>
					<div class="review">
						De <%= review.getUserName() %>:<br>
					<%= review.getReview() %>
					</div>
					<%
				}
			%>
		</div>
	</center>
</body>
</html>