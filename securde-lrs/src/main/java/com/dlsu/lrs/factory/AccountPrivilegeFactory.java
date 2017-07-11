package com.dlsu.lrs.factory;

import java.util.Arrays;
import java.util.List;

import com.dlsu.lrs.models.AccountPrivilege;

public class AccountPrivilegeFactory {

	public List<AccountPrivilege> rootPrivileges() {
		return Arrays.asList(
				AccountPrivilege.ACCOUNT_UNLOCK,
				AccountPrivilege.MANAGER_CREATE,
				AccountPrivilege.STAFF_CREATE);
	}
	public List<AccountPrivilege> adminPrivileges() {
		return Arrays.asList(
				AccountPrivilege.ACCOUNT_UNLOCK,
				AccountPrivilege.MANAGER_CREATE,
				AccountPrivilege.STAFF_CREATE);
	}
	public List<AccountPrivilege> managerPrivileges() {
		return Arrays.asList(
				AccountPrivilege.INVENTORY_EDIT,
				AccountPrivilege.ITEM_ADD,
				AccountPrivilege.STAFF_CREATE);
	}
	public List<AccountPrivilege> staffPrivileges() {
		return Arrays.asList(
				AccountPrivilege.INVENTORY_EDIT,
				AccountPrivilege.ITEM_ADD,
				AccountPrivilege.STAFF_CREATE);
	}
	public List<AccountPrivilege> facultyPrivileges() {
		return Arrays.asList(
				AccountPrivilege.INVENTORY_EDIT,
				AccountPrivilege.ITEM_ADD,
				AccountPrivilege.STAFF_CREATE);
	}
	public List<AccountPrivilege> studentPrivileges() {
		return Arrays.asList(
				AccountPrivilege.INVENTORY_EDIT,
				AccountPrivilege.ITEM_ADD,
				AccountPrivilege.STAFF_CREATE);
	}
}
