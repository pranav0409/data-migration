package com.example.data_migration.reader;

import com.example.data_migration.model.Product;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class ProductReader implements ItemReader<Product> {

    @Autowired
    private MongoTemplate mongoTemplate;

    private static final String COLLECTION_NAME = "products";

    private Iterator<Product> productIterator;

    @Override
    public Product read() throws Exception {
        if (productIterator == null) {
            productIterator = mongoTemplate.findAll(Product.class, COLLECTION_NAME).iterator();
        }
        if (productIterator.hasNext()) {
            return productIterator.next();
        } else {
            return null;
        }
    }
}

