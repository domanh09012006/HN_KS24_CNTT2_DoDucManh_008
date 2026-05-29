package org.example.hnks24cntt2doducmanh008.advice;


import lombok.extern.slf4j.Slf4j;
import org.example.hnks24cntt2doducmanh008.dto.response.MenuItemApiRespone;
import org.example.hnks24cntt2doducmanh008.exception.MenuItemExist;
import org.example.hnks24cntt2doducmanh008.exception.MenuItemNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.TreeMap;

@RestControllerAdvice
@Slf4j
public class MenuItemAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MenuItemApiRespone<Map<String, String>>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new TreeMap<>();
        for (FieldError fieldError : ex.getFieldErrors()) {
            erros.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        log.warn("Lỗi: {}", erros);
        return new ResponseEntity<>(new MenuItemApiRespone<>(
                false,
                "Lỗi xác thực dữ liệu",
                null,
                erros,
                HttpStatus.BAD_REQUEST
        ), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MenuItemExist.class)
    public ResponseEntity<MenuItemApiRespone<String>> handleMedicationExist(MenuItemExist ex) {
        log.warn("Lỗi: {}", ex.getLocalizedMessage());
        return new ResponseEntity<>(new MenuItemApiRespone<>(
                false,
                "Lỗi: Trùng lặp tên mon",
                null,
                ex.getLocalizedMessage(),
                HttpStatus.BAD_REQUEST
        ), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MenuItemNotFound.class)
    public ResponseEntity<MenuItemApiRespone<String>> handleMedicationNotFound(MenuItemNotFound ex) {
        return new ResponseEntity<>(new MenuItemApiRespone<>(
                false,
                "Lỗi: Không tìm thấy tên mon an",
                null,
                ex.getLocalizedMessage(),
                HttpStatus.NOT_FOUND
        ), HttpStatus.NOT_FOUND);
    }
}