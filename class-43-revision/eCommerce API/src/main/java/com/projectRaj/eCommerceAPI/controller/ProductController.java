package com.projectRaj.eCommerceAPI.controller;

import com.projectRaj.eCommerceAPI.models.Category;
import com.projectRaj.eCommerceAPI.models.Product;
import com.projectRaj.eCommerceAPI.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("api/products")
    public String createProducts(@Valid @RequestBody List<Product> products) {
        return productService.createProducts(products);
    }

    @GetMapping("api/products")
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping("api/products/category")
    public List<Product> getAllProductsByCategory(@RequestParam Category category)
    {
        return productService.getAllProductsByCategory(category);
    }

    @DeleteMapping("api/{productId}")
    public String deleteProduct(@PathVariable Integer productId){
        return productService.deleteProduct(productId);
    }
}
