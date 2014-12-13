<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='http://fonts.googleapis.com/css?family=Marck+Script'
	rel='stylesheet' type='text/css'>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/pages.css" />
<title>Insert title here</title>
</head>
<body>
	<%@ include file="barTop.jsp"%>


	<center>
		<div class="page-body">
			<div class="page-header">
				<h1>Catalogue 2015</h1>
			</div>
			<marquee class="defileParent" onmouseover="this.stop()"
				onmouseout="this.start()" direction="left" scrollamount="5">
				<span class="defile">Nouveau Produit : Un magnifique god au
					couleur arc-en-ciel est disponible dans notre Catalogue ! Venez
					vite l'achetez !</span>
			</marquee>

			<div class="page-container">
				<div class="table">
					<%
						for (i = 0; i != 10; i++) {
					%>
					<div class="li">
						<div class="top purple white">
							<h1>Poêle</h1>
							<div class="circle pink">4€</div>
						</div>
						<div class="bottom">
							<img width="199px" alt=""
								src="http://g-ecx.images-amazon.com/images/G/02/uk/pcs/aplus/kitchen/JamieOliverAnniversaryFrypan._V355316657_.jpg">
							<p>
								<span>Description</span>
							</p>
							<p>Jolie peite description qui sert juste de test, c'est
								énorme</p>
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