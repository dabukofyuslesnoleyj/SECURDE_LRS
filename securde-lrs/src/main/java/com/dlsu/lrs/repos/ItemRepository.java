package com.dlsu.lrs.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {
	
	List<Item> findByNameContainsOrDescriptionContainsAllIgnoreCase(String name, String desc);
}
