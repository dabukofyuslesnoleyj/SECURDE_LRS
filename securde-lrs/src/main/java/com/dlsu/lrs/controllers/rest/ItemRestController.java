package com.dlsu.lrs.controllers.rest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import com.dlsu.lrs.controllers.DataTypes.ItemProxy;
import com.dlsu.lrs.controllers.DataTypes.NameData;
import com.dlsu.lrs.controllers.DataTypes.RatingParams;
import com.dlsu.lrs.controllers.DataTypes.ReviewParams;
import com.dlsu.lrs.models.AcademicType;
import com.dlsu.lrs.models.Account;
import com.dlsu.lrs.models.AccountType;
import com.dlsu.lrs.models.Item;
import com.dlsu.lrs.models.ItemAuthor;
import com.dlsu.lrs.models.ItemBorrowing;
import com.dlsu.lrs.models.ItemPublisher;
import com.dlsu.lrs.models.ItemRating;
import com.dlsu.lrs.models.ItemReview;
import com.dlsu.lrs.models.ItemStatus;
import com.dlsu.lrs.models.ItemTag;
import com.dlsu.lrs.repos.AccountRepository;
import com.dlsu.lrs.repos.ItemAuthorRepository;
import com.dlsu.lrs.repos.ItemBorrowingRepository;
import com.dlsu.lrs.repos.ItemPublisherRepository;
import com.dlsu.lrs.repos.ItemRatingRepository;
import com.dlsu.lrs.repos.ItemRepository;
import com.dlsu.lrs.repos.ItemReviewRepository;
import com.dlsu.lrs.repos.ItemTagRepository;
import com.dlsu.lrs.util.ajax.AjaxResponseEntity;

