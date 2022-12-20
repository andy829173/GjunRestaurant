package com.example.gjunrestaurant.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "orderItem")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrderItem {
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
