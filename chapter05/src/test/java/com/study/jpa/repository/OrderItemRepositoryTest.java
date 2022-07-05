package com.study.jpa.repository;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.jpa.entity.Item;
import com.study.jpa.entity.Member;
import com.study.jpa.entity.Order;
import com.study.jpa.entity.OrderItem;
import com.study.jpa.enums.OrderStatus;

@SpringBootTest
@Transactional
public class OrderItemRepositoryTest {

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Test
	public void createTest() throws Exception {

		Item item = Item.builder()
				.name("바나나")
				.price(3500)
				.stockQuantity(10)
				.build();
		itemRepository.save(item);

		Member member = Member.builder()
				.name("홍길동")
				.city("서울시")
				.street("올림픽대로")
				.zipcode("12345")
				.build();
		memberRepository.save(member);

		Order order = Order.builder()
				.member(member)
				.orderDate(LocalDateTime.now())
				.status(OrderStatus.ORDER)
				.build();
		orderRepository.save(order);

		OrderItem orderItem = OrderItem.builder()
				.order(order)
				.item(item)
				.orderPrice(3500)
				.count(1)
				.build();

		orderItemRepository.save(orderItem);
	}
}
