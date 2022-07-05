package com.study.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.study.jpa.entity.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Long>{

}
