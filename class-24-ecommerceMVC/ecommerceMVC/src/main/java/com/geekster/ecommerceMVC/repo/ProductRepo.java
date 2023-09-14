package com.geekster.ecommerceMVC.repo;

import com.geekster.ecommerceMVC.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public class ProductRepo {

    @Autowired
    private Map<Integer, Product> productMap;

    public Map<Integer, Product> getProductMap() {
        return productMap;
    }
}
