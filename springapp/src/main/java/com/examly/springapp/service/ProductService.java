package com.examly.springapp.service;

import com.examly.springapp.model.Product;
import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(int id);

    Product updateProduct(int id, Product product);
}
