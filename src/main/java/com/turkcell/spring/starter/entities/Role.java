package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"users"})
public class Role {
    @Id
    @Column(name="id")
    @GeneratedValue()
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

}
