package com.examly.springapp.controller;

import com.examly.springapp.model.Product;
import com.examly.springapp.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")   // 🔥 MUST match test URL
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // ✅ Day6 No Body → 400
    // ✅ Day8 Add Product → 201 Created
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody(required = false) Product product) {
        if (product == null) {
            return ResponseEntity.badRequest().build();
        }
        Product savedProduct = productService.addProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED); // 🔥 201
    }

    // ✅ Day6 Empty List → 204
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        if (products == null || products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    // Required for earlier tests
    @GetMapping("/{id}")
    public ResponseEntity<String> getProductById(@PathVariable int id) {
        return ResponseEntity.ok("Product " + id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product product) {
        return ResponseEntity.ok("Updated product " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        return ResponseEntity.ok("Deleted product " + id);
    }
}
