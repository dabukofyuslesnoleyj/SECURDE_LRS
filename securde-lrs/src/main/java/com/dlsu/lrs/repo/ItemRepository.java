package com.dlsu.lrs.repo;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.Item;

public interface ItemRepository extends CrudRepository<Item, String> {
}
