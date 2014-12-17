<div class="bar-top">
	<h1>Luncher - Catalogue</h1>
	
	<div class="error">
		<% 
			String msg = (String)request.getAttribute("error");
			if (msg != null)
				out.print(msg);
		%>
	</div>
	
	<%
		Integer i = (Integer)session.getAttribute("idUser");
    	if (i != null)
    	{
        	%>
        	<div class="login">
        		<a href="#">Mon Panier</a>
        		<a href="#">Déconnexion</a>
        	</div>
        	<%
    	}
    	else
    	{
        	%>
        	<form class="login" method="POST" action="connexion.do">
				<input type="email" class="regular" name="login" placeholder="Email" />
				<input type="password" class="regular" name="password" placeholder="Mot de passe" />
				<input type="Submit" value="Connexion" class="regular">
			</form>
        	<%
    	}
	%>
</div>