//package com.example.data_migration.model;
//
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import org.springframework.data.annotation.Id;
//
//import java.math.BigDecimal;
//import java.util.UUID;
//
//@Entity
//public class OrderItem{
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private UUID orderItemId;
//
//    private UUID orderId;    // Foreign key reference to OrderEntity
//    private UUID productId;  // Foreign key reference to ProductEntity
//    private int quantity;
//    private BigDecimal price;
//
//    // Getters and setters
//    public UUID getOrderItemId() {
//        return orderItemId;
//    }
//
//    public void setOrderItemId(UUID orderItemId) {
//        this.orderItemId = orderItemId;
//    }
//
//    public UUID getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(UUID orderId) {
//        this.orderId = orderId;
//    }
//
//    public UUID getProductId() {
//        return productId;
//    }
//
//    public void setProductId(UUID productId) {
//        this.productId = productId;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//}
//
