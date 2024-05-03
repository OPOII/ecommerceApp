package com.example.ecommerce.controller;

import com.example.ecommerce.customHandler.ResponseHandler;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService product){
        this.productService=product;
    }
    @PostMapping("/save")
    public ResponseEntity<Object> saveProduct(@RequestBody Product product, @RequestParam Long id)throws Exception{
        try{
            return ResponseHandler.generateResponse("The product was saved successfully", HttpStatus.ACCEPTED,productService.save(product,id));
        }catch (Exception e){
            return null;
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<Object> editProduct(@RequestBody Product product)throws Exception{
        try{
            return ResponseHandler.generateResponse("The product was edited successfully", HttpStatus.ACCEPTED,productService.update(product));
        }catch (Exception e){
            return null;
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") Long id)throws Exception{
        try{
            return ResponseHandler.generateResponse("The product was edited successfully", HttpStatus.ACCEPTED,productService.get(id).get());
        }catch (Exception e){
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteProductById(@PathVariable("id") Long id)throws Exception{
        try{
            this.productService.delete(id);
            return ResponseHandler.generateResponse("The product was edited successfully", HttpStatus.ACCEPTED,new Object());
        }catch (Exception e){
            return null;
        }
    }


}
