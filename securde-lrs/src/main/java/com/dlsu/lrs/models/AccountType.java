package com.dlsu.lrs.models;

import com.dlsu.lrs.util.Jsonifiable;

public enum AccountType implements Jsonifiable {

	ADMIN, MANAGER, STAFF, FACULTY, STUDENT;
}
