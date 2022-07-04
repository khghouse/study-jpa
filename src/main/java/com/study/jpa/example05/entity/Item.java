package com.study.jpa.example05.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "itemEx05")
@Table(name = "item")
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Item {

	@Id
	@Column(name = "ITEM_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private int price;
	private int stockQuantity;
}
