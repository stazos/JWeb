<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	%>
	Hello! The time is now
	<%
		/* Connexion à la base de données */
		String url = "jdbc:mysql://localhost/jweb";
		String utilisateur = "root";
		String motDePasse = "admin";
		Connection connexion = null;
		try {
			connexion = DriverManager.getConnection(url, utilisateur,
					motDePasse);
			/* Création de l'objet gérant les requêtes */
			Statement statement = connexion.createStatement();
			
			/* Ici, nous placerons nos requêtes vers la BDD */
			/* ... */

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (connexion != null)
				try {
					/* Fermeture de la connexion */
					connexion.close();
				} catch (SQLException ignore) {
					/* Si une erreur survient lors de la fermeture, il suffit de l'ignorer. */
				}
		}
	%>

	<%
		// This scriptlet declares and initializes "date"
		System.out.println("Evaluating date now");
		java.util.Date date = new java.util.Date();
		out.println(date);
		out.println("<BR>Your machine's address is ");
		//out.println(request.getRemoteHost());
	%>
</body>
</html>