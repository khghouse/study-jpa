package com.study.jpa.dto;

import java.util.List;

import com.study.jpa.entity.OrderItem;
import com.study.jpa.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class OrderDto {

	@Getter
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Request {

		private Long memberId;
		private List<OrderItem> orderItems;
		private OrderStatus status;
	}
}
