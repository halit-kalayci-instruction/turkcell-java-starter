package com.turkcell.spring.starter.controllers;

import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
// localhost:8080/categories
public class CategoriesController {
    // CategoryService

    // DI
    // Spring IoC => Bağımlılıkların çözümlenmesi..
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoriesController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping()
    public List<Category> getCategories()
    {
        List<Category> categoriesInDb = categoryRepository.findAll();
        return categoriesInDb;
    }

    @GetMapping("getByName")
    public List<Category> getCategoriesByName(@RequestParam("name") String name){
        List<Category> categories = categoryRepository.findByCategoryNameContaining(name);
        return categories;
    }

    @GetMapping("search")
    public List<Category> search(@RequestParam("name") String name){
        List<Category> categories = categoryRepository.search(name);
        return categories;
    }

    @GetMapping("getById")
    public Category getCategoryById(@RequestParam("id") int id){
        Category category = categoryRepository.findById(id).orElseThrow();
        return category;
    }

    @PostMapping()
    public ResponseEntity add(@RequestBody Category category){
        categoryRepository.save(category);
        return new ResponseEntity("Kategori eklendi", HttpStatus.CREATED);
    }

    // PostgreSQL kurulumu
    // Northwind kurulumu
    // Northwinddeki tüm tabloları modellemek.
    // Araştırma Konusu : Spring JPA'da ilişkisel tabloların modellenmesi.
    // 3 temel tablomuz için veri erişim- business katmanı - controller kodlarının yazılması.

    // 20:05 => Discord Pair
}
