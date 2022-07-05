package com.study.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.jpa.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
