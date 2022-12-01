package com.example.gjunrestaurant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "order")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID;
    @Column(name = "date")
    String date;
    @Column(name = "time")
    String time;
    @Column(name = "totalPrice")
    Integer totalPrice;
    @Column(name = "paid")
    Boolean paid;
}
