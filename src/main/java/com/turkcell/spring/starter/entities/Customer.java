package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customers")
@Entity
public class Customer {
    @Id()
    @Column(name="customer_id")
    private String customerId;

    @Column(name="company_name")
    private String companyName;


    @Column(name="contact_name")
    private String contactName;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
