package com.mouritech.swiggy_application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mouritech.swiggy_application.dto.ItemDto;
import com.mouritech.swiggy_application.dto.ItemDto2;
import com.mouritech.swiggy_application.entity.Items;
import com.mouritech.swiggy_application.entity.Offers;

public interface OfferRepository extends JpaRepository<Offers, Long> {

	// @Query("SELECT c FROM Items c WHERE c.itemName=:itemName")
	// Optional<Items> findByItemName(String itemName);

	// Items addItems(Items itemRequest, Restaurent restaurent);
	
}
