package com.study.jpa.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.study.jpa.entity.Member;
import com.study.jpa.entity.Order;
import com.study.jpa.enums.OrderStatus;
import com.study.jpa.repository.OrderRepository;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

	@InjectMocks
	private OrderService orderService;

	@Mock
	private OrderRepository orderRepository;

	@Test
	public void createOrder() throws Exception {
		// given
		Order order = Order.builder()
				.member(Member.builder().id(1L).build())
				.orderDate(LocalDateTime.now())
				.status(OrderStatus.ORDER)
				.build();

		when(orderRepository.save(any())).thenReturn(order);

		// when
		Order result = orderService.createOrder(Order.builder().build());

		System.out.println("result : " + result);
		System.out.println("order : " + order);

		// then
		verify(orderRepository, times(1)).save(any());
		assertThat(result, equalTo(order));
	}
}
