package com.turkcell.spring.starter.business.abstracts;

import com.turkcell.spring.starter.entities.dtos.product.ProductForAddDto;
import com.turkcell.spring.starter.entities.dtos.product.ProductForListingDto;

import java.util.List;

public interface ProductService {
    List<ProductForListingDto> getAll();
    void add(ProductForAddDto request);
}
