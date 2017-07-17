package com.dlsu.lrs.controllers;

public class DataTypes {
	
	// Data
	public static class NameData {
		
		public String f, m, l;
	}

	// Model proxy
	public static class AuthorProxy {
		
		public Long id;
	}
	public static class PublisherProxy {
		
		Long id;
		String name;
	}
	public static class ItemProxy {
		
	}
	
	// Parameters
	public static class LoginParams {
		
		public String username, password;
	}
	public static class RegisterParams {
		
		public String token, password, confirmPassword;
	}
}
