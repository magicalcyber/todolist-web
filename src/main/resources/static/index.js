function completeTodo(e, id) {
	//alert(e.checked + '    ' + id);
	var resp = $.post('http://localhost:8080/api/todos/' + id + '/' + e.checked);

	resp.done(function(data) {
		//alert('Succes update');
	});
}

function createTodo() {
	var todo = $('#todo').val();
	var data = JSON.stringify({'todo': todo});
	
	$.ajax({
		method: 'PUT',
		contentType: 'application/json',
		data: data,
		url: 'http://localhost:8080/api/todos/'
	}).done(function(data){
		//alert('Success update');
		var span = '<span>' + data.todo + '</span>';
		var checkbox = '<input type="checkbox" onclick="completeTodo(this,\''+data.id +'\')" />';
		var label = '<label>' + checkbox + span + '</label>';
		var listItem = '<li>' + label + '</li>';
		
		$('#todo-list').append(listItem);
	})
	
}