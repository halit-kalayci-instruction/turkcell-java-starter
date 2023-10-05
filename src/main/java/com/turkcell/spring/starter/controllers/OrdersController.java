package com.turkcell.spring.starter.controllers;

import com.turkcell.spring.starter.business.abstracts.OrderService;
import com.turkcell.spring.starter.entities.dtos.order.OrderForAddDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class OrdersController {
    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void add(@RequestBody OrderForAddDto request){
        orderService.add(request);
    }
}
