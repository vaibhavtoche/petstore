package com.itv.petstore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itv.petstore.dto.RegisterUserDto;
import com.itv.petstore.entites.User;
import com.itv.petstore.services.UserServices;
import jakarta.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserServices userServices;

    @PostMapping("/users")
    public ResponseEntity<?> registerUser(@RequestBody  @Valid RegisterUserDto registerUserDto)
    {
        return  new  ResponseEntity<>(this.userServices.registerUser(registerUserDto),HttpStatus.CREATED);
    }
    // retrawing data
    @GetMapping("/users")
   public ResponseEntity<?>getAll()
   {
    return ResponseEntity.ok(this.userServices.getAll());
   }
   //serching data
   //searching data
  @GetMapping("/users/{id}")
   public ResponseEntity<?>getById(@PathVariable Integer id)
   {
    User userExits=this.userServices.getById(id);
    if(userExits!=null)
    {
        return new ResponseEntity<>(userExits,HttpStatus.OK);
    }
    else{
        return new ResponseEntity<>("user not found",HttpStatus.NOT_FOUND);
    }
   }
   //update data
   @PutMapping("/users/{id}")
   public ResponseEntity<?>updateuser(@PathVariable Integer id,@RequestBody User user)
   {
    User userExits=this.userServices.getById(id);
    if(userExits!=null)
    {
    
        return new ResponseEntity<>(this.userServices.updateUser(id,user),HttpStatus.OK);
    }
    else{
        return new ResponseEntity<>("user not found",HttpStatus.NOT_FOUND);
    }
   }
   }
