<%@page import="java.util.Date"%>
<%@page import="javax.swing.text.DateFormatter"%>
<div id="module" class="admin-module">
	<%
		String title = null;
		String body = null;
		String author = null;
	%>
	<table style="border: 1px solid black; cellpadding: '0'; cellspacing: '0'; overflow: scroll;">
		<thead>
			<tr>
				<td><center>id</center></td>
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
		<%
		for (i = 0; i != 10; i++)
			{
			%>
			<tr>
				<td><%=(title != null) ? title : "titre non spécifié"%></td>
				<td><%=(body != null) ? body : "corps non spécifié"%></td>
				<td><%=(body != null) ? body : "corps non spécifié"%></td>
				<td><%=(body != null) ? body : "corps non spécifié"%></td>
				<td><%=(body != null) ? body : "corps non spécifié"%></td>
				<td><input type="checkbox" /></td>
				<td><a href="#">PasserAdmin</a></td>
				<td><a href="#">Oui</a></td>
			</tr>
			<%
			}
		%>
		</tbody>
	</table>
</div>