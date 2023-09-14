package com.geekster.ecommerceMVC.controller;


import com.geekster.ecommerceMVC.entity.Category;
import com.geekster.ecommerceMVC.entity.Product;
import com.geekster.ecommerceMVC.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;


    @PostMapping("product")
    public String addProduct(@RequestBody Product myProduct)
    {
        return productService.addProduct(myProduct);
    }

    @GetMapping("products")
    public Map<Integer,Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping("products/category/{category}")
    public List<Product> getAllProductsByCategory(@PathVariable Category category)
    {
        return productService.getAllProductsByCategory(category);
    }
}
