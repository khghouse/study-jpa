package com.study.jpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.jpa.entity.Member;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;

	@Test
	public void createTest() throws Exception {
		Member member = Member.builder()
				.name("홍길동")
				.city("서울시")
				.street("올림픽대로")
				.zipcode("12345")
				.build();

		System.out.println("member : " + member);
		memberRepository.save(member);
	}

	@Nested
	class ReadTest {

		@Test
		void success() {
			Member member = Optional.ofNullable(memberRepository.findById(2L)).get()
					.orElseThrow(() -> new IllegalArgumentException());

			assertEquals("홍길동", member.getName());
			assertEquals("서울시", member.getCity());
			assertEquals("올림픽대로", member.getStreet());
			assertEquals("12345", member.getZipcode());
		}

		@Test
		void fail() {
			assertThrows(IllegalArgumentException.class, () -> {
				Optional.ofNullable(memberRepository.findById(9999L)).get()
						.orElseThrow(() -> new IllegalArgumentException());
			});
		}
	}
}
