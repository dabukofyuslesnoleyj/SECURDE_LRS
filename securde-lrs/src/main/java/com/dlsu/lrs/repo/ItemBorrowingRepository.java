package com.dlsu.lrs.repo;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.ItemBorrowing;

public interface ItemBorrowingRepository extends CrudRepository<ItemBorrowing, String> {
}
