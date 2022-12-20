package com.example.gjunrestaurant.dao;

import com.example.gjunrestaurant.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Integer> {
}
