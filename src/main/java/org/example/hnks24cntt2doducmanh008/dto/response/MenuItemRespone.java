package org.example.hnks24cntt2doducmanh008.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.hnks24cntt2doducmanh008.entity.MenuItemStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class MenuItemRespone {
    private Long id;
    private String name;
    private String manufacturer;
    private Double price;
    private MenuItemStatus status;
    private Boolean isDelete;
}









































