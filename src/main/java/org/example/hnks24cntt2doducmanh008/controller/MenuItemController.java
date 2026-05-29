package org.example.hnks24cntt2doducmanh008.controller;

import jakarta.validation.Valid;
import org.example.hnks24cntt2doducmanh008.dto.request.MenuItemDTORequest;
import org.example.hnks24cntt2doducmanh008.dto.response.MenuItemApiRespone;
import org.example.hnks24cntt2doducmanh008.dto.response.MenuItemRespone;
import org.example.hnks24cntt2doducmanh008.service.MenuItemService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class MenuItemController {
    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping
    public ResponseEntity<MenuItemApiRespone<List<MenuItemRespone>>> getmenuItems() {
        return new ResponseEntity<>(new MenuItemApiRespone<>(
                true,
                "Lấy danh sách món an thành công.",
                menuItemService.getMenuItems(),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @GetMapping("/pagination")
    public ResponseEntity<MenuItemApiRespone<Page<MenuItemRespone>>> getMadicationPaging(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        Integer pageSize = 5;
        return new ResponseEntity<>(new MenuItemApiRespone<>(
                true,
                "Lấy danh sách món trang " + page + " thành công",
                menuItemService.getAllMenuItem(page - 1, pageSize),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MenuItemApiRespone<MenuItemRespone>> insertmenuItem(@Valid @RequestBody MenuItemDTORequest menuItemDTORequest) {
        return new ResponseEntity<>(new MenuItemApiRespone<>(
                true,
                "Thêm mới món ăn thành công",
                menuItemService.insertMenuItem(menuItemDTORequest),
                null,
                HttpStatus.CREATED
        ), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuItemApiRespone<MenuItemRespone>> updatemenuItem(@PathVariable Long id, @Valid @RequestBody MenuItemDTORequest menuItemDTORequest) {
        return new ResponseEntity<>(new MenuItemApiRespone<>(
                true,
                "Cập nhật thông tin món ăn thành công",
                menuItemService.updateMenuItem(id, menuItemDTORequest),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MenuItemApiRespone<MenuItemRespone>> updatePartialmenuItem(@PathVariable Long id, @RequestBody MenuItemDTORequest menuItemDTORequest) {
        return new ResponseEntity<>(new MenuItemApiRespone<>(
                true,
                "Cập nhật thông tin món ăn thành công",
                menuItemService.updatePartialMenuItem(id, menuItemDTORequest),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MenuItemApiRespone<MenuItemRespone>> deletemenuItem(@PathVariable Long id) {
        return new ResponseEntity<>(new MenuItemApiRespone<>(
                true,
                "Cập nhật thông tinmonsn ăn thành công",
                menuItemService.deleteMenuItem(id),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }
}
