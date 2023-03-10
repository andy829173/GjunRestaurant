package com.example.gjunrestaurant.dao;

import com.example.gjunrestaurant.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {
}
