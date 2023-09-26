package com.turkcell.spring.starter.business;

import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.dtos.CategoryForListingDto;

import java.util.List;

public interface CategoryService {
    // Serviceler entityleri değil dtoları kullanmalı..
    List<CategoryForListingDto> getAll();
}
