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

<title>Insert title here</title>
</head>
<body>
	<div class="bar-top">
		<h1 class="title">Luncher - Catalogue</h1>
		<form class="login" method="POST" action="SelectCoffee.do">
			<input type="email" class="regular" name="login" placeholder="Email" />
			<input type="password" class="regular" name="password" placeholder="Mot de passe" />
			<input type="Submit" value="Connexion" class="small">
		</form>
	</div>
	
	
	
	<div class="subscribe">
		<center class="sub">
			<h1>Inscription</h1>
			<form action="POST" action="SendSubscribe.do">
				<input type="text" class="regular" name="fistrname" placeholder="Prénom" />
				<input type="text" class="regular" name="lastname" placeholder="Nom" />
				<input type="email" name="email" placeholder="JohnDoe@example.com" />
				<input type="text" class="small" name="fistrname" placeholder="Jour" />
				<input type="text" class="small" name="fistrname" placeholder="Mois" />
				<input type="text" class="small" name="fistrname" placeholder="Année" />
				<input type="Submit" value="Envoyer">
			</form>
		</center>
	</div>


</body>
</html>