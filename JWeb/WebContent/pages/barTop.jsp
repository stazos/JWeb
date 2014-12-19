<div class="bar-top">
	<h1>Luncher - Catalogue</h1>
	<%
		Integer i = (Integer)session.getAttribute("idUser");
    	if (i != null)
    	{
        	%>
        	<div class="login">
        		<form method="GET" action="panier.do">
        			<input type="Submit" class="regular" value="Mon Panier(<%= request.getAttribute("inPanier")%>)">
        		</form>
        		<form method="POST" action="deconnexion.do">
        			<input type="Submit" class="regular" value="Déconnexion"></a>
        		</form>
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
	<center>
		<div class="success">
			<% 
				String msg = (String)request.getAttribute("success");
				if (msg != null)
					out.print(msg);
			%>
		</div>
		<div class="error">
			<% 
				msg = (String)request.getAttribute("error");
				if (msg != null)
					out.print(msg);
			%>
		</div>
	</center>
</div>