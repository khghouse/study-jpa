package com.study.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.jpa.entity.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

}
