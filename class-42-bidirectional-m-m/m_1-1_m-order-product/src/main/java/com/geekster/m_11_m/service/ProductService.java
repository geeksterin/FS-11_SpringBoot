package com.geekster.m_11_m.service;


import com.geekster.m_11_m.model.Product;
import com.geekster.m_11_m.repo.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    IProductRepo productRepo;

    public String addProduct(Product newProduct) {

        productRepo.save(newProduct);
        return "added new product";
    }

    public List<Product> getAllProducts() {
        List<Product> ans = productRepo.findAll();
        return ans;
    }
}
