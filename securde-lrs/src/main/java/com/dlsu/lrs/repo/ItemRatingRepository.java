package com.dlsu.lrs.repo;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.ItemRating;

public interface ItemRatingRepository extends CrudRepository<ItemRating, String> {
}
