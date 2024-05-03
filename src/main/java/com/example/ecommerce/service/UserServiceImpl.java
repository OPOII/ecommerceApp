package com.example.ecommerce.service;

import com.example.ecommerce.auth.RegisterRequest;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.utils.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository repository;


    @Override
    public User save(User user) {
        this.validationUser(user);
        return this.repository.save(user);
    }

    @Override
    public User findById(Long id) {
        return this.repository.findById(id).get();
    }

    @Override
    public void deleteUser(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User editUser(User user) {
       return this.repository.saveAndFlush(user);
    }

    @Override
    public List<Product> getProducts(Long id)throws Exception {
        User us=null;
        if(this.repository.findById(id).isPresent()){
            us=this.repository.findById(id).get();
        }else {
            throw new ApplicationException(Errors.USER_NOT_EXIST,"The user with the id: "+id+" doesnt exist", HttpStatus.BAD_REQUEST);
        }
        return us.getProducts();
    }

    public void validationUser(User user){
        User aux=this.repository.findByUsername(user.getUsername());
        if(aux!=null){
            throw new ApplicationException(
                    Errors.USERNAME_ALREADY_EXIST,
                    "The username "+user.getUsername()+" already exist, try with other username",
                    HttpStatus.BAD_REQUEST
            );
        }
        aux=this.repository.findByEmail(user.getEmail()).isPresent()?this.repository.findByEmail(user.getEmail()).get():null;
        if(aux!=null){
            throw new ApplicationException(
                    Errors.EMAIL_ALREADY_TAKEN,
                    "There is already an account with the email: "+user.getEmail(),
                    HttpStatus.BAD_REQUEST
            );
        }
        if(!UtilMethods.isValidEmail(user.getEmail())){
            throw new ApplicationException(
                    Errors.INVALID_EMAIL,
                    "The email: "+user.getEmail()+" is invalid",
                    HttpStatus.BAD_REQUEST
            );
        }
    }

}
