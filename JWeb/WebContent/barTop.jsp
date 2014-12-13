<div class="bar-top">
	<h1>Luncher - Catalogue</h1>
	<marquee class="defileParent" onmouseover="this.stop()" onmouseout="this.start()" direction="left" scrollamount="10">
		<span class="defile">TEXTE DÉFILANT</span>
	</marquee>
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