package com.omas.model;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    @Id
    private Long id;
    
    private Long concertID;
    private String concertName;
    private ArrayList<HashMap<String,String>> orderDetail;
    private String userID;
    private String nameSei;
    private String nameMei;
    private String postCode;
    private String address;
    private String mail;
    private String phone;
    private String orderDate;
    private String payMehtod;
    private String payStatus;
    private String passMethod;
    private String passStatus;
}
