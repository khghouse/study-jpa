package com.study.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.study.jpa.entity.Member;

public interface MemberRepository extends CrudRepository<Member, Long>{
	
}
