package com.example.data_migration.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
@Data
public class Customer{

    @Id
    private String customerId;

    private String firstName;
    private String lastName;
    private String email;
    private String address;

    // Getters and setters
}

