package com.example.ecommerce.service;

import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.repository=userRepository;
    }

    @Override
    public User save(User user) {
        return this.repository.save(user);
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void editUser(Long id) {

    }
}
