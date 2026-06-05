package com.example.todo_project.controller;

import com.example.todo_project.DTO.TodoCreateRequest;
import com.example.todo_project.DTO.TodoResponse;
import com.example.todo_project.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public List<TodoResponse> getAllTodos() {
        return todoService.getAllTodo();
    }

    @GetMapping("/{id}")
    public TodoResponse getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id);
    }

    @PostMapping
    public TodoResponse createTodo(@RequestBody TodoCreateRequest todo) {
        return todoService.createTodo(todo);
    }

    @PutMapping("/{id}")
    public TodoResponse updateTodo(@RequestBody TodoCreateRequest updatetodo, @PathVariable Long id) {
        return todoService.updateTodo(id, updatetodo);
    }

    @DeleteMapping("/{id}")
    public TodoResponse deleteTodo(@PathVariable Long id) {
        return todoService.deleteTodo(id);
    }

    @PatchMapping("/{id}/toggle")
    public TodoResponse toggleTodo(@PathVariable Long id) {
        return todoService.completeToggle(id);
    }
}
