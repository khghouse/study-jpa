package com.study.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.jpa.entity.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {

}
