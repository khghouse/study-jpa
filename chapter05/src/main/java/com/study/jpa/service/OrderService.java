package com.study.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.jpa.entity.Order;
import com.study.jpa.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public Order createOrder(final Order order) throws Exception {
		return orderRepository.save(order);
	}
}
