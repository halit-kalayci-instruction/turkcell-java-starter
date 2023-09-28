package com.turkcell.spring.starter.business.concretes;

import com.turkcell.spring.starter.business.abstracts.CategoryService;
import com.turkcell.spring.starter.business.exceptions.BusinessException;
import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.dtos.CategoryForAddDto;
import com.turkcell.spring.starter.entities.dtos.CategoryForListingDto;
import com.turkcell.spring.starter.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryManager(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryForListingDto> getAll() {
        // DTO => Data Transfer Object

/*   BAD PRACTICE !!
        List<Category> categories = categoryRepository.findAll();
        List<CategoryForListingDto> categoryForListingDtos = new ArrayList<>();

        // Mapleme
        for (Category c: categories) {
            CategoryForListingDto dto = new CategoryForListingDto();
            dto.setCategoryId(c.getCategoryId());
            dto.setCategoryName(c.getCategoryName());
            categoryForListingDtos.add(dto);
        }
*/
        return categoryRepository.getForListing();
    }

    @Override
    public void add(CategoryForAddDto request) {
        // Business Rule => Aynı isimde iki kategori olmamalı

        categoryWithSameNameShouldNotExist(request.getCategoryName());
        Category category = new Category();
        category.setCategoryName(request.getCategoryName());
        category.setDescription(request.getDescription());

        // Mapleme işlemi business içerisinde
        categoryRepository.save(category);
    }

    // DRY => Dont repeat yourself
    @Override
    public void update() {
    }

    private void categoryWithSameNameShouldNotExist(String categoryName){
        Category categoryWithSameName = categoryRepository.findByCategoryName(categoryName);
        if(categoryWithSameName != null){
            throw new BusinessException("Aynı kategori isminden 2 kategori bulunamaz.");
        }
    }
}
