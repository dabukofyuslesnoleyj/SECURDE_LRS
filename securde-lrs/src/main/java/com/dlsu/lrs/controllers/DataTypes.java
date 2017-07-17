package com.dlsu.lrs.controllers;

import java.util.List;

import com.dlsu.lrs.models.AccountType;
import com.dlsu.lrs.models.ItemType;

public class DataTypes {
	
	// Data
	public static class NameData {
		
		public String f, m, l;
	}
	public static class BDayData {
		
		public Integer f, m, l;
	}
	public static class SecretData {
		
		public Integer q, a;
	}

	// Model proxy
	public static class AuthorProxy {
		
		public Long id;
	}
	public static class PublisherProxy {
		
		public Long id;
		public String name;
	}
	public static class ItemProxy {
		
		public Long id;
		public String name, desc, publisher;
		public Integer year;
		public ItemType type;
		public List<NameData> authors;
		public List<String> tags;
	}
	public static class AccoutProxy {

		public String id, uname, pass, email;
		public NameData name;
		public BDayData bday;
		public SecretData secret;
		public AccountType type;
	}
	
	// Parameters
	public static class LoginParams {
		
		public String uname, pass;
	}

	public static class ReviewParams {
		
		public Long itemId;
		public String review;
	}
	public static class RatingParams {
		
		public Long itemId;
		public String rating;
	}
}
