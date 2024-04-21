package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{


    private final ProductRepository repository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.repository=productRepository;
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public Optional<Product> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public void update(Product product) {
        repository.saveAndFlush(product);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
