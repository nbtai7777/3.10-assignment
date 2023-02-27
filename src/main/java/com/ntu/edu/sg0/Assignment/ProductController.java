package com.ntu.edu.sg0.Assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping
    public productRequest getSampleProduct() {
        logger.info("SampleProduct route called");
        return new productRequest("Sample Product", 100.0f, "This is a sample product.");
    }

    @PostMapping
    public productRequest postProduct(@RequestBody ProductRequest productRequest) {
        logger.info("Product route called with productRequest: {}", productRequest);
        return new productRequest(productRequest.getName(), productRequest.getPrice(), productRequest.getDescription());
    }

    private static class ProductRequest {
        private String name;
        private double price;
        private String description;

        public String getName() {
            return name;
        }

        public float getPrice() {
            return (float) price;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "ProductRequest{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}


// sh ./mvnw spring-boot:run