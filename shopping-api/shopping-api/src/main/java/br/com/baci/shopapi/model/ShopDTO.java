package br.com.baci.shopapi.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ShopDTO (

    @NotBlank
    String userIdentifier,

    @NotNull
    Float total,

    @NotNull
    LocalDateTime date,

    @NotNull
    List<ItemDTO> items
){    
    public static ShopDTO converter(Shop shop){

        ShopDTO shopDTO = new ShopDTO(
            shop.getUserIdentifier(),
            shop.getTotal(),
            shop.getDate(),
            ItemDTO.convert(shop.getItems())
        );        

        return shopDTO;
    }

}