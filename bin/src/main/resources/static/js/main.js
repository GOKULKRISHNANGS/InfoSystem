function vote(issueID) {

	var issueId = $("#issueId").val();

	var postUrl = "vote/" + issueID;

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : postUrl,
		data : JSON.stringify(issueId),
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {
			setTimeout(function() {
				window.location.reload();
			});
		},
		error : function(e) {

		}
	});

}

function comment(issueID) {

	var commentId = "comment" + issueID;
	var comment = {};
	var commentText = $("#" + commentId).val();
	comment["commentText"] = commentText;
	var postUrl = "comment/" + issueID;
	var jsonData = JSON.stringify(commentText);
	if(commentText.length > 5){
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : postUrl,
		data : jsonData,
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {
			setTimeout(function() {
				window.location.reload();
			}, 2);
		},
		error : function(e) {

		}
	});
	} else {
		alert("Comments should be greater than 5 letters");
	}
}