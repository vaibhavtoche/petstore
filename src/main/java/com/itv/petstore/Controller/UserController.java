package com.itv.petstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itv.petstore.dto.RegisterUserDto;
import com.itv.petstore.services.UserServices;
import jakarta.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserServices userServices;

    @PostMapping("/users")
    public com.itv.petstore.entites.User registerUser(@RequestBody @Valid RegisterUserDto registerUserDto) 
    {
        return this.userServices.registerUser(registerUserDto);
    }
}