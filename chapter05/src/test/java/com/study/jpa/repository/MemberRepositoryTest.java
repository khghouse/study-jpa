package com.study.jpa.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.study.jpa.entity.Member;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
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
	void createTest() {
		// when
		Member dbMember = memberRepository.save(member);

		// then
		assertThat(dbMember.getName()).isEqualTo(member.getName());
		assertThat(dbMember.getCity()).isEqualTo(member.getCity());
		assertThat(dbMember.getStreet()).isEqualTo(member.getStreet());
		assertThat(dbMember.getZipcode()).isEqualTo(member.getZipcode());
	}

	@Nested
	class ReadTest {
		@Test
		void success() {
			// given
			memberRepository.save(member);

			// when
			Member dbMember = Optional.ofNullable(memberRepository.findById(member.getId())).get()
					.orElseThrow(() -> new IllegalArgumentException());

			// then
			assertThat(dbMember.getName()).isEqualTo(member.getName());
			assertThat(dbMember.getCity()).isEqualTo(member.getCity());
			assertThat(dbMember.getStreet()).isEqualTo(member.getStreet());
			assertThat(dbMember.getZipcode()).isEqualTo(member.getZipcode());
		}

		@Test
		void fail() {
			assertThrows(IllegalArgumentException.class, () -> {
				Optional.ofNullable(memberRepository.findById(9999L)).get()
						.orElseThrow(() -> new IllegalArgumentException());
			});
		}
	}

	@Test
	void updateTest() {
		// given
		memberRepository.save(member);
		Member dbMember = testEntityManager.find(Member.class, member.getId());

		// when
		dbMember.updateZipcode("67890");
		testEntityManager.flush();
		Member updatedMember = Optional.ofNullable(memberRepository.findById(member.getId())).get()
				.orElseThrow(() -> new IllegalArgumentException());

		// then
		assertThat(updatedMember.getZipcode()).isEqualTo(dbMember.getZipcode());
	}

	@Test
	void deleteTest() {
		// given
		memberRepository.save(member);
		Member dbMember = testEntityManager.find(Member.class, member.getId());

		// when
		testEntityManager.remove(dbMember);

		// when
		assertThat(dbMember.getName()).isEqualTo(member.getName());
		assertThat(dbMember.getCity()).isEqualTo(member.getCity());
		assertThat(dbMember.getStreet()).isEqualTo(member.getStreet());
		assertThat(dbMember.getZipcode()).isEqualTo(member.getZipcode());

		testEntityManager.flush();

		assertThrows(IllegalArgumentException.class, () -> {
			Optional.ofNullable(memberRepository.findById(member.getId())).get()
					.orElseThrow(() -> new IllegalArgumentException());
		});
	}
}
