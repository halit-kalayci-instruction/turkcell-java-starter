package com.turkcell.spring.starter.business.concretes;

import com.turkcell.spring.starter.business.abstracts.ProductService;
import com.turkcell.spring.starter.core.exceptions.types.BusinessException;
import com.turkcell.spring.starter.entities.Category;
import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.entities.Supplier;
import com.turkcell.spring.starter.entities.dtos.product.ProductForAddDto;
import com.turkcell.spring.starter.entities.dtos.product.ProductForListingDto;
import com.turkcell.spring.starter.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {
    private final ProductRepository productRepository;

    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductForListingDto> getAll() {
        return productRepository.getAllForListing();
    }

    @Override
    public void add(ProductForAddDto request) {
        productWithSameNameShouldNotExist(request.getProductName());

        Product newProduct = Product.builder()
                .name(request.getProductName())
                .unitPrice(request.getUnitPrice())
                .unitsInStock(request.getUnitsInStock())
                .category(Category.builder().categoryId(request.getCategoryId()).build())
                .supplier(Supplier.builder().supplierId(request.getSupplierId()).build())
                .discontinued(0)
                .build();

        /* Builderin alternatifi
        Product newProduct2 = new Product();
        newProduct2.setName(request.getProductName());
        Category category = new Category();
        category.setCategoryId(request.getCategoryId());
        newProduct2.setCategory(category);
         */

        productRepository.save(newProduct);
    }

    private void productWithSameNameShouldNotExist(String productName) {
        Product productWithSameName = productRepository.findByName(productName);
        if(productWithSameName!=null)
            throw new BusinessException("Aynı isimde ikinci ürün eklenemez");
    }
}
