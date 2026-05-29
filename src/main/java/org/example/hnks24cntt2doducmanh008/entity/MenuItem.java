package org.example.hnks24cntt2doducmanh008.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
@Builder
@Table(name= "resstaurant_menu_items")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100,  nullable = false, unique = true)
    private String name;
    @Column(length = 100,  nullable = false)
    private String category;
    private Double price;
    private MenuItemStatus Status;
    @Column(name= "is_deleted")
    private Boolean isDeleted;
}





