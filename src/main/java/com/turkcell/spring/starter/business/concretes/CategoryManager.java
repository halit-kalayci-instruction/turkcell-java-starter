package com.turkcell.spring.starter.business.concretes;

import com.turkcell.spring.starter.business.abstracts.CategoryService;
import com.turkcell.spring.starter.business.exceptions.BusinessException;
import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.dtos.category.CategoryForAddDto;
import com.turkcell.spring.starter.entities.dtos.category.CategoryForListingDto;
import com.turkcell.spring.starter.entities.dtos.category.CategoryForUpdateDto;
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
    // 7:30


    // DRY => Dont repeat yourself
    @Override
    public void update(CategoryForUpdateDto request) {
        Category categoryToUpdate = returnCategoryByIdIfExists(request.getId());

        categoryToUpdate.setDescription(request.getDescription());
        categoryToUpdate.setCategoryName(request.getCategoryName());

        categoryRepository.save(categoryToUpdate);
    }

    @Override
    public void delete(int id) {
        Category categoryToDelete = returnCategoryByIdIfExists(id);

        categoryRepository.delete(categoryToDelete);
    }

    private void categoryWithSameNameShouldNotExist(String categoryName){
        Category categoryWithSameName = categoryRepository.findByCategoryName(categoryName);
        if(categoryWithSameName != null){
            throw new BusinessException("Aynı kategori isminden 2 kategori bulunamaz.");
        }
    }

    private Category returnCategoryByIdIfExists(int id){
        Category categoryToDelete = categoryRepository.findById(id).orElse(null);
        if(categoryToDelete==null)
            throw new BusinessException("Böyle bir kategori bulunamadı.");
        return categoryToDelete;
    }
}
