<%@page import="model.News"%>
<%@page import="java.util.ArrayList"%>

<jsp:useBean id="shop" class="controller.LoadController" scope="session"/>
<jsp:setProperty name="shop" property="*"/>

<div class="Box left">
	<center><h1>Liste des News</h1></center>
	<form method="POST" action="updateNews.do">
		<input type="submit" value="Modifier">
		<table>
			<thead>
				<tr>
					<td><b>Id</b></td>
					<td><b>Title</b></td>
					<td><b>Description</b></td>
					<td><b>Date</b></td>
					<td><b>Supprimer</b></td>
				</tr>
	
			</thead>
			<tbody>
				<%
					ArrayList<News> listNews = shop.getNews();
					if (listNews != null)
						for (News news : listNews) {
							out.println("<tr><td>" + news.getId() + "</td>");
							out.println("<td>" + news.getTitle() + "</td>");
							out.println("<td>" + news.getDescription() + "</td>");
							out.println("<td>" + news.getDate() + "</td>");
							out.println("<td><input type='checkbox' name='delete' value='" + news.getId() + "' /></td></tr>");
						}
				%>
			</tbody>
		</table>
	</form>
</div>