package com.mouritech.swiggy_application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mouritech.swiggy_application.entity.Items;

public interface ItemsRepository extends JpaRepository<Items, Long> {

	@Query("SELECT c FROM Items c WHERE c.itemName=:itemName")
	Optional<Items> findByItemName(String itemName);

}
