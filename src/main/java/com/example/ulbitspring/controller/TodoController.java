package com.example.ulbitspring.controller;

import com.example.ulbitspring.entity.Todo;
import com.example.ulbitspring.entity.User;
import com.example.ulbitspring.exception.UserAlreadyExistException;
import com.example.ulbitspring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody @Valid Todo todo, @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(todoService.createTodo(todo, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Exception occurred");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(todoService.completeTodo(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Exception occurred");
        }
    }
}
