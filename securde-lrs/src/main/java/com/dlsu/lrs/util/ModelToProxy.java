package com.dlsu.lrs.util;

import java.util.ArrayList;

import com.dlsu.lrs.models.Account;
import com.dlsu.lrs.models.Item;
import com.dlsu.lrs.models.ItemAuthor;
import com.dlsu.lrs.models.ItemTag;
import com.dlsu.lrs.util.DataTypes.AccountProxy;
import com.dlsu.lrs.util.DataTypes.ItemProxy;
import com.dlsu.lrs.util.DataTypes.NameData;
import com.dlsu.lrs.util.DataTypes.SecretData;

public class ModelToProxy {

	public static ItemProxy from(Item item) {
		ItemProxy result = new ItemProxy();
		result.id = item.getId();
		result.name = item.getName();
		result.desc = item.getDescription();
		result.publisher = item.getPublisher().getName();
		result.year = item.getYear();
		result.type = item.getType();
		result.status = item.getStatus();
		
		result.authors = new ArrayList<>();
		for(ItemAuthor a : item.getAuthors()) {
			NameData n = new NameData();
			n.f = a.getFirstName();
			n.m = a.getMiddleName();
			n.l = a.getLastName();
			result.authors.add(n);
		}

		result.tags = new ArrayList<>();
		for(ItemTag t : item.getTags())
			result.tags.add(t.getName());
		
		return result;
	}
	
	public static AccountProxy from(Account account) {
		AccountProxy result = new AccountProxy();
		result.id = account.getId();
		result.uname = account.getUsername();
		result.pass = account.getPassword();
		result.email = account.getAcademic().getEmail();
		
		result.name = new NameData();
		result.name.f = account.getAcademic().getFirstName();
		result.name.m = account.getAcademic().getMiddleName();
		result.name.l = account.getAcademic().getLastName();

		result.bday.d = account.getAcademic().getBirthday().getDayOfMonth();
		result.bday.m = account.getAcademic().getBirthday().getMonthValue();
		result.bday.y = account.getAcademic().getBirthday().getYear();
		
		result.secret = new SecretData();
		result.secret.q = account.getSecurity().getQuestion();
		result.secret.q = account.getSecurity().getAnswer();
		result.type = account.getType();
		
		return result;
	}
}
