package org.example.hnks24cntt2doducmanh008.dto.request;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.hnks24cntt2doducmanh008.entity.MenuItemStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MenuItemDTORequest {
    @NotBlank(message = "Không được để trống tên món ăn")
    private String name;
    @NotBlank(message = "Khong duoc de trong ten danh muc")
    private String category;
    @Min(value = 0,message = "Gia ban phai lon hon 0")
    private Double price;
    private MenuItemStatus Status;
    @NotNull(message = "Không được để trống trạng thái xóa")
    private Boolean isDeleted;
}





