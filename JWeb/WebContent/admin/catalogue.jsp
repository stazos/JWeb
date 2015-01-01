<%@page import="model.*"%>
<%@page import="java.util.ArrayList"%>

<jsp:useBean id="shop" class="controller.LoadController" scope="session"/>
<jsp:setProperty name="shop" property="*"/>

<div class="Box right">
	<center><h1>Catalogue</h1></center>
	<table>
		<thead>
			<tr>
				<td><b>Id</b></td>
				<td><b>Titre</b></td>
				<td><b>Produit</b></td>
				<td><b>Description</b></td>
				<td><b>Prix</b></td>
				<td><b>Effacer</b></td>
			</tr>
		</thead>
		<tbody>
			<form method="POST" action="updateCatalog.do">
			<%
				ArrayList<Product> listProduct = shop.getListProduct();
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