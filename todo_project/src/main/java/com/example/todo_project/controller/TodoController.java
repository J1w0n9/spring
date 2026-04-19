package com.example.todo_project.controller;

import com.example.todo_project.domain.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private List<Todo> todoList = new ArrayList<>();
    private Long nextId = 1L;

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoList;
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                return todo;
            }
            return null;
        }
        return null;
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        todo.setId(nextId++);
        todoList.add(todo);
        return todo;
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@RequestBody Todo updatetodo, @PathVariable Long id) {
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                todo.setTitle(updatetodo.getTitle());
                todo.setCompleted(updatetodo.isCompleted());
                return todo;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Todo deleteTodo(@PathVariable Long id) {
        Todo d_todo = getTodoById(id);
        todoList.remove(d_todo);
        return d_todo;
    }

    @PatchMapping("/{id}/toggle")
    public Todo toggleTodo(@PathVariable Long id) {
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                todo.setCompleted(!todo.isCompleted());
                return todo;
            }
        }
        return null;
    }
}
