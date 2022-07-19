package com.study.jpa.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.study.jpa.entity.Member;

@ExtendWith(MockitoExtension.class)
public class MemberRepositoryMockitoTest {

	@Mock
	private MemberRepository memberRepository;

	private Member member;

	@BeforeEach
	void setUp() {
		member = Member.builder()
				.name("홍길동")
				.city("서울시")
				.street("올림픽대로")
				.zipcode("12345")
				.build();
	}

	@Test
	void readTest() {
		// given
		when(memberRepository.findById(anyLong())).thenReturn(Optional.of(member));

		// when
		Member selectedMember = memberRepository.findById(anyLong()).get();

		// then
		verify(memberRepository, times(1)).findById(anyLong());
		assertThat(selectedMember).isEqualTo(member);
	}

	@Test
	void createTest() {
		// given
		when(memberRepository.save(any())).thenReturn(member);

		// when
		Member savedMember = memberRepository.save(any());

		// then
		verify(memberRepository).save(any());
		assertThat(savedMember).isEqualTo(member);
	}

	@Test
	void deleteTest() {
		// given
		when(memberRepository.findById(anyLong())).thenReturn(Optional.of(member));

		// when
		Member selectedMember = memberRepository.findById(anyLong()).get();
		memberRepository.delete(selectedMember);

		// then
		verify(memberRepository).findById(anyLong());
		verify(memberRepository).delete(selectedMember);
	}
}
