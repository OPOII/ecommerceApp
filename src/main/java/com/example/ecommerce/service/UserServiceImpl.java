package com.example.ecommerce.service;

import com.example.ecommerce.auth.RegisterRequest;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

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
        return this.repository.findById(id).get();
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



    public boolean isValidEmail(String email){
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern).matcher(email).matches();
    }


}
