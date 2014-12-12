/**
 * 
 */

function init()
{
	document.body.style.width = screen.width + "px";
}

function sendNews() {
	var $this = $(this);

	var title = $('#title').val();
	var description = $('#description').val();
	alert(title);
	if (title == null || title == "" || description == null || description == "")
		return false;
	else {
		$.ajax({
			url : $this.attr('action'),
			type : $this.attr('method'),
			data : $this.serialize(),
			success : function() {
				alert("News Envoyé !");
			},
			error : function(xhr, ajaxOptions, thrownError) {
				alert(xhr.status);
				alert(thrownError);
			}
		});
		return false;
	}
}