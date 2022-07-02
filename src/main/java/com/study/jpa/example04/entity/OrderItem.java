package com.study.jpa.example04.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;

@Entity
@Getter
public class OrderItem {

	@Id
	@Column(name = "ORDER_ITEM_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ORDER_ID")
	private Long orderId;

	@Column(name = "ITEM_ID")
	private Long itemId;

	private int orderPrice;
	private int count;
}
