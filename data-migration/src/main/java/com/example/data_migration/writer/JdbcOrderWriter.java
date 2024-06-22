package com.example.data_migration.writer;

import com.example.data_migration.entity.OrderEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class JdbcOrderWriter implements ItemWriter<OrderEntity> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_ORDER_SQL = "INSERT INTO orders (order_Id, product_Id ,customer_Id ,order_date , status) VALUES (?,?, ?, ?, ?)";

    @Override
    public void write(List<? extends OrderEntity> items) throws Exception {
        for (OrderEntity order : items) {
            jdbcTemplate.update(INSERT_ORDER_SQL, order.getOrderNumber(), order.getCustomerName(), order.getTotalAmount(), order.getOrderDate());
            log.info("Order written to MySQL: {}", order.getOrderNumber());
        }
    }
}
