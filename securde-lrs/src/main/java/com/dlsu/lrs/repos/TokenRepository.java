package com.dlsu.lrs.repos;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.Token;

@Deprecated
public interface TokenRepository extends CrudRepository<Token, String> {
	
	Token findByToken(String token);
}
