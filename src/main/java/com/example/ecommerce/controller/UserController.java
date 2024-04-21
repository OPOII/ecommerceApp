package com.example.ecommerce.controller;

import com.example.ecommerce.customHandler.ResponseHandler;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;
import com.example.ecommerce.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/loggin")
    public ResponseEntity<Object>loggin(@RequestBody User user)throws Exception{
        try {
          User usuario=this.userService.save(user);
          return ResponseHandler.generateResponse("User saved successfully", HttpStatus.ACCEPTED,usuario);
        }catch (Exception e){
            return ResponseHandler.generateResponse("Something went wrong",HttpStatus.BAD_REQUEST,null);
        }
    }
}
