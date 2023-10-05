package com.turkcell.spring.starter.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Table(name="suppliers")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    @Id
    @Column(name="supplier_id")
    private short supplierId;

    @Column(name="company_name")
    private String companyName;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;
}
