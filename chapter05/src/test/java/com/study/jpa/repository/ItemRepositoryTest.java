package com.study.jpa.repository;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.jpa.entity.Item;

/*
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
*/
@SpringBootTest
@Transactional
public class ItemRepositoryTest {

	@Autowired
	private ItemRepository itemRepository;

	@Test
	public void insertTest() throws Exception {
		Item item = Item.builder()
				.name("바나나")
				.price(3500)
				.stockQuantity(10)
				.build();

		System.out.println("item : " + item);
		itemRepository.save(item);
	}
}
