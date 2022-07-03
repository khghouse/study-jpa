package com.study.jpa.example05.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.jpa.example05.entity.OrderItem;

@Repository("orderItemRepositoryEx05")
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

}
