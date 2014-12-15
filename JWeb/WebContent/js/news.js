/**
 * 
 */

$.ajax({
	dataType : "json",
	url : '../news.do',
	type : 'GET',
	success : function(data) {
		console.log(data)
		for (i = 0; i < data.length; i++) {
			var span = "<span class=\"defile\">" + data[i].date + data[i].title
					+ data[i].description + "</span>";
			document.getElementById("newsContainer").innerHTML += span;
		}
	},
	error : function(xhr, ajaxOptions, thrownError) {
		console.log("fail");
		alert(xhr.status);
		alert(thrownError);
	}
});