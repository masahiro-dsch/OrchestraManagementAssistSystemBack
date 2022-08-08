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

    public Iterable<OrderNumber> getOrderNumber(ArrayList<Long> ids){
        Iterable<OrderNumber> res = orderNumberRepository.findAllById(ids);
        OrderNumber orderNumber = orderNumberRepository.findAllById(ids).iterator().next();
        OrderNumber orderNumberPlus = new OrderNumber(orderNumber.getId(),orderNumber.getOrderNumber()+1);
        orderNumberRepository.save(orderNumberPlus);
        return res;
    }
}
