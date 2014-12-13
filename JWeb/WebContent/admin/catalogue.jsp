<div class="boite catalogue">
	<center>
		<h1>Catalogue</h1>
	</center>
	<%
		String title1 = null;
		String body1 = null;
		String author1 = null;
	%>
	<table>
		<tbody>
		<thead>
			<tr>
				<td>Titre</td>
				<td><center>Produit</center></td>
				<td><center>Description</center></td>
				<td><center>Prix</center></td>
				<td><center>Effacer</center></td>
			</tr>

		</thead>
		<%
			for (i = 0; i != 100; i++) {
		%>
		<tr>
			<td>titre</td>
			<td><img alt="" width="200px" src="http://ustensiles-en-inox.confort-domicile.com/album/Fotolia_27393624_XS.jpg"></td>
			<td>description</td>
			<td>33euros</td>
			<td><a href="#">Supprimer</a></td>
		</tr>
		<%
			}
		%>
		</tbody>
	</table>
</div>