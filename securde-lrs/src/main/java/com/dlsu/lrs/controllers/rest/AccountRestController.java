package com.dlsu.lrs.controllers.rest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dlsu.lrs.constants.SessionKeys;
import com.dlsu.lrs.controllers.DataTypes.LoginParams;
import com.dlsu.lrs.controllers.DataTypes.AccountProxy;
import com.dlsu.lrs.models.Academic;
import com.dlsu.lrs.models.Account;
import com.dlsu.lrs.models.AccountType;
import com.dlsu.lrs.models.Token;
import com.dlsu.lrs.repos.AccountRepository;
import com.dlsu.lrs.repos.TokenRepository;
import com.dlsu.lrs.util.ajax.AjaxResponseEntity;

@RestController
@RequestMapping("rest/account")
public class AccountRestController {
	
	@Autowired
	private AccountRepository accountRepo;


	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<?> accessAccount(HttpSession session) {
		return null;
	}
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> createAccount(HttpSession session) {
		return null;
	}
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAccount(HttpSession session) {
		return null;
	}
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAccount(HttpSession session) {
		return null;
	}

	@RequestMapping("/login")
	public ResponseEntity<?> login(HttpSession session) {
		return null;
	}
	@RequestMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		return null;
	}
}
