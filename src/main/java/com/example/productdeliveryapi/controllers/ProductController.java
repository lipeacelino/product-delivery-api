package com.example.productdeliveryapi.controllers;

import com.example.productdeliveryapi.dto.ProductInputDTO;
import com.example.productdeliveryapi.entities.Product;
import com.example.productdeliveryapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Product addProduct(@RequestBody ProductInputDTO productInputDTO) {
        return productService.addProduct(productInputDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

}
