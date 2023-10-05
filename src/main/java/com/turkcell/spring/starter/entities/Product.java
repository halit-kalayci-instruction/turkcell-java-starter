package com.turkcell.spring.starter.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(name="products")
@Entity
public class Product {
    @Id
    @Column(name="product_id")
    private int id;

    @Column(name="product_name")
    private String name;

    @ManyToOne()
    @JoinColumn(name="category_id")
    @JsonIgnore
    private Category category;


    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

}

// ORM => Object Relation Mapping
// Infinite recursion