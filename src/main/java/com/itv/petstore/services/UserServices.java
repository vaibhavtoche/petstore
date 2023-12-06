package com.itv.petstore.services;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.itv.petstore.dto.RegisterUserDto;
import com.itv.petstore.entites.User;

@Service
public class UserServices {
    private Map<Integer, User> users = new HashMap<>();
    private AtomicInteger atomic = new AtomicInteger();

    public User registerUser(RegisterUserDto registerUserDto) {
        User user = new User();
        user.setId(atomic.incrementAndGet());
        user.setFirstname(registerUserDto.getFirstname());
        user.setLastname(registerUserDto.getLastname());
        user.setEmail(registerUserDto.getEmail());
        user.setPassword(registerUserDto.getPassword());
        user.setMobile(registerUserDto.getMobile());
        user.setSalary(registerUserDto.getSalary());
        users.put(user.getId(), user);
        return user;
    }
}