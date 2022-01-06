package com.example.ulbitspring.service.impl;

import com.example.ulbitspring.dto.UserDto;
import com.example.ulbitspring.entity.User;
import com.example.ulbitspring.exception.UserAlreadyExistException;
import com.example.ulbitspring.exception.UserNotFoundException;
import com.example.ulbitspring.repository.UserRepo;
import com.example.ulbitspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public User registration(User user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("User with this username is exist");
        }
        return userRepo.save(user);
    }

    @Override
    public UserDto getOne(Long id) throws UserNotFoundException {
        User user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return UserDto.toDto(user);
    }

    @Override
    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
