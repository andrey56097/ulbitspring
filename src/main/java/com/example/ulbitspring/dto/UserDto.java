package com.example.ulbitspring.dto;

import com.example.ulbitspring.entity.Todo;
import com.example.ulbitspring.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDto {
    private Long id;
    private String username;
    private List<TodoDto> todos;

    public static UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setTodos(user.getTodos().stream().map(TodoDto::toDto).collect(Collectors.toList()));
        return userDto;
    }

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<TodoDto> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoDto> todos) {
        this.todos = todos;
    }
}
