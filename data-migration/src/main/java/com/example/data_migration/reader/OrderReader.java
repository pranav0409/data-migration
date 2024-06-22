package com.example.data_migration.reader;

import com.example.data_migration.model.Order;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class OrderReader implements ItemReader<Order> {

    @Autowired
    private MongoTemplate mongoTemplate;

    private static final String COLLECTION_NAME = "orders";

    private Iterator<Order> orderIterator;

    @Override
    public Order read() throws Exception {
        if (orderIterator == null) {
            orderIterator = mongoTemplate.findAll(Order.class, COLLECTION_NAME).iterator();
        }
        if (orderIterator.hasNext()) {
            return orderIterator.next();
        } else {
            return null;
        }
    }
}
