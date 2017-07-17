package com.dlsu.lrs.models;

import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Deprecated
@MappedSuperclass
@SQLDelete(sql = "UPDATE #{#entityName} SET deleted = 1 WHERE id = ?")
@Where(clause = "deleted = 0")
public class _Prototype_AppModel {

	private boolean deleted = false;
	
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
