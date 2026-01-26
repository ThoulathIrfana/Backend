package com.examly.springapp.service;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private List<Product> productList = new ArrayList<>();

    @Override
    public Product addProduct(Product product) {
        productList.add(product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }
}

