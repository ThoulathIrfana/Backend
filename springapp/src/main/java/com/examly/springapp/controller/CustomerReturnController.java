package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer-returns")
public class CustomerReturnController {

    @GetMapping("/{id}")
    public String getReturn(@PathVariable int id) {
        return "Return " + id;
    }
}
