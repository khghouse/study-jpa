package com.study.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;

@Entity
@Getter
public class Item {

	@Id
	@Column(name = "ITEM_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private int price;
	private int stockQuantity;
}
