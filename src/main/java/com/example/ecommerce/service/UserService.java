package com.example.ecommerce.service;

import com.example.ecommerce.auth.RegisterRequest;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User findById(Long id);
    void deleteUser(Long id);
    List<User> findAll();
    User editUser(User user);

    List<Product> getProducts(Long id) throws Exception;

}
