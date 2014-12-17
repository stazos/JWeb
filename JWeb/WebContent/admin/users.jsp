<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.*"%>
<%@page import="java.util.ArrayList"%>
<div class="boite users">
	<center>
		<h1>Listes des Utilisateurs</h1>
	</center>
	<table>
		<thead>
			<tr>
				<td>id</td>
				<td><center>Statut</center></td>
				<td><center>Prénom</center></td>
				<td><center>Nom</center></td>
				<td><center>Email</center></td>
				<td><center>Newsletter</center></td>
				<td><center>Admin/User</center></td>
				<td><center>Supprimer</center></td>
			</tr>

		</thead>
		<tbody>
			<form method="POST" action="updateUser.do">
			<%
				ArrayList<User> list = (ArrayList<User>) request.getAttribute("listUser");
				if (list != null)
					for (User user : list) {
						out.println("<tr><td>" + user.getId() + "</td>");
						if (user.getAdmin() == true)
							out.println("<td>Admin</td>");
						else
							out.println("<td>User</td>");
						out.println("<td>"+ user.getFirstname() + "</td>" + "<td>"
								+ user.getLastname() + "</td>" + "<td>"
								+ user.getEmail() + "</td>");
						if (user.getNewsletter() == true)
							out.println("<td><input type='checkbox' name='newsletter[" + user.getId()+ "]' checked /></td>");
						else
							out.println("<td><input type='checkbox' name='newsletter[" + user.getId()+ "]'/></td>");
						if (user.getAdmin() == true)
							out.println("<td><input type='checkbox' name='admin[" + user.getId()+ "]' checked /></td>");
						else
							out.println("<td><input type='checkbox' name='admin[" + user.getId()+ "]'/></td>");
						out.println("<td><input type='checkbox' name='delete[" + user.getId()+ "]' /></td>");
					}
			%>
				<input type="submit" value="Modifier">
			</form>
		</tbody>
	</table>
</div>