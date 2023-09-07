package com.turkcell.spring.starter.entities;


import jakarta.persistence.*; // * => ilgili paketin tüm alt paketlerini import eder.
import lombok.Data;

@Data // getter+setter
@Table(name="categories")
@Entity
public class Category {
    @Id
    @Column(name="category_id")
    private int categoryId;

    @Column(name="category_name")
    private String categoryName;

    @Column(name="description")
    private String description;
}
