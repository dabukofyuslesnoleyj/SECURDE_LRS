package com.dlsu.lrs.repos;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.ItemBorrowing;

public interface ItemBorrowingRepository extends CrudRepository<ItemBorrowing, String> {
}
