package com.omas.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, Long>{
    List<OrderDetail> findByOrderId(Long orderId);
}
