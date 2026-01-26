package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @PostMapping
    public ResponseEntity<String> createSupplier(@RequestBody String supplier) {
        return ResponseEntity.ok("Supplier created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getSupplier(@PathVariable int id) {
        return ResponseEntity.ok("Supplier " + id);
    }
}
