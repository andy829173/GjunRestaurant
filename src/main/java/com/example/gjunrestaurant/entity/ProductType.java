package com.example.gjunrestaurant.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "productType")
@Data
@NoArgsConstructor
public class ProductType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID;

    @Column(name = "describeChi")
    String describeChi;

    @Column(name = "describeEng")
    String describeEng;
}
