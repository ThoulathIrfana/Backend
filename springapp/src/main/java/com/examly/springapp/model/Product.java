package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productName;
    private String description;
    private double price;
    private int stockQuantity;

    public Product() {}
    

    public Product(String productName, String description, double price, int stockQuantity) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
}
