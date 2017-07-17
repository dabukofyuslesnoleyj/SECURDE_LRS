package com.dlsu.lrs.controllers.rest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dlsu.lrs.constants.SessionKeys;
import com.dlsu.lrs.models.Academic;
import com.dlsu.lrs.models.Account;
import com.dlsu.lrs.models.AccountSecurity;
import com.dlsu.lrs.models.AccountType;
import com.dlsu.lrs.repos.AcademicRepository;
import com.dlsu.lrs.repos.AccountRepository;
import com.dlsu.lrs.util.ModelToProxy;
import com.dlsu.lrs.util.DataTypes.AccountProxy;
import com.dlsu.lrs.util.DataTypes.LoginParams;
import com.dlsu.lrs.util.ajax.AjaxResponseEntity;

@RestController
@RequestMapping("rest/account")
public class AccountRestController {

	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private AcademicRepository acadRepo;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> accessAccount(@PathVariable String id, HttpSession session) {
		Account account = accountRepo.findOne(session.getAttribute(SessionKeys.LOGGED_IN_ACCOUNT_ID) + "");
		if(account == null)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED);

		if(account.getType() == AccountType.CUSTOMER && !account.getId().equals(id))
			return new AjaxResponseEntity<>(HttpStatus.FORBIDDEN);

		Account access = accountRepo.findOne(id);
		if(access == null)
			return new AjaxResponseEntity<>(HttpStatus.NOT_FOUND);

		AccountProxy result = ModelToProxy.from(access);
		if(!account.getAcademic().getId().equals(access.getAcademic().getId()))
			result.pass = null;

		return new AjaxResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> createAccount(@RequestBody AccountProxy params, HttpSession session) {
		Account account = accountRepo.findOne(session.getAttribute(SessionKeys.LOGGED_IN_ACCOUNT_ID) + "");
		if(account == null)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED);

		if(account.getType() != AccountType.ADMIN)
			return new AjaxResponseEntity<>(HttpStatus.FORBIDDEN);

