<div id="module" class="admin-module">
	<center><h1>Ajouter un produit</h1></center>
	<form method="POST" name="Form" action="inscription.do" onsubmit="return validateForm()">
		<input type="text" name="name" placeholder="Nom du produit" /><br>
		<textarea name="description"></textarea><br>
		Select a file: <input type="file" name="img"><br>
		<input type="number" name="price" placeholder="Prix" /><br>
		<input type="Submit" value="Envoyer">
	</form>
</div>
