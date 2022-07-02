package com.study.jpa.example04.repository;

import org.springframework.data.repository.CrudRepository;

import com.study.jpa.example04.entity.Member;

public interface MemberRepository extends CrudRepository<Member, Long>{
	
}
