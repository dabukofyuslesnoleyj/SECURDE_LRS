package com.dlsu.lrs.repo;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.ItemCategory;

public interface ItemCategoryRepository extends CrudRepository<ItemCategory, String> {
}
