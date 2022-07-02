package com.study.jpa.example04.repository;

import org.springframework.data.repository.CrudRepository;

import com.study.jpa.example04.entity.OrdersCustom;

public interface OrdersCustomRepository extends CrudRepository<OrdersCustom, Long> {

}
