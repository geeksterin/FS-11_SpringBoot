package com.projectRaj.eCommerceAPI.service;

import com.projectRaj.eCommerceAPI.models.Orders;
import com.projectRaj.eCommerceAPI.models.Product;
import com.projectRaj.eCommerceAPI.repo.OrderRepository;
import com.projectRaj.eCommerceAPI.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

    public String createOrder(Orders order) {
        
        //todo : set the productQuantity
        order.setProductQuantity(order.getProducts().size());
        orderRepository.save(order);
        return "Orders placed. please stay tunned.";
    }




    public String createNewOrder() {

        Orders order = new Orders();
        orderRepository.save(order);
        return "Orders started. please stay tunned.";
    }

    public Object getOrderById(Integer orderId) {
        Optional<Orders> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isPresent()){
            return optionalOrder;
        }
        return "Orders with id : "+orderId+" is not available";
    }

    public Integer getCountProducts(Integer orderId) {

        Orders myOrder =  orderRepository.findById(orderId).orElseGet(null);

        return myOrder.getProducts().size();
    }

    public String linkProducts(Integer orderId, List<Integer> productIds) {

        Orders myOrder = orderRepository.findById(orderId).orElseThrow();

        List<Product> orderProducts = productRepository.findAllById(productIds);

        myOrder.setProducts(orderProducts);

        orderRepository.save(myOrder);

        return "linking done";
    }
}
