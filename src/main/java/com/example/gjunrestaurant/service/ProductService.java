package com.example.gjunrestaurant.service;

import com.example.gjunrestaurant.dao.ProductDao;
import com.example.gjunrestaurant.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    public List<Product> getProducts() {
        List<Product> productList = Streamable.of(productDao.findAll()).toList();
        return productList;
    }

    public List<Integer> addProducts(List<Product> productList) {
        List<Integer> idList = null;
        for (Product p : productList) {
            productDao.save(p);
            idList.add(p.getID());
        }
        return idList;
    }

    public String reviseProduct(Product product) {
        productDao.save(product);
        return "ProductID[" + product.getID() + "] has be revised.";
    }

    public String deleteProduct(Integer productID) {
        productDao.deleteById(productID);
        return "ProductID[" + productID + "] has be deleted.";
    }

    public Product getOneProduct(Integer productID) {
        return productDao.findById(productID).get();
    }
}
