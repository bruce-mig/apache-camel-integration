package com.github.bruce_mig.apache_camel_integration.service;

import com.github.bruce_mig.apache_camel_integration.dto.Order;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final List<Order> list = new ArrayList<>();

    @PostConstruct
    public void initDb(){
        list.addAll(List.of(
                Order.builder().id(7).name("Mobile").price(5000.0).build(),
                Order.builder().id(8).name("Book").price(400.0).build(),
                Order.builder().id(8).name("Laptop").price(15000.0).build(),
                Order.builder().id(9).name("Tablet").price(8000.0).build()
        ));
    }

    public Order addOrder(Order order){
        list.add(order);
        return order;
    }

    public List<Order> getOrders(){
        return list;
    }
}
