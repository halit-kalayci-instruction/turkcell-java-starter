package com.turkcell.spring.starter.business.abstracts;

import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.dtos.CategoryForAddDto;
import com.turkcell.spring.starter.entities.dtos.CategoryForListingDto;

import java.util.List;

public interface CategoryService {
    // Serviceler entityleri değil dtoları kullanmalı..
    List<CategoryForListingDto> getAll();
    void add(CategoryForAddDto request);
    void update();
}
