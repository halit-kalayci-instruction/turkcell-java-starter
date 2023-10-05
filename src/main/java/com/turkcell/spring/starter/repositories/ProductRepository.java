package com.turkcell.spring.starter.repositories;

import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.entities.dtos.product.ProductForListingDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT new com.turkcell.spring.starter.entities.dtos.product.ProductForListingDto(p.id, p.name) FROM Product p")
    List<ProductForListingDto> getAllForListing();

    Product findByName(String name);
}
