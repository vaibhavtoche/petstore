package com.itv.petstore.entites;

import lombok.Data;

@Data

public class Product {
    private Integer id;
    private String name;
    private String Manufature;
    private Double price;
    private String description;
}
