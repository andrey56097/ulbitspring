package com.example.ulbitspring.service.impl;

import com.example.ulbitspring.dto.TodoDto;
import com.example.ulbitspring.entity.Todo;
import com.example.ulbitspring.entity.User;
import com.example.ulbitspring.repository.TodoRepo;
import com.example.ulbitspring.repository.UserRepo;
import com.example.ulbitspring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    @Override
    public TodoDto createTodo(Todo todo, Long userId) {
        User user = userRepo.findById(userId).get();
        todo.setUser(user);
        return TodoDto.toDto(todoRepo.save(todo));
    }

    @Override
    public TodoDto completeTodo(Long id) {
        Todo todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return TodoDto.toDto(todoRepo.save(todo));
    }
}
