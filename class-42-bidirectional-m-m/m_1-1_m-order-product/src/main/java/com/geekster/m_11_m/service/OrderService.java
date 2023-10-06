package com.geekster.m_11_m.service;


import com.geekster.m_11_m.model.Order;
import com.geekster.m_11_m.repo.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {


    @Autowired
    IOrderRepo orderRepo;

    public String addOrder(Order newOrder) {
        orderRepo.save(newOrder);
        return "order added";
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}
