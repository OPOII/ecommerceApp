package com.example.ecommerce.controller;

import com.example.ecommerce.customHandler.ResponseHandler;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/getProducts")
    public ResponseEntity<Object> getProducts(@RequestParam Long id)throws Exception{
        try{
            return ResponseHandler.generateResponse("The request was successfully", HttpStatus.ACCEPTED,userService.getProducts(id));
        }catch (Exception e){
            return null;
        }
    }

    @PostMapping("/saveUser")
    public ResponseEntity<Object> saveUser(@RequestBody User user)throws Exception{
        try{
            return ResponseHandler.generateResponse("The user was saved successfully", HttpStatus.ACCEPTED,userService.save(user));
        }catch (Exception e){
            return null;
        }
    }


}
