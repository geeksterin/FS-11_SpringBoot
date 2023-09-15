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

    public List<Product> getProductsByPrice(double lowerPrice, double higherPrice) {

        /*List<Product> filteredProductList = new ArrayList<>();

        Map<Integer,Product> productMap = getAllProducts();
        for(Integer key : productMap.keySet())
        {
            Product product = productMap.get(key);

            if(product.getProductPrice() >= lowerPrice && product.getProductPrice() <= higherPrice)
            {
                filteredProductList.add(product);
            }


        }

        return filteredProductList;*/

        return getAllProducts().values()
                .stream()
                .filter(product->product.getProductPrice() >= lowerPrice
                        && product.getProductPrice() <= higherPrice)
                .collect(Collectors.toList());
    }

    public List<Product> getProductsByPriceAndCategory(double lowerPrice, double higherPrice, Category category) {

        return getProductsByPrice(lowerPrice,higherPrice)
                .stream()
                .filter(product -> product.getProductCategory().equals(category))
                .collect(Collectors.toList());
    }

    public String addProducts(List<Product> myProducts) {

        Map<Integer,Product> productMap = getAllProducts();

        for(Product product : myProducts)
        {
            productMap.put(product.getProductId(),product);
        }

        return myProducts.size()  + " products were added.";
    }
}
