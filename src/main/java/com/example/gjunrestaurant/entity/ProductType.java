package com.example.gjunrestaurant.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
