package com.example.ecommerce.service;

import com.example.ecommerce.model.RegisterUser;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.utils.*;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService{

    private User saveUser=new User();
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

    @Override
    public User registerUser(RegisterUser registerUser)throws Exception {

        User prueba=this.repository.findByUsername(registerUser.getUsername());
        if(prueba!=null){
            throw new ApplicationException(
                    Errors.USERNAME_ALREADY_EXIST,
                    "The username "+registerUser.getUsername()+" already exist, try with other username",
                    HttpStatus.BAD_REQUEST
            );
        }
        prueba=this.repository.findByEmail(registerUser.getEmail()).isPresent()?this.repository.findByEmail(registerUser.getEmail()).get():null;
        if(prueba!=null){
            throw new ApplicationException(
                    Errors.EMAIL_ALREADY_TAKEN,
                    "There is already an account with the email: "+registerUser.getEmail(),
                    HttpStatus.BAD_REQUEST
            );
        }
        if(!isValidEmail(registerUser.getEmail())){
            throw new ApplicationException(
                    Errors.INVALID_EMAIL,
                    "The email: "+registerUser.getEmail()+" is invalid",
                    HttpStatus.BAD_REQUEST
            );
        }
        if(!registerUser.getPassword().equals(registerUser.getPassword2())){
            throw new ApplicationException(
                    Errors.PASSWORD_DONT_MATCH,
                    "The passwords doesnt match",
                    HttpStatus.BAD_REQUEST
            );
        }

//       TODO Validate the password
        System.out.println(registerUser.toString());
        // TODO mejorar el parseo usando gson
//        Type type=new TypeToken<User>(){}.getType();
//        User saveUser= (User)MapObjects.convertRequestToObject(registerUser.toString(),type);

        saveUser.setFirstName(registerUser.getFirstName());
        saveUser.setMiddleName(registerUser.getMiddleName());
        saveUser.setSecondName(registerUser.getSecondName());
        saveUser.setLastName(registerUser.getLastName());
        saveUser.setUsername(registerUser.getUsername());
        saveUser.setIdentification(IdentityType.valueOf(registerUser.getIdentification()));
        saveUser.setIdentificationNumber(registerUser.getIdentificationNumber());
        saveUser.setEmail(registerUser.getEmail());
        saveUser.setDirection(registerUser.getDirection());
        saveUser.setPhone(registerUser.getPhone());
        saveUser.setRole(UserRol.USER);
        saveUser.setPassword(registerUser.getPassword());
        saveUser.setActive(true);

        return this.save(saveUser);
    }

    public boolean isValidEmail(String email){
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern).matcher(email).matches();
    }


}
