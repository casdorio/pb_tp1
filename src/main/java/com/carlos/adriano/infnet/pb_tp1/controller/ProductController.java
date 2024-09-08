package com.carlos.adriano.infnet.pb_tp1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.carlos.adriano.infnet.pb_tp1.model.Product;
import com.carlos.adriano.infnet.pb_tp1.service.ProductService;

import java.util.*;

@RestController
@RequestMapping("/api/public")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping("/product")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public Optional<Product> findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @PutMapping("/product/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return productService.update(id, product);
    }
}