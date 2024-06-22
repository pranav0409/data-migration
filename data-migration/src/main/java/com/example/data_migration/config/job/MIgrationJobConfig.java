//package com.example.data_migration.config.job;
//
//import com.example.data_migration.model.Product;
//import com.example.data_migration.processor.CustomerProcessor;
//import com.example.data_migration.processor.ProductProcessor;
//import com.example.data_migration.writer.JdbcProductWriter;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.data.MongoItemReader;
//import org.springframework.batch.item.data.builder.MongoItemReaderBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.core.MongoTemplate;
//
//@Configuration
//@EnableBatchProcessing
//public class MigrationJobConfig {
//
//    private final MongoTemplate mongoTemplate;
//
//    @Autowired
//    public MigrationJobConfig(MongoTemplate mongoTemplate) {
//        this.mongoTemplate = mongoTemplate;
//    }
//
//    @Bean
//    public Step migrateProductsStep(ProductProcessor productProcessor, JdbcProductWriter productWriter) {
//        return createStep("migrateProductsStep", productProcessor, productWriter, Product.class);
//    }
//
//    @Bean
//    public Step migrateCustomersStep(CustomerProcessor customerProcessor, CustomerWriter customerWriter) {
//        return createStep("migrateCustomersStep", customerProcessor, customerWriter, Customer.class);
//    }
//
//    @Bean
//    public Step migrateOrdersStep(OrderProcessor orderProcessor, OrderWriter orderWriter) {
//        return createStep("migrateOrdersStep", orderProcessor, orderWriter, Order.class);
//    }
//
//    @Bean
//    public Job migrationJob() {
//        return createJob("migrationJob")
//                .start(migrateProductsStep(null, null))
//                .next(migrateCustomersStep(null, null))
//                .next(migrateOrdersStep(null, null))
//                .build();
//    }
//
//    private <T> Step createStep(String stepName, ItemProcessor<T, T> processor, ItemWriter<T> writer, Class<T> itemType) {
//        return new StepBuilderHelper(stepName)
//                .<T, T>chunk(100)
//                .reader(itemReader(itemType))
//                .processor(processor)
//                .writer(writer)
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public MongoItemReader<Product> productReader() {
//        return new MongoItemReaderBuilder<Product>()
//                .name("productReader")
//                .template(mongoTemplate)
//                .jsonQuery("{}") // Query to fetch all documents from "products" collection
//                .targetType(Product.class)
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public MongoItemReader<Customer> customerReader() {
//        return new MongoItemReaderBuilder<Customer>()
//                .name("customerReader")
//                .template(mongoTemplate)
//                .jsonQuery("{}") // Query to fetch all documents from "customers" collection
//                .targetType(Customer.class)
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public MongoItemReader<Order> orderReader() {
//        return new MongoItemReaderBuilder<Order>()
//                .name("orderReader")
//                .template(mongoTemplate)
//                .jsonQuery("{}") // Query to fetch all documents from "orders" collection
//                .targetType(Order.class)
//                .build();
//    }
//
//    private static class StepBuilderHelper extends StepBuilder {
//
//        private StepBuilderHelper(String name) {
//            super(name);
//        }
//    }
//
//    private static class JobBuilderHelper extends JobBuilder {
//
//        private JobBuilderHelper(String name) {
//            super(name);
//        }
//    }
//}
