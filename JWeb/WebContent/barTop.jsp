<div class="bar-top">
	<h1 class="title">Luncher - Catalogue</h1>
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
        <form class="login" method="POST" action="connexion.do">
			<input type="email" class="regular" name="login" placeholder="Email" />
			<input type="password" class="regular" name="password" placeholder="Mot de passe" />
			<input type="Submit" value="Connexion" class="small">
		</form>
        <%
    }
	%>
</div>