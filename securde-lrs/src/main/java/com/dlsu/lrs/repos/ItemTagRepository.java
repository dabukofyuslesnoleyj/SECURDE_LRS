package com.dlsu.lrs.repos;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.ItemTag;

public interface ItemTagRepository extends CrudRepository<ItemTag, Long> {
	
	ItemTag findByNameIgnoreCase(String name);
}
