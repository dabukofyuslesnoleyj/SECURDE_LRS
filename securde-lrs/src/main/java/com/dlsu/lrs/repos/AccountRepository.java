package com.dlsu.lrs.repos;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.Account;

public interface AccountRepository extends CrudRepository<Account, String> {
	
	Account findByUsernameAndPassword(String username, String password);
}
