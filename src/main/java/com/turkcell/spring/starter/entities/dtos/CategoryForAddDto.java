package com.turkcell.spring.starter.entities.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

// Kullanıcı girdi =>
// Hatalı ve istenmeyen durumları önlemek adına
// categoryName 3 haneden küçük olamaz

// Never Trust User Input

// Backend Validation is mandatory Frontend validation is a plus
@Data // Getter+Setter
public class CategoryForAddDto {

    @NotBlank(message = "Kategori adı girmek zorunludur.")
    @Size(min=3)
    private String categoryName;

    @NotBlank(message = "Açıklama alanı zorunludur.")
    private String description;
}
