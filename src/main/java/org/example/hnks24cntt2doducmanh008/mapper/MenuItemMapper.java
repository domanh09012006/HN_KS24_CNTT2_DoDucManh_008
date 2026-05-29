
package org.example.hnks24cntt2doducmanh008.mapper;

import org.example.hnks24cntt2doducmanh008.dto.request.MenuItemDTORequest;
import org.example.hnks24cntt2doducmanh008.dto.response.MenuItemRespone;
import org.example.hnks24cntt2doducmanh008.entity.MenuItem;


@org.springframework.stereotype.Component
public class MenuItemMapper {
    public MenuItem dtoToMenuItem(MenuItemDTORequest menuItemDTORequest){
        return MenuItem.builder()
                .price(menuItemDTORequest.getPrice())
                .name(menuItemDTORequest.getName())
                .isDeleted(false)
                .category(menuItemDTORequest.getCategory())
                .Status(menuItemDTORequest.getStatus())
                .build();
    }

    public MenuItemRespone ormToMedicationResponse(MenuItem menuItem){
        return MenuItemRespone.builder()
                .id(menuItem.getId())
                .price(menuItem.getPrice())
                .name(menuItem.getName())
                .isDelete(false)
                .manufacturer(menuItem.getCategory())
                .status(menuItem.getStatus())
                .build();
    }
}
