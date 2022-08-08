package com.omas.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    private Long id;
    private Long concertId;
    private String userId;
    private String nameSei;
    private String nameMei;
    private String postCode;
    private String address;
    private String mail;
    private String phone;
    private Date orderDate;
    private String payMethod;
    private String payStatus;
    private String passMethod;
    private String passStatus;
}
