package com.study.jpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.study.jpa.converter.OrderStatusCustomConverter;
import com.study.jpa.enums.OrderStatusCustom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrdersCustom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "member_id")
	private Long memberId;

	private LocalDateTime orderDate;

	@Convert(converter = OrderStatusCustomConverter.class)
	private OrderStatusCustom status;
}
