package com.mouritech.swiggy_application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mouritech.swiggy_application.dto.ItemDto;
import com.mouritech.swiggy_application.dto.ItemDto2;
import com.mouritech.swiggy_application.entity.Items;

public interface ItemsRepository extends JpaRepository<Items, Long> {

	 @Query("SELECT c FROM Items c WHERE c.itemName=:itemName")
	 Optional<Items> findByItemNames(String itemName);

	
	@Query("SELECT r FROM Items r WHERE r.itemName LIKE %?1%")
	List<ItemDto2> findByItemName(String itemName);
	
}
