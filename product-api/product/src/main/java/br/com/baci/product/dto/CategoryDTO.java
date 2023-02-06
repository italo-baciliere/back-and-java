package br.com.baci.product.dto;

import br.com.baci.product.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoryDTO(
    @NotNull
    Long id,
    @NotBlank
    String nome
){
    public static CategoryDTO convert(Category category){
        CategoryDTO categoryDTO = new CategoryDTO(
            category.getId(),
            category.getNome()
        );
        return categoryDTO;
    }
}