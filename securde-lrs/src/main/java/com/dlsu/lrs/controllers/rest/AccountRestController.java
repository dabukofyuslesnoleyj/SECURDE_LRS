package com.dlsu.lrs.controllers.rest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlsu.lrs.constants.KeyConstants;
import com.dlsu.lrs.controllers.DataTypes.LoginParams;
import com.dlsu.lrs.controllers.DataTypes.AccoutProxy;
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
	@Autowired
	private TokenRepository tokenRepo;
	
	@RequestMapping("login")
	public ResponseEntity<?> login(@RequestBody LoginParams params, HttpSession session) {
		Account account = (Account) session.getAttribute(KeyConstants.SESSION_ATTRIB_KEY_ACCOUNTLOGGEDIN);
		if(account != null)
			return new AjaxResponseEntity<Object>(HttpStatus.CONFLICT) {{
				getBody().setErrorData("User alread logged in");
			}};
		account = accountRepo.findByUsernameAndPassword(params.username, params.password);
		if(account == null)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED);
		// TODO Session logic here
		return new AjaxResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping("/register")
	public ResponseEntity<?> register(@RequestBody AccoutProxy params) {
		Token token = tokenRepo.findByToken(params.token);
		if(token == null)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED);
		if(params.password == null || !params.password.matches("[\\w]{4,10}"))
			return new AjaxResponseEntity<Object>(HttpStatus.EXPECTATION_FAILED) {{
				getBody().setErrorData("Invalid password structure");
			}};
		if(params.password != params.confirmPassword)
			return new AjaxResponseEntity<Object>(HttpStatus.EXPECTATION_FAILED) {{
				getBody().setErrorData("Wrong confirm password");
			}};
		Account account = new Account() {{
			Academic academic = token.getAcademic();
			AccountType type = token.getType();
			String password = params.password;

			setId(type + "-" + academic.getId());
			setPassword(password);
			setAcademic(academic);
			
			// TODO Register logic here
		}};
		accountRepo.save(account);
		return new AjaxResponseEntity<>(HttpStatus.OK);
	}
}
