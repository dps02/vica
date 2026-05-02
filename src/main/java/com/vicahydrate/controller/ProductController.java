package com.vicahydrate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//If you have @RequestMapping("/api") here, your URL would be localhost:8080/products
public class ProductController {

 @GetMapping("/products") // Must match exactly what you typed in the browser
 public String showProducts(Model model) {
     // your logic...
     return "products"; // This must match your HTML file name exactly
 }
}

