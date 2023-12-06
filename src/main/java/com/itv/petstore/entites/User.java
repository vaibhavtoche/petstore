package com.itv.petstore.entites;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class User {
    private Integer id;
    @NotNull
    private String firstname,lastname,email,password,mobile,salary;
}