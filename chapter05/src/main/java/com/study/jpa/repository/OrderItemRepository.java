package com.study.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.jpa.entity.OrderItem;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

}
