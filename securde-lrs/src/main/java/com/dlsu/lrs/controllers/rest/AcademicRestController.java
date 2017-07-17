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
import com.dlsu.lrs.models.Academic;
import com.dlsu.lrs.models.Account;
import com.dlsu.lrs.models.AccountType;
import com.dlsu.lrs.repos.AcademicRepository;
import com.dlsu.lrs.repos.AccountRepository;
import com.dlsu.lrs.util.DataTypes.AcadIndexParams;
import com.dlsu.lrs.util.ajax.AjaxResponseEntity;

@RestController
@RequestMapping("rest/acad")
public class AcademicRestController {

	@Autowired
	private AcademicRepository acadRepo;
	@Autowired
	private AccountRepository accountRepo;
	

	@RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
	public ResponseEntity<?> indexAcad(@RequestBody AcadIndexParams params, HttpSession session) {
		Account account = accountRepo.findOne(session.getAttribute(SessionKeys.LOGGED_IN_ACCOUNT_ID) + "");
		if(account == null)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
		if(account.getType() != AccountType.ADMIN)
			return new AjaxResponseEntity<>(HttpStatus.FORBIDDEN);
		
		if(acadRepo.exists(params.id))
			return new AjaxResponseEntity<>(HttpStatus.CONFLICT);
		
		Academic academic = new Academic();
		academic.setId(params.id);
		academic.setType(params.type);
		acadRepo.save(academic);
		return new AjaxResponseEntity<>(HttpStatus.CREATED);
	}
}
