package com.dlsu.lrs.repos;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.ItemRating;

public interface ItemRatingRepository extends CrudRepository<ItemRating, String> {
}
