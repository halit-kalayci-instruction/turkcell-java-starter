package com.turkcell.spring.starter.entities.dtos;

import lombok.Data;

@Data // Getter+Setter
public class CategoryForAddDto {
    private String categoryName;
    private String description;
}
