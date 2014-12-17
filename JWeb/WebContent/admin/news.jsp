<div class="boite">
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
</div>
