package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase-orders")
public class PurchaseOrderController {

    @GetMapping("/{id}")
    public String getOrder(@PathVariable int id) {
        return "Order " + id;
    }
}
