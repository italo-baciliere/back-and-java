package br.com.baci.product.dto;

import br.com.baci.product.model.Product;
import br.com.baci.product.model.ProductIdentifier;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDTO(
    @NotBlank // verifica se a string é diferente de nulo e não é vazia
    ProductIdentifier productIdentifier,
    @NotBlank
    String nome,
    @NotBlank
    String descricao,
    @NotNull
    Float preco,
    @NotNull
    CategoryDTO categoryDTO
){
    public static ProductDTO convert(Product product){
        ProductDTO productDTO = new ProductDTO(
            product.getProductIdentifier(),
            product.getNome(),
            product.getDescricao(),
            product.getPreco(),
            CategoryDTO.convert(product.getCategory())
        );
        return productDTO;
    }
}