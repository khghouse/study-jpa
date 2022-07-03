package com.study.jpa.example05.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.jpa.example05.entity.Item;

@Repository("itemRepositoryEx05")
public interface ItemRepository extends CrudRepository<Item, Long> {

}
