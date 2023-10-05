package com.geekster.m_11_m.repo;

import com.geekster.m_11_m.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProductRepo extends JpaRepository<Product,Long> {
}
