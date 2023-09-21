package com.turkcell.spring.starter.repositories;

import com.turkcell.spring.starter.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByCategoryNameContaining(String categoryName);

    List<Category> findByIdGreaterThanEqual(int id);
    List<Category> findByDescription(String description);

}
// Spring Derived Query Methods