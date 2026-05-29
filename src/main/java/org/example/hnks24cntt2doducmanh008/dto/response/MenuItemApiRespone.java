package org.example.hnks24cntt2doducmanh008.dto.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MenuItemApiRespone<T> {
    private Boolean success;
    private String message;
    private T data;
    private T errors;
    private HttpStatus httpStatus;
}







