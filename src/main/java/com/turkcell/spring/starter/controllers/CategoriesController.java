package com.turkcell.spring.starter.controllers;

import com.turkcell.spring.starter.business.CategoryService;
import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.dtos.CategoryForAddDto;
import com.turkcell.spring.starter.entities.dtos.CategoryForListingDto;
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
    private final CategoryService categoryService;

    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<CategoryForListingDto> getCategories()
    {
        // Category => PostgreSQL'deki tablo
        List<CategoryForListingDto> categoriesInDb = categoryService.getAll();
        return categoriesInDb;
    }

    @GetMapping("getByName")
    public List<Category> getCategoriesByName(@RequestParam("name") String name){
        //List<Category> categories = categoryRepository.findByCategoryNameContaining(name);
        return null;
    }

    @GetMapping("search")
    public List<Category> search(@RequestParam("name") String name){
        //List<Category> categories = categoryRepository.searchNative(name);
        return null;
    }

    @GetMapping("getById")
    public Category getCategoryById(@RequestParam("id") int id){
        //Category category = categoryRepository.findById(id).orElseThrow();
        return null;
    }

    @PostMapping()
    public ResponseEntity add(@RequestBody CategoryForAddDto request){
        // Manual Mapleme
        // Auto Mapper => ModelMapper
        Category category = new Category();
        category.setCategoryName(request.getCategoryName());
        category.setDescription(request.getDescription());
        //categoryRepository.save(category);
        return new ResponseEntity("Kategori eklendi", HttpStatus.CREATED);
    }

    // PostgreSQL kurulumu
    // Northwind kurulumu
    // Northwinddeki tüm tabloları modellemek.
    // Araştırma Konusu : Spring JPA'da ilişkisel tabloların modellenmesi.
    // 3 temel tablomuz için veri erişim- business katmanı - controller kodlarının yazılması.

    // 20:05 => Discord Pair
}

// DTOlar => Data Transfer Object
