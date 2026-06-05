package com.example.todo_project.service;


import com.example.todo_project.DTO.TodoCreateRequest;
import com.example.todo_project.DTO.TodoResponse;
import com.example.todo_project.domain.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private List<Todo> todoList = new ArrayList<>();
    private Long nextId = 1L;

    public List<TodoResponse> getAllTodo() {
        List<TodoResponse> todoResponseList = new ArrayList<>();
        for(Todo todo : todoList) {
            todoResponseList.add(new TodoResponse(todo));
        }
        return todoResponseList;
    }

    public TodoResponse getTodoById(Long id) {
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                return new TodoResponse(todo);
            }
        }
        return null;
    }

    public TodoResponse createTodo(TodoCreateRequest request) {
        Todo todo = new Todo(nextId, request.getTitle(), false);
        nextId++;
        todoList.add(todo);
        return new TodoResponse(todo);
    }

    public TodoResponse updateTodo(Long id, TodoCreateRequest request) {
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                todo.setTitle(request.getTitle());
                return new TodoResponse(todo);
            }
        }
        return null;
    }

    public TodoResponse completeToggle(Long id) {
        for (Todo todo : todoList) {
            if (todo.getId().equals(id)) {
                todo.setCompleted(true);
                return new TodoResponse(todo);
            }
        }
        return null;
    }

    public TodoResponse deleteTodo(Long id) {
        for (Todo removed_todo : todoList) {
            if (removed_todo.getId().equals(id)) {
                todoList.remove(removed_todo);
                return new TodoResponse(removed_todo);
            }
        }
        return null;
    }
}
