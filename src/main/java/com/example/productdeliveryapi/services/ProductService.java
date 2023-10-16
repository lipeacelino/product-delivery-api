package com.example.productdeliveryapi.services;

import com.example.productdeliveryapi.dto.ProductInputDTO;
import com.example.productdeliveryapi.entities.Product;
import com.example.productdeliveryapi.rabbitmq.publisher.ProductCreatedPublisher;
import com.example.productdeliveryapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCreatedPublisher productCreatedPublisher;

    public Product addProduct(ProductInputDTO productInputDTO) {
        Product product = Product.builder()
                .name(productInputDTO.name())
                .price(productInputDTO.price())
                .build();
        Product productSaved = productRepository.save(product);
        productCreatedPublisher.send(productSaved);
        return productSaved;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

}
