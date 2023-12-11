package com.itv.petstore.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itv.petstore.dto.RegisterUserDto;
import com.itv.petstore.entites.User;
import com.itv.petstore.repositories.UserRepository;

@Service
public class UserServices {
    // private Map<Integer,User>users=new HashMap<>();
    // private AtomicInteger atomic=new AtomicInteger();
@Autowired
private UserRepository repository;
    public User registerUser(RegisterUserDto registerUserDto) {
        User user=new User();
        // user.setId(atomic.incrementAndGet());
        user.setFirstname(registerUserDto.getFirstname());
        user.setLastname(registerUserDto.getLastname());
        user.setEmail(registerUserDto.getEmail());
        user.setPassword(registerUserDto.getPassword());
        user.setMobile(registerUserDto.getMobile());
        user.setSalary(registerUserDto.getSalary());
        // users.put(user.getId(),user);
        repository.save(user);
        return user;
    }
    public List<User> getAll() {
        return repository.findAll();
       }
     public User getById(Integer id){
        return repository.findById(id).orElse(null);
     }  
     public void deleteuser(Integer id) 
     {
        repository.deleteById(id);
        
}
    public User updateUser(Integer id,User user)
        {
            user.setId(id);
            return repository.save(user);
        }

}