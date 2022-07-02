package com.study.jpa.example04.repository;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.jpa.example04.entity.Member;
import com.study.jpa.example04.entity.Orders;
import com.study.jpa.example04.enums.OrderStatus;

@SpringBootTest
public class OrdersRepositoryTest {

	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Test
	public void createTest() throws Exception {
		Orders orders = Orders
				.builder()
				.memberId(1L)
				.orderDate(new Date())
				.status(OrderStatus.ORDER)
				.build();

		ordersRepository.save(orders);
	}

	@Test
	public void readTest() throws Exception {
		Orders orders = Optional.ofNullable(ordersRepository.findById(2L)).get()
				.orElseThrow(() -> new IllegalArgumentException());

		System.out.println("orders : " + orders);

		Member member = Optional.ofNullable(memberRepository.findById(orders.getMemberId())).get()
				.orElseThrow(() -> new IllegalArgumentException());

		System.out.println("member : " + member);
	}
}
