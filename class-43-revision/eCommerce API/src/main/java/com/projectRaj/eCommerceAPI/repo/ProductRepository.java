package com.projectRaj.eCommerceAPI.repo;

import com.projectRaj.eCommerceAPI.models.Category;
import com.projectRaj.eCommerceAPI.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByCategory(Category category);
}
