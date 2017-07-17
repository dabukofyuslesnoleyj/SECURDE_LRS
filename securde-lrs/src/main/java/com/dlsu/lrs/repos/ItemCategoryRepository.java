package com.dlsu.lrs.repos;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.ItemCategory;

public interface ItemCategoryRepository extends CrudRepository<ItemCategory, String> {
}
