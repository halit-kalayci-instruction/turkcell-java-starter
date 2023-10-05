package com.turkcell.spring.starter.entities.dtos.orderdetail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailForAddDto {
    private int productId;
    private short quantity;
}
