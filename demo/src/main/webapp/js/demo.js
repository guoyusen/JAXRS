function testJsonAddBook() {
		$.ajax({
			type : "POST",
			url : "api/json/adduser",
			dataType : "json",
			contentType : 'application/json',
			data : JSON.stringify({
				"name" : "Java",
				"address" : "ddddddddddddddddd",

			}),
			success : function(data, textStatus, jqXHR) {
				alert("以下是从服务器返回的Book对象:\n\n" + JSON.stringify(data));
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert('error: ' + textStatus);
			}
		});
}