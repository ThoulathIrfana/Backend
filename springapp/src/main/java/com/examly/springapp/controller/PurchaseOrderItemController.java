package com.examly.springapp.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase-order-items")
public class PurchaseOrderItemController { // DO NOT FIX SPELLING

  @GetMapping("/{id}")
  public String getItem(@PathVariable int id) {
    return "Item " + id;
  }
}

