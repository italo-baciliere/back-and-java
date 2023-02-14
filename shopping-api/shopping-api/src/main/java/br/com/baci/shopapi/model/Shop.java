package br.com.baci.shopapi.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "shop")
@Getter
@Setter
@NoArgsConstructor
public class Shop {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String userIdentifier;

    @NotNull
    private LocalDateTime date;
    
    @NotNull
    private float total;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "item",
                     joinColumns = @JoinColumn(name = "shop_id"))
    private List<Item> items;

    public static Shop converter(ShopDTO shopDTO){
        Shop shop = new Shop();
        shop.setUserIdentifier(shopDTO.userIdentifier());
        shop.setDate(shopDTO.date());
        shop.setTotal(shopDTO.total());
        shop.setItems(
            shopDTO.items()
            .stream()
            .map(Item::convert)
            .collect(Collectors.toList())
        );
        return shop;
    }

    public static Shop converter(ShopDadosCadastroDTO shopDadosCadastroDTO) {
        Shop shop = new Shop();
        shop.setUserIdentifier(shopDadosCadastroDTO.userIdentifier());
        shop.setDate(shopDadosCadastroDTO.date());
        shop.setTotal(shopDadosCadastroDTO.total());
        shop.setItems(
            shopDadosCadastroDTO.items()
            .stream()
            .map(Item::convert)
            .collect(Collectors.toList())
        );
        return shop;
    }

}