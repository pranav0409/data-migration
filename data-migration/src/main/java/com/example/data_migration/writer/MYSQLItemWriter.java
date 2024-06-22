//package com.example.data_migration.writer;
//
//
//import com.example.data_migration.model.Customer;
//import com.example.data_migration.model.Order;
//import com.example.data_migration.model.OrderItem;
//import com.example.data_migration.model.Product;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.transaction.Transactional;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MySQLItemWriter {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private OrderItemRepository orderItemRepository;
//
//    @Transactional
//    public ItemWriter<Customer> customerWriter() {
//        return items -> {
//            for (Customer item : items) {
//                entityManager.merge(item); // Persist or update customer entity
//            }
//        };
//    }
//
//    @Transactional
//    public ItemWriter<Order> orderWriter() {
//        return items -> {
//            for (Order item : items) {
//                entityManager.merge(item); // Persist or update order entity
//            }
//        };
//    }
//
//    @Transactional
//    public ItemWriter<Product> productWriter() {
//        return items -> {
//            for (Product item : items) {
//                entityManager.merge(item); // Persist or update product entity
//            }
//        };
//    }
//
//    @Transactional
//    public ItemWriter<OrderItem> orderItemWriter() {
//        return items -> {
//            for (OrderItem item : items) {
//                entityManager.merge(item); // Persist or update order item entity
//            }
//        };
//    }
//}
