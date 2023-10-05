package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employees")
@Entity
public class Employee {
    @Id
    @Column(name="employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short employeeId;

    @Column(name="last_name")
    private String lastName;

    @Column(name="first_name")
    private String firstName;

    @Column(name="birth_date")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "employee")
    private List<Order> orders;
}
