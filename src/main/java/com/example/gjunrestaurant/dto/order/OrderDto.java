package com.example.gjunrestaurant.dto.order;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDto {
    Integer productID;
    Integer quantity;
}
