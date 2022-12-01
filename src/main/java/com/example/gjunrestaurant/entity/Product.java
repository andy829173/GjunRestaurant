package com.example.gjunrestaurant.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ID;
    @Column(name = "NameChi")
    String nameChi;
    @Column(name = "NameEng")
    String nameEng;
    @Column(name = "Description")
    String description;
    @Column(name = "Price")
    Integer productPrice;
    @Column(name = "ImagePath")
    String imagePath;
    @Column(name = "category")
    Integer category;
}
