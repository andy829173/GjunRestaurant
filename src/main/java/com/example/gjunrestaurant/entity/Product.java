package com.example.gjunrestaurant.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
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

    @Column(name = "ImagePath", columnDefinition = "LONGTEXT")
    private String imagePath;

    @Column(name = "category")
    private Integer category;

//    public Product(CreateProductDto createProductDto) {
//        this.nameChi = createProductDto.getNameChi();
//        this.nameEng = createProductDto.getNameEng();
//        this.description = createProductDto.getDescription();
//        this.productPrice = createProductDto.getProductPrice();
//        this.category = createProductDto.getCategory();
//        this.imagePath = createProductDto.getImagePath();
//    }
//
//    public Product(ReviseProductDto reviseProductDto) {
//        this.id =
//    }
}
