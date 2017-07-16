package com.dlsu.lrs.models;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.dlsu.lrs.util.Jsonifiable;

@MappedSuperclass
@SQLDelete(sql = "UPDATE #{#entityName} SET deleted = 1 WHERE id = ?")
@Where(clause = "deleted = 0")
public class _Prototype_AppModel implements Jsonifiable {

	private boolean deleted = false;
	
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getSimpleName() + " [");
		sb.append(String.join(", ", Arrays.asList(this.getClass().getDeclaredFields())
				.stream()
				.map(f -> {
					String s = f.getName() + "=";
					try {
						s += f.get(this) + "";
					} catch (Exception e) {
						s += "ERROR";
					}
					return s;
				}).collect(Collectors.toList())));
		sb.append("]");
		return sb.toString();
	}
}
