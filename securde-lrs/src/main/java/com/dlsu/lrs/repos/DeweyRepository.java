package com.dlsu.lrs.repos;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.ItemDewey;

public interface DeweyRepository extends CrudRepository<ItemDewey, String> {
}
