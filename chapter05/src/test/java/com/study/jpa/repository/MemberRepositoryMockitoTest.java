package com.study.jpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.study.jpa.entity.Member;

@ExtendWith(MockitoExtension.class)
public class MemberRepositoryMockitoTest {

	@Mock
	private MemberRepository memberRepository;

	@Test
	void readTest() {
		// given
		Member member = Member.builder()
				.name("홍길동")
				.city("서울시")
				.street("올림픽대로")
				.zipcode("12345")
				.build();

		// when
		when(memberRepository.findById(anyLong())).thenReturn(Optional.of(member));
		System.out.println(memberRepository.findById(anyLong()));

		// then
		verify(memberRepository).findById(anyLong());
		assertEquals(Optional.of(member), memberRepository.findById(anyLong()));
	}
}
