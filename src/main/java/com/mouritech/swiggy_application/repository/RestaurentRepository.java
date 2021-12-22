package com.mouritech.swiggy_application.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mouritech.swiggy_application.dto.RestaurentDto;
import com.mouritech.swiggy_application.entity.Restaurent;

public interface RestaurentRepository extends JpaRepository<Restaurent, Long> {
	@Query("SELECT r FROM Restaurent r WHERE r.restaurentName LIKE %?1%")
	List<Restaurent> findByRestaurentName(String restaurentName);
	

}
