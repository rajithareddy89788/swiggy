package com.mouritech.swiggy_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mouritech.swiggy_application.entity.Restaurent;

public interface RestaurentRepository extends JpaRepository<Restaurent, Long> {
	Restaurent findByRestaurentName(String restaurentName);
}