		if(params.id == null || params.uname == null || params.pass == null || params.type == null)
			return new AjaxResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY).setErrorData("Missing params");

		if(accountRepo.findByUsernameIgnoreCase(params.uname) != null)
			return new AjaxResponseEntity<>(HttpStatus.CONFLICT).setErrorData("Username exists");

		Academic academic = acadRepo.findOne(params.id);
		if(academic == null)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED);

		if(academic.getFirstName() != null)
			academic.setFirstName(params.name.f);
		if(academic.getMiddleName() != null)
			academic.setMiddleName(params.name.m);
		if(academic.getLastName() != null)
			academic.setLastName(params.name.l);
		if(academic.getEmail() != null)
			academic.setEmail(params.email);

		if(params.bday != null)
			academic.setBirthday(LocalDate.of(params.bday.y, params.bday.m, params.bday.d));
		academic = acadRepo.save(academic);

		for(Account a : academic.getAccounts())
			if(a.getType() == params.type)
				return new AjaxResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY).setErrorData("Account already exists");

		Account nAccount = new Account();
		nAccount.setAcademic(academic);
		nAccount.setId(params.type + academic.getId());
		nAccount.setUsername(params.uname);
		nAccount.setPassword(params.pass);
		nAccount.setSecurity(new AccountSecurity(params.secret.q, params.secret.a));
		nAccount.setExpiration(LocalDateTime.now().plusDays(1));

		accountRepo.save(nAccount);
		return new AjaxResponseEntity<>(HttpStatus.CREATED).setData("Academic and account created");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAccount(@PathVariable("id") String id, @RequestBody AccountProxy params, HttpSession session) {
		Account account = accountRepo.findOne(session.getAttribute(SessionKeys.LOGGED_IN_ACCOUNT_ID) + "");
		if(account == null)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED);

		if(account.getType() == AccountType.CUSTOMER)
			return new AjaxResponseEntity<>(HttpStatus.FORBIDDEN);

		if(!accountRepo.exists(id))
			return new AjaxResponseEntity<>(HttpStatus.NOT_FOUND);

		if(params.type != AccountType.CUSTOMER && account.getType() != AccountType.ADMIN)
			return new AjaxResponseEntity<>(HttpStatus.FORBIDDEN);

		if(accountRepo.findByUsernameIgnoreCase(params.uname) != null)
			return new AjaxResponseEntity<>(HttpStatus.CONFLICT).setErrorData("Username exists");

		Account nAccount = accountRepo.findOne(id);
		nAccount.setPassword(params.pass);
		nAccount.setUsername(params.uname);
		nAccount.setType(params.type);

		return new AjaxResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAccount(@PathVariable("id") String id, HttpSession session) {
		Account account = accountRepo.findOne(session.getAttribute(SessionKeys.LOGGED_IN_ACCOUNT_ID) + "");
		if(account == null)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED);

		if(account.getType() != AccountType.ADMIN)
			return new AjaxResponseEntity<>(HttpStatus.FORBIDDEN);

		if(!accountRepo.exists(id))
			return new AjaxResponseEntity<>(HttpStatus.NOT_FOUND);

		if(account.getId().equals(id))
			return new AjaxResponseEntity<>(HttpStatus.FORBIDDEN).setErrorData("Self deletion is not allowed");

		accountRepo.delete(id);
		return new AjaxResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping("/unlock/{id}")
	public ResponseEntity<?> unlock(@PathVariable("id") String id, HttpSession session) {
		Account account = accountRepo.findOne(session.getAttribute(SessionKeys.LOGGED_IN_ACCOUNT_ID) + "");
		if(account == null)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED);

		if(account.getType() != AccountType.ADMIN)
			return new AjaxResponseEntity<>(HttpStatus.FORBIDDEN);

		Account access = accountRepo.findOne(id);
		if(access == null)
			return new AjaxResponseEntity<>(HttpStatus.NOT_FOUND);

		if(access.getExpiration() != null && LocalDateTime.now().isAfter(access.getExpiration()))
			return new AjaxResponseEntity<>(HttpStatus.CONFLICT).setErrorData("Account is not locked");

		access.setExpiration(null);
		return new AjaxResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping("/register")
	public ResponseEntity<?> register(@RequestBody AccountProxy params, HttpSession session) {
		Academic academic = acadRepo.findOne(params.id);
		if(academic == null)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED).setErrorData("ID not registered");

		for(Account account : academic.getAccounts())
			if(account.getType() == AccountType.CUSTOMER)
				return new AjaxResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY).setErrorData("Account already exists");

		if(accountRepo.findByUsernameIgnoreCase(params.uname) != null)
			return new AjaxResponseEntity<>(HttpStatus.CONFLICT).setErrorData("Username exists");

		academic.setFirstName(params.name.f);
		academic.setMiddleName(params.name.m);
		academic.setLastName(params.name.l);
		academic.setEmail(params.email);
		academic.setBirthday(LocalDate.of(params.bday.y, params.bday.m, params.bday.d));

		Account account = new Account();
		account.setId(AccountType.CUSTOMER + academic.getId());
		account.setAcademic(academic);
		account.setUsername(params.uname);
		account.setPassword(params.pass);
		if(params.secret != null)
			account.setSecurity(new AccountSecurity(params.secret.q, params.secret.a));

		accountRepo.save(account);
		return new AjaxResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginParams params, HttpSession session) {
		Account account = accountRepo.findOne(session.getAttribute(SessionKeys.LOGGED_IN_ACCOUNT_ID) + "");
		if(account != null)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED).setErrorData("Log out first");

		account = accountRepo.findByUsernameAndPassword(params.uname, params.pass);
		if(account == null)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED).setErrorData("Invalid username and password combination");

		if(account.getExpiration() != null && LocalDateTime.now().isAfter(account.getExpiration()))
			return new AjaxResponseEntity<>(HttpStatus.FORBIDDEN).setErrorData("Locked account");

		session.setAttribute(SessionKeys.LOGGED_IN_ACCOUNT_ID, account.getId());
		return new AjaxResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		Account account = accountRepo.findOne(session.getAttribute(SessionKeys.LOGGED_IN_ACCOUNT_ID) + "");
		if(account == null)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED).setErrorData("Log in first");

		session.setAttribute(SessionKeys.LOGGED_IN_ACCOUNT_ID, null);
		return new AjaxResponseEntity<>(HttpStatus.OK);
	}
}
