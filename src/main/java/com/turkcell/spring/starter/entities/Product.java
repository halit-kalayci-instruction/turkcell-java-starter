package com.turkcell.spring.starter.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Table(name="products")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name="product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="product_name")
    private String name;

    @Column(name="unit_price")
    private float unitPrice;

    @Column(name="units_in_stock")
    private int unitsInStock;

    @Column(name="discontinued")
    private int discontinued;


    @ManyToOne()
    @JoinColumn(name="category_id")
    @JsonIgnore
    private Category category;


    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    @ManyToOne()
    @JoinColumn(name="supplier_id")
    private Supplier supplier;
}

// ORM => Object Relation Mapping
// Infinite recursion