package com.dlsu.lrs.repo;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.ItemType;

public interface ItemTypeRepository extends CrudRepository<ItemType, String> {
}
