package com.study.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "orderItem")
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

	@Id
	@Column(name = "ORDER_ITEM_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ORDER_ID")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "ITEM_ID")
	private Item item;

	private int orderPrice;
	private int count;
}
