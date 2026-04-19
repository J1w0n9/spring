package com.example.todo_project.DTO;
import com.example.todo_project.domain.Todo;
import lombok.*;

@Getter
@Setter
public class TodoResponse {
    private Long id;
    private String title;
    private boolean completed;

    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.completed = todo.isCompleted();
    }
}
