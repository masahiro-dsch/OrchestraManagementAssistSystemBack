package com.omas.model;

import org.springframework.data.annotation.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderNumber {
    @Id
    private Long id;
    private Long orderNumber;
}
