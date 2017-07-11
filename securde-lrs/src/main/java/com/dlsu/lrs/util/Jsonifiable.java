package com.dlsu.lrs.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public interface Jsonifiable {

	Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	
	default String toJson() {
		return GSON.toJson(this);
	}
}
