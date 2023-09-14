package com.geekster.ecommerceMVC.service;

import com.geekster.ecommerceMVC.entity.Category;
import com.geekster.ecommerceMVC.entity.Product;
import com.geekster.ecommerceMVC.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public String addProduct(Product myProduct) {

        productRepo.getProductMap().put(myProduct.getProductId(),myProduct);
        return "added";
    }

    public Map<Integer, Product> getAllProducts() {

        return productRepo.getProductMap();
    }


    public List<Product> getAllProductsByCategory(Category category) {

       /* List<Product> filteredList = new ArrayList<>();
        for(Integer keyId : getAllProducts().keySet())
        {
            Product product = getAllProducts().get(keyId);
            if(product.getProductCategory().equals(category))
            {
                filteredList.add(product);
            }
        }

        return  filteredList;*/

        return getAllProducts().values()
                .stream()
                .filter(product->product.getProductCategory().equals(category))
                .collect(Collectors.toList());
    }
}
