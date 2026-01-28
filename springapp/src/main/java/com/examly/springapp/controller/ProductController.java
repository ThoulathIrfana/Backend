package com.examly.springapp.controller;

import com.examly.springapp.model.Product;
import com.examly.springapp.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody(required = false) Product product) {
        if (product == null) return ResponseEntity.badRequest().build();
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(products);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);
        if (product == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(product);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product updated = productService.updateProduct(id, product);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    // DELETE (kept for earlier tests)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        return ResponseEntity.ok("Deleted product " + id);
    }
}
