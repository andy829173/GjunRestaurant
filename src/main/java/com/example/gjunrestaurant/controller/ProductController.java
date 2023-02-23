package com.example.gjunrestaurant.controller;

import com.example.gjunrestaurant.dto.CreateProductDto;
import com.example.gjunrestaurant.entity.Product;
import com.example.gjunrestaurant.service.ProductService;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String deleteProduct(@RequestBody HashMap<String, Integer> data) {
        Integer id = data.get("id");
        return productService.deleteProduct(id);
    }

    @PostMapping("/createProduct")
    public String createProduct(@RequestBody CreateProductDto requestDto, HttpServletResponse response) {
        String msg;
        boolean isSuccess = productService.createProduct(requestDto);
        if (isSuccess) {
            msg = "新增成功";
            response.setStatus(200);
        } else {
            msg = "新增失敗";
        }
        return msg;
    }
}
