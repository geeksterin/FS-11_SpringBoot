package com.geekster.m_11_m.controller;


import com.geekster.m_11_m.model.Order;
import com.geekster.m_11_m.model.Product;
import com.geekster.m_11_m.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;


    @PostMapping("order")
    public String addOrder(@RequestBody Order newOrder)
    {
        return orderService.addOrder(newOrder);
    }
}
