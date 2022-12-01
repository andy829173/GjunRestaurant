package com.example.gjunrestaurant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "productType")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID;
    @Column(name = "describeChi")
    String describeChi;
    @Column(name = "describeEng")
    String describeEng;
}
