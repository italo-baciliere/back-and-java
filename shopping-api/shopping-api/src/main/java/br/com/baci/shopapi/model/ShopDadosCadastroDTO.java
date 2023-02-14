package br.com.baci.shopapi.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ShopDadosCadastroDTO(

    @NotBlank
    String userIdentifier,
    
    Float total,    
    LocalDateTime date,

    @NotNull
    List<ItemDTO> items
){    
    public static ShopDadosCadastroDTO converter(Shop shop){

        ShopDadosCadastroDTO shopDTO = new ShopDadosCadastroDTO(
            shop.getUserIdentifier(),
            shop.getTotal(),
            shop.getDate(),
            ItemDTO.convert(shop.getItems())
        );        

        return shopDTO;
    }

}