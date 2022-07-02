package com.study.jpa.example04.repository;

import org.springframework.data.repository.CrudRepository;

import com.study.jpa.example04.entity.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Long>{

}
