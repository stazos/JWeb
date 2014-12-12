<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="controller.Synchronize"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='http://fonts.googleapis.com/css?family=Marck+Script'
	rel='stylesheet' type='text/css'>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/inscription.js"></script>
<title>Luncher - Catalogue</title>
</head>
<body>
	<%
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		Synchronize.synDB();
	%>
	<div class="bar-top">
		<h1 class="title">Luncher - Catalogue</h1>
		<form class="login" method="POST" action="connexion.do">
			<input type="email" class="regular" name="login" placeholder="Email" />
			<input type="password" class="regular" name="password"
				placeholder="Mot de passe" /> <input type="Submit"
				value="Connexion" class="small">
		</form>
	</div>


	<center>
		<div class="container-inscription">
			<center>
				<h1>Inscription</h1>
			</center>
			<form method="POST" name="Form" action="inscription.do"
				onsubmit="return validateForm()">
				<input type="text" class="regular" name="firstname"
					placeholder="Prénom" /> <input type="text" class="regular"
					name="lastname" placeholder="Nom" /> <input type="email"
					name="email" placeholder="JohnDoe@example.com" /> <input
					type="password" class="regular" name="password"
					placeholder="Mot de passe" /> <input type="password"
					class="regular" name="validPassword" placeholder="Validation" /> <span><input
					type="checkbox" name="newsletter" value=true> S'inscrire à
					la newsletter</span> <input type="Submit" value="Envoyer">
			</form>
		</div>
	</center>

</body>
</html>