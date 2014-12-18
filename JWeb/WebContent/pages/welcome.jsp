<%@page import="java.util.ArrayList"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='http://fonts.googleapis.com/css?family=Marck+Script' rel='stylesheet' type='text/css'>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/pages.css" />
<title>Insert title here</title>
</head>
<body>
	<%@ include file="barTop.jsp"%>

	<center>
		<div class="page-body">
			<div class="page-header">
				<h1>Catalogue 2015</h1>
			</div>
			<marquee id="newsContainer" class="defileParent" onmouseover="this.stop()"
				onmouseout="this.start()" direction="left" scrollamount="5">
			</marquee>

			<div class="page-container">
				<div class="table">
				<%
				ArrayList<Product> listProduct = (ArrayList<Product>) request.getAttribute("listProduct");
				if (listProduct != null)
					for (Product product : listProduct) {
					%>
					<div class="li">
						<div class="top purple white">
							<h1><% out.println(product.getName()); %></h1>
							<div class="circle pink"><% out.println(product.getPrice()); %>€</div>
						</div>
						<div class="bottom">
							<img width="199px" alt=""
								src="http://g-ecx.images-amazon.com/images/G/02/uk/pcs/aplus/kitchen/JamieOliverAnniversaryFrypan._V355316657_.jpg">
							<p>
								<span>Description</span>
							</p>
							<p><% out.println(product.getDescription()); %></p>
							<div class="sign">
								<input type="button" value="Voir"><input type="button"
									value="Ajouter au Panier">
							</div>
						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>
			<div class="page-footer">
				<center>
					<a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#">4</a>
					<a href="#">5</a>
				</center>
			</div>
		</div>
	</center>
</body>
</html>