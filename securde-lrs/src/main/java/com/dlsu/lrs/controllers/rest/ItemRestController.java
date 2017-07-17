package com.dlsu.lrs.controllers.rest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dlsu.lrs.models.Item;
import com.dlsu.lrs.repos.ItemRepository;
import com.dlsu.lrs.util.ajax.AjaxResponseEntity;

@RestController
@RequestMapping("rest/item")
public class ItemRestController {
	
	public static class ItemProxy {
		
	}
	
	@Autowired
	private ItemRepository itemRepo;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> accessItem(
			@PathVariable("id") Long id,
			HttpSession session) {
		Item item = itemRepo.findOne(id);
		if(item == null)
			return new AjaxResponseEntity<>(HttpStatus.NOT_FOUND);
		return null;
	}

	@RequestMapping(value = {"", "/", "/{id}"}, method = RequestMethod.POST)
	public ResponseEntity<?> createItem(
			@PathVariable(value = "id", required = false) Long id,
			@RequestBody ItemProxy item,
			HttpSession session) {
		return null;
	}
	
	@RequestMapping(value  = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateItem(
			@PathVariable("id") Long id,
			@RequestBody ItemProxy item,
			HttpSession session) {
		if(!itemRepo.exists(id))
			return new AjaxResponseEntity<>(HttpStatus.NOT_FOUND);
		// TODO update logic
		return null;
	}
	
	@RequestMapping(value  = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> removeItem(
			@PathVariable("id") Long id,
			HttpSession session) {
		if(!itemRepo.exists(id))
			return new AjaxResponseEntity<>(HttpStatus.NOT_FOUND);
		itemRepo.delete(id);
		return new AjaxResponseEntity<>(HttpStatus.OK);
	}
}
