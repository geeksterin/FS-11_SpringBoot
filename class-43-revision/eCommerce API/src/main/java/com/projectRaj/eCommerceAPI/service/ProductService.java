package com.projectRaj.eCommerceAPI.service;

import com.projectRaj.eCommerceAPI.models.Category;
import com.projectRaj.eCommerceAPI.models.Product;
import com.projectRaj.eCommerceAPI.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public String createProducts(List<Product> products) {
        productRepository.saveAll(products);
        return products.size()+" Products has been added into product repository";
    }

    public List<Product> getAllProducts() {
       return productRepository.findAll();
    }

    public List<Product> getAllProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    public String deleteProduct(Integer productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isPresent())
        {
            productRepository.deleteById(productId);
            return "Product with id : "+productId +" has been deleted";
        }
        return "Product with id : "+productId +" is not available";
    }
}
