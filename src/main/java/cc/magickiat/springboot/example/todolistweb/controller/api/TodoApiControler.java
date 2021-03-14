package cc.magickiat.springboot.example.todolistweb.controller.api;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.magickiat.springboot.example.todolistweb.entity.Todo;
import cc.magickiat.springboot.example.todolistweb.repository.TodoRepository;

@RestController
@RequestMapping("/api/todos")
public class TodoApiControler {

	private TodoRepository todoRepository;

	public TodoApiControler(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@PutMapping
	public Todo createTodo(@RequestBody Todo todo) {
		if (todo.getId() == null) {
			todo.setCreatedDateTime(LocalDateTime.now());
			todoRepository.save(todo);
		}

		return todo;
	}

	@PostMapping("/{id}/{complete}")
	public Todo completeTodo(@PathVariable UUID id, @PathVariable boolean complete) {
		Optional<Todo> todoInDb = todoRepository.findById(id);
		if (todoInDb.isPresent()) {
			Todo todo = todoInDb.get();
			todo.setComplete(complete);
			if (complete) {
				todo.setCompletedDateTime(LocalDateTime.now());
			} else {
				todo.setCompletedDateTime(null);
			}
			todoRepository.save(todo);
			return todo;
		}
		return null;
	}

}
