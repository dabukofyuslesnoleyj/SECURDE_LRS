package com.dlsu.lrs.repo;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.Account;

public interface AccountRepository extends CrudRepository<Account, String> {

}
