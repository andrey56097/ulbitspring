package com.example.ulbitspring.service;

import com.example.ulbitspring.dto.UserDto;
import com.example.ulbitspring.entity.User;
import com.example.ulbitspring.exception.UserAlreadyExistException;
import com.example.ulbitspring.exception.UserNotFoundException;

public interface UserService {
    User registration(User user) throws UserAlreadyExistException;
    UserDto getOne(Long id) throws UserNotFoundException;
    Long delete(Long id);
}
