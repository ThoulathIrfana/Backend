package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class PurchaseOrderItem {
    @Id
    private int id;

    
    public PurchaseOrderItem(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
