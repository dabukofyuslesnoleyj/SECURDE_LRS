package com.dlsu.lrs.util;

import java.util.ArrayList;

import com.dlsu.lrs.controllers.DataTypes.ItemProxy;
import com.dlsu.lrs.controllers.DataTypes.NameData;
import com.dlsu.lrs.models.Item;
import com.dlsu.lrs.models.ItemAuthor;
import com.dlsu.lrs.models.ItemTag;

public class ModelToProxy {

	public static ItemProxy from(Item item) {
		ItemProxy result = new ItemProxy();
		result.id = item.getId();
		result.name = item.getName();
		result.desc = item.getDescription();
		result.publisher = item.getPublisher().getName();
		result.year = item.getYear();
		result.type = item.getType();
		result.authors = new ArrayList<>();
		result.tags = new ArrayList<>();
		
		for(ItemAuthor a : item.getAuthors()) {
			NameData n = new NameData();
			n.f = a.getFirstName();
			n.m = a.getMiddleName();
			n.l = a.getLastName();
			result.authors.add(n);
		}
		for(ItemTag t : item.getTags())
			result.tags.add(t.getName());
		
		return result;
	}
}
