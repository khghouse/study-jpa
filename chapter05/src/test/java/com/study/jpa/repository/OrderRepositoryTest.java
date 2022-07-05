package com.study.jpa.repository;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.jpa.entity.Member;
import com.study.jpa.entity.Order;
import com.study.jpa.enums.OrderStatus;

@SpringBootTest
@Transactional
public class OrderRepositoryTest {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Test
	public void createTest() throws Exception {

		Member member = Member.builder()
				.name("홍길동")
				.city("서울시")
				.street("올림픽대로")
				.zipcode("12345")
				.build();
		System.out.println("member : " + member);
		memberRepository.save(member);

		Order order = Order.builder()
				.member(member)
				.orderDate(LocalDateTime.now())
				.status(OrderStatus.ORDER)
				.build();

		System.out.println("order : " + order);
		orderRepository.save(order);
	}
}
