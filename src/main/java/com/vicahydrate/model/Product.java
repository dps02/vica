package com.vicahydrate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products") // Maps the class to your MySQL table name
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Or Long, depending on your DB schema

    private String name;
    private String description;
    private String sizeLabel;
    private String features;
    private double price;
    private boolean inStock;
}