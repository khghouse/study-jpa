package com.study.jpa.example04.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.study.jpa.example04.enums.OrderStatusCustom;

@Converter
public class OrderStatusCustomConverter implements AttributeConverter<OrderStatusCustom, Integer> {

	@Override
	public Integer convertToDatabaseColumn(OrderStatusCustom attribute) {
		return attribute.getStatus();
	}

	@Override
	public OrderStatusCustom convertToEntityAttribute(Integer dbData) {
		return OrderStatusCustom.ofStatus(dbData);
	}
}
