//package com.example.data_migration.reader;
//
//
//import com.example.data_migration.model.Customer;
//import com.example.data_migration.model.Order;
//import com.example.data_migration.model.Product;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoCollection;
//import jakarta.annotation.PostConstruct;
//import org.bson.Document;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.convert.MongoConverter;
//import org.springframework.stereotype.Component;
//
//
//
//@Component
//public class MongoDBItemReader {
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @Autowired
//    private MongoClient mongoClient;
//
//    private MongoConverter mongoConverter;
//
//    @PostConstruct
//    public void init() {
//        this.mongoConverter = mongoTemplate.getConverter();
//    }
//
//    public ItemReader<Customer> customerReader() {
//        return new ItemReader<Customer>() {
//            @Override
//            public Customer read() throws Exception {
//                // Read data from MongoDB Customers collection
//                MongoCollection<Document> collection = mongoTemplate.getCollection("Customers");
//                Document document = collection.find().first();
//                if (document != null) {
//                    return mongoConverter.read(Customer.class, document);
//                } else {
//                    return null;
//                }
//            }
//        };
//    }
//
//    public ItemReader<Order> orderReader() {
//        return new ItemReader<Order>() {
//            @Override
//            public Order read() throws Exception {
//                // Read data from MongoDB Orders collection
//                MongoCollection<Document> collection = mongoTemplate.getCollection("Orders");
//                Document document = collection.find().first();
//                if (document != null) {
//                    return mongoConverter.read(Order.class, document);
//                } else {
//                    return null;
//                }
//            }
//        };
//    }
//
//    public ItemReader<Product> productReader() {
//        return new ItemReader<Product>() {
//            @Override
//            public Product read() throws Exception {
//                // Read data from MongoDB Products collection
//                MongoCollection<Document> collection = mongoTemplate.getCollection("Products");
//                Document document = collection.find().first();
//                if (document != null) {
//                    return mongoConverter.read(Product.class, document);
//                } else {
//                    return null;
//                }
//            }
//        };
//    }
//}
