package com.turkcell.spring.starter.entities.dtos.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductForAddDto {
    @Size(min=3)
    private String productName;
    @NotNull()
    @Min(1)
    private short supplierId;
    @NotNull()
    @Min(1)
    private int categoryId;
    @NotNull()
    @Min(1)
    private float unitPrice;
    @NotNull()
    @Min(1)
    private int unitsInStock;
}
