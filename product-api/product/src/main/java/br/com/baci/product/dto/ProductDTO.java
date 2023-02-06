package br.com.baci.product.dto;

import br.com.baci.product.model.Category;
import br.com.baci.product.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDTO(
    @NotBlank // verifica se a string é diferente de nulo e não é vazia
    String productIdentifier,
    @NotBlank
    String nome,
    @NotBlank
    String descricao,
    @NotNull
    Float preco,
    @NotNull
    Category category
){
    public static ProductDTO convert(Product product){
        ProductDTO productDTO = new ProductDTO(
            product.getProductIdentifier(),
            product.getNome(),
            product.getDescricao(),
            product.getPreco(),
            product.getCategory()
        );                    
        return productDTO;
    }
}