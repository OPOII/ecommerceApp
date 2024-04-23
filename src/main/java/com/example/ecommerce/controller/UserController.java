package com.example.ecommerce.controller;

import com.example.ecommerce.customHandler.ResponseHandler;
import com.example.ecommerce.model.RegisterUser;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;
import com.example.ecommerce.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Object>login(@RequestBody RegisterUser user)throws Exception{
          User usuario=this.userService.registerUser(user);
          return ResponseHandler.generateResponse("User saved successfully", HttpStatus.ACCEPTED,usuario);
    }
}
