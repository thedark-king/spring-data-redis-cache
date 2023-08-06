package com.springboot.redis.springdataredis.service;

import com.springboot.redis.springdataredis.entity.Product;
import com.springboot.redis.springdataredis.repository.ProductDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@EnableCaching
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public Product saveProduct(Product product){
        return productDao.save(product);
    }
    public List<Product> getAllProduct(){
        return productDao.findAll();
    }
    @Cacheable(key = "#id", value = "Product", unless = "#result.price > 1000")
    public Product findProductById(int id){
        log.info("Fetching data from from db");
        return  productDao.findById(id);
    }
    @CacheEvict(key = "#id", value = "Product")
    public String deleteProductById(int id){
        return productDao.deleteProduct(id);
    }

}
