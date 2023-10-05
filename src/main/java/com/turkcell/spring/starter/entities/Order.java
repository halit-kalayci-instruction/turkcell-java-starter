package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders")
public class Order {
    @Id
    @Column(name="order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short orderId;

    @Column(name="order_date")
    private LocalDate orderDate;

    @Column(name="required_date")
    private LocalDate requiredDate;

    @Column(name="shipped_date")
    private LocalDate shippedDate;

    @Column(name="freight")
    private float freight;

    @Column(name="ship_name")
    private String shipName;

    @Column(name="ship_address")
    private String shipAddress;

    @Column(name="ship_city")
    private String shipCity;

    @Column(name="ship_region")
    private String shipRegion;

    @Column(name="ship_postal_code")
    private String shipPostalCode;

    @Column(name="ship_country")
    private String shipCountry;

    @ManyToOne()
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne()
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
}