@RestController
@RequestMapping("rest/item")
public class ItemRestController {

	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private ItemAuthorRepository authorRepo;
	@Autowired
	private ItemBorrowingRepository borrowRepo;
	@Autowired
	private ItemPublisherRepository publishRepo;
	@Autowired
	private ItemRatingRepository ratingRepo;
	@Autowired
	private ItemRepository itemRepo;
	@Autowired
	private ItemReviewRepository reviewRepo;
	@Autowired
	private ItemTagRepository tagRepo;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> accessItem(@PathVariable("id") Long id, HttpSession session) {
		Account account = accountRepo.findOne(session.getAttribute(SessionKeys.LOGGED_IN_ACCOUNT_ID) + "");
		if(account == null)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
		Item item = itemRepo.findOne(id);
		if(item == null)
			return new AjaxResponseEntity<>(HttpStatus.NOT_FOUND);
		
		ItemProxy result = new ItemProxy();
		result.id = item.getId();
		result.name = item.getName();
		result.desc = item.getDescription();
		result.publisher = item.getPublisher().getName();
		result.year = item.getYear();
		result.type = item.getType();
		result.authors = new ArrayList<>();
		result.tags = new ArrayList<>();
		
		for(ItemAuthor a : item.getAuthors()) {
			NameData n = new NameData();
			n.f = a.getFirstName();
			n.m = a.getMiddleName();
			n.l = a.getLastName();
			result.authors.add(n);
		}
		for(ItemTag t : item.getTags())
			result.tags.add(t.getName());

		return new AjaxResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
	public ResponseEntity<?> createItem(@RequestBody ItemProxy params, HttpSession session) {
		Account account = accountRepo.findOne(session.getAttribute(SessionKeys.LOGGED_IN_ACCOUNT_ID) + "");
		if(account == null)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
		if(account.getType() == AccountType.CUSTOMER)
			return new AjaxResponseEntity<>(HttpStatus.FORBIDDEN);
		
		Item item = new Item();
		item.setName(params.name);
		item.setDescription(params.desc);
		item.setYear(params.year);
		item.setType(params.type);
		item.setAuthors(new ArrayList<>());
		item.setTags(new ArrayList<>());
		
		ItemPublisher publisher = publishRepo.findByNameIgnoreCase(params.publisher);
		if(publisher == null) {
			publisher = new ItemPublisher(params.publisher);
			publisher = publishRepo.save(publisher);
		}
		item.setPublisher(publisher);

		if(params.authors == null)
			params.authors = new ArrayList<>();
		for(NameData a : params.authors) {
			ItemAuthor author = authorRepo.findByFirstNameAndMiddleNameAndLastNameAllIgnoreCase(a.f, a.m, a.l);
			if(author == null) {
				author = new ItemAuthor(a.f, a.m, a.l);
				author = authorRepo.save(author);
			}
			item.getAuthors().add(author);
		}

		if(params.tags == null)
			params.tags = new ArrayList<>();
		for(String t : params.tags) {
			ItemTag tag = tagRepo.findByNameIgnoreCase(t);
			if(tag == null) {
				tag = new ItemTag(t);
				tag = tagRepo.save(tag);
			}
			item.getTags().add(tag);
		}
		
		item = itemRepo.save(item);
		return new AjaxResponseEntity<>(item.getId(), HttpStatus.CREATED);
	}
	
	@RequestMapping(value  = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateItem(@PathVariable("id") Long id, @RequestBody ItemProxy params, HttpSession session) {
		Account account = accountRepo.findOne(session.getAttribute(SessionKeys.LOGGED_IN_ACCOUNT_ID) + "");
		if(account == null)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
		if(account.getType() == AccountType.CUSTOMER)
			return new AjaxResponseEntity<>(HttpStatus.FORBIDDEN);
		
		if(!itemRepo.exists(id))
			return new AjaxResponseEntity<>(HttpStatus.NOT_FOUND);
		
		Item item = new Item();
		item.setId(id);
		item.setName(params.name);
		item.setDescription(params.desc);
		item.setYear(params.year);
		item.setType(params.type);
		item.setAuthors(new ArrayList<>());
		item.setTags(new ArrayList<>());
		
		ItemPublisher publisher = publishRepo.findByNameIgnoreCase(params.publisher);
		if(publisher == null) {
			publisher = new ItemPublisher(params.publisher);
			publisher = publishRepo.save(publisher);
		}
		item.setPublisher(publisher);

		if(params.authors == null)
			params.authors = new ArrayList<>();
		for(NameData a : params.authors) {
			ItemAuthor author = authorRepo.findByFirstNameAndMiddleNameAndLastNameAllIgnoreCase(a.f, a.m, a.l);
			if(author == null) {
				author = new ItemAuthor(a.f, a.m, a.l);
				author = authorRepo.save(author);
			}
			item.getAuthors().add(author);
		}

		if(params.tags == null)
			params.tags = new ArrayList<>();
		for(String t : params.tags) {
			ItemTag tag = tagRepo.findByNameIgnoreCase(t);
			if(tag == null) {
				tag = new ItemTag(t);
				tag = tagRepo.save(tag);
			}
			item.getTags().add(tag);
		}
		
		item = itemRepo.save(item);
		return new AjaxResponseEntity<>(item.getId(), HttpStatus.CREATED);
	}
	
	@RequestMapping(value  = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> removeItem(@PathVariable("id") Long id, HttpSession session) {
		Account account = accountRepo.findOne(session.getAttribute(SessionKeys.LOGGED_IN_ACCOUNT_ID) + "");
		if(account == null)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED);
		
		if(account.getType() == AccountType.CUSTOMER)
			return new AjaxResponseEntity<>(HttpStatus.FORBIDDEN);
		
		if(!itemRepo.exists(id))
			return new AjaxResponseEntity<>(HttpStatus.NOT_FOUND);
		
		itemRepo.delete(id);
		return new AjaxResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping("/borrow/{itemId}")
	public ResponseEntity<?> borrow(@PathVariable("itemId") Long itemId, HttpSession session) {
		Account account = accountRepo.findOne(session.getAttribute(SessionKeys.LOGGED_IN_ACCOUNT_ID) + "");
		if(account == null)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED);

		Item item = itemRepo.findOne(itemId);
		if(item == null)
			return new AjaxResponseEntity<>(HttpStatus.NOT_FOUND);
		
		if(item.getStatus() != ItemStatus.AVAILABLE)
			return new AjaxResponseEntity<>(HttpStatus.FORBIDDEN).setErrorData("Item not available");
		
		LocalDate deadline = LocalDate.now();
		if(account.getAcademic().getType() == AcademicType.STUDENT)
			deadline = deadline.plusDays(7);
		else
			deadline = deadline.plusMonths(1);
		
		ItemBorrowing borrow = new ItemBorrowing(deadline, account, item);
		borrowRepo.save(borrow);
		return new AjaxResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping("/review")
	public ResponseEntity<?> review(@RequestBody ReviewParams params, HttpSession session) {
		Account account = accountRepo.findOne(session.getAttribute(SessionKeys.LOGGED_IN_ACCOUNT_ID) + "");
		if(account == null)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED);

		Item item = itemRepo.findOne(params.itemId);
		if(item == null)
			return new AjaxResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<ItemBorrowing> borrows = borrowRepo.findReturnedItemsByBorrowerAndItem(account, item);
		if(borrows.size() == 0)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED).setErrorData("Item not borrowed");
		
		ItemReview rating = new ItemReview(item, account, params.review);
		reviewRepo.save(rating);
		return new AjaxResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping("/rate")
	public ResponseEntity<?> rate(@RequestBody RatingParams params, HttpSession session) {
		Account account = accountRepo.findOne(session.getAttribute(SessionKeys.LOGGED_IN_ACCOUNT_ID) + "");
		if(account == null)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED);

		Item item = itemRepo.findOne(params.itemId);
		if(item == null)
			return new AjaxResponseEntity<>(HttpStatus.NOT_FOUND);
		
		List<ItemBorrowing> borrows = borrowRepo.findReturnedItemsByBorrowerAndItem(account, item);
		if(borrows.size() == 0)
			return new AjaxResponseEntity<>(HttpStatus.UNAUTHORIZED).setErrorData("Item not borrowed");
		
		ItemRating rating = new ItemRating(item, account, params.rating);
		ratingRepo.save(rating);
		return new AjaxResponseEntity<>(HttpStatus.CREATED);
	}
}
