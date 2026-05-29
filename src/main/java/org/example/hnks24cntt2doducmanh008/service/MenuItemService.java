package org.example.hnks24cntt2doducmanh008.service;


import org.example.hnks24cntt2doducmanh008.dto.request.MenuItemDTORequest;
import org.example.hnks24cntt2doducmanh008.dto.response.MenuItemRespone;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MenuItemService {
    List<MenuItemRespone> getMenuItems();
    Page<MenuItemRespone> getAllMenuItem(Integer page, Integer pageSize);
    MenuItemRespone insertMenuItem(MenuItemDTORequest menuItemDTORequest);
    MenuItemRespone updateMenuItem(Long id, MenuItemDTORequest menuItemDTORequest);
    MenuItemRespone updatePartialMenuItem(Long id, MenuItemDTORequest menuItemDTORequest);
    MenuItemRespone deleteMenuItem(Long id);
}


















































