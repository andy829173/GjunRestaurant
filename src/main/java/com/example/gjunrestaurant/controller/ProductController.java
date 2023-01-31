package com.example.gjunrestaurant.controller;

import com.example.gjunrestaurant.entity.Product;
import com.example.gjunrestaurant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public List<Product> getProducts() {
        List<Product> productList = null;
        productList = productService.getProducts();
        return productList;
    }

    // return ProductIDs
    @PostMapping("/product")
    public List<Integer> addProducts(List<Product> productList) {
        List<Integer> idList = productService.addProducts(productList);
        return idList;
    }

    @PatchMapping("/product")
    public String reviceProduct(Product product) {
        return productService.reviseProduct(product);
    }

    @DeleteMapping("/product")
    public String deleteProduct(Integer productID) {
        return productService.deleteProduct(productID);
    }
}
