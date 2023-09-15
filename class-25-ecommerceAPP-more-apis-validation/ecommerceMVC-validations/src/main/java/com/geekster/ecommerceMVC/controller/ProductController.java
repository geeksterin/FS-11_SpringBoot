package com.geekster.ecommerceMVC.controller;


import com.geekster.ecommerceMVC.entity.Category;
import com.geekster.ecommerceMVC.entity.Product;
import com.geekster.ecommerceMVC.service.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Validated
public class ProductController {

    @Autowired
    ProductService productService;


    @PostMapping("product")
    public String addProduct(@RequestBody @Valid Product myProduct)
    {

        return productService.addProduct(myProduct);
    }

    @PostMapping("products")
    public String addProduct(@RequestBody @Valid List<Product> myProducts)
    {

        return productService.addProducts(myProducts);
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


    @GetMapping("products/filter/lowerPrice/{lowerPrice}/higherPrice/{higherPrice}")
    List<Product> getProductsByPriceRange(@PathVariable double lowerPrice,@PathVariable double higherPrice)
    {
        return productService.getProductsByPrice(lowerPrice,higherPrice);
    }

    //get count of all products : todo

    @GetMapping("products/filter/lowerPrice/{lowerPrice}/higherPrice/{higherPrice}/category")
    List<Product> getProductsByPriceRange(@PathVariable @Min(0) double lowerPrice, @PathVariable @Max(value = 10000,message = "price cannot exceed 10000") double higherPrice, @RequestParam Category category)
    {
        return productService.getProductsByPriceAndCategory(lowerPrice,higherPrice,category);
    }




}
