package com.springboot.redis.springdataredis.controller;

import com.springboot.redis.springdataredis.entity.Product;
import com.springboot.redis.springdataredis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity save(@RequestBody Product product) {
        Product updatedProduct = productService.saveProduct(product);
        return new ResponseEntity(updatedProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getAllProduct() {
        List<Product> listOfProduct = productService.getAllProduct();
        return new ResponseEntity(listOfProduct, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable int id) {
        Product product = productService.findProductById(id);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProductById(@PathVariable int id) {
        String status = productService.deleteProductById(id);
        return new ResponseEntity(status, HttpStatus.OK);
    }

}
