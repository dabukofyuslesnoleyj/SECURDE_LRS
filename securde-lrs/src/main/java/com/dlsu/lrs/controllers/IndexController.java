package com.dlsu.lrs.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dlsu.lrs.constants.SessionKeys;
import com.dlsu.lrs.models.Account;
import com.dlsu.lrs.repos.AccountRepository;
import com.dlsu.lrs.util.ajax.AjaxResponseEntity;

@Controller
@RequestMapping("")
public class IndexController {
	
	@Autowired
	private AccountRepository accountRepo;

	@RequestMapping({"", "/"})
	public String root(Model model, HttpSession session) {
		Account account = accountRepo.findOne(session.getAttribute(SessionKeys.LOGGED_IN_ACCOUNT_ID) + "");
		if(account == null)
			return "index";
		return "home";
	}

	@RequestMapping("login")
	public String login(Model model) {
		return "redirect:/";
	}
	@RequestMapping("register")
	public String register(Model model) {
		return "redirect:/";
	}

	@RequestMapping("itemlist")
	public String itemList(Model model, HttpSession session) {
		Account account = accountRepo.findOne(session.getAttribute(SessionKeys.LOGGED_IN_ACCOUNT_ID) + "");
		if(account == null)
			return "redirect:/";
		return "itemList";
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
	public String searchItem(@RequestParam("q") String q, Model model) {
		return null;
	}
}
