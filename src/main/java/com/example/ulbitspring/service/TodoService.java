package com.example.ulbitspring.service;

import com.example.ulbitspring.dto.TodoDto;
import com.example.ulbitspring.entity.Todo;

public interface TodoService {
    TodoDto createTodo(Todo todo, Long userId);
    TodoDto completeTodo(Long id);
}
