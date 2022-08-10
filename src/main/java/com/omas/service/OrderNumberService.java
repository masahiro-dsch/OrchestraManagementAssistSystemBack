package com.omas.service;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.omas.model.OrderNumber;
import com.omas.model.OrderNumberRepository;

@Service
public class OrderNumberService {
    private final OrderNumberRepository orderNumberRepository;

    public OrderNumberService(OrderNumberRepository orderNumberRepository){
        this.orderNumberRepository = orderNumberRepository;
    }

    // public Iterable<OrderNumber> getOrderNumber(ArrayList<Long> ids){
    public OrderNumber getOrderNumber(Long id){
        // Iterable<OrderNumber> res = orderNumberRepository.findAllById(ids);
        // OrderNumber orderNumber = orderNumberRepository.findById(ids).iterator().next();
        OrderNumber orderNumber = orderNumberRepository.findById(id).get();
        OrderNumber orderNumberPlus = new OrderNumber(orderNumber.getId(),orderNumber.getOrderNumber()+1);
        orderNumberRepository.save(orderNumberPlus);
        return orderNumber;
    }
}
