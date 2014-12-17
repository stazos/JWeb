/**
 * 
 */

function init() {
	document.body.style.width = screen.width + "px";
}

function changeNewsletter(id) {
	var str = "{\"id\" : \"" + id + "\"}";
	console.log(str);
	var obj = JSON.stringify(str);
    $.ajax({
        url: '../changeNewsletter.do', // Le nom du fichier indiqué dans le formulaire
        type: 'POST', // La méthode indiquée dans le formulaire (get ou post)
        data: obj,
        success: function(html) { // Je récupère la réponse du fichier PHP
            alert("Envoyé"); // J'affiche cette réponse
        }
    });
}


$.ajax({
	dataType : "json",
	url : '../getUser.do',
	type : 'GET',
	success : function(data) {
		var tr;
		for (i = 0; i < data.length; i++) {
			tr = "";
			tr = "<tr>" + "<td>" + data[i].id + "</td>";
			if (data[i].admin == true)
				tr += "<td>Admin</td>";
			else
				tr += "<td>User</td>";
			tr +=	"<td>" + data[i].firstname  + "</td>" +
					"<td>" + data[i].lastname + "</td>" +
					"<td>" + data[i].email + "</td>";
			
			if (data[i].newsletter == true)
				tr += "<td><input type='checkbox' value='true' onclick=\"changeNewsletter(" + data[i].id + ")\" checked></td>";
			else
				tr += "<td><input type='checkbox' value='false' onclick=\"changeNewsletter(" + data[i].id + ")\"></td>";

			tr += "<td><select>";
			if (data[i].admin == true)
				tr += "<option value='admin' selected>Admin</option><option value='user'>User</option>";
			else
				tr += "<option value='admin'>Admin</option><option value='user' selected>User</option>";
			tr += "</select></td>";
	
			tr += "<td><a href='#'>Supprimer</a></td></tr>";
			document.getElementById("listUsers").innerHTML += tr;
		}
	},
	error : function(xhr, ajaxOptions, thrownError) {
		alert(xhr.status);
		alert(thrownError);
	}
});

$(document).ready( function () {
	$('#FormNews').on('submit', function(e) {
        e.preventDefault(); // J'empêche le comportement par défaut du navigateur, c-à-d de soumettre le formulaire
 
        var $this = $(this); // L'objet jQuery du formulaire
 
        // Je récupère les valeurs
        var pseudo = $('#titleNews').val();
        var mail = $('#descriptionNews').val();
 
        // Je vérifie une première fois pour ne pas lancer la requête HTTP
        // si je sais que mon PHP renverra une erreur
        if(pseudo === '' || mail === '') {
            alert('Les champs doivent êtres remplis');
        } else {
            // Envoi de la requête HTTP en mode asynchrone
            $.ajax({
                url: '../news.do', // Le nom du fichier indiqué dans le formulaire
                type: 'POST', // La méthode indiquée dans le formulaire (get ou post)
                data: $this.serialize(), // Je sérialise les données (j'envoie toutes les valeurs présentes dans le formulaire)
                success: function(html) { // Je récupère la réponse du fichier PHP
                    alert("Envoyé"); // J'affiche cette réponse
                }
            });
        }
    });
	
	$('#FormProduct').on('submit', function(e) {
        e.preventDefault();

        var $this = $(this);
        var title = $('#titleProduct').val();
        var description = $('#descriptionProduct').val();
        var file = $('#fileProduct').val();
        var price = $('#priceProduct').val();
        
        if(title === '' || description === '' || price === '') {
            alert('Les champs doivent êtres remplis');
        }
        else {
        	var fileSelect = document.getElementById("fileProduct").files[0];
        	var reader = new FileReader();
             reader.onload = function(e) {
                     console.log(e.target.result);
                 	var fd = new FormData();	
                	fd.append("titleProduct", title);
                	fd.append("descriptionProduct", description);
                	fd.append("priceProduct", price);
                	fd.append("fileProduct", e.target.result);
                    $.ajax({
                        url: '../product.do', // Le nom du fichier indiqué dans le formulaire
                        type: 'POST', // La méthode indiquée dans le formulaire (get ou post)
                        contentType: false,
                        processData: false,
                        data: fd,
                        success: function(html) { // Je récupère la réponse du fichier PHP
                            alert("Envoyé"); // J'affiche cette réponse
                        }
                    });
             };
             reader.readAsDataURL(fileSelect);
        }
    });
});