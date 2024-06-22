package com.example.data_migration.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;


@Document(collection = "products")
@Data
public class Product{

    @Id
    private String productId;

    private String name;
    private String description;
    private BigDecimal price;
    private String category;

    // Getters and setters

}
