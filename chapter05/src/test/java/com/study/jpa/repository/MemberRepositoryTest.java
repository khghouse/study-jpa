package com.study.jpa.repository;

import javax.transaction.Transactional;

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
}
