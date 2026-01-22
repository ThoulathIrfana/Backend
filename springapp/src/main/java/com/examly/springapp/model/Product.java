package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Product {
    @Id
    private int id;
    

    public Product(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
