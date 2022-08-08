package com.omas.model;

import org.springframework.data.annotation.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    @Id
    private Long id;
    private Long orderId;
    private String floor;
    private String column;
    private String number;
    private String rank;
}
