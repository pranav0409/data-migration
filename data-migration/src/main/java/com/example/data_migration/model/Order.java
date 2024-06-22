package com.example.data_migration.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "orders")
@Data
public class Order{

    @Id
    private String orderId;

    private String customerId;
    private List<String> productIds;
    private Date orderDate;
    private String status;


}

