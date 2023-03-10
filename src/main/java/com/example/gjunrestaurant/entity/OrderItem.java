package com.example.gjunrestaurant.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "orderItem")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID;
    @Column(name = "orderID")
    String orderID;
    @Column(name = "productID")
    Integer productID;
    @Column(name = "quantity")
    Integer quantity;
    @Column(name = "price")
    Integer price;

    public OrderItem(Integer productID, Integer quantity) {
        this.productID = productID;
        this.quantity = quantity;
    }
}
