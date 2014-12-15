<div class="bar-top">
	<h1>Luncher - Catalogue</h1>
	<%
	int i = 1;
    if (i != 1)
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
        <form id="connect" name="connect" class="login" method="POST" action="connexion.do">
			<input type="email" class="regular" id="login" name="login" placeholder="Email" />
			<input type="password" class="regular" id="mdp" name="mdp" placeholder="Mot de passe" />
			<input type="Submit" value="Connexion" class="regular">
		</form>
        <%
    }
	%>
</div>