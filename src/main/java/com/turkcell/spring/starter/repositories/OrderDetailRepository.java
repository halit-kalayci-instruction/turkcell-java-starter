package com.turkcell.spring.starter.repositories;

import com.turkcell.spring.starter.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Short> {
}
