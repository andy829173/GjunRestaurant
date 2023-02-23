package com.example.gjunrestaurant.service;

import com.example.gjunrestaurant.controller.TestController;
import com.example.gjunrestaurant.dao.ProductDao;
import com.example.gjunrestaurant.dto.CreateProductDto;
import com.example.gjunrestaurant.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
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

    public boolean createProduct(CreateProductDto requestDto){
        boolean isSuccess = false;
        Product newProduct = new Product();
        newProduct.setNameChi(requestDto.getNameChi());
        newProduct.setNameEng(requestDto.getNameEng());
        newProduct.setDescription(requestDto.getDescription());
        newProduct.setProductPrice(requestDto.getPrice());
        newProduct.setCategory(requestDto.getCategory());
        newProduct.setImagePath(requestDto.getBase64Img());

        try {
            productDao.save(newProduct);
            isSuccess = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isSuccess;
    }
}
