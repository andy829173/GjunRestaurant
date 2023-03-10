package com.example.gjunrestaurant.dto.product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviseProductDto {
    Integer ID;
    String nameChi;
    String nameEng;
    String description;
    Integer productPrice;
    Integer category;
    String imagePath;
}
