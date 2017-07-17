package com.dlsu.lrs.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dlsu.lrs.models.Account;
import com.dlsu.lrs.models.Item;
import com.dlsu.lrs.models.ItemBorrowing;

public interface ItemBorrowingRepository extends CrudRepository<ItemBorrowing, Long> {

	@Query("SELECT * " +
			"FROM #entityName b " +
			"WHERE b.borrowerId = _1.id AND b.itemId = _2.id AND b.isReturned = 1")
	List<ItemBorrowing> findReturnedItemsByBorrowerAndItem(@Param("_1") Account borrower, @Param("_2") Item item);
}
