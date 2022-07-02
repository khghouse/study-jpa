package com.study.jpa.example04.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.jpa.example04.entity.Member;

@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;

	@Test
	public void createTest() throws Exception {
		Member member = Member
				.builder()
				.name("홍길동")
				.city("서울시")
				.street("올림픽대로")
				.zipcode("12345")
				.build();

		memberRepository.save(member);
	}
}
