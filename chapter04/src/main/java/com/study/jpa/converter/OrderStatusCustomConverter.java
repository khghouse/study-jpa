package com.study.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.study.jpa.enums.OrderStatusCustom;

@Converter
public class OrderStatusCustomConverter implements AttributeConverter<OrderStatusCustom, Integer> {

	@Override
	public Integer convertToDatabaseColumn(final OrderStatusCustom attribute) {
		return attribute.getStatus();
	}

	@Override
	public OrderStatusCustom convertToEntityAttribute(final Integer dbData) {
		return OrderStatusCustom.ofStatus(dbData);
	}
}
