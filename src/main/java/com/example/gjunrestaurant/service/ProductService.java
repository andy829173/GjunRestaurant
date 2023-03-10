package com.example.gjunrestaurant.service;

import com.example.gjunrestaurant.dao.ProductDao;
import com.example.gjunrestaurant.dto.product.CreateProductDto;
import com.example.gjunrestaurant.dto.product.ReviseProductDto;
import com.example.gjunrestaurant.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    // Get product list
    public List<Product> getProducts() {
        return Streamable.of(productDao.findAll()).toList();
    }

    public List<Integer> addProducts(List<Product> productList) {
        List<Integer> idList = null;
        for (Product p : productList) {
            productDao.save(p);
            idList.add(p.getID());
        }
        return idList;
    }

    public String reviseProduct(ReviseProductDto requestDto) {
        Product product = new Product();
        BeanUtils.copyProperties(requestDto, product);
        productDao.save(product);
        System.out.println(product);
        return "ProductID[" + product.getID() + "] has be revised.";
    }

    public String deleteProduct(Integer productID) {
        productDao.deleteById(productID);
        return "ProductID[" + productID + "] has be deleted.";
    }

    public Product getOneProduct(Integer productID) {
        if (productDao.findById(productID).isPresent()) {
            return productDao.findById(productID).get();
        }
        return null;
    }

    public Integer createProduct(CreateProductDto requestDto) throws Exception {
        Product product = new Product();
        BeanUtils.copyProperties(requestDto, product);
        return productDao.save(product).getID();
    }
}
