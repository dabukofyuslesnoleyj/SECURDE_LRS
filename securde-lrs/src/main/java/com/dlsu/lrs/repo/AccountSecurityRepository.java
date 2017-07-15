package com.dlsu.lrs.repo;

import org.springframework.data.repository.CrudRepository;

import com.dlsu.lrs.models.AccountSecurity;

public interface AccountSecurityRepository extends CrudRepository<AccountSecurity, String> {
}
