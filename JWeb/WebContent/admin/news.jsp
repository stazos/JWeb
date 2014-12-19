<%@page import="model.News"%>
<%@page import="java.util.ArrayList"%>
<div class="Box left">
	<center><h1>Ecrire une nouvelle</h1></center>
	<form method="POST" action="news.do">
		<input type="text" name="title" placeholder="Titre de la nouvelle" /><br>
		<textarea name="description"></textarea><br>
		<input type="submit" value="Envoyer">
	</form>
	<div class="success">
		<% 
			String success = (String)request.getAttribute("success");
			if (success != null)
				out.print(success);
		%>
	</div>
	<div class="error">
		<% 
			String error = (String)request.getAttribute("error");
			if (error != null)
				out.print(error);
		%>
	</div>
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
			<form method="POST" action="updateNews.do">
			<input type="submit" value="Modifier">
			<%
				ArrayList<News> listNews = (ArrayList<News>) request.getAttribute("listNews");
				if (listNews != null)
					for (News news : listNews) {
						out.println("<tr><td>" + news.getId() + "</td>");
						out.println("<td>" + news.getTitle() + "</td>");
						out.println("<td>" + news.getDescription() + "</td>");
						out.println("<td>" + news.getDate() + "</td>");
						out.println("<td><input type='checkbox' name='delete' value='" + news.getId() + "' /></td></tr>");
					}
			%>
			</form>
		</tbody>
	</table>
</div>
