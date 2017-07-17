package com.dlsu.lrs.repos;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.ItemAuthor;

public interface ItemAuthorRepository extends CrudRepository<ItemAuthor, Long> {
	
	ItemAuthor findByFirstNameAndMiddleNameAndLastNameAllIgnoreCase(String firstName, String middleName, String lastName);
}
