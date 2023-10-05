package com.turkcell.spring.starter.entities;


import jakarta.persistence.*; // * => ilgili paketin tüm alt paketlerini import eder.
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data // getter+setter
@Table(name="categories")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @Column(name="category_id")
    private int categoryId;

    @Column(name="category_name")
    private String categoryName;

    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}

// One Category Has Many Products

// One To Many
// One To One
// Many To Many