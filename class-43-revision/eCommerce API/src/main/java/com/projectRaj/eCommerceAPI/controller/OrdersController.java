package com.projectRaj.eCommerceAPI.controller;

import com.projectRaj.eCommerceAPI.models.Orders;
import com.projectRaj.eCommerceAPI.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    /*@PostMapping("api/userId/productId/addressId/productQuantity")
    public String placeOrder(@RequestBody Orders order){

        return ordersService.createOrder(order);
    }*/

     @PostMapping("api/userId/productId/addressId/productQuantity")
    public String placeOrder(){

        return ordersService.createNewOrder();
    }

    @GetMapping("api/order/{orderId}")
    public Object getOrderById(@PathVariable Integer orderId){

        return ordersService.getOrderById(orderId);
    }


    @GetMapping("order/{orderId}/count/products")
    public Integer getCountProducts(@PathVariable Integer orderId)
    {
        return ordersService.getCountProducts(orderId);
    }

    @PutMapping("linkOrdeWithProduct/{orderId}")
    public String linkProductsWithOrder(@PathVariable Integer orderId,@RequestBody List<Integer> productIds)
    {
        return ordersService.linkProducts(orderId,productIds);
    }

}
