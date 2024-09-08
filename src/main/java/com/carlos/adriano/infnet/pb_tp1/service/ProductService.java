package com.carlos.adriano.infnet.pb_tp1.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlos.adriano.infnet.pb_tp1.model.Product;
import com.carlos.adriano.infnet.pb_tp1.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void delete(Long id) {
        if(!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Produto não encontrado " + id);
        }
        productRepository.deleteById(id);
    }

    public Product update(Long id, Product productAlterado) {
        return productRepository.findById(id).map(product -> {
            product.setName(productAlterado.getName());
            product.setDescription(productAlterado.getDescription());
            return productRepository.save(product);
        }).orElseGet(() -> {
            productAlterado.setId(id);
            return productRepository.save(productAlterado);
        });
    }
}
