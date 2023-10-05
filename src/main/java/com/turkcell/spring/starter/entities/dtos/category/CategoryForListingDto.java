package com.turkcell.spring.starter.entities.dtos.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryForListingDto {
    private int categoryId;
    private String categoryName;
}
