<div class="bar-top">
	<h1>Luncher - Catalogue</h1>
	<%
		Integer id = (Integer)session.getAttribute("idUser");
		Boolean adm = (Boolean)session.getAttribute("admin");
    	if (id != null)
    	{
        	%>
        	<div class="login">
    	    	<%
        			if (adm != true)
        			{
	        		%>
       					
		        		<form style="display: inline-block;" method="POST" action="getAllProduct.do">
        					<input type="Submit" class="regular" value="Le Catalogue">
        				</form>
        				<form style="display: inline-block;" method="GET" action="panier.do">
        					<input type="Submit" class="regular" value="Mon Panier(<%= request.getAttribute("inPanier")%>)">
        				</form>
        				
        			<%
        			}
        		%>
        		<form style="display: inline-block;" method="POST" action="deconnexion.do">
        			<input type="Submit" class="regular" value="Déconnexion">
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