package com.itv.petstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itv.petstore.entites.User;

public interface UserRepository  extends JpaRepository<User,Integer>{
}