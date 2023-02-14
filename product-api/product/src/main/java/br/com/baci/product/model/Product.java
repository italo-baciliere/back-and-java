package br.com.baci.product.model;

import br.com.baci.product.dto.ProductDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private Float preco;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private ProductIdentifier productIdentifier;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public static Product convert(ProductDTO productDTO){
        Product product = new Product();
        product.setNome(productDTO.nome());
        product.setPreco(productDTO.preco());
        product.setDescricao(productDTO.descricao());
        product.setProductIdentifier(productDTO.productIdentifier());
        if(productDTO.categoryDTO() != null){
            product.setCategory(
                Category.convert(productDTO.categoryDTO()));
        }
        return product;
    }
}