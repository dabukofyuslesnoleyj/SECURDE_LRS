package com.dlsu.lrs.util;

import java.util.List;

import com.dlsu.lrs.models.AcademicType;
import com.dlsu.lrs.models.AccountType;
import com.dlsu.lrs.models.ItemStatus;
import com.dlsu.lrs.models.ItemType;

public class DataTypes {
	
	// Data
	public static class NameData implements Jsonifiable {
		
		public String f, m, l;
	}
	public static class BDayData implements Jsonifiable {
		
		public Integer d, m, y;
	}
	public static class SecretData implements Jsonifiable {
		
		public String q, a;
	}

	// Model proxy
	public static class AuthorProxy implements Jsonifiable {
		
		public Long id;
	}
	public static class PublisherProxy implements Jsonifiable {
		
		public Long id;
		public String name;
	}
	public static class ItemProxy implements Jsonifiable {
		
		public Long id;
		public String name, desc, publisher;
		public Integer year;
		public ItemType type;
		public ItemStatus status;
		public List<NameData> authors;
		public List<String> tags;
	}
	public static class AccountProxy implements Jsonifiable {

		public String id, uname, pass, email;
		public NameData name;
		public BDayData bday;
		public SecretData secret;
		public AccountType type;
	}
	
	// Parameters
	public static class LoginParams implements Jsonifiable {
		
		public String uname, pass;
	}

	public static class ReviewParams implements Jsonifiable {
		
		public Long itemId;
		public String review;
	}
	public static class RatingParams implements Jsonifiable {
		
		public Long itemId;
		public Integer rating;
	}
	public static class AcadIndexParams implements Jsonifiable {
		
		public String id;
		public AcademicType type;
	}
}
