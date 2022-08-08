package com.omas.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import org.springframework.stereotype.Service;

import com.omas.model.ConcertRepository;
import com.omas.model.Order;
import com.omas.model.OrderDetail;
import com.omas.model.OrderDetailRepository;
import com.omas.model.OrderRepository;
import com.omas.model.OrderResponse;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ConcertRepository concertRepository;
    
    public OrderService(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, ConcertRepository concertRepository){
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.concertRepository = concertRepository;
    }

    public Iterable<OrderResponse> getAllOrder(){
        ArrayList<OrderResponse> resList = new ArrayList<OrderResponse>();
        Iterator<Order> orderIterator = orderRepository.findAll().iterator();
        while(orderIterator.hasNext()){
            Order order = orderIterator.next();
            OrderResponse res = new OrderResponse();
            res.setId(order.getId());
            res.setConcertID(order.getConcertId());
            res.setConcertName(concertRepository.findById(order.getConcertId()).get().getTitle());
            res.setOrderDetail(new ArrayList<HashMap<String, String>>());
            Iterator<OrderDetail> orderDetailIterator = orderDetailRepository.findByOrderId(order.getId()).iterator();
            while(orderDetailIterator.hasNext()){
                OrderDetail orderDetail = orderDetailIterator.next();
                HashMap<String, String> detail = new HashMap<String, String>();
                detail.put("floor", orderDetail.getFloor());
                detail.put("column", orderDetail.getColumn());
                detail.put("number", orderDetail.getNumber());
                detail.put("rank", orderDetail.getRank());
                res.getOrderDetail().add(detail);
            }
            res.setUserID(order.getUserId());
            res.setNameSei(order.getNameSei());
            res.setNameMei(order.getNameMei());
            res.setPostCode(order.getPostCode());
            res.setAddress(order.getAddress());
            res.setMail(order.getMail());
            res.setPhone(order.getPhone());
            res.setOrderDate(order.getOrderDate().toString());
            res.setPayMehtod(order.getPayMethod());
            res.setPayStatus(order.getPayStatus());
            res.setPassMethod(order.getPassMethod());
            res.setPassStatus(order.getPassStatus());
            resList.add(res);
        }
        return resList;
    }

    public OrderResponse setOrder(OrderResponse orderRequest){
        Order newOrder = new Order();
        newOrder.setConcertId(orderRequest.getConcertID());
        newOrder.setUserId(orderRequest.getUserID());
        newOrder.setNameSei(orderRequest.getNameSei());
        newOrder.setNameMei(orderRequest.getNameMei());
        newOrder.setPostCode(orderRequest.getPostCode());
        newOrder.setAddress(orderRequest.getAddress());
        newOrder.setMail(orderRequest.getMail());
        newOrder.setPhone(orderRequest.getPhone());
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try{
            newOrder.setOrderDate(df.parse(orderRequest.getOrderDate()));
        } catch(Exception e) {
            System.out.println(e);
        };
        newOrder.setPayMethod(orderRequest.getPayMehtod());
        newOrder.setPayStatus(orderRequest.getPayStatus());
        newOrder.setPassMethod(orderRequest.getPassMethod());
        newOrder.setPassStatus(orderRequest.getPassStatus());
        orderRepository.save(newOrder);

        Iterator<HashMap<String,String>> detailIterator = orderRequest.getOrderDetail().iterator();
        while(detailIterator.hasNext()){
            HashMap<String, String> reqDetail = detailIterator.next();
            OrderDetail newDetail = new OrderDetail();
            newDetail.setFloor(reqDetail.get("floor"));
            newDetail.setColumn(reqDetail.get("column"));
            newDetail.setNumber(reqDetail.get("number"));
            newDetail.setRank(reqDetail.get("rank"));
            orderDetailRepository.save(newDetail);
        }

        return orderRequest;

    }
}
