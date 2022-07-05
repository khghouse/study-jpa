package com.study.jpa.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.study.jpa.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "orders")
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	@Id
	@Column(name = "ORDER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member member;

	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems;

	private LocalDateTime orderDate;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;
}
