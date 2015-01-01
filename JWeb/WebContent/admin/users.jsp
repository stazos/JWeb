<%@page import="model.*"%>
<%@page import="java.util.ArrayList"%>

<jsp:useBean id="shop" class="controller.LoadController" scope="session"/>
<jsp:setProperty name="shop" property="*"/>

<div class="Box left">
	<center><h1>Liste des Utilisateurs</h1></center>
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
				ArrayList<User> listUser = shop.getUsers();
				if (listUser != null)
					for (User user : listUser) {
						out.println("<tr><td>" + user.getId() + "</td>");
						if (user.getAdmin() == true)
							out.println("<td>Admin</td>");
						else
							out.println("<td>User</td>");
						out.println("<td>"+ user.getFirstname() + "</td>" + "<td>"
								+ user.getLastname() + "</td>" + "<td>"
								+ user.getEmail() + "</td>");
						if (user.getNewsletter() == true)
							out.println("<td><input type='checkbox' name='newsletter' value='" + user.getId() + "' checked /></td>");
						else
							out.println("<td><input type='checkbox' name='newsletter'value='" + user.getId() + "'/></td>");
						if (user.getAdmin() == true)
							out.println("<td><input type='checkbox' name='admin' value='" + user.getId() + "' checked /></td>");
						else
							out.println("<td><input type='checkbox' name='admin' value='" + user.getId() + "'/></td>");
						out.println("<td><input type='checkbox' name='delete' value='" + user.getId() + "' /></td></tr>");
					}
			%>
				
			</form>
		</tbody>
	</table>
</div>