package com.turkcell.spring.starter.entities.dtos.category;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryForUpdateDto {

    @NotNull()
    @Min(1)
    private int id;

    @NotBlank(message = "Kategori adı girmek zorunludur.")
    @Size(min=3)
    private String categoryName;

    @NotBlank(message = "Açıklama alanı zorunludur.")
    private String description;
}
