/**
 * 
 */

function init() {
	document.body.style.width = screen.width + "px";
}

function sendNews() {

	var obj = new Object();
	obj.title = $('#title').val();
	obj.description = $('#description').val();

	if (obj.title == null || obj.title == "" || obj.description == null
			|| obj.description == "")
		return false;
	else {
		$.post('../news.do', {
			title : obj.title,
			description : obj.description
		}, function(data) {
			console.log("data", data);
		})
		.fail(function(error) {
			console.log("error", error);
		});
		return false;
	}
}