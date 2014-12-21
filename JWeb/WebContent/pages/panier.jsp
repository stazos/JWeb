<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Collection"%>
<%@page import="model.Product"%>
<%@page import="model.News"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='http://fonts.googleapis.com/css?family=Marck+Script' rel='stylesheet' type='text/css'>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="css/pages.css" />
<link type="text/css" rel="stylesheet" href="css/table.css" />
<title>Mon panier</title>
</head>
<body class="bg">
	<%@ include file="barTop.jsp"%>
	<center>
	<div class="page-body">
			<div class="page-header">
				<h1>Mon panier - Récapitulatif</h1>
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
					ArrayList<Product> panier = (ArrayList<Product>) request.getAttribute("Panier");
					List<Integer> list = new ArrayList<Integer>();
					List<Integer> display = new ArrayList<Integer>();
		
					for (Product element : panier)
					{
						list.add(element.getId());
					}

				%>
				<form method="POST" action="rmPanier.do">
				<table>
					<thead>
						<tr>
							<td><h1><b>Article</b></h1></td>
							<td><h1><b>Image</b></h1></td>
							<td><h1><b>Description</b></h1></td>
							<td><h1><b>Quantité</b></h1></td>
							<td><h1><b>Prix</b></h1></td>
						</tr>
					</thead>
					<tbody>
						<%
						if (panier != null)
							for (Product product : panier)
							{
								if (!display.contains(product.getId()))
								{
									display.add(product.getId());
									int nb = Collections.frequency(list, product.getId());
									%>
									<tr>
										<td><%= product.getName() %></td>
										<td><img width="200px" alt="" src="http://g-ecx.images-amazon.com/images/G/02/uk/pcs/aplus/kitchen/JamieOliverAnniversaryFrypan._V355316657_.jpg"></td>
										<td><%= product.getDescription() %></td>
										<td><%= nb%></td>
										<td><%= nb * product.getPrice() %>€</td>
									</tr>
									<%
								}
							}
						%>
					</tbody>
				</table>
				<input type="submit" value="Tout Supprimer">
				</form>
			</div>
		</div>
	</center>
</body>
</html>