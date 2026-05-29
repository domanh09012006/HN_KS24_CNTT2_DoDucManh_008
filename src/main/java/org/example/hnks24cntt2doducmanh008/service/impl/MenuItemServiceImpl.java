package org.example.hnks24cntt2doducmanh008.service.impl;

import org.example.hnks24cntt2doducmanh008.dto.request.MenuItemDTORequest;
import org.example.hnks24cntt2doducmanh008.entity.MenuItem;
import org.example.hnks24cntt2doducmanh008.mapper.MenuItemMapper;
import org.example.hnks24cntt2doducmanh008.repository.RestaurantRepository;
import org.example.hnks24cntt2doducmanh008.service.MenuItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.example.hnks24cntt2doducmanh008.dto.response.MenuItemRespone;

import java.util.List;

@Service

public class MenuItemServiceImpl implements MenuItemService {
    private final RestaurantRepository restaurantRepository;
    private final MenuItemMapper menuItemMapper;

    public MenuItemServiceImpl(RestaurantRepository restaurantRepository, MenuItemMapper menuItemMapper) {
        this.restaurantRepository = restaurantRepository;
        this.menuItemMapper = menuItemMapper;
    }

    @Override
    public List<MenuItemRespone> getMenuItems() {
        List<MenuItem> list = restaurantRepository.findAll();
        return list.stream().map(menuItemMapper::ormToMedicationResponse).toList();
    }

    @Override
    public Page<MenuItemRespone> getAllMenuItem(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<MenuItem> pageResult = restaurantRepository.findAll(pageable);
        List<MenuItem> content = pageResult.getContent();
        List<MenuItemRespone> contentResult = content.stream().map(menuItemMapper::ormToMedicationResponse).toList();
        return new PageImpl<>(
                contentResult, pageResult.getPageable(), pageResult.getTotalElements()
        );
    }

    @Override
    public MenuItemRespone insertMenuItem(MenuItemDTORequest medicationDTORequest) {
        MenuItem medication = menuItemMapper.dtoToMenuItem(medicationDTORequest);
        MenuItem result = restaurantRepository.save(medication);
        return menuItemMapper.ormToMedicationResponse(result);
    }

    @Override
    public MenuItemRespone updateMenuItem(Long id, MenuItemDTORequest medicationDTORequest) {
        restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy món ăn có mã: " + id));
        MenuItem menuItem = menuItemMapper.dtoToMenuItem(medicationDTORequest);
        menuItem.setId(id);
        MenuItem result = restaurantRepository.save(menuItem);
        return menuItemMapper.ormToMedicationResponse(result);
    }

    @Override
    public MenuItemRespone deleteMenuItem(Long id) {
        MenuItem menuItem = restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy món ăn có mã: " + id));
        menuItem.setIsDeleted(true);
        MenuItem result = restaurantRepository.save(menuItem);
        return menuItemMapper.ormToMedicationResponse(result);
    }
    @Override
    public MenuItemRespone updatePartialMenuItem(Long id, MenuItemDTORequest menuItemDTORequest) {
        MenuItem menuItem = restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy món ăn có mã: " + id));
        if (menuItemDTORequest.getIsDeleted() != null) {
            menuItem.setIsDeleted(menuItemDTORequest.getIsDeleted());
        }
        if (menuItemDTORequest.getName() != null && !menuItemDTORequest.getName().isBlank()) {
            menuItem.setName(menuItemDTORequest.getName());
        }
        if (menuItemDTORequest.getStatus() != null) {
            menuItem.setStatus(menuItemDTORequest.getStatus());
        }
        if (menuItemDTORequest.getCategory() != null && !menuItemDTORequest.getCategory().isBlank()) {
            menuItem.setCategory(menuItemDTORequest.getCategory());
        }
        if (menuItemDTORequest.getPrice() != null && menuItemDTORequest.getPrice() > 0) {
            menuItem.setPrice(menuItemDTORequest.getPrice());
        }
        MenuItem result = restaurantRepository.save(menuItem);
        return menuItemMapper.ormToMedicationResponse(result);
    }


}
