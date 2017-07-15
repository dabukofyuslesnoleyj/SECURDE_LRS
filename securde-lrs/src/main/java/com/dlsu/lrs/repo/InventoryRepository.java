package com.dlsu.lrs.repo;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, String> {
}
