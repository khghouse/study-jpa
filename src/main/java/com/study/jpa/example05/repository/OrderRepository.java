package com.study.jpa.example05.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.jpa.example05.entity.Order;

@Repository("orderRepositoryEx05")
public interface OrderRepository extends CrudRepository<Order, Long> {

}
