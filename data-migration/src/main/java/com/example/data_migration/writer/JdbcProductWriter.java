package com.example.data_migration.writer;

import com.example.data_migration.entity.ProductEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class JdbcProductWriter implements ItemWriter<ProductEntity> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_PRODUCT_SQL = "INSERT INTO products (name, description, price, category) VALUES (?, ?, ?, ?)";

    @Override
    public void write(List<? extends ProductEntity> items) throws Exception {
        for (ProductEntity product : items) {
            jdbcTemplate.update(INSERT_PRODUCT_SQL, product.getName(), product.getDescription(), product.getPrice(), product.getCategory());
            log.info("Product written to MySQL: {}", product.getName());
        }
    }
}

