<div class="boite users">
	<center><h1>Listes des Utilisateurs</h1></center>
	<%
		String title = null;
		String body = null;
		String author = null;
	%>
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