<center>
	<div class="container-inscription">
		<center><h1>Inscription</h1></center>
		<form method="POST" name="Form" action="inscription.do" onsubmit="return validateForm()">
			<input type="text" class="regular" name="firstname" placeholder="Prénom" />
			<input type="text" class="regular" name="lastname" placeholder="Nom" />
			<input type="email" name="email" placeholder="JohnDoe@example.com" />
			<input type="password" class="regular" name="password" placeholder="Mot de passe" />
			<input type="password" class="regular" name="validPassword" placeholder="Validation" />
			<span><input type="checkbox" name="newsletter" value=true> S'inscrire à la newsletter</span>
			<input type="Submit" value="Envoyer">
		</form>
	</div>
</center>