package com.turkcell.spring.starter.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="order_details")
@Entity
public class OrderDetail {

    @Id()
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name="unit_price")
    private float unitPrice;

    @Column(name="discount")
    private float discount;

    @Column(name="quantity")
    private short quantity;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

}
