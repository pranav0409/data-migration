package com.example.data_migration.reader;

import com.example.data_migration.model.Customer;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class CustomerReader implements ItemReader<Customer> {

    @Autowired
    private MongoTemplate mongoTemplate;

    private static final String COLLECTION_NAME = "customers";

    private Iterator<Customer> customerIterator;

    @Override
    public Customer read() throws Exception {
        if (customerIterator == null) {
            customerIterator = mongoTemplate.findAll(Customer.class, COLLECTION_NAME).iterator();
        }
        if (customerIterator.hasNext()) {
            return customerIterator.next();
        } else {
            return null;
        }
    }
}

