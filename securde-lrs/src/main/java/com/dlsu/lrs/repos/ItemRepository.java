package com.dlsu.lrs.repos;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.Item;

public interface ItemRepository extends CrudRepository<Item, String> {
}
