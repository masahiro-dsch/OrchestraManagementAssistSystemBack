package com.omas.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, Long>{
    Iterable<OrderDetail> findAllByOrderId(Long orderId);
}
