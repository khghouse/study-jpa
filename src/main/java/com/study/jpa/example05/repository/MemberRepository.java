package com.study.jpa.example05.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.jpa.example05.entity.Member;

@Repository("memberRepositoryEx05")
public interface MemberRepository extends CrudRepository<Member, Long> {

}
