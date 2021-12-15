package com.mouritech.swiggy_application.service;

import java.util.List;
import java.util.Optional;

import com.mouritech.swiggy_application.dto.RestaurentDto;
import com.mouritech.swiggy_application.entity.Restaurent;
import com.mouritech.swiggy_application.entity.User;

public interface RestaurentService {
	void addToRestaurent(RestaurentDto restaurentDto, User users);

	List<Restaurent> listRestaurents();

	Restaurent readRestaurent(String restaurentName);

	Optional<Restaurent> readRestaurent(long restaurentId);

	Restaurent getRestaurentByName(String restaurentName);
}
