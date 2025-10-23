package com.jhj.vue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
	
	@Autowired
	private TodoRepository todoRepository;
	
	@PostMapping
	public Todo addTodo(@RequestBody Todo todo){
		todoRepository.save(todo);
		
		return todo;
	}
	
	@GetMapping
	public List<Todo> getAllTodos() {
		
		return todoRepository.findAll();
	}
	
	@DeleteMapping("{id}")
	public void deleteTodo(@PathVariable("id") Long id) {
		todoRepository.deleteById(id);
	}

}
