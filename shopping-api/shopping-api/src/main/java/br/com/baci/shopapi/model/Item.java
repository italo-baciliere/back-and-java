package br.com.baci.shopapi.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {        

    private String product_identifier;
    private Float price;

    public static Item convert(ItemDTO itemDTO){
        Item item = new Item(
            itemDTO.product_identifier(),
            itemDTO.price()
        );
        return item;
    }

    // public static List<Item> convert(List<ItemDTO> listItemsDTO){
    //     Item item = new Item(
    //         itemDTO.product_identifier(),
    //         itemDTO.price());
    //     return item;
    // }

}