package com.dlsu.lrs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

	@RequestMapping({"", "/"})
	public String root(Model model) {
		return null;
	}

	@RequestMapping("login")
	public String login(Model model) {
		return "login";
	}
	@RequestMapping("register")
	public String register(Model model) {
		return "register";
	}
	
	@RequestMapping("acadlist")
	public String acadList(@PathVariable("id") String id, Model model) {
		return null;
	}
	
	@RequestMapping("account/{id}")
	public String viewAccount(@PathVariable("id") String id, Model model) {
		return null;
	}
	@RequestMapping("item/{id}")
	public String viewItem(@PathVariable("id") String id, Model model) {
		return null;
	}
	@RequestMapping("author/{id}")
	public String viewAuthor(@PathVariable("id") String id, Model model) {
		return null;
	}

	@RequestMapping("search/item")
	public String searchItem(@PathVariable("id") String id, Model model) {
		return null;
	}
	@RequestMapping("search/author")
	public String searchAuthor(
			@RequestParam(name = "first", required = false) String firstName,
			@RequestParam(name = "middle", required = false) String middleName,
			@RequestParam(name = "last", required = false) String lastName,
			Model model) {
		return null;
	}
}
