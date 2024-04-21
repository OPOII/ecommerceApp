package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product save(Product product);
    Optional<Product> get(Long id);
    void update(Product product);
    void delete (Long id);

    List<Product> findAll();
}
