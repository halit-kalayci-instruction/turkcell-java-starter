package com.turkcell.spring.starter.business.abstracts;

import com.turkcell.spring.starter.entities.dtos.order.OrderForAddDto;

public interface OrderService {
    void add(OrderForAddDto request);
}
