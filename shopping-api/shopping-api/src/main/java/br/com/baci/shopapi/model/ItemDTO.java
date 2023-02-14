package br.com.baci.shopapi.model;

import java.util.List;
import java.util.stream.Collectors;

public record ItemDTO(
    String product_identifier,
    Float price
){

    public static ItemDTO convert(Item item){        
        ItemDTO itemDTO = new ItemDTO(
            item.getProduct_identifier(),
            item.getPrice()
        );
        return itemDTO;
    }

    public static List<ItemDTO> convert(List<Item> items) {
        return items.stream()
        .map(ItemDTO::convert)
        .collect(Collectors.toList());        
    }}
