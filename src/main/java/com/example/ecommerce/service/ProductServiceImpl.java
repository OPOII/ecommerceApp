package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;
    private final UserRepository userRepository;
    @Override
    public Product save(Product product,Long id) {
        User searchUser=this.userRepository.findById(id).get();
        product.setUser(searchUser);

        return this.repository.save(product);
    }

    @Override
    public Optional<Product> get(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public Product update(Product product) {

        return this.repository.saveAndFlush(product);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
