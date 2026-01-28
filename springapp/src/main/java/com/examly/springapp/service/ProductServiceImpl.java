package com.examly.springapp.service;

import com.examly.springapp.model.Product;
import com.examly.springapp.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    // Constructor Injection
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Product existing = productRepo.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setProductName(product.getProductName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setStockQuantity(product.getStockQuantity());

        return productRepo.save(existing);
    }
}
