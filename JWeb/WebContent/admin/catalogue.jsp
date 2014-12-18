<%@page import="model.*"%>
<%@page import="java.util.ArrayList"%>
<div class="Box right">
	<center><h1>Catalogue</h1></center>
	<table>
		<thead>
			<tr>
				<td>Id</td>
				<td>Titre</td>
				<td><center>Produit</center></td>
				<td><center>Description</center></td>
				<td><center>Prix</center></td>
				<td><center>Effacer</center></td>
			</tr>
		</thead>
		<tbody>
			<form method="POST" action="updateCatalog.do">
			<%
				ArrayList<Product> listProduct = (ArrayList<Product>) request.getAttribute("listProduct");
				if (listProduct != null)
					for (Product product : listProduct) {
						out.println("<tr><td>" + product.getId() + "</td>");
						out.println("<td>" + product.getName() + "</td>");
						out.println("<td>" + product.getPhoto() + "</td>");
						out.println("<td>" + product.getDescription() + "</td>");
						out.println("<td>" + product.getPrice() + "</td>");
						out.println("<td><input type='checkbox' name='delete' value='" + product.getId() + "'></td></tr>");
					}
			%>
				<input type="submit" value="Modifier">
			</form>
		</tbody>
	</table>
	<div class="success">
		<% 
			String successRmProduct = (String)request.getAttribute("successRmProduct");
			if (successRmProduct != null)
				out.print(successRmProduct);
		%>
	</div>
</div>