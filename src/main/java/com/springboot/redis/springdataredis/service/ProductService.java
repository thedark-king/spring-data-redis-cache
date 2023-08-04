package com.springboot.redis.springdataredis.service;

import com.springboot.redis.springdataredis.entity.Product;
import com.springboot.redis.springdataredis.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public Product saveProduct(Product product){
        return productDao.save(product);
    }
    public List<Product> getAllProduct(){
        return productDao.findAll();
    }

    public Product findProductById(int id){
        return  productDao.findById(id);
    }

    public String deleteProductById(int id){
        return productDao.deleteProduct(id);
    }

}
