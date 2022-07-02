package com.study.jpa.example04.enums;

import java.util.Arrays;

import lombok.Getter;

@Getter
public enum OrderStatusCustom {

	CANCLE(0),
	ORDER(1);

	private int status;

	private OrderStatusCustom(int status) {
		this.status = status;
	}

	public static OrderStatusCustom ofStatus(int status) {
		return Arrays.stream(OrderStatusCustom.values())
				.filter(orderStatusCustom -> orderStatusCustom.getStatus() == status)
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException());
	}
}
