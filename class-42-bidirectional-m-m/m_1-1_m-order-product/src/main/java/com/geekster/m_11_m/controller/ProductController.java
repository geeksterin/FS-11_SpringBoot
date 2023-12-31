package com.geekster.m_11_m.controller;

import com.geekster.m_11_m.model.Product;
import com.geekster.m_11_m.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("product")
    public String addProduct(@RequestBody Product newProduct)
    {
        return productService.addProduct(newProduct);
    }

    @GetMapping("products")
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }
}
