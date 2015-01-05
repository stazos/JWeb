<div class="Box right">
	<center><h1>Ajouter un produit</h1></center>
	<form method="POST" action="product.do" enctype="multipart/form-data">
		<input type="text" name="title" placeholder="Nom du produit"  maxlength="15"/><br>
		<textarea name="description"></textarea><br>
		Select a file: <input type="file" name="file" accept="image/*"><br>
		<input type="number" name="price" placeholder="Prix" step="any"/><br>
		<input type="Submit" value="Envoyer">
	</form>
</div>
