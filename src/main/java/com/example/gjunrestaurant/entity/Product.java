package com.example.gjunrestaurant.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @Column(name = "NameChi")
    private String nameChi;
    @Column(name = "NameEng")
    private String nameEng;
    @Column(name = "Description")
    private String description;
    @Column(name = "Price")
    private Integer productPrice;
    @Column(name = "ImagePath", columnDefinition="LONGTEXT")
    private String imagePath;
    @Column(name = "category")
    private Integer category;
}
