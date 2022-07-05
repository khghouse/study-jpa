package com.study.jpa.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.jpa.entity.OrdersCustom;
import com.study.jpa.enums.OrderStatusCustom;

@SpringBootTest
public class OrdersCustomRepositoryTest {

	@Autowired
	private OrdersCustomRepository ordersCustomRepository;

	@Test
	public void createTest() throws Exception {
		OrdersCustom ordersCustom = OrdersCustom
				.builder()
				.memberId(2L)
				.orderDate(LocalDateTime.now())
				.status(OrderStatusCustom.ORDER)
				.build();

		ordersCustomRepository.save(ordersCustom);
	}

	@Test
	public void readTest() throws Exception {
		OrdersCustom ordersCustom = Optional.ofNullable(ordersCustomRepository.findById(1L)).get()
				.orElseThrow(() -> new IllegalArgumentException());
		System.out.println("ordersCustom : " + ordersCustom);
		System.out.println("enum check : " + ordersCustom.getStatus().getStatus());
	}
}
