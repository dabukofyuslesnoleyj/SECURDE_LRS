package com.dlsu.lrs.models;

import com.dlsu.lrs.util.Jsonifiable;

public enum AccountType implements Jsonifiable {

	CUSTOMER, LIBRARY_MANAGER, LIBRARY_STAFF, ADMIN;
}
