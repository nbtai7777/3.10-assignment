package com.ntu.edu.sg0.Assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/products")
    public Product getSampleProduct() {
        logger.info("GET /products called.");
        return new Product("Sample Product", 9.99, "This is a sample product.");
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        logger.info("POST /products called with product: {}", product);
        // Save the product to the database or perform other business logic
        return product;
    }
}