package com.example.data_migration.writer;

import com.example.data_migration.model.Customer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcCustomerItemWriter implements ItemWriter<Customer> {

    @Autowired
    private JdbcBatchItemWriter<Customer> writer;

    @Bean
    public JdbcBatchItemWriter<Customer> writer(DataSource dataSource) {
        JdbcBatchItemWriter<Customer> writer = new JdbcBatchItemWriter<>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO Customers (customer_id, first_name, last_name, email, address) VALUES (:customerId, :firstName, :lastName, :email, :address)");
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        return writer;
    }

    @Override
    public void write(List<? extends Customer> items) throws Exception {
        writer.write(items);
    }
}

