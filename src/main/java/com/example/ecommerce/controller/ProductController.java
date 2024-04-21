package com.example.ecommerce.controller;

import com.example.ecommerce.customHandler.ResponseHandler;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService product){
        this.productService=product;
    }
    @PostMapping("/save")
    public ResponseEntity<Object> saveProduct(@RequestBody Product product)throws Exception{
        try{
            return ResponseHandler.generateResponse("The product was saved successfully", HttpStatus.ACCEPTED,productService.save(product));
        }catch (Exception e){
            return null;
        }
    }

}
