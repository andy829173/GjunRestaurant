package com.example.gjunrestaurant.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductDto {
    String nameChi;
    String nameEng;
    String description;
    Integer price;
    Integer category;
    String base64Img;
}
