package cc.magickiat.springboot.example.todolistweb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cc.magickiat.springboot.example.todolistweb.entity.Todo;
import cc.magickiat.springboot.example.todolistweb.repository.TodoRepository;

@Controller
public class IndexControler {

	private TodoRepository todoRepository;

	public IndexControler(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	@GetMapping("/")
	public String index(Model model) {
		List<Todo> todos = todoRepository.findAll();
		model.addAttribute("todos", todos);
		return "index";
	}
}
