<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='http://fonts.googleapis.com/css?family=Marck+Script' rel='stylesheet' type='text/css'>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<title>Mon panier</title>
</head>
<body>

<center><h1>Mon Panier</h1></center>
	<table>
		<thead>
			<tr>
				<td><b>id</b></td>
				<td><b>Statut</b></td>
				<td><b>Prénom</b></td>
				<td><b>Nom</b></td>
				<td><b>Email</b></td>
				<td><b>Newsletter</b></td>
				<td><b>Admin/User</b></td>
				<td><b>Supprimer</b></td>
			</tr>

		</thead>
		<tbody>
			<form method="POST" action="updateUser.do">
				<input type="submit" value="Modifier">
				<%
				%>
			</form>
		</tbody>
	</table>

</body>
</html>