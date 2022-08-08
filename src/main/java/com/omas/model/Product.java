package com.omas.model;

import org.springframework.data.annotation.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private Long id;

    private String name;

    private String description;

    private Integer quantity;
}