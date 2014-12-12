<center>
	<div class="container-inscription">
		<center><h1>Inscription</h1></center>
		<form method="POST" id="Form" name="Form" action="inscription.do" onsubmit="sendFormRegister()">
			<input type="text" class="regular" id="firstname" name="firstname" placeholder="Prénom" />
			<input type="text" class="regular" id="lastname" name="lastname" placeholder="Nom" />
			<input type="email" id="email" name="email" placeholder="JohnDoe@example.com" />
			<input type="password" class="regular" id="password" name="password" placeholder="Mot de passe" />
			<input type="password" class="regular" id="validPassword" name="validPassword" placeholder="Validation" />
			<span><input type="checkbox" id="newsletter" name="newsletter" value=true> S'inscrire à la newsletter</span>
			<input type="Submit" id="send" value="Envoyer">
		</form>
	</div>
</center>