package com.example.gjunrestaurant.controller;

import com.example.gjunrestaurant.dto.product.CreateProductDto;
import com.example.gjunrestaurant.dto.product.ReviseProductDto;
import com.example.gjunrestaurant.entity.Product;
import com.example.gjunrestaurant.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/product/{productID}")
    public ResponseEntity<Product> getProduct(@PathVariable("productID") Integer productID) {
        Product product = productService.getOneProduct(productID);

        // need to be fixed
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
        }
    }

    @PatchMapping("/product")
    public String reviseProduct(@RequestBody ReviseProductDto requestDto) {
        return productService.reviseProduct(requestDto);
    }

    @DeleteMapping("/product")
    public String deleteProduct(@RequestBody HashMap<String, Integer> data) {
        Integer id = data.get("id");
        return productService.deleteProduct(id);
    }

    @PostMapping("/product")
    public ResponseEntity<String> createProduct(@RequestBody CreateProductDto requestDto) {
        String msg;
        try {
            Integer productId = productService.createProduct(requestDto);
            msg = productId + " has be created.";
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e) {
            msg = "新增失敗 Exception: " + e.getMessage();
            return new ResponseEntity<>(msg, HttpStatus.FORBIDDEN);
        }
    }
}
