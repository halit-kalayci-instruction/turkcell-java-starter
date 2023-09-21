package com.turkcell.spring.starter.repositories;

import com.turkcell.spring.starter.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByCategoryNameContaining(String categoryName);
    //List<Category> findByIdGreaterThanEqual(int id);
    List<Category> findByDescription(String description);

    // Native SQL
    // JPQL => JPA'nın SQL'e neredeyse birebir benzer versiyonu..
    // JPQL => Tablo ismi yerine entity yazmak
    @Query(value = "Select c FROM Category c WHERE c.categoryName LIKE %:categoryName%", nativeQuery = false)
    List<Category> search(String categoryName);
}
// Spring Derived Query Methods