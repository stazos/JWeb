/**
 * 
 */

function validateForm() {
	var firstname = document.forms["Form"]["firstname"].value;
	var lastname = document.forms["Form"]["lastname"].value;
	var email = document.forms["Form"]["email"].value;
	var password = document.forms["Form"]["password"].value;
	var validPassword = document.forms["Form"]["validPassword"].value;
	
	if (firstname == null || firstname == "" && lastname == null || lastname == "", email == null || email == "", password == null || password == "", validPassword == null || validPassword == "")
		return false;
	if (validPassword != password)
	{
		document.forms["Form"]["password"].style.border = '1px solid red';
		document.forms["Form"]["validPassword"].style.border = '1px solid red';
		setTimeout(function()
				{
					document.forms["Form"]["password"].style.border = 'none';
					document.forms["Form"]["validPassword"].style.border = 'none';
				}, 3000);
		return false;
	}
}