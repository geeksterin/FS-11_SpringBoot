package com.geekster.ecommerceMVC.repo;

import com.geekster.ecommerceMVC.entity.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSource {


    @Bean
    Map<Integer, Product> getProductSource()
    {
        return new HashMap<>();
    }
}
